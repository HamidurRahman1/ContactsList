
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <div class="name-section">
        <h4>Admin: ${sessionScope.get("admin").getFirstName()} ${sessionScope.get("admin").getLastName()} </h4>
    </div>

</body>
</html>
