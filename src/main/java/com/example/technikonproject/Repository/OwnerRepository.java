package com.example.technikonproject.Repository;

import com.example.technikonproject.Model.Owner;

public interface OwnerRepository {

    boolean createOwner();
    Owner readOwner();
    boolean updateOwner();
    boolean deleteOwner();
}
