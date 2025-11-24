package com.community.events.entities;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PARTICIPANT")
public class Participant extends User {
    public Participant() { super(); }
}
