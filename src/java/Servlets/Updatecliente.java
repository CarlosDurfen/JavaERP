/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utilidad.Conexion;

/**
 *
 * @author Durfen
 */
@WebServlet(name = "Updatecliente", urlPatterns = {"/Updatecliente"})
public class Updatecliente extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Getting de the session id
        HttpSession session = request.getSession();
        Integer idusuario = (Integer) session.getAttribute("usuario");
        //Getting the parameters from the form
        int idcliente= Integer.parseInt(request.getParameter("id"));
        String nombre= request.getParameter("nombre");
        int telefono= Integer.parseInt(request.getParameter("telefono"));
        //Using the singleton class
        Conexion conex = new Conexion();
        conex.actualizarCliente(idusuario, idcliente, nombre, telefono);
        response.sendRedirect("inicio.jsp");
    }

}
