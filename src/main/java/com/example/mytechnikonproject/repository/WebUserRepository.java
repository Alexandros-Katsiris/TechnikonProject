package com.example.mytechnikonproject.repository;

import com.example.mytechnikonproject.entity.WebUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebUserRepository extends JpaRepository<WebUser, Long> {
    //void deleteByTin(Integer tin);
    WebUser readWebUserByTin(Long tin);
}
