package com.example.jspexample.servlets;

import com.example.jspexample.util.BookData;
import com.example.jspexample.model.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AddBookServlet", value = "/add-book-servlet")
public class AddBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        double price = Double.parseDouble(request.getParameter("price"));
        int year = Integer.parseInt(request.getParameter("year"));

        Book newBook = new Book(title, author, price, year);
        BookData.getBooks().add(newBook);

        // Redirect to the bookshop page with a success message
        request.setAttribute("message", "Book added successfully!");
        request.getRequestDispatcher("/bookshop.jsp").forward(request, response);
    }
}
