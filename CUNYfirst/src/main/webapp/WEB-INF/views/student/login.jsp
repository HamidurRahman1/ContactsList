
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Student Login</title>
</head>
<body>
    <form:form action="processLogin" method="post" modelAttribute="studentLogin">
        <label for="username">Username</label>
        <form:input path="username"/>

        <br>
        <br>

        <label for="password">Password</label>
        <form:password path="password"/>

        <br>
        <br>

        <input value="Submit" type="submit">
    </form:form>
</body>
</html>
