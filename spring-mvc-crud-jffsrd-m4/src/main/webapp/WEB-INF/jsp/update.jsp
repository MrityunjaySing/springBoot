<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<f:form action="update" modelAttribute="empUpdate">
	
		<f:label path="id">empid</f:label>
		<f:input path="id"/>
		
		<f:label path="name">empName</f:label>
		<f:input path="name"/>
		
		<f:label path="email">empEmail</f:label>
		<f:input path="email"/>
		
		<input type="submit" value="update">
		
	</f:form>
</body>
</html>