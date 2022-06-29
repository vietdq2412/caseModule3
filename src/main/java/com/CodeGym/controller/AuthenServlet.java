package com.CodeGym.controller;

import com.CodeGym.service.authenService.AuthenticationService;
import com.CodeGym.model.AppUser;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AuthenServlet", value = "/authen")
public class AuthenServlet extends HttpServlet {
    private AuthenticationService authenticationService = AuthenticationService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = "";
        action = request.getParameter("action");

        switch (action) {
            case "login":
                loginForm(request, response);
                break;
            case "logout":
                logout(request, response);
                break;
            case "register":
                registerForm(request, response);
            default:
                request.getRequestDispatcher("views/test.jsp").forward(request, response);
        }
    }

    private void registerForm(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String error = "";
        String message = "";
        if (session.getAttribute("error") != null) {
            error = session.getAttribute("error").toString();
        }
        if (session.getAttribute("message") != null) {
            message = session.getAttribute("message").toString();
        }

        try {
            request.setAttribute("message", message);
            request.setAttribute("error", error);
            request.getRequestDispatcher("views/authen/register.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) {

    }

    private void loginForm(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        request.setAttribute("error", session.getAttribute("error"));
        request.setAttribute("message", session.getAttribute("message"));
        try {
            request.getRequestDispatcher("views/authen/login.jsp").forward(request, response);
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
            case "login":
                login(request, response);
                break;
            case "logout":
                logout(request, response);
                break;
            case "register":
                register(request, response);

        }
    }

    private void register(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        AppUser newUser = new AppUser(password, email);
        request.setAttribute("email", email);
        request.setAttribute("password", password);

        boolean checkCreate = authenticationService.create(newUser);
        HttpSession session = request.getSession();
        try {
            if (checkCreate) {
                session.removeAttribute("error");
                session.removeAttribute("message");
                response.sendRedirect("authen?action=login");
            } else {
                session.setAttribute("error", "Email already exist!");
                response.sendRedirect("authen?action=register");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        String loginRs = authenticationService.login(email, password);
        if (loginRs.equals("success")) {
            session.setAttribute("user", email);
//            session.setAttribute("message", loginRs);
            session.removeAttribute("error");
            try {
                response.sendRedirect("/");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            session.removeAttribute("message");
            session.setAttribute("error", loginRs);
            try {
                response.sendRedirect("authen?action=login");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
