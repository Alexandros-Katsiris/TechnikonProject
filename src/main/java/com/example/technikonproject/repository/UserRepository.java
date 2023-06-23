package com.example.technikonproject.repository;

import com.example.technikonproject.Model.PropertyOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<PropertyOwner,Integer> {

}
