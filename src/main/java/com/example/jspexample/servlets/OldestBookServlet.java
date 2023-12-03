package com.example.jspexample.servlets;

import com.example.jspexample.model.Book;
import com.example.jspexample.util.BookData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

@WebServlet(name = "OldestBookServlet", value = "/oldest-book-servlet")
public class OldestBookServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = BookData.getBooks();

        Book oldestBook = books.stream()
                .min(Comparator.comparingInt(Book::getPublishingYear))
                .orElse(null);

        request.setAttribute("oldestBook", oldestBook);
        request.getRequestDispatcher("/oldest-book.jsp").forward(request, response);
    }
}

