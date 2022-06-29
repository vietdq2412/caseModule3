package com.CodeGym.controller;

import com.CodeGym.model.Category;
import com.CodeGym.service.categoryService.CategoryService;
import com.CodeGym.service.categoryService.ICategoryService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CategoryServlet", value = "/category")
public class CategoryController extends HttpServlet {
    private ICategoryService categoryService = CategoryService.getInstance();

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
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/category/list.jsp");
        request.setAttribute("categoryList", categoryService.find("").values());
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/category/create.jsp");
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
                createCategory(request, response);
                break;
            case "edit":
                break;
            default:
                request.getRequestDispatcher("views/test.jsp").forward(request, response);
        }
    }

    private void createCategory(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        Category category = new Category(name);
        try {
            categoryService.create(category);
            response.sendRedirect("/category?action=list");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
