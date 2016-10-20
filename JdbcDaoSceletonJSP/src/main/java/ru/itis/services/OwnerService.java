package ru.itis.services;

import ru.itis.models.Owner;

import java.util.List;

public interface OwnerService {
    Owner findUserById(int id);
    void updateOwner(Owner owner);
    List<Owner> getAllOwners();
    void addNewOwner(Owner owner);
}
