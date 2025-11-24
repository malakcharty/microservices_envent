package com.community.events.entities;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ORGANIZER")
public class Organizer extends User {
    public Organizer() { super(); }
}
