package ru.itis.models;

/**
 * Created by admin on 06.10.2016.
 */
public class User {
    private String name;
    private String password;
    private int age;
    private int userId;

    public int getId() {
        return userId;
    }

    public User(String name, String password, int age, int id) {
        this.name = name;
        this.password = password;
        this.age = age;
        this.userId = id;

    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }
}
