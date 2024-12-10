package org.example.dp_project.service;

import org.example.dp_project.dto.CategoryDto;
import org.example.dp_project.entity.Category;

import java.util.List;

public interface CategoryService {
    Category getCategoryById(Long id);
    Category getCategoryEntityByName(String name);
    CategoryDto getCategoryByName(String name);
    List<CategoryDto> getAllCategories();

    CategoryDto createCategory(CategoryDto categoryDto);
    CategoryDto updateCategory(CategoryDto categoryDto);
}
