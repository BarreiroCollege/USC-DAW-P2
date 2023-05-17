<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="constants" class="xyz.barreiro.usc.daw.utils.Constants"/>
<jsp:useBean id="routes" class="xyz.barreiro.usc.daw.Routes"/>

<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Iniciar Sesión</title>

    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>

<body style="background-color: #FDF5E6">
<p align="center"
   style="font-family: 'Times New Roman', 'Times', serif; font-size: 3em; font-weight: bold; margin-bottom: 0">
    Iniciar Sesión
</p>

<hr/>

<form action="${routes.iniciarSesion}" method="post">
    <div style="text-align: center;">
        <table align="center" style="background-color: white;">
            <tr>
                <td>Email</td>
                <td><input type="email" name="${constants.inputEmail}" required></td>
            </tr>
            <tr>
                <td>Contraseña</td>
                <td><input type="password" name="${constants.inputPassword}" required></td>
            </tr>
        </table>
    </div>

    <hr/>

    <div style="text-align: center;">
        <table align="center" border="0">
            <tr>
                <td>
                    <button type="submit">
                        Acceder
                    </button>
                </td>
                <td>
                    <a href="${routes.registrarse}">
                        <button type="button">Registrarse</button>
                    </a>
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
