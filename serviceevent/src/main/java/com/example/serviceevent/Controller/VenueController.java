package com.example.serviceevent.Controller;

import com.example.serviceevent.Dto.Venue.VenueCreateUpdateDto;
import com.example.serviceevent.Dto.Venue.VenueReadDto;
import com.example.serviceevent.Dto.Venue.VenueShortDto;
import com.example.serviceevent.service.IVenueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/venues")
public class VenueController {

    private final IVenueService venueService;

    public VenueController(IVenueService venueService) {
        this.venueService = venueService;
    }

    @GetMapping
    public List<VenueShortDto> getAllVenues() {
        return venueService.getAllVenues();
    }

    @GetMapping("/{id}")
    public VenueReadDto getVenue(@PathVariable Long id) {
        return venueService.getVenueById(id);
    }

    @PostMapping
    public ResponseEntity<VenueReadDto> createVenue(
            @RequestBody VenueCreateUpdateDto dto) {
        VenueReadDto created = venueService.createVenue(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public VenueReadDto updateVenue(@PathVariable Long id,
                                    @RequestBody VenueCreateUpdateDto dto) {
        return venueService.updateVenue(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVenue(@PathVariable Long id) {
        venueService.deleteVenue(id);
    }
}
