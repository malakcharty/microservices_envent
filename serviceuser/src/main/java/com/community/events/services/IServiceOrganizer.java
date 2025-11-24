package com.community.events.services;
import com.community.events.entities.Organizer;
import java.util.List;
public interface IServiceOrganizer {
    Organizer create(Organizer organizer);
    Organizer get(Long id);
    List<Organizer> all();
    Organizer update(Organizer organizer);
    void delete(Long id);
}
