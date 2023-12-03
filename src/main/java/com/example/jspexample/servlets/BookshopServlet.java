package com.example.jspexample.servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import java.io.IOException;

@WebServlet(name = "BookshopServlet", value = "/bookshop-servlet")
public class BookshopServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookshopName = request.getParameter("bookshopName");

        // Set the bookshop name in the session to be used across the application
        HttpSession session = request.getSession();
        session.setAttribute("bookshopName", bookshopName);

        // Redirect to the bookshop page
        response.sendRedirect("bookshop.jsp");
    }
}
