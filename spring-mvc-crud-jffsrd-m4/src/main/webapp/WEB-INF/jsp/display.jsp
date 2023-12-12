<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
			<table border="2">
				<tr>
					<th>id</th>
					<th>name</th>
					<th>email</th>
					<th>edit</th>
					<th>delete</th>
				</tr>
				
					
					<c:forEach var="emp" items="${list}">
					<tr>
						<td>${emp.getId()}</td>
						<td>${emp.getName()}</td>
						<td>${emp.getEmail()}</td>
						<td><a href="edit?id=${emp.getId()}">EDIT</a></td>
						<td><a href="delete?id=${emp.getId()}">DELETE</a></td>
					</tr>
					</c:forEach>
				
			</table>
</body>
</html>