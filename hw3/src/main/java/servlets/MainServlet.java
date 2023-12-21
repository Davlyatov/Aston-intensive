package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//@WebServlet(name = "mainServlet", value = "/main-servlet")
@WebServlet(value = "/main-servlet", name = "MainServlet")
public class MainServlet extends HttpServlet {

    public void init() {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.getRequestDispatcher("/MainMenu.html").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int answer = Integer.parseInt(req.getParameter("answer"));
        if (answer == 1 ){
            resp.sendRedirect("/one-to-many");
        }
    }
}
