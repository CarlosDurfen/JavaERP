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
@WebServlet(name = "Crearempleado", urlPatterns = {"/Crearempleado"})
public class Crearempleado extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //request the session atribute id
        HttpSession sesion = request.getSession();
        Integer id = (Integer)sesion.getAttribute("usuario");
        //Taking the parameters from the form
        String nombre= request.getParameter("nombre").trim();
        String fecha1= request.getParameter("fecha1").trim();
        String fecha2= request.getParameter("fecha2").trim();
        String telefono= request.getParameter("telefono");
        //Calling the class that will do the data transfer
        Conexion conex = new Conexion();
        conex.crearEmpleado(id,nombre, fecha1, fecha2, telefono);
        response.sendRedirect("inicio.jsp");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
