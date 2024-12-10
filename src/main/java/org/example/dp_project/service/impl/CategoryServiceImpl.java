package org.example.dp_project.service.impl;

import org.example.dp_project.dto.CategoryDto;
import org.example.dp_project.entity.Category;
import org.example.dp_project.repository.CategoryRepository;
import org.example.dp_project.service.CategoryService;
import org.example.dp_project.utils.exception.AlreadyExistException;
import org.example.dp_project.utils.exception.ObjectNotFoundException;
import org.example.dp_project.utils.mapper.CategoryMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    private boolean isIdExist(Long id) {
        if (categoryRepository.existsById(id))
            throw new AlreadyExistException("Category", "id");
        return false;
    }

    private boolean isNameExist(String name) {
        if (categoryRepository.isNameExist(name))
            throw new AlreadyExistException("Category", "name");
        return false;
    }

    private Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category getCategoryById(Long id) {
         return categoryRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Category"));
    }

    @Override
    public Category getCategoryEntityByName(String name) {
        return categoryRepository.findByName(name)
                .orElseThrow(() -> new ObjectNotFoundException("Category"));
    }

    @Override
    public CategoryDto getCategoryByName(String name) {
        return categoryMapper.entityToDto(categoryRepository.findByName(name)
                .orElseThrow(() -> new ObjectNotFoundException("Category")));
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryMapper.entityToDtoList(categoryRepository.findAll());
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        if (!isNameExist(categoryDto.getName()))
            return categoryMapper.entityToDto(save(categoryMapper.dtoToEntity(categoryDto)));
        return null;
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto) {
        Category oldCategory = categoryMapper.dtoToEntity(categoryDto);
        Category newCategory = getCategoryEntityByName(categoryDto.getName());

        if (!newCategory.getName().equals(oldCategory.getName()))
            isNameExist(oldCategory.getName());

        if (!(oldCategory.getName() == null))
            newCategory.setName(oldCategory.getName());
        if (!(oldCategory.getDescription() == null))
            newCategory.setDescription(oldCategory.getDescription());

        return categoryMapper.entityToDto(save(newCategory));
    }
}
