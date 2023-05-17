<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="constants" class="xyz.barreiro.usc.daw.Constants"/>
<jsp:useBean id="routes" class="xyz.barreiro.usc.daw.Routes"/>

<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Completar Pago</title>

    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>

<body style="background-color: #FDF5E6">
<p align="center"
   style="font-family: 'Times New Roman', 'Times', serif; font-size: 3em; font-weight: bold; margin-bottom: 0">
    Caja
</p>

<hr/>

<div style="text-align: center;">
    <c:if test="${not empty requestScope.importe}">
        <table align="center" style="background-color: white;">
            <tr>
                <th>TOTAL A PAGAR</th>
            </tr>
            <tr>
                <th>$<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2"
                                       value="${requestScope.importe}"/></th>
            </tr>
        </table>
    </c:if>
</div>

<hr/>

<div style="text-align: center;">
    <form action="${routes.pagar}" method="post">
        <button type="submit">
            Pagar y Volver
        </button>
    </form>
</div>

</body>
</html>
