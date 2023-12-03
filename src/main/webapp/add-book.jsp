<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Book</title>
</head>
<body>
<form action="add-book-servlet" method="post">
    Title: <input type="text" name="title"><br>
    Author: <input type="text" name="author"><br>
    Price: <input type="text" name="price"><br>
    Publishing Year: <input type="text" name="year"><br>
    <input type="submit" value="Add Book">
</form>
</body>
</html>
