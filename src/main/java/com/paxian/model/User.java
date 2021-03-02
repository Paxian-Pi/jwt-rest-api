package com.paxian.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Document(collection = "SpringCollections")
public class User {

    @Id
    private String id;
    private String username;
    private String password;
    private int active;
    private String role = "";
    private String permissions = "";

    public User(String username, String password, String role, String permissions) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.permissions = permissions;
        this.active = 1;
    }

    protected User() {}

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getActive() {
        return active;
    }

    public String getRole() {
        return role;
    }

    public String getPermissions() {
        return permissions;
    }

    public List<String> getRoleList() {
        if(this.role.length() > 0) {
            return Arrays.asList(this.role.split(","));
        }
        return new ArrayList<>();
    }

    public List<String> getPermissionList() {
        if(this.permissions.length() > 0) {
            return Arrays.asList(this.permissions.split(","));
        }
        return new ArrayList<>();
    }
}
