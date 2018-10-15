<%-- 
    Document   : tablausuarios
    Created on : 09-jun-2018, 12:31:06
    Author     : Durfen
--%>

<%@page import="java.util.List"%>
<%@page import="utilidad.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="tablausuarios.css">
        <title>Empleados</title>
        <script type = "text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script type= "text/javascript" src="js/jstablacliente.js"></script>

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
                <li><a href="">Salir</a></li>
            </ul>

        </div>
        <a name="sdsd" href="crearcliente.html"><img src="imagenes/botonanadir.png"  border="0" alt="Este es el ejemplo de un texto alternativo"/></a>
        <div>
            <table border="1">
                <!--tabla dinámica, posible mejora de código-->
                <thead>
                    <tr>
                        <td>ID</td>
                        <td>Nombre</td>
                        <td>Telefono</td>
                        <td>Acción</td>
                    </tr>
                </thead>

                <%  int contador = 1;
                /*Obtain the List*/
                    Conexion conex = new Conexion();
                    HttpSession sesion = request.getSession();
                    Integer usuario = (Integer) sesion.getAttribute("usuario");
                    List<String> lista = conex.tablaClientes(usuario);
                    /*Starting the loop introducin the data into the tr and td*/
                    int valor = 0;
                    if (lista.size() != 0) {
                        for (int i = 0; i < lista.size(); i++) {
                            if (contador == 1) {
                                valor++;
                                contador++;
                %>

                <tr  id= "<%=valor%>">
                    <td class = "fila">
                        <%=lista.get(i)%>
                    </td>


                    <%
                    } else if (contador < 3) {
                        contador++;

                    %>
                    <td class= "fila"><%=lista.get(i)%></td>
                    <%} else if (contador == 3) {
                        contador = 1;

                    %>
                    <td class= "fila">
                        <%=lista.get(i)%>       
                        <%%>
                    </td>
                    <td>
                        <input type="button" class ="eliminar" value="Eliminar" method = "POST" onclick="mandar(this)">   
                        <input type="button" class="modificar" onclick="modificar(this)" value="Modificar" >

                    </td>

                </tr>


                <%}%>

                <%
                        }
                    }
                %>

            </table>

        </div>
        <a id="probar"></a>

    </body>
</html>