package com.example.jspexample.model;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book {
    private String title;
    private String author;
    private double price;
    private int publishingYear;

    // Constructor, getters, and setters


    public Book() {
    }

    public Book(String title, String author, double price, int publishingYear) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.publishingYear = publishingYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }
}
