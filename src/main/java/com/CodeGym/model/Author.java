package com.CodeGym.model;

import java.sql.Date;

public class Author {
    private int id;
    private String name;
    private String dob;

    public Author(int id, String name, String dob) {
        this.id = id;
        this.name = name;
        this.dob = dob;
    }

    public Author(String name, String dob) {
        this.name = name;
        this.dob = dob;
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

    public String getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        dob = dob;
    }

    @Override
    public String toString() {
        return "'"+ name+ "', '"+ dob+"'";
    }

    public String getInsertColumns() {
        return "name, Dob";
    }
}
