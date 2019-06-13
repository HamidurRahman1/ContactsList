<%@ page import="com.hamidur.webCrawler.models.Admin" %>
<%@ page import="java.util.Set" %>
<%@ page import="com.hamidur.webCrawler.models.Page" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Displaying Crawled Data</title>
</head>
<body>

    <%!
        Admin admin = null;
        Set<Page> pages = null;
        Float timeToFindLinks = 0.0f;
        Float timeToFindWords = 0.0f;
        Float timeTakenToInsert = 0.0f;
    %>

    <%
        response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
        response.setHeader("Pragma","no-cache");
        response.setDateHeader ("Expires", 0);
        if(request.getSession().getAttribute("admin") == null) response.sendRedirect("views/Login.jsp");
        else admin = (Admin)session.getAttribute("admin");

        timeTakenToInsert = (Float) (request.getSession().getAttribute("timeTakenToInsert"));
        timeToFindWords = (Float) (request.getSession().getAttribute("timeToFindWords"));
        timeToFindLinks = (Float) (request.getSession().getAttribute("timeToFindLinks"));
        admin = (Admin)request.getSession().getAttribute("admin");
        pages = (Set<Page>)request.getSession().getAttribute("pages");
    %>

    <hr>
    Admin: <%= admin.getFirstName()+" "+admin.getLastName()%>
    <hr>
    <br><br>

    <%
        int words = 0;
        for(Page page1 : pages) words += page1.getWordFrequency().size();

        out.println("Time taken to find " + pages.size() + " links " + " -> " + timeToFindLinks + " secs.");
        out.println("<br>");
        out.println("Time taken to extract " + words + " words " + " -> " + timeToFindWords + " secs.");
        out.println("<br>");
        out.println("Time taken to insert " + words + " words and  " + pages.size() + " pages -> " + timeTakenToInsert + " secs.");
        out.println("<br>");
        out.println("<hr>");

        for(Page page1 : pages)
        {
            out.println(page1.getUrl() + " -> " + page1.getWordFrequency().size());
            out.println("<br>");
            out.println("<hr>");
        }

        out.println(session.getAttribute("BackToAdminAccess"));
    %>

</body>
</html>
