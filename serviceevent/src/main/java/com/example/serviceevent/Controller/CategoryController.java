package com.example.serviceevent.Controller;



import com.example.serviceevent.Dto.Category.CategoryCreateUpdateDto;
import com.example.serviceevent.Dto.Category.CategoryReadDto;
import com.example.serviceevent.Dto.Category.CategoryShortDto;
import com.example.serviceevent.service.ICategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<CategoryShortDto> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public CategoryReadDto getCategory(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping
    public ResponseEntity<CategoryReadDto> createCategory(
            @RequestBody CategoryCreateUpdateDto dto) {
        CategoryReadDto created = categoryService.createCategory(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public CategoryReadDto updateCategory(@PathVariable Long id,
                                          @RequestBody CategoryCreateUpdateDto dto) {
        return categoryService.updateCategory(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}
