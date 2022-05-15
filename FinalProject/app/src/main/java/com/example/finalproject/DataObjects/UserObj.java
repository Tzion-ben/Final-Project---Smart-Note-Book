package com.example.finalproject;

public class User {
    private String name;
    private String id;
    private String passeword;
    private String email;


    public User(String name, String id, String passeword, String email) {
        this.name = name;
        this.id = id;
        this.passeword = passeword;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getPasseword() {
        return passeword;
    }

    public String getEmail() {
        return email;
    }

}