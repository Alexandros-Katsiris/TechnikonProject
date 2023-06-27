package com.example.technikonproject.repository;

import com.example.technikonproject.Model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
    Property readPropertyByE9Number(Long e9Number);
}
