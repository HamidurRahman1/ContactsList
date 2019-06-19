
<%@ page import="com.hamidur.webCrawler.services.HTMLReader" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home page</title>
</head>
<body>

    <br><hr><br>

    Welcome to SARA(Search And Reporting Application)

    <br><br><hr><br><br>
    <%
        out.println(new HTMLReader("AdminOption.html").getFormAsContent());
    %>

    <br><br><hr><br>
    <% out.println(new HTMLReader("SearchQueryForm.html").getFormAsContent());%>

    <br><br><hr><br>
    <% out.println(new HTMLReader("AboutSARA.html").getBody());%>

</body>
</html>