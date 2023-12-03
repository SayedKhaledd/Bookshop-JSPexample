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
    <script type="text/javascript">
        function submitForm(formId) {
            document.getElementById(formId).submit();
        }
    </script>
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
            String removeFormId = "removeForm" + book.getTitle().replaceAll("\\s+", "");
            String discountFormId = "discountForm" + book.getTitle().replaceAll("\\s+", "");
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
        <td class="center">
            <form id="<%= removeFormId %>" action="remove-book-servlet" method="post" style="display: none;">
                <input type="hidden" name="title" value="<%= book.getTitle() %>"/>
            </form>
            <a onclick="submitForm('<%= removeFormId %>'); return false;" class="action-link">Remove</a>
        </td>
        <td class="center">
            <form id="<%= discountFormId %>" action="discount-servlet" method="post" style="display: none;">
                <input type="hidden" name="title" value="<%= book.getTitle() %>"/>
            </form>
            <a onclick="submitForm('<%= discountFormId %>'); return false;" class="action-link">5% Off</a>
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
</body>
</html>
