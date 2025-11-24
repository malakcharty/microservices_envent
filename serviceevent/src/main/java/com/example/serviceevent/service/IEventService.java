package com.example.serviceevent.service;

import com.example.serviceevent.Dto.Event.EventCreateUpdateDto;
import com.example.serviceevent.Dto.Event.EventReadDto;
import com.example.serviceevent.Dto.Event.EventShortDto;

import java.util.List;

public interface IEventService {

    List<EventShortDto> getAllEvents();

    EventReadDto getEventById(Long id);

    EventReadDto createEvent(EventCreateUpdateDto dto);

    EventReadDto updateEvent(Long id, EventCreateUpdateDto dto);

    void deleteEvent(Long id);
}

