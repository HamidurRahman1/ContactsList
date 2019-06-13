<%@ page import="com.hamidur.webCrawler.models.SearchHistory" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hamidur.webCrawler.models.Admin" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Displaying Query History</title>
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

        List<SearchHistory> searchHistories = (List<SearchHistory>)request.getAttribute("queriesHistories");

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
        out.println(request.getSession().getAttribute("BackToAdminAccess"));
    %>

</body>
</html>
