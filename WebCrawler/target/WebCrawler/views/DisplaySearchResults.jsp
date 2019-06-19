<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="com.hamidur.webCrawler.models.Page" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hamidur.webCrawler.services.Attributes" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Display Search Results</title>
</head>
<body>

    <br>
    Entered Search Query:
    <%= request.getSession(false).getAttribute(Attributes.query.toString()) %>
    <br><br>

    <%
        List<Page> pages = (List<Page>)request.getSession(false).getAttribute(Attributes.pages.toString());
        if(pages == null || pages.isEmpty())
        {
            out.println("No results found.");
        }
        else
        {
            out.println("Total results found: " + pages.size());
            out.println("<br>");
            out.println("<br>");

            out.println("Time taken: " + session.getAttribute(Attributes.timeTakenToFindPages.toString()) + " sec(s)");
            out.println("<hr>");
            out.println("<br>");

            for(Page page1 : pages)
            {
                String div = "<div>" +
                        "<h2><a href=" + page1.getUrl() + " target=" + "_blank" + "\">" + "<strong>"
                        + page1.getUrl() + "</strong></a></h2>" + page1.getDescription() + "</div>";

                out.println(div);
                out.println("<hr>");
            }
        }
    %>

    <br><br>

    <%
        if(session.getAttribute(Attributes.admin.toString()) != null)
            out.println(session.getAttribute(Attributes.BackToAdminAccess.toString()));
        else out.println(session.getAttribute(Attributes.BackToIndex.toString()));
    %>

    <br><br><hr>


</body>
</html>