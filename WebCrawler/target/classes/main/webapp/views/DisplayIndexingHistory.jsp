<%@ page import="com.hamidur.webCrawler.models.Admin" %>
<%@ page import="com.hamidur.webCrawler.models.IndexingHistory" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Displaying Indexed URLs</title>
</head>
<body>

    <%
        Admin admin = null;

        response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
        response.setHeader("Pragma","no-cache");
        response.setDateHeader ("Expires", 0);

        if(session.getAttribute("admin") == null) response.sendRedirect("views/Login.jsp");
        else admin = (Admin)session.getAttribute("admin");

        out.println("<br>");
        out.println("Admin: " + admin.getFirstName() + " " + admin.getLastName());
        out.println("<br>");

        List<IndexingHistory> indexingHistories = (List<IndexingHistory>)request.getAttribute("indexingHistories");

        out.println("<br>");
        out.println("<hr>");
        for(IndexingHistory indexingHistory : indexingHistories)
        {
            out.println("Admin id: " + indexingHistory.getAdmin().getAdminId());
            out.println("<br>");
            out.println("Page Url: " + indexingHistory.getIndexedPages().iterator().next().getUrl());
            out.println("<br>");
            out.println("Date: " + indexingHistory.getDate());
            out.println("<br>");
            out.println("<hr>");
        }

        out.println("<br>");
        out.println(request.getSession().getAttribute("BackToAdminAccess"));
    %>

</body>
</html>
