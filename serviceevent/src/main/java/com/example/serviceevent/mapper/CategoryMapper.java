package com.example.serviceevent.mapper;

import com.example.serviceevent.Dto.Category.CategoryCreateUpdateDto;
import com.example.serviceevent.Dto.Category.CategoryReadDto;
import com.example.serviceevent.Dto.Category.CategoryShortDto;
import com.example.serviceevent.entities.Category;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE   // <= AJOUT ICI
)
public interface CategoryMapper {

    CategoryShortDto toShortDto(Category category);

    CategoryReadDto toReadDto(Category category);

    List<CategoryShortDto> toShortDtoList(List<Category> categories);

    List<CategoryReadDto> toReadDtoList(List<Category> categories);

    @Mapping(target = "id", ignore = true)
    Category fromCreateUpdateDto(CategoryCreateUpdateDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCategoryFromDto(CategoryCreateUpdateDto dto,
                               @MappingTarget Category category);
}
