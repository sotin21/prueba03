<%--
  Created by IntelliJ IDEA.
  User: sebastian soto
  Date: 18-06-2024
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Información Detallada del Vuelo</title>
</head>
<body>
<h1>Información Detallada del Vuelo</h1>
<table border="1">
    <tr>
        <th>Número de Vuelo:</th>
        <td>${vuelo.numeroVuelo}</td>
    </tr>
    <tr>
        <th>Origen:</th>
        <td>${vuelo.origen}</td>
    </tr>
    <tr>
        <th>Destino:</th>
        <td>${vuelo.destino}</td>
    </tr>
    <tr>
        <th>Fecha de Salida:</th>
        <td>${vuelo.fechaSalida}</td>
    </tr>
    <tr>
        <th>Fecha de Llegada:</th>
        <td>${vuelo.fechaLlegada}</td>
    </tr>
    <tr>
        <th>Horario de Salida:</th>
        <td>${vuelo.horarioSalida}</td>
    </tr>
    <tr>
        <th>Horario de Llegada:</th>
        <td>${vuelo.horarioLlegada}</td>
    </tr>
    <tr>
        <th>Escalas:</th>
        <td>
            <c:forEach items="${vuelo.escalas}" var="escala">
                ${escala}<br>
            </c:forEach>
        </td>
    </tr>
    <tr>
        <th>Precio Económico:</th>
        <td>${vuelo.precioEconomico}</td>
    </tr>
    <tr>
        <th>Precio Ejecutivo:</th>
        <td>${vuelo.precioEjecutivo}</td>
    </tr>
    <tr>
        <th>Precio Primera Clase:</th>
        <td>${vuelo.precioPrimeraClase}</td>
    </tr>
</table>
</body>
</html>
