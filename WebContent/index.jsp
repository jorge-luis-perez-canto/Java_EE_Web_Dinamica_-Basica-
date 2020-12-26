<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
	body {
		background: grey;
	}
	form {
		padding: 10px;
		width: 400px;
		height: 400px;
		text-align: center;
		border: 1px solid grey;
		margin: auto;
		border-radius: 5px;
		background: white;
	}
</style>
<title>Insert title here</title>
</head>
<body>
	<%java.text.DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");%> 
	<form method="GET" action="Controlador">
		<input type="text" name="nombre" value="Nombre">
		<br><br>
		<input type="text" name="email" value="Correo">
		<br><br>
		<input type="text" name="fecha" value="<%= fecha.format(new java.util.Date()) %>">
		<br><br>
		<input type="submit">
		<br><br>
		<a href="Mostrar">Pulsa aquí e irás a ver los resultados</a>
	</form>
	
</body>
</html>