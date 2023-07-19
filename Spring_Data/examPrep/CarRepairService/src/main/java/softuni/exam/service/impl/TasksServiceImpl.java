package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TaskSeedRootDto;
import softuni.exam.models.entity.*;
import softuni.exam.repository.TasksRepository;
import softuni.exam.service.CarsService;
import softuni.exam.service.MechanicsService;
import softuni.exam.service.PartsService;
import softuni.exam.service.TasksService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;

@Service
public class TasksServiceImpl implements TasksService {
    private static String TASKS_FILE_PATH = "src/main/resources/files/xml/tasks.xml";
    private final TasksRepository tasksRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final MechanicsService mechanicsService;
    private final CarsService carsService;
    private final PartsService partsService;

    public TasksServiceImpl(TasksRepository tasksRepository, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil, MechanicsService mechanicsService, CarsService carsService, PartsService partsService) {
        this.tasksRepository = tasksRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.mechanicsService = mechanicsService;
        this.carsService = carsService;
        this.partsService = partsService;
    }

    @Override
    public boolean areImported() {
        return tasksRepository.count() > 0;
    }

    @Override
    public String readTasksFileContent() throws IOException {
        return Files.readString(Path.of(TASKS_FILE_PATH));
    }

    @Override
    public String importTasks() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();
        xmlParser.fromFile(TASKS_FILE_PATH, TaskSeedRootDto.class)
                .getTasks()
                .stream()
                .filter(taskSeedDto -> {
                    boolean isValid = validationUtil.isValid(taskSeedDto);

                    Mechanic byName = mechanicsService.getMechanicByName(taskSeedDto.getMechanic().getFirstName());
                    if (byName == null) {
                        isValid = false;
                    }

                    sb
                            .append(isValid ? String.format(Locale.US, "Successfully imported task %.2f", taskSeedDto.getPrice())
                                    : "Invalid task")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(taskSeedDto -> {
                    Task task = modelMapper.map(taskSeedDto, Task.class);

                    Mechanic mechanic = mechanicsService.getMechanicByName(taskSeedDto.getMechanic().getFirstName());
                    Car car = carsService.getCarById(taskSeedDto.getCar().getId());
                    Part part = partsService.getPartById(taskSeedDto.getPart().getId());

                    task.setMechanic(mechanic);
                    task.setCar(car);
                    task.setPart(part);

                    return task;
                })
                .forEach(tasksRepository::save);

        return sb.toString();
    }

    @Override
    public String getCoupeCarTasksOrderByPrice() {
        StringBuilder sb = new StringBuilder();

        tasksRepository.findAllByCarCarTypeOrderByPriceDesc(CarType.coupe)
                .forEach(task -> {
                    sb
                            .append(String.format("Car %s %s with %dkm\n" +
                                    "-Mechanic: %s %s - task №%d:\n" +
                                    " --Engine: %s\n" +
                                    "---Price: %s$\n",
                                    task.getCar().getCarMake(),
                                    task.getCar().getCarModel(),
                                    task.getCar().getKilometers(),
                                    task.getMechanic().getFirstName(),
                                    task.getMechanic().getLastName(),
                                    task.getId(),
                                    task.getCar().getEngine(),
                                    task.getPrice()));
                });

        return sb.toString();
    }
}
