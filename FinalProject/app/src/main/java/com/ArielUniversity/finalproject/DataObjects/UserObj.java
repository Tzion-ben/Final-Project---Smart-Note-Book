package com.ArielUniversity.finalproject.DataObjects;

import io.realm.RealmObject;

public class UserObj extends RealmObject {
    private String name;
    private String id;
    private String password;
    private String email;

    public UserObj() {}

    public UserObj(String name, String id, String password, String email) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

}