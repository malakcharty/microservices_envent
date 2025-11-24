package com.community.events.services.Impl;

import com.community.events.entities.Participant;
import com.community.events.repositories.ParticipantRepository;
import com.community.events.repositories.UserRepository;
import com.community.events.services.IServiceParticipant;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class ServiceParticipantImpl implements IServiceParticipant {

    private final ParticipantRepository repo;
    private final UserRepository userRepo;

    public ServiceParticipantImpl(ParticipantRepository repo, UserRepository userRepo) {
        this.repo = repo; this.userRepo = userRepo;
    }

    @Override
    public Participant create(Participant p) {
        if (userRepo.existsByEmail(p.getEmail()))
            throw new DataIntegrityViolationException("Email already used: " + p.getEmail());
        return repo.save(p);
    }

    @Override @Transactional(readOnly = true)
    public Participant get(Long id) {
        return repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Participant not found: " + id));
    }

    @Override @Transactional(readOnly = true)
    public List<Participant> all() { return repo.findAll(); }

    @Override
    public Participant update(Participant p) {
        Participant existing = get(p.getId());
        if (!existing.getEmail().equalsIgnoreCase(p.getEmail())
                && userRepo.existsByEmail(p.getEmail()))
            throw new DataIntegrityViolationException("Email already used: " + p.getEmail());

        existing.setEmail(p.getEmail());
        existing.setPassword(p.getPassword());
        existing.setFirstName(p.getFirstName());
        existing.setLastName(p.getLastName());
        existing.setPhone(p.getPhone());
        return repo.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) throw new EntityNotFoundException("Participant not found: " + id);
        repo.deleteById(id);
    }
}
