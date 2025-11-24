package com.example.serviceevent.mapper;

import com.example.serviceevent.Dto.Event.EventCreateUpdateDto;
import com.example.serviceevent.Dto.Event.EventReadDto;
import com.example.serviceevent.Dto.Event.EventShortDto;
import com.example.serviceevent.entities.Event;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventMapper {

    EventReadDto toReadDto(Event event);

    EventShortDto toShortDto(Event event);

    List<EventReadDto> toReadDtoList(List<Event> events);

    List<EventShortDto> toShortDtoList(List<Event> events);

    Event fromCreateUpdateDto(EventCreateUpdateDto dto);

    void updateEventFromDto(EventCreateUpdateDto dto, @MappingTarget Event event);
}
