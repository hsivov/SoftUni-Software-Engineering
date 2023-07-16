package exam.service.impl;

import com.google.gson.Gson;
import exam.model.dto.CustomerSeedDto;
import exam.model.entity.Customer;
import exam.model.entity.Town;
import exam.repository.CustomerRepository;
import exam.service.CustomerService;
import exam.service.TownService;
import exam.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private static final String CUSTOMERS_FILE_PATH = "src/main/resources/files/json/customers.json";
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final TownService townService;

    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil, TownService townService) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.townService = townService;
    }

    @Override
    public boolean areImported() {
        return customerRepository.count() > 0;
    }

    @Override
    public String readCustomersFileContent() throws IOException {
        return Files.readString(Path.of(CUSTOMERS_FILE_PATH));
    }

    @Override
    public String importCustomers() throws IOException {
        StringBuilder sb = new StringBuilder();

        CustomerSeedDto[] customerSeedDtos = gson.fromJson(readCustomersFileContent(), CustomerSeedDto[].class);

        Arrays.stream(customerSeedDtos)
                .filter(customerSeedDto -> {
                    boolean isValid = validationUtil.isValid(customerSeedDto);

                    Optional<Customer> byEmail = customerRepository.findByEmail(customerSeedDto.getEmail());
                    if (byEmail.isPresent()) {
                        isValid = false;
                    }

                    sb
                            .append(isValid ? String.format("Successfully imported Customer %s %s - %s",
                                    customerSeedDto.getFirstName(),
                                    customerSeedDto.getLastName(),
                                    customerSeedDto.getEmail())
                                    : "Invalid Customer")
                            .append(System.lineSeparator());
                    return isValid;
                })
                .map(customerSeedDto -> {
                    Customer customer = modelMapper.map(customerSeedDto, Customer.class);

                    Town town = townService.getTownByName(customerSeedDto.getTown().getName());
                    customer.setTown(town);
                    return customer;
                })
                .forEach(customerRepository::save);

        return sb.toString();
    }
}
