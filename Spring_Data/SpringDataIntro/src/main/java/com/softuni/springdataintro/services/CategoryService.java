package com.softuni.springdataintro.services;

import com.softuni.springdataintro.entities.Category;

import java.io.IOException;

public interface CategoryService {
    void seedCategories() throws IOException;

    Category getCategoryById(Long id);
}
