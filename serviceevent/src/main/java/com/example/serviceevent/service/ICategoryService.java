package com.example.serviceevent.service;



import com.example.serviceevent.Dto.Category.CategoryCreateUpdateDto;
import com.example.serviceevent.Dto.Category.CategoryReadDto;
import com.example.serviceevent.Dto.Category.CategoryShortDto;

import java.util.List;

public interface ICategoryService {

    List<CategoryShortDto> getAllCategories();

    CategoryReadDto getCategoryById(Long id);

    CategoryReadDto createCategory(CategoryCreateUpdateDto dto);

    CategoryReadDto updateCategory(Long id, CategoryCreateUpdateDto dto);

    void deleteCategory(Long id);
}
