
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>


<html>
<head>
    <title>Admin Services</title>
</head>
<body>

        <div><%@include file="adminName.jsp" %></div>

        <div id="adminStudentServices">
            <h3>Student Services</h3>
            <ul>
                <li><a href="/admin/getstudent">Get Student</a></li>
                <li><a href="/admin/student/newStudent">Insert Student</a></li>
                <li><a href="">Update Student</a></li>
            </ul>
        </div>

        <div id="adminInstructorServices">
            <h3>Instructor Services</h3>
            <ul>
                <li>Get Student</li>
                <li>Insert Student</li>
                <li>Update Student</li>
            </ul>
        </div>

        <div id="adminCourseServices">
            <h3>Course Services</h3>
            <ul>
                <li>Insert a Course</li>
                <li>Get Courses</li>
            </ul>
        </div>
</body>
</html>
