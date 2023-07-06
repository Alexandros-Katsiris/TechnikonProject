package com.example.technikonproject.repository;

import com.example.technikonproject.domain.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
    Property readPropertyByE9Number(Long e9Number);

    List<Property> findByWebUserTin(Long tin);
}
