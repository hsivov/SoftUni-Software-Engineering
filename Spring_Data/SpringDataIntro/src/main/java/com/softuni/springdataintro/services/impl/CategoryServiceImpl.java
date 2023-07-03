package com.softuni.springdataintro.services.impl;

import com.softuni.springdataintro.entities.Category;
import com.softuni.springdataintro.repositories.CategoryRepository;
import com.softuni.springdataintro.services.CategoryService;
import com.softuni.springdataintro.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;

import static com.softuni.springdataintro.constants.GlobalConstants.CATEGORIES_FILE_PATH;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final FileUtil fileUtil;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, FileUtil fileUtil) {
        this.categoryRepository = categoryRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedCategories() throws IOException {
        if (this.categoryRepository.count() != 0) {
            return;
        }

        String[] fileContent = this.fileUtil.readFileContent(CATEGORIES_FILE_PATH);

        Arrays.stream(fileContent)
                .forEach(r -> {
                    Category category = new Category(r);

                    this.categoryRepository.saveAndFlush(category);
                });
    }

    @Override
    public Category getCategoryById(Long id) {
        return this.categoryRepository.getReferenceById(id);
    }
}
