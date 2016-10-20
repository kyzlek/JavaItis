package ru.itis.dao;


import ru.itis.models.Owner;

import java.sql.Connection;
import java.util.List;

public interface OwnersDao {
    List<Owner> getAllOwners();
    Owner find(int id);
    void update(Owner owner);
}
