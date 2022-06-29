package com.CodeGym.service.categoryService;

import com.CodeGym.model.Category;
import com.CodeGym.service.DBHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class CategoryService implements ICategoryService{
    private static CategoryService instance;
    private DBHandler<Category> categoryDBHandler = DBHandler.getInstance();
    private final String CATEGORY_TABLE = "category";

    private CategoryService() {

    }

    public static CategoryService getInstance() {
        if (instance == null) {
            instance = new CategoryService();
            return instance;
        }
        return instance;
    }
    @Override
    public Boolean create(Category category) {
        return categoryDBHandler.insertData(CATEGORY_TABLE, category, category.getInsertColumns());
    }

    @Override
    public HashMap<Integer, Category> find(String condition) {
        ResultSet rs = categoryDBHandler.findAllByCondition(CATEGORY_TABLE,condition);
        HashMap<Integer, Category> categoryHashMap = new HashMap<>();
        try {
            while (rs.next()){
                String name = rs.getString("name");
                int id = rs.getInt("id");
                Category category = new Category(id, name);
                categoryHashMap.put(id, category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categoryHashMap;
    }

    @Override
    public Category findById(int id) {
        String condition = "Where id = " + id;
        return find(condition).get(id);
    }

    @Override
    public Category update(int id) {
        return null;
    }

    @Override
    public Category delete(int id) {
        return null;
    }
}
