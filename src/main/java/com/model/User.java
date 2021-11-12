package com.model;

public class User {
    protected int id;
    protected String name;
    protected String email;
    protected String country;
    private Type type;

    public User() {
    }

    public User(int id, String name, String email, String country) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.country = country;
    }

    public User(String name, String email, String country) {
        this.name = name;
        this.email = email;
        this.country = country;
    }

    public User(int id, String name, String email, String country, Type type) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.country = country;
        this.type = type;
    }

    public User(String name, String email, String country, Type type) {
        this.name = name;
        this.email = email;
        this.country = country;
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
