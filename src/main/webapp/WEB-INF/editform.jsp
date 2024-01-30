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
<h3 style="color: blue;" align="center">Student Edit Page</h3>
<form method="Post" action="update">
<center>
<table>
<tr>
	<th>Student Id</th>
	<td>${sto.sid}<input type="hidden" name = "sid" value="${sto.sid}" /></td>
</tr>
<tr>
	<th>Student Name</th>
	<td><input type="text" name="sname"  value="${sto.sname}"/></td>
</tr>
<tr>
	<th>Student Address</th>
	<td><input type="text" name="saddr"  value='${sto.saddr}'/></td>
</tr>
<tr>
	<td><input type="submit" value="UPDATE"/></td>
</tr>
</table>
</center>
</form>
</body>
</html>