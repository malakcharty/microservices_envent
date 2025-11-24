package com.example.serviceevent.Dto.Category;



public class CategoryCreateUpdateDto {

    private String name;
    private String description;

    public CategoryCreateUpdateDto() {
    }

    public CategoryCreateUpdateDto(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // ----- Getters & Setters -----

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
