package com.example.mytechnikonproject.repository;

import com.example.mytechnikonproject.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
    Property readPropertyByE9Number(Long e9Number);
}
