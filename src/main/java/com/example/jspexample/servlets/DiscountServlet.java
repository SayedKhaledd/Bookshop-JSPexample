package com.example.jspexample.servlets;

import com.example.jspexample.model.Book;
import com.example.jspexample.util.BookData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "DiscountServlet", value = "/discount-servlet")
public class DiscountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        BookData.getBooks().stream().filter(book -> book.getTitle().equals(title))
                .forEach(book -> book.setPrice(book.getPrice() * 0.95));

        request.setAttribute("message", "Discount applied successfully!");
        request.getRequestDispatcher("/bookshop.jsp").forward(request, response);
    }
}

