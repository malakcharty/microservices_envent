package com.community.events.controller;

import com.community.events.dto.participant.ParticipantCreateUpdateDto;
import com.community.events.dto.participant.ParticipantReadDto;
import com.community.events.entities.Participant;
import com.community.events.mapper.ParticipantMapper;
import com.community.events.services.IServiceParticipant;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/participants")
public class ParticipantController {

    private final IServiceParticipant participantService;
    private final ParticipantMapper participantMapper;

    public ParticipantController(IServiceParticipant participantService,
                                 ParticipantMapper participantMapper) {
        this.participantService = participantService;
        this.participantMapper = participantMapper;
    }

    @GetMapping
    public List<ParticipantReadDto> getAllParticipants() {
        List<Participant> participants = participantService.all();
        return participantMapper.toDtoList(participants);
    }

    @GetMapping("/{id}")
    public ParticipantReadDto getParticipant(@PathVariable Long id) {
        Participant participant = participantService.get(id);
        return participantMapper.toDto(participant);
    }

    @PostMapping
    public ResponseEntity<ParticipantReadDto> createParticipant(
            @RequestBody ParticipantCreateUpdateDto dto) {

        Participant participant = participantMapper.fromCreateUpdateDto(dto);

        Participant saved = participantService.create(participant);

        ParticipantReadDto result = participantMapper.toDto(saved);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ParticipantReadDto updateParticipant(@PathVariable Long id,
                                                @RequestBody ParticipantCreateUpdateDto dto) {

        Participant toUpdate = participantMapper.fromCreateUpdateDto(dto);
        try {
            toUpdate.setId(id);
        } catch (Exception e) {
            throw new RuntimeException("Assure-toi que Participant a bien setId(Long id)", e);
        }

        Participant updated = participantService.update(toUpdate);
        return participantMapper.toDto(updated);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteParticipant(@PathVariable Long id) {
        participantService.delete(id);
    }
}
