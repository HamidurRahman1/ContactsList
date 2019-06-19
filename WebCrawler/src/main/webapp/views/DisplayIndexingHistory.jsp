<%@ page import="com.hamidur.webCrawler.models.Admin" %>
<%@ page import="com.hamidur.webCrawler.models.IndexingHistory" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hamidur.webCrawler.services.AdminAccessiblePages" %>
<%@ page import="com.hamidur.webCrawler.services.Attributes" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Displaying Indexed URLs</title>
</head>
<body>

    <%
        if(!AdminAccessiblePages.validateAdminAccessiblePages(request, response))
        {
            response.sendRedirect("../errors/DisplayErrors.jsp");
        }
        else
        {
            out.println("<br>");
            out.println("<hr>");
            Admin admin = (Admin) request.getSession(false).getAttribute(Attributes.admin.toString());
            out.println("Admin: " + admin.getFirstName() + " " + admin.getLastName());

            List<IndexingHistory> indexingHistories =
                    (List<IndexingHistory>)request.getSession(false).getAttribute(Attributes.indexingHistories.toString());

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
            out.println(request.getSession(false).getAttribute(Attributes.BackToAdminAccess.toString()));
            out.println("<br>");
            out.println("<hr>");
        }
    %>

</body>
</html>
