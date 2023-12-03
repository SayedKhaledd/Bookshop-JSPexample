package com.example.jspexample.servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "SaveBookServlet", value = "/save-book-servlet")
public class SaveBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Code to save the book to XML
        // ...

        request.setAttribute("message", "Book saved successfully!");
        request.getRequestDispatcher("/bookshop.jsp").forward(request, response);
    }
}

