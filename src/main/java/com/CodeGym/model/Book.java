package com.CodeGym.model;

public class Book {
    private int id;
    private String title;
    private String description;
    private String image;
    private Author author;
    private Position position;
    private Category category;

    public Book(int id, String title, String description, String image, Author author, Position position, Category category) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.author = author;
        this.position = position;
        this.category = category;
    }

    public Book(String title, String description, String image, Author author, Position position, Category category) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.author = author;
        this.position = position;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "'"+ title+ "', '"+ description+"', '"+ image+"',"+ author.getId()+","+ position.getId()+","+category.getId();
    }

    public String getColumns(){
        return "title, description, image, authorId, positionId, categoryId";
    }
}
