<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 style="color: red" align="center">Student Management System</h2>
<h3 style="color: blue;" align="center">Student Add Page</h3>
<form action="add" method="Post">
<center>
<table>
<tr>
	<td>Student Id</td>
	<td><input type="text" name="sid"/></td>
</tr>
<tr>
	<td>Student Name</td>
	<td><input type="text" name="sname"/></td>
</tr>
<tr>
	<td>Student Address</td>
	<td><input type="text" name="saddr"/></td>
</tr>
<tr>
	<td><input type="submit" value="ADD"/></td>
</tr>
</table>
</center>
</form>
</body>
</html>