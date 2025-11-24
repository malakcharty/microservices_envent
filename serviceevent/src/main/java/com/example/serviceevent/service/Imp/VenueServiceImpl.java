package com.example.serviceevent.service.Imp;

import com.example.serviceevent.Dto.Venue.VenueCreateUpdateDto;
import com.example.serviceevent.Dto.Venue.VenueReadDto;
import com.example.serviceevent.Dto.Venue.VenueShortDto;
import com.example.serviceevent.entities.Venue;
import com.example.serviceevent.mapper.VenueMapper;
import com.example.serviceevent.Repositories.VenueRepository;
import com.example.serviceevent.service.IVenueService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueServiceImpl implements IVenueService {

    private final VenueRepository venueRepository;
    private final VenueMapper venueMapper;

    public VenueServiceImpl(VenueRepository venueRepository,
                            VenueMapper venueMapper) {
        this.venueRepository = venueRepository;
        this.venueMapper = venueMapper;
    }

    @Override
    public List<VenueShortDto> getAllVenues() {
        List<Venue> venues = venueRepository.findAll();
        return venueMapper.toShortDtoList(venues);
    }

    @Override
    public VenueReadDto getVenueById(Long id) {
        Venue venue = venueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venue not found with id = " + id));
        return venueMapper.toReadDto(venue);
    }

    @Override
    public VenueReadDto createVenue(VenueCreateUpdateDto dto) {
        Venue venue = venueMapper.fromCreateUpdateDto(dto);
        Venue saved = venueRepository.save(venue);
        return venueMapper.toReadDto(saved);
    }

    @Override
    public VenueReadDto updateVenue(Long id, VenueCreateUpdateDto dto) {
        Venue existing = venueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venue not found with id = " + id));

        venueMapper.updateVenueFromDto(dto, existing);

        Venue updated = venueRepository.save(existing);
        return venueMapper.toReadDto(updated);
    }

    @Override
    public void deleteVenue(Long id) {
        if (!venueRepository.existsById(id)) {
            throw new RuntimeException("Venue not found with id = " + id);
        }
        venueRepository.deleteById(id);
    }
}
