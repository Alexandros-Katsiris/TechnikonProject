package com.example.technikonproject.repository;

import com.example.technikonproject.Model.User;

public interface UserRepository {

    boolean createOwner();
    User readOwner();
    boolean updateOwner();
    boolean deleteOwner();
}
