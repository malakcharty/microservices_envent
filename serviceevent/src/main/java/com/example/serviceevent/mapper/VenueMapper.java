package com.example.serviceevent.mapper;

import com.example.serviceevent.Dto.Venue.VenueCreateUpdateDto;
import com.example.serviceevent.Dto.Venue.VenueReadDto;
import com.example.serviceevent.Dto.Venue.VenueShortDto;
import com.example.serviceevent.entities.Venue;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface VenueMapper {

    VenueShortDto toShortDto(Venue venue);

    VenueReadDto toReadDto(Venue venue);

    List<VenueShortDto> toShortDtoList(List<Venue> venues);

    List<VenueReadDto> toReadDtoList(List<Venue> venues);

    @Mapping(target = "id", ignore = true)
    Venue fromCreateUpdateDto(VenueCreateUpdateDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateVenueFromDto(VenueCreateUpdateDto dto,
                            @MappingTarget Venue venue);
}
