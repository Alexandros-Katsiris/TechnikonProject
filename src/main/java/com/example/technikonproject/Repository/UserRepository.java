package com.example.technikonproject.Repository;

import com.example.technikonproject.Model.Parent.User;

public interface UserRepository {

    boolean createOwner();
    User readOwner();
    boolean updateOwner();
    boolean deleteOwner();
}
