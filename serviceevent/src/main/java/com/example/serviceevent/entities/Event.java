package com.example.serviceevent.entities;

import com.example.serviceevent.enums.EventStatus;
import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 2000)
    private String description;

    @Column(name = "event_date")
    private LocalDate date;

    private String location;

    private String category;

    @Column(name = "organizer_id")
    private Long organizerId;

    @Enumerated(EnumType.STRING)
    private EventStatus status;

    private Integer capacity;

    // ---------------- Constructors ----------------

    public Event() {}

    public Event(Long id, String title, String description, LocalDate date, String location,
                 String category, Long organizerId, EventStatus status, Integer capacity) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.location = location;
        this.category = category;
        this.organizerId = organizerId;
        this.status = status;
        this.capacity = capacity;
    }

    // ---------------- Getters & Setters ----------------

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public Long getOrganizerId() { return organizerId; }
    public void setOrganizerId(Long organizerId) { this.organizerId = organizerId; }

    public EventStatus getStatus() { return status; }
    public void setStatus(EventStatus status) { this.status = status; }

    public Integer getCapacity() { return capacity; }
    public void setCapacity(Integer capacity) { this.capacity = capacity; }
}
