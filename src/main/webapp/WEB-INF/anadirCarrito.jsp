<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="constants" class="xyz.barreiro.usc.daw.utils.Constants"/>
<jsp:useBean id="routes" class="xyz.barreiro.usc.daw.Routes"/>

<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Música para DAA</title>
</head>

<body style="background-color: #FDF5E6">
<p align="center"
   style="font-family: 'Times New Roman', 'Times', serif; font-size: 3em; font-weight: bold; margin-bottom: 0">
    Música para DAA
</p>

<hr>

<div style="text-align: center;">
    <form action="${routes.anadirCarrito}" method="post">
        <b>CD:</b>
        <select name="${constants.inputIdCd}">
            <c:forEach items="${requestScope.cds}" var="cd">
                <option value="${cd.id}">
                        ${cd.name} | ${cd.artist} | ${cd.country} | $${cd.price}
                </option>
            </c:forEach>
        </select>
        <b>Cantidad:</b>
        <input type="text" name="${constants.inputCantidad}" value="1" required>
        <p>
        <div style="text-align: center;">
            <input type="submit" value="Selecciona Producto">
        </div>
    </form>
</div>

</body>
</html>
