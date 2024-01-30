<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br><br><br>
<h2 style="color: red;" align="center">Student Management System</h2>
<h3 style="color: blue;" align="center">Student Details Page</h3>
<center>
<table border="1">
<tr>
	<th>Student Id</th>
	<td>${sto.sid}</td>
</tr>
<tr>
	<th>Student Name</th>
	<td>${sto.sname}</td>
</tr>
<tr>
	<th>Student Address</th>
	<td>${sto.saddr}</td>
</tr>
</table>
</center>
<h2 align="center">
<a  href="homepage">Home Page</a>
</h2>
</body>
</html>