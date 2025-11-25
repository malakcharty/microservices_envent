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

    @Enumerated(EnumType.STRING)
    private EventStatus status;

    private Integer capacity;

    @Column(name = "organizer_id")
    private Long organizerId;

    // ---------- Relations ----------
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venue_id")
    private Venue venue;

    // ---------- Constructors ----------
    public Event() {}

    public Event(Long id, String title, String description, LocalDate date,
                 EventStatus status, Integer capacity, Long organizerId,
                 Category category, Venue venue) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.status = status;
        this.capacity = capacity;
        this.organizerId = organizerId;
        this.category = category;
        this.venue = venue;
    }

    // ---------- Getters & Setters ----------
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public EventStatus getStatus() { return status; }
    public void setStatus(EventStatus status) { this.status = status; }

    public Integer getCapacity() { return capacity; }
    public void setCapacity(Integer capacity) { this.capacity = capacity; }

    public Long getOrganizerId() { return organizerId; }
    public void setOrganizerId(Long organizerId) { this.organizerId = organizerId; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    public Venue getVenue() { return venue; }
    public void setVenue(Venue venue) { this.venue = venue; }
}
