package com.example.bookstore.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class Registeration {
    @NotEmpty
    @Size(min = 5, max = 30)
    private String username = "";

    @NotEmpty
    @Size(min = 7, max = 30)
    private String password = "";

    @NotEmpty
    private String role = "USER";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
