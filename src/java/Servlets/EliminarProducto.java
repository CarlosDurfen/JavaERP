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
@WebServlet(name = "EliminarProducto", urlPatterns = {"/EliminarProducto"})
public class EliminarProducto extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Taking the parameters from the JSON
        int idproducto = Integer.parseInt(request.getParameter("idproducto").trim());
        //request the session atribute id
        HttpSession sesion = request.getSession();
        Integer idstring = (Integer) sesion.getAttribute("usuario");
        int id = idstring;
        //Calling the class that will do the data transfer
        Conexion conex = new Conexion();
        conex.eliminarProducto(idproducto, id);
    }

}
