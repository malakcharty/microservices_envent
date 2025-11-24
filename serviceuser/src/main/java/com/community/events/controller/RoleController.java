package com.community.events.controller;
import com.community.events.dto.role.RoleDto;
import com.community.events.entities.Role;
import com.community.events.mapper.RoleMapper;
import com.community.events.services.IServiceRole;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    private final IServiceRole service;
    private final RoleMapper mapper;

    public RoleController(IServiceRole service, RoleMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    // ➤ GET ALL
    @GetMapping
    public List<RoleDto> all() {
        return service.all()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    // ➤ GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<RoleDto> get(@PathVariable Long id) {
        try {
            Role role = service.get(id);
            return ResponseEntity.ok(mapper.toDto(role));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // ➤ CREATE
    @PostMapping
    public ResponseEntity<RoleDto> create(@RequestBody RoleDto dto) {
        try {
            Role entity = mapper.toEntity(dto);
            Role saved = service.create(entity);
            return ResponseEntity.created(URI.create("/api/roles/" + saved.getId()))
                    .body(mapper.toDto(saved));
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // ➤ UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<RoleDto> update(@PathVariable Long id, @RequestBody RoleDto dto) {
        try {
            Role existing = service.get(id);

            Role updated = mapper.partialUpdate(dto, existing);
            Role saved = service.update(updated);

            return ResponseEntity.ok(mapper.toDto(saved));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // ➤ DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
