package com.example.serviceevent.mapper;

import com.example.serviceevent.Dto.Event.EventCreateUpdateDto;
import com.example.serviceevent.Dto.Event.EventReadDto;
import com.example.serviceevent.Dto.Event.EventShortDto;
import com.example.serviceevent.entities.Event;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {

    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "venue.id", target = "venueId")
    EventReadDto toReadDto(Event event);

    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "venue.id", target = "venueId")
    EventShortDto toShortDto(Event event);

    List<EventReadDto> toReadDtoList(List<Event> events);
    List<EventShortDto> toShortDtoList(List<Event> events);

    @Mapping(target = "category", ignore = true)
    @Mapping(target = "venue", ignore = true)
    Event fromCreateUpdateDto(EventCreateUpdateDto dto);

    @Mapping(target = "category", ignore = true)
    @Mapping(target = "venue", ignore = true)
    void updateEventFromDto(EventCreateUpdateDto dto, @MappingTarget Event event);
}
