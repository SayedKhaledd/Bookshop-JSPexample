<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.jspexample.model.Book" %>
<html>
<head>
    <title>Oldest Book</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }

        h1 {
            color: #337ab7;
        }

        p {
            background-color: #f2f2f2;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }

        .book-details {
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<h1>Oldest Book in the Bookshop</h1>
<% Book oldestBook = (Book) request.getAttribute("oldestBook"); %>
<% if (oldestBook != null) { %>
<div class="book-details">
    <p>Title: <%= oldestBook.getTitle() %>
    </p>
    <p>Author: <%= oldestBook.getAuthor() %>
    </p>
    <p>Price: $<%= String.format("%.2f", oldestBook.getPrice()) %>
    </p>
    <p>Year: <%= oldestBook.getPublishingYear() %>
    </p>
</div>
<% } else { %>
<p>No books found.</p>
<% } %>
</body>
</html>
