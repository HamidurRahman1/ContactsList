<%@ page import="com.hamidur.webCrawler.models.Admin" %>
<%@ page import="com.hamidur.webCrawler.services.AdminAccessiblePages" %>
<%@ page import="com.hamidur.webCrawler.services.Attributes" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin View</title>
</head>
<body>

    <hr><br>
    <%
        if(AdminAccessiblePages.validateAdminAccessiblePages(request, response))
        {
            Admin admin = (Admin) request.getSession(false).getAttribute(Attributes.admin.toString());
            out.println("Admin: " + admin.getFirstName() + " " + admin.getLastName());
        }
        else
        {
            response.sendRedirect("../errors/DisplayErrors.jsp");
        }
    %>

    <br><br>

    <hr><br>
            <% out.println(request.getSession(false).getAttribute(Attributes.SignOutAdmin.toString()));%>
    <br>

    <hr><br>
            <% out.println(request.getSession(false).getAttribute(Attributes.GetAllQueries.toString()));%>
    <br>

    <hr><br>
            <% out.println(request.getSession(false).getAttribute(Attributes.GetAllIndexedUrls.toString()));%>
    <br>

    <hr><br>
            <% out.println(request.getSession(false).getAttribute(Attributes.CrawlerForm.toString()));%>
    <br>

    <hr><br>
            <% out.println(request.getSession(false).getAttribute(Attributes.SearchQueryForm.toString()));%>
    <br><hr>

</body>
</html>
