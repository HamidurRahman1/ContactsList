
<%@ page import="com.hamidur.webCrawler.services.HTMLReader" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>

    <%
        out.println(new HTMLReader("LoginForm.html").getFormAsContent());
        out.println("<br>");
        out.println(new HTMLReader("BackToIndex.html").getFormAsContent());
    %>

</body>
</html>