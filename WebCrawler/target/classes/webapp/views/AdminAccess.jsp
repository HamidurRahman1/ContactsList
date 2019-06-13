<%@ page import="com.hamidur.webCrawler.models.Admin" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin View</title>
</head>
<body>

    <%! Admin admin = null; %>

    <%
        response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
        response.setHeader("Pragma","no-cache");
        response.setDateHeader ("Expires", 0);
        if(session.getAttribute("admin") == null) response.sendRedirect("index.jsp");
        else admin = (Admin)session.getAttribute("admin");
    %>

    <hr><br>
            <% out.println("Admin: " + admin.getFirstName() + " " + admin.getLastName());%>
    <br><br>

    <hr><br>
            <% out.println(session.getAttribute("SignOutAdmin"));%>
    <br>

    <hr><br>
            <% out.println(session.getAttribute("GetAllQueries"));%>
    <br>

    <hr><br>
            <% out.println(session.getAttribute("GetAllIndexedUrls"));%>
    <br>

    <hr><br>
            <% out.println(session.getAttribute("CrawlerForm"));%>
    <br>

    <hr><br>
            <% out.println(session.getAttribute("SearchQueryForm"));%>
    <br><hr>

</body>
</html>
