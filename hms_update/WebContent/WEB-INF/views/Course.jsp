<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
Ketan
	<table border="1" cellpadding="5">
		<c:forEach var="data" items="${courseList}">
			<tr>
				<td>${data.id}</td>
				<td>${data.description}</td>
				<td>${data.mode}</td>
				<td>${data.name}</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>