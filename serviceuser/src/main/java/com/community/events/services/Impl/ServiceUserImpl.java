package com.community.events.services.Impl;

import com.community.events.entities.Role;
import com.community.events.entities.User;
import com.community.events.repositories.RoleRepository;
import com.community.events.repositories.UserRepository;
import com.community.events.services.IServiceUser;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class ServiceUserImpl implements IServiceUser {

    private final UserRepository userRepo;
    private final RoleRepository roleRepo;

    public ServiceUserImpl(UserRepository userRepo, RoleRepository roleRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }

    @Override
    public User create(User user) {
        if (userRepo.existsByEmail(user.getEmail()))
            throw new DataIntegrityViolationException("Email already used: " + user.getEmail());
        return userRepo.save(user);
    }

    @Override @Transactional(readOnly = true)
    public User get(Long id) {
        return userRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found: " + id));
    }

    @Override @Transactional(readOnly = true)
    public List<User> all() { return userRepo.findAll(); }

    @Override
    public User update(User user) {
        User existing = get(user.getId());
        if (!existing.getEmail().equalsIgnoreCase(user.getEmail())
                && userRepo.existsByEmail(user.getEmail()))
            throw new DataIntegrityViolationException("Email already used: " + user.getEmail());

        existing.setEmail(user.getEmail());
        existing.setPassword(user.getPassword());
        existing.setFirstName(user.getFirstName());
        existing.setLastName(user.getLastName());
        existing.setPhone(user.getPhone());
        return userRepo.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!userRepo.existsById(id)) throw new EntityNotFoundException("User not found: " + id);
        userRepo.deleteById(id);
    }

    @Override @Transactional(readOnly = true)
    public User findByEmail(String email) {
        return userRepo.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("User not found: " + email));
    }

    @Override
    public User addRole(Long userId, Long roleId) {
        User user = get(userId);
        Role role = roleRepo.findById(roleId)
                .orElseThrow(() -> new EntityNotFoundException("Role not found: " + roleId));
        user.getRoles().add(role);
        return userRepo.save(user);
    }

    @Override
    public User removeRole(Long userId, Long roleId) {
        User user = get(userId);
        Role role = roleRepo.findById(roleId)
                .orElseThrow(() -> new EntityNotFoundException("Role not found: " + roleId));
        user.getRoles().remove(role);
        return userRepo.save(user);
    }
}
