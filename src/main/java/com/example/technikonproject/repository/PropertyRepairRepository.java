package com.example.technikonproject.repository;

import com.example.technikonproject.Model.PropertyRepair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PropertyRepairRepository extends JpaRepository<PropertyRepair, Long> {

    @Query(value = "SELECT * FROM property_repair WHERE web_user_id = :tin", nativeQuery = true)
    List<PropertyRepair> searchPropertyRepair(@Param("tin") Long tin);
    @Query(value = "SELECT * FROM property_repair WHERE date_of_scheduled_repair = :date", nativeQuery = true)
    List<PropertyRepair> searchPropertyRepair(@Param("date") LocalDate date);
}
