package com.example.serviceevent.Dto.Event;

import com.example.serviceevent.enums.EventStatus;
import java.time.LocalDate;

public class EventShortDto {

    private Long id;
    private String title;
    private LocalDate date;
    private EventStatus status;
    private Long categoryId;
    private Long venueId;

    public EventShortDto() {
    }

    public EventShortDto(Long id,
                         String title,
                         LocalDate date,
                         EventStatus status,
                         Long categoryId,
                         Long venueId) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.status = status;
        this.categoryId = categoryId;
        this.venueId = venueId;
    }

    // ---------- Getters & Setters ----------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public EventStatus getStatus() {
        return status;
    }

    public void setStatus(EventStatus status) {
        this.status = status;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getVenueId() {
        return venueId;
    }

    public void setVenueId(Long venueId) {
        this.venueId = venueId;
    }
}
