package com.CodeGym.controller;

import com.CodeGym.model.Author;
import com.CodeGym.service.authorService.AuthorService;
import com.CodeGym.service.authorService.IAuthorService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AuthorServlet", value = "/author")
public class AuthorController extends HttpServlet {
    private IAuthorService authorService = AuthorService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = "";
        action = request.getParameter("action");

        switch (action) {
            case "create":
                createForm(request, response);
                break;
            case "list":
                showList(request, response);
                break;
            default:
                request.getRequestDispatcher("views/test.jsp").forward(request, response);

        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/author/list.jsp");
        request.setAttribute("authorList", authorService.find("").values());
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/author/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = "";
        action = request.getParameter("action");

        switch (action) {
            case "create":
                createAuthor(request, response);
                break;
            case "edit":
                break;
            default:
                request.getRequestDispatcher("views/test.jsp").forward(request, response);

        }
    }

    private void createAuthor(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String dateInput = request.getParameter("date");

        Author author = new Author(name,dateInput);
        try {
            authorService.create(author);
            response.sendRedirect("/author?action=list");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
