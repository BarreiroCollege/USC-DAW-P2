<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="constants" class="xyz.barreiro.usc.daw.utils.Constants"/>
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

<c:if test="${not empty sessionScope.user}">
    <div style="text-align: center;">
        <table align="center" style="background-color: white;">
            <tr>
                <td>Nombre</td>
                <td>${sessionScope.user.name}</td>
            </tr>
            <tr>
                <td>Email</td>
                <td>${sessionScope.user.email}</td>
            </tr>
            <tr>
                <td>Tipo de Tarjeta</td>
                <td>${sessionScope.user.cardType.fancyName}</td>
            </tr>
            <tr>
                <td>Número de Tarjeta</td>
                <td>${sessionScope.user.cardNumber}</td>
            </tr>
        </table>
    </div>

    <hr/>
</c:if>

<div style="text-align: center;">
    <c:choose>
        <c:when test="${not empty sessionScope.user}">
            <form action="${routes.pagar}" method="post">
                <button type="submit">
                    Pagar y Volver
                </button>
            </form>
        </c:when>

        <c:otherwise>
            <table align="center" border="0">
                <tr>
                    <td>
                        <a href="${routes.iniciarSesion}">
                            <button>Iniciar Sesión</button>
                        </a>
                    </td>
                    <td>
                        <a href="${routes.registrarse}">
                            <button>Registrarse</button>
                        </a>
                    </td>
                </tr>
            </table>
        </c:otherwise>
    </c:choose>
</div>

</body>
</html>
