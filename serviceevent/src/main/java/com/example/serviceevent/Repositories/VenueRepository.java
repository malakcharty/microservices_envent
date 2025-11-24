package com.example.serviceevent.Repositories;

import com.example.serviceevent.entities.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenueRepository extends JpaRepository<Venue, Long> {
}
