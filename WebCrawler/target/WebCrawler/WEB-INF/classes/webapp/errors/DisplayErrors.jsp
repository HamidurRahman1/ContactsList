<%@ page import="java.util.Enumeration" %>
<%@ page import="com.hamidur.webCrawler.services.Attributes" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Errors</title>
</head>
<body>

    <%
        Enumeration<String> errors = session.getAttributeNames();
        out.println("<hr>");
        while (errors.hasMoreElements())
        {
            if(errors.nextElement().matches("^\\d+$"))
            {
                String errorHashcode = errors.nextElement();
                String errorMessage = (String) session.getAttribute(errorHashcode);
                session.removeAttribute(errorHashcode);
                out.println(errorHashcode);
                out.println("<br>");
                out.println(errorMessage);
                out.println("<br>");
                out.println("<hr>");
            }
        }

        if(session.getAttribute(Attributes.admin.toString()) != null)
            out.println(session.getAttribute(Attributes.BackToAdminAccess.toString()));
        else out.println(session.getAttribute(Attributes.BackToIndex.toString()));
    %>

</body>
</html>
