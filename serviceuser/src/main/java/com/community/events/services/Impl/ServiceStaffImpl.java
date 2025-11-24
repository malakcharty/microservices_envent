package com.community.events.services.Impl;

import com.community.events.entities.Staff;
import com.community.events.repositories.StaffRepository;
import com.community.events.repositories.UserRepository;
import com.community.events.services.IServiceStaff;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class ServiceStaffImpl implements IServiceStaff {

    private final StaffRepository repo;
    private final UserRepository userRepo;

    public ServiceStaffImpl(StaffRepository repo, UserRepository userRepo) {
        this.repo = repo; this.userRepo = userRepo;
    }

    @Override
    public Staff create(Staff s) {
        if (userRepo.existsByEmail(s.getEmail()))
            throw new DataIntegrityViolationException("Email already used: " + s.getEmail());
        return repo.save(s);
    }

    @Override @Transactional(readOnly = true)
    public Staff get(Long id) {
        return repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Staff not found: " + id));
    }

    @Override @Transactional(readOnly = true)
    public List<Staff> all() { return repo.findAll(); }

    @Override
    public Staff update(Staff s) {
        Staff existing = get(s.getId());
        if (!existing.getEmail().equalsIgnoreCase(s.getEmail())
                && userRepo.existsByEmail(s.getEmail()))
            throw new DataIntegrityViolationException("Email already used: " + s.getEmail());

        existing.setEmail(s.getEmail());
        existing.setPassword(s.getPassword());
        existing.setFirstName(s.getFirstName());
        existing.setLastName(s.getLastName());
        existing.setPhone(s.getPhone());
        return repo.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) throw new EntityNotFoundException("Staff not found: " + id);
        repo.deleteById(id);
    }
}
