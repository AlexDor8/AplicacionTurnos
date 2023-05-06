<%@page import="java.util.ArrayList"%>
<%@page import="model.Consulta"%>
<%@page import="service.Service"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Turnos</title>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>

<%
ArrayList<Consulta> consultas = (ArrayList<Consulta>) request.getAttribute("consultas");
Service service = new Service();
%>
</head>

<body>
	<h2>Alumnos que estan en cola:</h2>
	<form action="turnosenclase.do" method="POST">
		<%
		
		for (Consulta s : consultas) {
			String checkboxValue = request.getParameter(s.getNombre());
			if (checkboxValue != null) {
				s.setMarcado(true);
				service.actualizarConsulta(s.getId());
				System.out.println(s);
			}
		%>
		<b>Nombre: <%=s.getNombre() + " "%></b> <input type="checkbox"
			name="<%=s.getNombre()%>" value="1"> <br>
		<%
		}
		%>

		<input type="submit" value="Enviar">
	</form>

</body>
</html>