
<%@ page import="com.hamidur.webCrawler.services.Attributes" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Login Page</title>
</head>
<body>

    <%
        out.println(request.getSession(false).getAttribute(Attributes.LoginForm.toString()));
        out.println("<br>");
        out.println(request.getSession(false).getAttribute(Attributes.BackToIndex.toString()));
    %>

</body>
</html>