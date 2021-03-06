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
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet(name = "BookServlet", value = "/book")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class BookServlet extends HttpServlet {
    private IBookService bookService = BookService.getInstance();
    private Gson gson = new Gson();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = "";
        action = request.getParameter("action");
        String catID = request.getParameter("category-id");
        String authorID = request.getParameter("author-id");
        String positionID = request.getParameter("position-id");
        switch (action) {
            case "list":
                String condition = "";
                if (catID != null) {
                    condition = "where categoryId = " + catID;
                }
                if (authorID != null) {
                    condition = "where authorId = " + authorID;
                }
                if (positionID != null) {
                    condition = "where positionId = " + positionID;
                }
                showListBook(request, response, condition);
                break;
            case "add":
                formAdd(request, response);
                break;
            case "uploadImg":
                formUploadImg(request, response);
                break;
        }
    }

    private void showListBookByCategory(HttpServletRequest request, HttpServletResponse response, String catID) {

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

    private void showListBook(HttpServletRequest request, HttpServletResponse response, String condition) {
        HashMap<Integer, Book> bookHashMap = bookService.find(condition);
        HashMap<Integer, Category> categoryHashMap = CategoryService.getInstance().find("");
        HashMap<Integer, Position> positionHashMap = PositionService.getInstance().find("");
        HashMap<Integer, Author> authorHashMap = AuthorService.getInstance().find("");
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/book/list.jsp");
//        request.setAttribute("listBook", bookHashMap.values());
//        request.setAttribute("listCategory", categoryHashMap.values());
//        request.setAttribute("listPosition", positionHashMap.values());
//        request.setAttribute("listAuthor", authorHashMap.values());
//        try {
//            requestDispatcher.forward(request, response);
//        } catch (ServletException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        HashMap<String, HashMap> data = new HashMap<>();
        data.put("listBook", bookHashMap);
        data.put("listCategory", categoryHashMap);
        data.put("listPosition", positionHashMap);
        data.put("listAuthor", authorHashMap);
        String booksJsonString = this.gson.toJson(data);
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        response.setContentType("text/javascript");
        response.setCharacterEncoding("UTF-8");
        out.print(booksJsonString);
        out.flush();
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
        int authorId = Integer.parseInt(request.getParameter("author"));
        int categoryId = Integer.parseInt(request.getParameter("category"));
        int positionId = Integer.parseInt(request.getParameter("position"));
        String image = request.getParameter("image");
        Book book = new Book(title, description, image, authorId, positionId, categoryId);
        try {
            BookService.getInstance().create(book);
            response.sendRedirect("/book?action=list");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
