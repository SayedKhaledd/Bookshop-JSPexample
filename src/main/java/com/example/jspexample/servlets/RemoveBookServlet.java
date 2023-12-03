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

@WebServlet(name = "RemoveBookServlet", value = "/remove-book-servlet")
public class RemoveBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        List<Book> books = BookData.getBooks();

        books.removeIf(book -> book.getTitle().equals(title));

        request.setAttribute("message", "Book removed successfully!");
        request.getRequestDispatcher("/bookshop.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}

