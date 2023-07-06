package com.softuni.springdataintro.service;

import com.softuni.springdataintro.entity.Category;

import java.io.IOException;

public interface CategoryService {
    void seedCategories() throws IOException;

    Category getCategoryById(Long id);
}
