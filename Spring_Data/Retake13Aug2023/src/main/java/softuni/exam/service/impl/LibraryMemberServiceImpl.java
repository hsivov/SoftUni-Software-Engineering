package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.LibraryMemberSeedDto;
import softuni.exam.models.entity.LibraryMember;
import softuni.exam.repository.LibraryMemberRepository;
import softuni.exam.service.LibraryMemberService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;

@Service
public class LibraryMemberServiceImpl implements LibraryMemberService {

    private static final String LIBRARY_MEMBERS_FILE_PATH = "src/main/resources/files/json/library-members.json";
    private final LibraryMemberRepository libraryMemberRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public LibraryMemberServiceImpl(LibraryMemberRepository libraryMemberRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.libraryMemberRepository = libraryMemberRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return libraryMemberRepository.count() > 0;
    }

    @Override
    public String readLibraryMembersFileContent() throws IOException {
        return Files.readString(Path.of(LIBRARY_MEMBERS_FILE_PATH));
    }

    @Override
    public String importLibraryMembers() throws IOException {
        StringBuilder sb = new StringBuilder();
        LibraryMemberSeedDto[] libraryMemberSeedDtos =
                gson.fromJson(readLibraryMembersFileContent(), LibraryMemberSeedDto[].class);

        Arrays.stream(libraryMemberSeedDtos)
                .filter(libraryMemberSeedDto -> {
                    boolean isValid = validationUtil.isValid(libraryMemberSeedDto);

                    Optional<LibraryMember> byPhoneNumber =
                            libraryMemberRepository.findFirstByPhoneNumber(libraryMemberSeedDto.getPhoneNumber());
                    if (byPhoneNumber.isPresent()) {
                        isValid = false;
                    }

                    sb
                            .append(isValid ? String.format("Successfully imported library member %s - %s",
                                    libraryMemberSeedDto.getFirstName(),
                                    libraryMemberSeedDto.getLastName())
                                    : "Invalid library member")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(libraryMemberSeedDto -> modelMapper.map(libraryMemberSeedDto, LibraryMember.class))
                .forEach(libraryMemberRepository::save);

        return sb.toString();
    }
}
