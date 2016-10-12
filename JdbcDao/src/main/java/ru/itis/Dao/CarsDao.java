package ru.itis.Dao;

import ru.itis.Models.Cars;

import java.util.List;

/**
 * Created by KFU-user on 12.10.2016.
 */
public interface CarsDao {
    Cars find(int id);
    List getAll();
    void delete(int id);
    void update(Cars cars);
    void add(Cars cars);
}
