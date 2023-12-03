package com.example.jspexample.util;

import com.example.jspexample.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookData {
    private static List<Book> books = new ArrayList<>();

    static {
        // Add some initial books to the list
        books.add(new Book("1984", "George Orwell", 8.99, 1949));
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 7.99, 1925));
        // Add more books as needed
    }

    public static List<Book> getBooks() {
        return books;
    }

    // Methods to add, remove, apply discount, etc.
}
