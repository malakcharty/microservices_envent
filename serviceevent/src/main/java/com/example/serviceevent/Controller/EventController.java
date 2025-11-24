package com.example.serviceevent.Controller;

import com.example.serviceevent.Dto.Event.EventCreateUpdateDto;
import com.example.serviceevent.Dto.Event.EventReadDto;
import com.example.serviceevent.Dto.Event.EventShortDto;
import com.example.serviceevent.service.IEventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final IEventService eventService;

    public EventController(IEventService eventService) {
        this.eventService = eventService;
    }

    // Liste des événements (version courte)
    @GetMapping
    public List<EventShortDto> getAllEvents() {
        return eventService.getAllEvents();
    }

    // Détail d'un événement
    @GetMapping("/{id}")
    public EventReadDto getEvent(@PathVariable Long id) {
        return eventService.getEventById(id);
    }

    // Création
    @PostMapping
    public ResponseEntity<EventReadDto> createEvent(@RequestBody EventCreateUpdateDto dto) {
        EventReadDto created = eventService.createEvent(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // Mise à jour
    @PutMapping("/{id}")
    public EventReadDto updateEvent(@PathVariable Long id,
                                    @RequestBody EventCreateUpdateDto dto) {
        return eventService.updateEvent(id, dto);
    }

    // Suppression
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
    }
}
