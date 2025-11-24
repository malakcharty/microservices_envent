package com.example.serviceevent.Dto.Event;

import com.example.serviceevent.enums.EventStatus;

import java.time.LocalDate;

public class EventCreateUpdateDto {

    private String title;
    private String description;
    private LocalDate date;
    private String location;
    private String category;
    private Long organizerId;
    private EventStatus status;
    private Integer capacity;

    public EventCreateUpdateDto() {
    }

    public EventCreateUpdateDto(String title, String description, LocalDate date,
                                String location, String category, Long organizerId,
                                EventStatus status, Integer capacity) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.location = location;
        this.category = category;
        this.organizerId = organizerId;
        this.status = status;
        this.capacity = capacity;
    }

    // ---------- Getters & Setters ----------

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(Long organizerId) {
        this.organizerId = organizerId;
    }

    public EventStatus getStatus() {
        return status;
    }

    public void setStatus(EventStatus status) {
        this.status = status;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
