package com.community.events.services;
import com.community.events.entities.User;
import java.util.List;
public interface IServiceUser {
    User create(User user);
    User get(Long id);
    List<User> all();
    User update(User user);
    void delete(Long id);
    User findByEmail(String email);
    User addRole(Long userId, Long roleId);
    User removeRole(Long userId, Long roleId);
}
