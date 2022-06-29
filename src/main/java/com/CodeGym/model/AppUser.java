package com.CodeGym.model;

public class AppUser {
    private int id;
    private String email;

    private String password;

    public AppUser() {
    }

    public AppUser(int id, String password, String email) {
        this.id = id;
        this.password = password;
        this.email = email;
    }

    public AppUser( String password, String email) {
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInsertColumns() {
        return "email, password";
    }

    @Override
    public String toString() {
        return "'"+ email+ "', '"+ password+"'";
    }
}
