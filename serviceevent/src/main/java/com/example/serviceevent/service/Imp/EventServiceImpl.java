package com.example.serviceevent.service.Imp;

import com.example.serviceevent.Dto.Event.EventCreateUpdateDto;
import com.example.serviceevent.Dto.Event.EventReadDto;
import com.example.serviceevent.Dto.Event.EventShortDto;
import com.example.serviceevent.entities.Event;
import com.example.serviceevent.enums.EventStatus;
import com.example.serviceevent.mapper.EventMapper;
import com.example.serviceevent.Repositories.EventRepository;
import com.example.serviceevent.service.IEventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements IEventService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    public EventServiceImpl(EventRepository eventRepository, EventMapper eventMapper) {
        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
    }

    @Override
    public List<EventShortDto> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        return eventMapper.toShortDtoList(events);
    }

    @Override
    public EventReadDto getEventById(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found with id = " + id));
        return eventMapper.toReadDto(event);
    }

    @Override
    public EventReadDto createEvent(EventCreateUpdateDto dto) {
        if (dto.getStatus() == null) {
            dto.setStatus(EventStatus.PLANNED);
        }
        Event event = eventMapper.fromCreateUpdateDto(dto);
        Event saved = eventRepository.save(event);
        return eventMapper.toReadDto(saved);
    }

    @Override
    public EventReadDto updateEvent(Long id, EventCreateUpdateDto dto) {
        Event existing = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found with id = " + id));

        // met à jour l’entité existante
        eventMapper.updateEventFromDto(dto, existing);

        Event updated = eventRepository.save(existing);
        return eventMapper.toReadDto(updated);
    }

    @Override
    public void deleteEvent(Long id) {
        if (!eventRepository.existsById(id)) {
            throw new RuntimeException("Event not found with id = " + id);
        }
        eventRepository.deleteById(id);
    }
}
