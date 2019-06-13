<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="com.hamidur.webCrawler.models.Page" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Display Search Results</title>
</head>
<body>

    <%! List<Page> pages = null; %>

    Entered Search Query: <%= request.getAttribute("query") %>

    <br><br>

    <%
        pages = (List<Page>)request.getAttribute("pages");
        out.println("Results found: " + pages.size());
        out.println("<br>"); out.println("<br>");

        out.println("Time taken: " + request.getAttribute("timeTakenToFindPages") + " sec(s)");
    %>

    <hr><br>

    <%
        for(Page page1 : pages)
        {
            String div = "<div>" +
                    "<h2><a href=" + page1.getUrl() + " target=" + "_blank" + "\">" + "<strong>"
                    + page1.getUrl() + "</strong></a></h2>" + page1.getDescription() + "</div>";

            out.println(div);
            out.println("<hr>");
        }
    %>

    <br><br>

    <%
        if(session.getAttribute("admin") != null) out.println(session.getAttribute("BackToAdminAccess"));
        else out.println(request.getAttribute("BackToIndex"));
    %>

    <br><br><hr>


</body>
</html>