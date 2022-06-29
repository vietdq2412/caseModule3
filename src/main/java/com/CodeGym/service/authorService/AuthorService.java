package com.CodeGym.service.authorService;

import com.CodeGym.model.Author;
import com.CodeGym.service.DBHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class AuthorService implements IAuthorService{
    private final String AUTHOR_TABLE = "author";
    DBHandler<Author> authorDBHandler = DBHandler.getInstance();

    private static AuthorService instance;

    private AuthorService() {

    }

    public static AuthorService getInstance() {
        if (instance == null) {
            instance = new AuthorService();
            return instance;
        }
        return instance;
    }
    @Override
    public Boolean create(Author author) {
        return authorDBHandler.insertData("author", author, author.getInsertColumns());
    }

    @Override
    public HashMap<Integer, Author> find(String condition) {
        ResultSet rs = authorDBHandler.findAllByCondition(AUTHOR_TABLE,condition);
        HashMap<Integer, Author> authorHashMap = new HashMap<>();
        try {
            while (rs.next()){
                String name = rs.getString("name");
                String dob = rs.getString("Dob");
                int id = rs.getInt("id");
                Author author = new Author(id, name, dob);
                authorHashMap.put(id, author);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return authorHashMap;
    }

    @Override
    public Author findById(int id) {
        String condition = "Where id = " + id;
        return find(condition).get(id);
    }

    @Override
    public Author update(int id) {
        return null;
    }

    @Override
    public Author delete(int id) {
        return null;
    }
}
