<%@ page import="com.hamidur.webCrawler.models.Admin" %>
<%@ page import="java.util.Set" %>
<%@ page import="com.hamidur.webCrawler.models.Page" %>
<%@ page import="com.hamidur.webCrawler.services.AdminAccessiblePages" %>
<%@ page import="com.hamidur.webCrawler.services.Attributes" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Displaying Crawled Data</title>
</head>
<body>

    <hr><br>
    <%

        if(!AdminAccessiblePages.validateAdminAccessiblePages(request, response))
        {
            response.sendRedirect("../errors/DisplayErrors.jsp");
        }
        else
        {
            out.println("<br>");
            Admin admin = (Admin) request.getSession(false).getAttribute(Attributes.admin.toString());
            out.println("Admin: " + admin.getFirstName() + " " + admin.getLastName());
            out.println("<br>");

            Float timeTakenToInsert = (Float) (request.getSession(false).getAttribute(Attributes.timeTakenToInsert.toString()));
            Float timeTakenToFindWords = (Float) (request.getSession(false).getAttribute(Attributes.timeTakenToFindWords.toString()));
            Float timeTakenToFindLinks = (Float) (request.getSession(false).getAttribute(Attributes.timeTakenToFindLinks.toString()));

            Set<Page> pages = (Set<Page>)request.getSession(false).getAttribute(Attributes.crawledPages.toString());

            out.println("<br>");
            out.println("<hr>");
            out.println("<br>");
            out.println("<br>");

            int totalWords = 0;
            for(Page page1 : pages) totalWords += page1.getWordFrequency().size();

            out.println("Time taken to find " + pages.size() + " links " + " -> " + timeTakenToFindLinks + " secs.");
            out.println("<br>");
            out.println("Time taken to extract " + totalWords + " words " + " -> " + timeTakenToFindWords + " secs.");
            out.println("<br>");
            out.println("Time taken to insert " + totalWords + " words and  " + pages.size()
                    + " pages  into database -> " + timeTakenToInsert + " secs.");
            out.println("<br>");
            out.println("<hr>");

            for(Page page1 : pages)
            {
                out.println(page1.getUrl() + " -> " + page1.getWordFrequency().size() + " word(s)");
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
