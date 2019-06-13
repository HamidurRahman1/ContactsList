<%@ page import="java.util.Enumeration" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%
        Enumeration<String> errors = request.getAttributeNames();
        out.println("<hr>");
        while (errors.hasMoreElements())
        {
            String errorHashcode = errors.nextElement();
            if(errorHashcode.matches("^\\d+$"))
            {
                String errorMessage = (String) request.getAttribute(errorHashcode);
                out.println(errorHashcode);
                out.println("<br>");
                out.println(errorMessage);
                out.println("<br>");
                out.println("<hr>");
            }
        }

        if(session.getAttribute("admin") != null) out.println(session.getAttribute("BackToAdminAccess"));
        else out.println(request.getAttribute("BackToIndex"));
    %>

</body>
</html>
