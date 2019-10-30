
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false"%>

<html>
<head>
    <title>Title</title>
</head>
<body>

    <div id="add-student">
        <form:form modelAttribute="newStudent" method="post" action="/student/process">

            <strong>Student Personal Information</strong><br><br>
            <label for="firstName">* First Name: </label><form:input type="text" path="firstName"/>
            <br><br>
            <label for="lastName">* Last Name: </label><form:input type="text" path="lastName"/>
            <br><br>
            <label for="ssn">* SSN: </label><form:input type="number" path="ssn"/>
            <br><br>
            <label for="dateOfBirth">* Date of Birth: </label><form:input type="date" path="dateOfBirth"/>
            <br><br>
            <label for="gender">* Gender: </label><form:select path="gender"/>
            <br><br><br>

            <strong>Address:</strong><br><br>
            <label for="address.street">* Street: </label>
            <form:input type="text" path="address.street"/><br><br>
            <label for="address.crossStreet">* Cross Street: </label>
            <form:input type="text" path="address.crossStreet"/><br><br>
            <label for="address.city">* City: </label>
            <form:input type="text" path="address.city"/><br><br>
            <label for="highSchoolInfo.country">* Country: </label>
            <form:input type="text" path="address.state"/><br><br>
            <label for="address.zipCode">* ZipCode: </label>
            <form:input type="number" path="address.zipCode"/>
            <br><br><br>


            <strong>Contact:</strong><br><br>
            <label for="contact.phone">Phone: <form:input type="number" path="contact.phone"/></label><br><br>
            <label for="contact.email">* Email: <form:input path="contact.email"/></label><br><br>
            <label for="contact.collegeEmail">College Email: <form:input path="contact.collegeEmail"/>
            </label><br><br><br>


            <strong>High School Information</strong><br><br>
            <label for="highSchoolInfo.highSchoolName">* High School Name: </label>
            <form:input type="text" path="highSchoolInfo.highSchoolName"/><br><br>
            <label for="highSchoolInfo.year">* Year: </label>
            <form:input type="text" path="highSchoolInfo.year"/><br><br>
            <label for="highSchoolInfo.city">* City: </label>
            <form:input type="text" path="highSchoolInfo.city"/><br><br>
            <label for="highSchoolInfo.country">* Country: </label>
            <form:input type="text" path="highSchoolInfo.country"/>
            <br><br><br>

            <strong style="color: red">* marked field(s) are required</strong><br><br>

            <input value="Submit" type="submit">
        </form:form>
    </div>

</body>
</html>
