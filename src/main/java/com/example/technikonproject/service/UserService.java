package com.example.technikonproject.service;

import com.example.technikonproject.Model.PropertyOwner;
import com.example.technikonproject.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public PropertyOwner findById(Integer id){
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("This id doesnt exists."));
    }
}
