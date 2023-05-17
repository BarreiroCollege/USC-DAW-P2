<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="constants" class="xyz.barreiro.usc.daw.utils.Constants"/>
<jsp:useBean id="routes" class="xyz.barreiro.usc.daw.Routes"/>

<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Confirmación</title>

    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>

<body style="background-color: #FDF5E6">
<p align="center"
   style="font-family: 'Times New Roman', 'Times', serif; font-size: 3em; font-weight: bold; margin-bottom: 0">
    Confirmación de Compra
</p>

<hr/>

<div style="text-align: center;">
    <c:if test="${not empty requestScope.carrito}">
        <table align="center" style="background-color: white;">
            <tr>
                <th>TÍTULO DEL CD</th>
                <th>Precio</th>
                <th>Cantidad</th>
                <th>Importe</th>
            </tr>
            <c:forEach items="${requestScope.carrito}" var="entry">
                <tr>
                    <td>${entry.key.name} | ${entry.key.artist} | ${entry.key.country}</td>
                    <td>$<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2"
                                           value="${entry.key.price}"/></td>
                    <td>${entry.value}</td>
                    <td>$<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2"
                                           value="${entry.key.price * entry.value}"/></td>
                </tr>
            </c:forEach>
            <tr>
                <th></th>
                <th></th>
                <th>IMPORTE TOTAL</th>
                <th>$<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2"
                                       value="${requestScope.importe}"/></th>
            </tr>
        </table>
    </c:if>
</div>

<hr/>

<div style="text-align: center;">
    <a href="${routes.anadirCarrito}">
        <button>Volver a Comprar</button>
    </a>
</div>

</body>
</html>
