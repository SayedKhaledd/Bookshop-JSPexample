<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.jspexample.model.Book" %>
<%@ page import="com.example.jspexample.util.BookData" %>
<html>
<head>
    <title>Bookshop Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #eaeaea;
        }

        .center {
            text-align: center;
        }

        .action-link {
            color: #d9534f;
            text-decoration: none;
            cursor: pointer;
        }

        .add-new-book {
            margin-top: 20px;
            text-align: right;
        }

        .add-new-book a {
            padding: 10px 15px;
            background-color: #5cb85c;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }

        .message {
            color: #5cb85c;
            margin-bottom: 15px;
        }
    </style>
</head>
<body>
<h1>Welcome to <%= request.getSession().getAttribute("bookshopName") %> Bookshop!</h1>
<div class="message">
    <% if (request.getAttribute("message") != null) { %>
    <%= request.getAttribute("message") %>
    <% } %>
</div>
<table>
    <tr>
        <th>Title</th>
        <th>Author</th>
        <th>Price</th>
        <th>Year</th>
        <th class="center">Remove</th>
        <th class="center">Discount</th>
    </tr>
    <% List<Book> books = BookData.getBooks();
        for (Book book : books) {
    %>
    <tr>
        <td><%= book.getTitle() %>
        </td>
        <td><%= book.getAuthor() %>
        </td>
        <td>$<%= String.format("%.2f", book.getPrice()) %>
        </td>
        <td><%= book.getPublishingYear() %>
        </td>
        <td>
            <form action="remove-book-servlet" method="post">
                <input type="hidden" name="title" value="<%= book.getTitle() %>"/>
                <input type="submit" value="remove">
            </form>
        </td>
        <td>
            <form action="discount-servlet" method="post">
                <input type="hidden" name="title" value="<%= book.getTitle() %>"/>
                <input type="submit" value="discount">
            </form>
        </td>
    </tr>
    <% } %>
</table>
<div class="add-new-book">
    <a href="add-book.jsp">Add New Book</a>
</div>
<div class="view-oldest">
    <a href="oldest-book-servlet">View Oldest Book</a>
</div>

<%
    if (request.getAttribute("oldestBook") != null) {
        Book book = (Book) request.getAttribute("oldestBook");
%>
<table>
    <tr>
        <th>Title</th>
        <th>Author</th>
        <th>Price</th>
        <th>Year</th>
        <th>action</th>

    </tr>
    <tr>
        <th><%=book.getTitle()%>
        </th>
        <th><%=book.getAuthor()%>
        </th>
        <th><%=book.getPrice()%>
        </th>
        <th><%=book.getPublishingYear()%>
        </th>
        <th>    <form action="save-book-servlet" method="post">
            <input type="hidden" name="title" value="<%= book.getTitle() %>"/>
            <input type="submit" value="save to xml">
        </form></th>
    </tr>
</table>
<%}%>
</body>
</html>
