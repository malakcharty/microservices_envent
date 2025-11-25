package com.example.serviceevent.service.Imp;

import com.example.serviceevent.Dto.Event.EventCreateUpdateDto;
import com.example.serviceevent.Dto.Event.EventReadDto;
import com.example.serviceevent.Dto.Event.EventShortDto;
import com.example.serviceevent.Repositories.CategoryRepository;
import com.example.serviceevent.Repositories.EventRepository;
import com.example.serviceevent.Repositories.VenueRepository;
import com.example.serviceevent.entities.Category;
import com.example.serviceevent.entities.Event;
import com.example.serviceevent.entities.Venue;
import com.example.serviceevent.enums.EventStatus;
import com.example.serviceevent.mapper.EventMapper;
import com.example.serviceevent.service.IEventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements IEventService {

    private final EventRepository eventRepository;
    private final CategoryRepository categoryRepository;
    private final VenueRepository venueRepository;
    private final EventMapper eventMapper;

    public EventServiceImpl(EventRepository eventRepository,
                            CategoryRepository categoryRepository,
                            VenueRepository venueRepository,
                            EventMapper eventMapper) {
        this.eventRepository = eventRepository;
        this.categoryRepository = categoryRepository;
        this.venueRepository = venueRepository;
        this.eventMapper = eventMapper;
    }

    @Override
    public List<EventShortDto> getAllEvents() {
        return eventMapper.toShortDtoList(eventRepository.findAll());
    }

    @Override
    public EventReadDto getEventById(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found with id " + id));
        return eventMapper.toReadDto(event);
    }

    @Override
    public EventReadDto createEvent(EventCreateUpdateDto dto) {

        if (dto.getStatus() == null)
            dto.setStatus(EventStatus.PLANNED);

        Event event = eventMapper.fromCreateUpdateDto(dto);

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Venue venue = venueRepository.findById(dto.getVenueId())
                .orElseThrow(() -> new RuntimeException("Venue not found"));

        event.setCategory(category);
        event.setVenue(venue);

        Event saved = eventRepository.save(event);
        return eventMapper.toReadDto(saved);
    }

    @Override
    public EventReadDto updateEvent(Long id, EventCreateUpdateDto dto) {

        Event existing = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found with id " + id));

        eventMapper.updateEventFromDto(dto, existing);

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Venue venue = venueRepository.findById(dto.getVenueId())
                .orElseThrow(() -> new RuntimeException("Venue not found"));

        existing.setCategory(category);
        existing.setVenue(venue);

        Event updated = eventRepository.save(existing);

        return eventMapper.toReadDto(updated);
    }

    @Override
    public void deleteEvent(Long id) {
        if (!eventRepository.existsById(id))
            throw new RuntimeException("Event not found with id " + id);

        eventRepository.deleteById(id);
    }
}
