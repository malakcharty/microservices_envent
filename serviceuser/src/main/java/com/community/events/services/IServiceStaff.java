package com.community.events.services;
import com.community.events.entities.Staff;
import java.util.List;

public interface IServiceStaff {
    Staff create(Staff staff);
    Staff get(Long id);
    List<Staff> all();
    Staff update(Staff staff);
    void delete(Long id);
}
