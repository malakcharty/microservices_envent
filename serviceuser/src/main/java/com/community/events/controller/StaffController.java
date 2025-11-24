package com.community.events.controller;

import com.community.events.dto.staff.StaffCreateUpdateDto;
import com.community.events.dto.staff.StaffReadDto;
import com.community.events.entities.Staff;
import com.community.events.mapper.StaffMapper;
import com.community.events.services.IServiceStaff;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

    private final IServiceStaff staffService;
    private final StaffMapper staffMapper;

    public StaffController(IServiceStaff staffService, StaffMapper staffMapper) {
        this.staffService = staffService;
        this.staffMapper = staffMapper;
    }

    @GetMapping
    public List<StaffReadDto> all() {
        return staffService.all()
                .stream()
                .map(staffMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StaffReadDto> get(@PathVariable Long id) {
        try {
            Staff staff = staffService.get(id);
            return ResponseEntity.ok(staffMapper.toDto(staff));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<StaffReadDto> create(@RequestBody StaffCreateUpdateDto dto) {
        try {
            Staff staff = new Staff();
            staff.setEmail(dto.getEmail());
            staff.setPassword(dto.getPassword());
            staff.setFirstName(dto.getFirstName());
            staff.setLastName(dto.getLastName());
            staff.setPhone(dto.getPhone());

            Staff saved = staffService.create(staff);

            return ResponseEntity
                    .created(URI.create("/api/staff/" + saved.getId()))
                    .body(staffMapper.toDto(saved));

        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<StaffReadDto> update(@PathVariable Long id,
                                               @RequestBody StaffCreateUpdateDto dto) {
        try {
            Staff existing = staffService.get(id);

            existing.setEmail(dto.getEmail());
            existing.setPassword(dto.getPassword());
            existing.setFirstName(dto.getFirstName());
            existing.setLastName(dto.getLastName());
            existing.setPhone(dto.getPhone());

            Staff saved = staffService.update(existing);
            return ResponseEntity.ok(staffMapper.toDto(saved));

        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            staffService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
