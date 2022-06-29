package com.CodeGym.controller;

import com.CodeGym.model.Author;
import com.CodeGym.model.Book;
import com.CodeGym.model.Category;
import com.CodeGym.model.Position;
import com.CodeGym.service.authorService.AuthorService;
import com.CodeGym.service.bookService.BookService;
import com.CodeGym.service.bookService.IBookService;
import com.CodeGym.service.categoryService.CategoryService;
import com.CodeGym.service.positionService.PositionService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "BookServlet", value = "/book")
public class BookServlet extends HttpServlet {
    IBookService bookService = BookService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = "";
        action = request.getParameter("action");

        switch (action) {
            case "list":
                showListBook(request, response);
                break;
            case "add":
                formAdd(request, response);
                break;
            case "uploadImg":
                formUploadImg(request, response);
                break;
        }
    }

    private void formUploadImg(HttpServletRequest request, HttpServletResponse response) {

    }

    private void formAdd(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/book/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private HashMap<Integer, Book> showListBook(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/book/list.jsp");
        HashMap<Integer, Book> bookHashMap = bookService.find("");
        request.setAttribute("listBook", bookHashMap.values());
        HashMap<Integer, Category> categoryHashMap = CategoryService.getInstance().find("");
        request.setAttribute("listCategory", categoryHashMap.values());
        HashMap<Integer, Position> positionHashMap = PositionService.getInstance().find("");
        request.setAttribute("listPosition", positionHashMap.values());
        HashMap<Integer, Author> authorHashMap = AuthorService.getInstance().find("");
        request.setAttribute("listAuthor", authorHashMap.values());
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return bookHashMap;
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "create":
                addBook(request, response);
                break;
            case "edit":
                editBook(request, response);
                break;
            case "uploadImg":
                //uploadImage(request, response, "");
                break;
        }
    }

    ;

    private void editBook(HttpServletRequest request, HttpServletResponse response) {
    }

    private void addBook(HttpServletRequest request, HttpServletResponse response) {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String image = "";
        int authorId = Integer.parseInt(request.getParameter("author"));
        int categoryId = Integer.parseInt(request.getParameter("category"));
        int positionId = Integer.parseInt(request.getParameter("position"));

        Author author = AuthorService.getInstance().findById(authorId);
        Position position = PositionService.getInstance().findById(positionId);
        Category category = CategoryService.getInstance().findById(categoryId);
        Book book = new Book(title,description,image,author,position,category);
        try {
            BookService.getInstance().create(book);
            response.sendRedirect("/position?action=list");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
