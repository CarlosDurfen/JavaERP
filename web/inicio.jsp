<%-- 
    Document   : tablausuarios
    Created on : 08-jun-2018, 18:43:17
    Author     : Durfen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="inicio.css">
    </head>
    <body>
        <div class="menu">
            <ul class ="horizontal">
                <li><a href="inicio.jsp">Inicio</a></li>
                
                    <li><a href="tablaclientes.jsp">Clientes</a>
                    <li><a href="tablaempleados.jsp">Empleados</a></li>
                    <li><a href="productos.jsp">Productos</a></li>
                    <li><a href="acercade.jsp">Acerca de</a></li>
                    <li><a href="">Panel de control</a></li>
                    <li><a method = "post "href="/controlusuarios/Salir">Salir</a></li>
                

        </div>

        <div>

            <p>Está es la página de inicio de el servidor de uso. Seleccione en el menú la funcionalidad a la que desea acceder.</p>
            <br></br>
            <p>Posibles errores en la página pongase en contacto con <a class="resaltado"> correoficicticio@ficticio.com</a></p>
        </div>


    </div>
</body>
</html>
