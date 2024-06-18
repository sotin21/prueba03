<%--
  Created by IntelliJ IDEA.
  User: sebastian soto
  Date: 18-06-2024
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Buscar Vuelos</title>
</head>
<body>
<h1>Buscar Vuelos</h1>
<form action="buscarVuelos" method="post">
    Origen: <input type="text" name="origen"> <br>
    Destino: <input type="text" name="destino"> <br>
    Fecha: <input type="date" name="fecha"> <br>
    <input type="submit" value="Buscar">
</form>
</body>
</html>

