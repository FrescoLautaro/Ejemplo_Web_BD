<%-- 
    Document   : index.jsp
    Created on : 17 oct. 2023, 08:06:18
    Author     : ET36
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <div class="container">
            <h1 class="texto">Instituto Tecnológico</h1>
            <div class="imagen">
                <img src="instituto.jpg">
            </div>
            <div class="containerBoton">
                <tr>
                    <td> <a href="insertar.jsp"><button class="boton">Insertar</button> </a> </td>
                    <td> <a href="consultar.jsp"><button class="boton">Consultar</button> </a> </td>
                    <td> <a href="verregistro.jsp"><button class="boton">Ver Registros</button> </a> </td>
                </tr>
            </div>
        </div>
    </body>
</html>
