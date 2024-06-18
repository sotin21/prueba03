<%--
  Created by IntelliJ IDEA.
  User: sebastian soto
  Date: 18-06-2024
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reservar Pasaje</title>
</head>
<body>
<h1>Reservar Pasaje</h1>
<form action="reservarPasaje" method="post">
    Nombre: <input type="text" name="nombre"> <br>
    Apellido: <input type="text" name="apellido"> <br>
    Edad: <input type="number" name="edad"> <br>
    <input type="submit" value="Reservar">
</form>
</body>
</html>

