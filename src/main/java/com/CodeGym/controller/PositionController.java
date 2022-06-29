package com.CodeGym.controller;

import com.CodeGym.model.Position;
import com.CodeGym.service.positionService.PositionService;
import com.CodeGym.service.positionService.IPositionService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PositionServlet", value = "/position")
public class PositionController extends HttpServlet {
    private IPositionService positionService = PositionService.getInstance();

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
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/position/list.jsp");
        request.setAttribute("positionList", positionService.find("").values());
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/position/create.jsp");
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
                createPosition(request, response);
                break;
            case "edit":
                break;
            default:
                request.getRequestDispatcher("views/test.jsp").forward(request, response);
        }
    }

    private void createPosition(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        int maxSize = Integer.parseInt(request.getParameter("maxSize"));
        int currentUnit = Integer.parseInt(request.getParameter("currentUnit"));
        Position position = new Position(name,description,maxSize,currentUnit);
        try {
            positionService.create(position);
            response.sendRedirect("/position?action=list");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
