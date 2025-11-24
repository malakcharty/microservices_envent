package com.community.events.controller;

import com.community.events.dto.user.UserCreateUpdateDto;
import com.community.events.dto.user.UserReadDto;
import com.community.events.entities.User;
import com.community.events.entities.Role;
import com.community.events.mapper.UserMapper;
import com.community.events.services.IServiceUser;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final IServiceUser userService;
    private final UserMapper userMapper;

    public UserController(IServiceUser userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    // -------------------- GET ALL --------------------
    @GetMapping
    public List<UserReadDto> all() {
        return userService.all()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    // -------------------- GET BY ID --------------------
    @GetMapping("/{id}")
    public ResponseEntity<UserReadDto> get(@PathVariable Long id) {
        try {
            User user = userService.get(id);
            return ResponseEntity.ok(userMapper.toDto(user));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // -------------------- CREATE --------------------
    @PostMapping
    public ResponseEntity<UserReadDto> create(@RequestBody UserCreateUpdateDto dto) {
        try {
            User user = new User();
            user.setEmail(dto.getEmail());
            user.setPassword(dto.getPassword());
            user.setFirstName(dto.getFirstName());
            user.setLastName(dto.getLastName());
            user.setPhone(dto.getPhone());

            User saved = userService.create(user);

            return ResponseEntity
                    .created(URI.create("/api/users/" + saved.getId()))
                    .body(userMapper.toDto(saved));

        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // -------------------- UPDATE --------------------
    @PutMapping("/{id}")
    public ResponseEntity<UserReadDto> update(
            @PathVariable Long id,
            @RequestBody UserCreateUpdateDto dto
    ) {
        try {
            User existing = userService.get(id);

            existing.setEmail(dto.getEmail());
            existing.setPassword(dto.getPassword());
            existing.setFirstName(dto.getFirstName());
            existing.setLastName(dto.getLastName());
            existing.setPhone(dto.getPhone());

            User saved = userService.update(existing);

            return ResponseEntity.ok(userMapper.toDto(saved));

        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // -------------------- DELETE --------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            userService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // -------------------- ADD ROLE TO USER --------------------
    @PostMapping("/{userId}/roles/{roleId}")
    public ResponseEntity<UserReadDto> addRole(
            @PathVariable Long userId,
            @PathVariable Long roleId
    ) {
        try {
            User updated = userService.addRole(userId, roleId);
            return ResponseEntity.ok(userMapper.toDto(updated));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // -------------------- REMOVE ROLE FROM USER --------------------
    @DeleteMapping("/{userId}/roles/{roleId}")
    public ResponseEntity<UserReadDto> removeRole(
            @PathVariable Long userId,
            @PathVariable Long roleId
    ) {
        try {
            User updated = userService.removeRole(userId, roleId);
            return ResponseEntity.ok(userMapper.toDto(updated));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // -------------------- FIND BY EMAIL --------------------
    @GetMapping("/search")
    public ResponseEntity<UserReadDto> findByEmail(@RequestParam String email) {
        try {
            User user = userService.findByEmail(email);
            return ResponseEntity.ok(userMapper.toDto(user));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
