package com.CodeGym.model;

public class Position {
    private int id;
    private String name;
    private String description;
    private int maxSize;
    private int currentUnit;

    public Position() {
    }

    public Position(String name, String description, int maxSize, int currentUnit) {
        this.name = name;
        this.description = description;
        this.maxSize = maxSize;
        this.currentUnit = currentUnit;
    }

    public Position(int id, String name, String description, int maxSize, int currentUnit) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.maxSize = maxSize;
        this.currentUnit = currentUnit;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getCurrentUnit() {
        return currentUnit;
    }

    public void setCurrentUnit(int currentUnit) {
        this.currentUnit = currentUnit;
    }

    @Override
    public String toString() {
        return "'"+ name+ "', '"+ description+"', "+ maxSize+","+ currentUnit;
    }

    public String getColumns(){
        return "name, description, max_position, current_unit";
    }

}
