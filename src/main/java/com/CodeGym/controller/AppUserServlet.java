package com.CodeGym.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AppUserServlet", value = "/AppUser")
public class AppUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = "";
        action = request.getParameter("action");

        switch (action) {
            case "list":
                showListUser(request, response);
                break;
            case "add":
                formRegister(request, response);
                break;

        }
    }

    private void formRegister(HttpServletRequest request, HttpServletResponse response) {

    }

    private void showListUser(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "add":
                addUser(request, response);
                break;
            case "edit":
                editUser(request, response);
                break;
        }
    }

    private void editUser(HttpServletRequest request, HttpServletResponse response) {
    }

    private void addUser(HttpServletRequest request, HttpServletResponse response) {

    }
}
