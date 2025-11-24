package com.community.events.services.Impl;
import com.community.events.entities.Role;
import com.community.events.repositories.RoleRepository;
import com.community.events.services.IServiceRole;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class ServiceRoleImpl implements IServiceRole {
    private final RoleRepository repo;
    public ServiceRoleImpl(RoleRepository repo) { this.repo = repo; }
    @Override
    public Role create(Role role) {
        repo.findByName(role.getName()).ifPresent(r -> {
            throw new DataIntegrityViolationException("Role name already used: " + role.getName());
        });
        return repo.save(role);
    }
    @Override @Transactional(readOnly = true)
    public Role get(Long id) {
        return repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Role not found: " + id));
    }

    @Override @Transactional(readOnly = true)
    public List<Role> all() { return repo.findAll(); }

    @Override
    public Role update(Role role) {
        Role existing = get(role.getId());
        existing.setName(role.getName());
        return repo.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) throw new EntityNotFoundException("Role not found: " + id);
        repo.deleteById(id);
    }
}
