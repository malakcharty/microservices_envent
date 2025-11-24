package com.example.serviceevent.Repositories;


import com.example.serviceevent.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
