package com.community.events.services;
import com.community.events.entities.Role;
import java.util.List;

public interface IServiceRole {
        Role create(Role role);
        Role get(Long id);
        List<Role> all();
        Role update(Role role);
        void delete(Long id);
}