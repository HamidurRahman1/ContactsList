
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
        <div id="studentContainer">
            <h3>Student id: ${sessionScope.get("student").getStudentId()}</h3>
            <br>
            First name: ${sessionScope.get("student").getFirstName()}
            Last name: ${sessionScope.get("student").getLastName()} <br>
            Contact: ${sessionScope.get("student").getContact().getPhone()}
            ${sessionScope.get("student").getContact().getEmail()}

        </div>
</body>
</html>