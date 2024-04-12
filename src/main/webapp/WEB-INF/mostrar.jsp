<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Mostrar Estudiantes y su Contacto</title>
</head>
<body>
	<h1>Estudiantes:</h1>
	<c:forEach items="${estudiante}" var="estudiantes">
		<h3><c:out value="${estudiantes.nombre}"></c:out> <c:out value="${estudiantes.apellido}"></c:out></h3>
		<p>Direccion: <c:out value="${estudiantes.contacto.direccion}"></c:out></p>
		<p>Ciudad: <c:out value="${estudiantes.contacto.ciudad}"></c:out></p>
		<p>Provincia: <c:out value="${estudiantes.contacto.provincia}"></c:out></p>
	</c:forEach>
</body>
</html>