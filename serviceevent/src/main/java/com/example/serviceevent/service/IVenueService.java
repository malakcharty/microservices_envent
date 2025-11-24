package com.example.serviceevent.service;

import com.example.serviceevent.Dto.Venue.VenueCreateUpdateDto;
import com.example.serviceevent.Dto.Venue.VenueReadDto;
import com.example.serviceevent.Dto.Venue.VenueShortDto;

import java.util.List;

public interface IVenueService {

    List<VenueShortDto> getAllVenues();

    VenueReadDto getVenueById(Long id);

    VenueReadDto createVenue(VenueCreateUpdateDto dto);

    VenueReadDto updateVenue(Long id, VenueCreateUpdateDto dto);

    void deleteVenue(Long id);
}
