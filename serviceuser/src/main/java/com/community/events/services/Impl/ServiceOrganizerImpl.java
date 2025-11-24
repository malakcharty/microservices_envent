package com.community.events.services.Impl;
import com.community.events.entities.Organizer;
import com.community.events.repositories.OrganizerRepository;
import com.community.events.repositories.UserRepository;
import com.community.events.services.IServiceOrganizer;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
@Transactional
public class ServiceOrganizerImpl implements IServiceOrganizer {
    private final OrganizerRepository repo;
    private final UserRepository userRepo;
    public ServiceOrganizerImpl(OrganizerRepository repo, UserRepository userRepo) {
        this.repo = repo; this.userRepo = userRepo;
    }
    @Override
    public Organizer create(Organizer o) {
        if (userRepo.existsByEmail(o.getEmail()))
            throw new DataIntegrityViolationException("Email already used: " + o.getEmail());
        return repo.save(o);
    }
    @Override @Transactional(readOnly = true)
    public Organizer get(Long id) {
        return repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Organizer not found: " + id));
    }
    @Override @Transactional(readOnly = true)
    public List<Organizer> all() { return repo.findAll(); }
    @Override
    public Organizer update(Organizer o) {
        Organizer existing = get(o.getId());
        if (!existing.getEmail().equalsIgnoreCase(o.getEmail())
                && userRepo.existsByEmail(o.getEmail()))
            throw new DataIntegrityViolationException("Email already used: " + o.getEmail());
        existing.setEmail(o.getEmail());
        existing.setPassword(o.getPassword());
        existing.setFirstName(o.getFirstName());
        existing.setLastName(o.getLastName());
        existing.setPhone(o.getPhone());
        return repo.save(existing);
    }
    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) throw new EntityNotFoundException("Organizer not found: " + id);
        repo.deleteById(id);
    }
}
