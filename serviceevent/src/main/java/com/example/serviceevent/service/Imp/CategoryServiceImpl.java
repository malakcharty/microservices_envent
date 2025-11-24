package com.example.serviceevent.service.Imp;



import com.example.serviceevent.Dto.Category.CategoryCreateUpdateDto;
import com.example.serviceevent.Dto.Category.CategoryReadDto;
import com.example.serviceevent.Dto.Category.CategoryShortDto;
import com.example.serviceevent.entities.Category;
import com.example.serviceevent.mapper.CategoryMapper;
import com.example.serviceevent.Repositories.CategoryRepository;
import com.example.serviceevent.service.ICategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository,
                               CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<CategoryShortDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categoryMapper.toShortDtoList(categories);
    }

    @Override
    public CategoryReadDto getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id = " + id));
        return categoryMapper.toReadDto(category);
    }

    @Override
    public CategoryReadDto createCategory(CategoryCreateUpdateDto dto) {
        Category category = categoryMapper.fromCreateUpdateDto(dto);
        Category saved = categoryRepository.save(category);
        return categoryMapper.toReadDto(saved);
    }

    @Override
    public CategoryReadDto updateCategory(Long id, CategoryCreateUpdateDto dto) {
        Category existing = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id = " + id));

        categoryMapper.updateCategoryFromDto(dto, existing);

        Category updated = categoryRepository.save(existing);
        return categoryMapper.toReadDto(updated);
    }

    @Override
    public void deleteCategory(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new RuntimeException("Category not found with id = " + id);
        }
        categoryRepository.deleteById(id);
    }
}
