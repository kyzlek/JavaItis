package ru.itis;

import java.sql.Connection;


public class Factory {
    private static Factory instance;
    private Connection connection = null;
    String URL = "jdbc:postgresql://localhost:5432/SimpleDb";

    String name = "postgres";
    String password = "qwerty007";

}
