package com.CodeGym;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/app")
@MultipartConfig
        (
                fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
                maxFileSize = 1024 * 1024 * 10,      // 10 MB
                maxRequestSize = 1024 * 1024 * 100   // 100 MB
        )
public class HelloServlet extends HttpServlet {

    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");

        String action = request.getParameter("action");

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
        RequestDispatcher dispatcher = request.getRequestDispatcher("uploadImg_form.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");

        switch (action) {
            case "add":
                addBook(request, response);
                break;
            case "edit":
                editBook(request, response);
                break;
            case "uploadImg":
                uploadImage(request, response, "");
                break;
        }
    }

    private void uploadImage(HttpServletRequest req, HttpServletResponse resp, String name) {
        String PATH = "C:\\Users\\vietd\\Desktop\\S\\CG\\Module 3\\sevrlet2\\src\\main\\resources\\img\\";
        try {
            Part filePath = req.getPart("file");

            String fileName = filePath.getSubmittedFileName();

            for (Part part : req.getParts()) {
                part.write(PATH + fileName);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }

    private void editBook(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void addBook(HttpServletRequest req, HttpServletResponse resp) {
        try {
            resp.sendRedirect("/app?action=list");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //resp.sendRedirect( "/app?action=list");
    }

    private void formAdd(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        try {
            dispatcher.forward(request, response);
            return;
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showListBook(HttpServletRequest req, HttpServletResponse res) {
        req.setAttribute("list", "list");
        RequestDispatcher dispatcher = req.getRequestDispatcher("showBook.jsp");

        try {
            dispatcher.forward(req, res);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }
}