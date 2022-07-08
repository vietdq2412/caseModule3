package com.CodeGym.service.bookService;

import com.CodeGym.model.Author;
import com.CodeGym.model.Book;
import com.CodeGym.model.Category;
import com.CodeGym.model.Position;
import com.CodeGym.service.DBHandler;
import com.CodeGym.service.authorService.AuthorService;
import com.CodeGym.service.categoryService.CategoryService;
import com.CodeGym.service.positionService.PositionService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class BookService implements IBookService {
    private DBHandler<Book> bookDBHandler = DBHandler.getInstance();
    private final String BOOK_TABLE = "book";

    private static BookService instance;

    private BookService() {

    }

    public static BookService getInstance() {
        if (instance == null) {
            instance = new BookService();
            return instance;
        }
        return instance;
    }
    @Override
    public Boolean create(Book book) {
        return bookDBHandler.insertData(BOOK_TABLE, book, book.getColumns());
    }

    @Override
    public HashMap<Integer, Book> find(String condition) {
        HashMap<Integer, Book> bookMap = new HashMap<>();
        ResultSet rs = bookDBHandler.findAllByCondition(BOOK_TABLE,condition);


        try {
            while (rs.next()){
                String title = rs.getString("title");
                String description = rs.getString("description");
                String image = rs.getString("image");
                int id = rs.getInt("id");
                int authorId = rs.getInt("authorId");
                int positionId = rs.getInt("positionId");
                int categoryId = rs.getInt("positionId");
                Author author = AuthorService.getInstance().findById(authorId);
                Position position = PositionService.getInstance().findById(positionId);
                Category category = CategoryService.getInstance().findById(categoryId);

                Book book = new Book(id, title, description,image, author, position,category);
                bookMap.put(id, book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bookMap;
    }

    @Override
    public Book findById(int id) {
        String condition = "Where id = " + id;
        return find(condition).get(id);
    }

    @Override
    public Book update(int id) {
        return null;
    }

    @Override
    public Book delete(int id) {
        return null;
    }
}
