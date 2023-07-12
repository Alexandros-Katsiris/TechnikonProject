package com.example.technikonproject.repository;

import com.example.technikonproject.domain.PropertyRepair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PropertyRepairRepository extends JpaRepository<PropertyRepair, Long> {

    List<PropertyRepair> findAllLazy();

    List<PropertyRepair> searchPropertyRepairsByWebUserId(Long id);

    List<PropertyRepair> searchPropertyRepairsByDateOfScheduledRepairBetween(LocalDate dateStart, LocalDate dateEnd);
}
