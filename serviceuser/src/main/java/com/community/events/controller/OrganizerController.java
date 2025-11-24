package com.community.events.controller;
import com.community.events.dto.organizer.OrganizerCreateUpdateDto;
import com.community.events.dto.organizer.OrganizerReadDto;
import com.community.events.entities.Organizer;
import com.community.events.mapper.OrganizerMapper;
import com.community.events.repositories.OrganizerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/organizers")
public class OrganizerController {

    private final OrganizerRepository organizerRepository;
    private final OrganizerMapper organizerMapper;

    public OrganizerController(OrganizerRepository organizerRepository,
                               OrganizerMapper organizerMapper) {
        this.organizerRepository = organizerRepository;
        this.organizerMapper = organizerMapper;
    }

    @GetMapping
    public List<OrganizerReadDto> getAllOrganizers() {
        List<Organizer> organizers = organizerRepository.findAll();
        return organizers.stream()
                .map(organizerMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public OrganizerReadDto getOrganizer(@PathVariable Long id) {
        Organizer organizer = organizerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Organizer not found with id = " + id));

        return organizerMapper.toDto(organizer);
    }

    @PostMapping
    public ResponseEntity<OrganizerReadDto> createOrganizer(
            @RequestBody OrganizerCreateUpdateDto dto) {

        Organizer organizer = organizerMapper.fromCreateUpdateDto(dto);
        Organizer saved = organizerRepository.save(organizer);

        OrganizerReadDto result = organizerMapper.toDto(saved);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public OrganizerReadDto updateOrganizer(@PathVariable Long id,
                                            @RequestBody OrganizerCreateUpdateDto dto) {

        Organizer existing = organizerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Organizer not found with id = " + id));

        organizerMapper.updateOrganizerFromDto(dto, existing);

        Organizer updated = organizerRepository.save(existing);
        return organizerMapper.toDto(updated);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrganizer(@PathVariable Long id) {
        if (!organizerRepository.existsById(id)) {
            throw new RuntimeException("Organizer not found with id = " + id);
        }
        organizerRepository.deleteById(id);
    }
}
