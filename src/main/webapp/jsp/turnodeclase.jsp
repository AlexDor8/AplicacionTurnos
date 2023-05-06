<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Turno de clase</title>
</head>
<body>
	<h2>Inserción de consultas</h2>
	<form action="turnosdeclase.do" method="POST">
		<label>Nombre: <input type="text" name="nombre"></label> <br>
		<label><input type="checkbox" name="borrado" value="1">Salir
			de la cola</label> <br>
		<input type="submit" value="Enviar">
	</form>

</body>
</html>