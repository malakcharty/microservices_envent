package com.example.serviceevent.Dto.Event;

import com.example.serviceevent.enums.EventStatus;

import java.time.LocalDate;

public class EventShortDto {

    private Long id;
    private String title;
    private LocalDate date;
    private String location;
    private EventStatus status;

    public EventShortDto() {
    }

    public EventShortDto(Long id, String title, LocalDate date, String location, EventStatus status) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.location = location;
        this.status = status;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public EventStatus getStatus() {
        return status;
    }

    public void setStatus(EventStatus status) {
        this.status = status;
    }
}
