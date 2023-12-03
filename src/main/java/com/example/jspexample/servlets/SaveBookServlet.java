package com.example.jspexample.servlets;


import com.example.jspexample.model.Book;
import com.example.jspexample.util.BookData;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.io.IOException;

@WebServlet(name = "SaveBookServlet", value = "/save-book-servlet")
public class SaveBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("title");

        Book book = BookData.getBooks().stream()
                .filter(e -> e.getTitle().equals(name))
                .findFirst()
                .orElse(null);
        if (book != null) {
            try {
                JAXBContext jaxbContext = JAXBContext.newInstance(Book.class);
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

                // Specify the path where the XML file will be saved
                File file = new File("C:\\Users\\Sayed Khaled\\Downloads\\Other\\" + name + "_book.xml");
                jaxbMarshaller.marshal(book, file);

                request.setAttribute("message", "Book saved successfully!");
            } catch (JAXBException e) {
                e.printStackTrace();
                request.setAttribute("message", e.getMessage());
            } catch (Exception e) {
                request.setAttribute("message", e.getMessage());
            }
        } else {
            request.setAttribute("message", "Book not found.");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("bookshop.jsp");
        dispatcher.forward(request, response);

    }
}

