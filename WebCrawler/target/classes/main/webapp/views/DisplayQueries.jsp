<%@ page import="com.hamidur.webCrawler.models.SearchHistory" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hamidur.webCrawler.models.Admin" %>
<%@ page import="com.hamidur.webCrawler.services.AdminAccessiblePages" %>
<%@ page import="com.hamidur.webCrawler.services.Attributes" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Displaying Query History</title>
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

            List<SearchHistory> searchHistories =
                    (List<SearchHistory>)request.getSession(false).getAttribute(Attributes.queriesHistories.toString());

            out.println("<br>");
            out.println("<hr>");
            for(SearchHistory searchHistory : searchHistories)
            {
                out.println("Query: " + searchHistory.getQuery());
                out.println("<br>");
                out.println("Total results: " + searchHistory.getTotalResultsFound());
                out.println("<br>");
                out.println("Total time: " + searchHistory.getTimeTakenToFindResults() + " sec(s)");
                out.println("<br>");
                out.println("Date: " + searchHistory.getDate().toString());
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
