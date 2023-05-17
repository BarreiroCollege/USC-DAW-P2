<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="constants" class="xyz.barreiro.usc.daw.utils.Constants"/>
<jsp:useBean id="routes" class="xyz.barreiro.usc.daw.Routes"/>

<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registrarse</title>

    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>

<body style="background-color: #FDF5E6">
<p align="center"
   style="font-family: 'Times New Roman', 'Times', serif; font-size: 3em; font-weight: bold; margin-bottom: 0">
    Registrarse
</p>

<hr/>

<form action="${routes.registrarse}" method="post">
    <div style="text-align: center;">
        <table align="center" style="background-color: white;">
            <tr>
                <td>Nombre Completo</td>
                <td><input type="text" name="${constants.inputName}" required></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="email" name="${constants.inputEmail}" required></td>
            </tr>
            <tr>
                <td>Contraseña</td>
                <td><input type="password" name="${constants.inputPassword}" required></td>
            </tr>
            <tr>
                <td>Tipo de Tarjeta</td>
                <td>
                    <input type="radio" id="credit" name="${constants.inputCardType}" value="C" required>
                    <label for="credit">Crédito</label>
                    <input type="radio" id="debit" name="${constants.inputCardType}" value="D" required>
                    <label for="debit">Débito</label>
                </td>
            </tr>
            <tr>
                <td>Número de Tarjeta</td>
                <td><input type="number" name="${constants.inputCardNumber}" required></td>
            </tr>
        </table>
    </div>

    <hr/>

    <div style="text-align: center;">
        <table align="center" border="0">
            <tr>
                <td>
                    <a href="${routes.iniciarSesion}">
                        <button type="button">Acceder</button>
                    </a>
                </td>
                <td>
                    <button type="submit">
                        Registrarse
                    </button>
                </td>
            </tr>
        </table>
    </div>

</form>

<% if (request.getAttribute(constants.getError()) != null) { %>
<script type="text/javascript">
    window.onload = () => window.alert("<%=request.getAttribute(constants.getError())%>");
</script>
<% } %>

</body>
</html>
