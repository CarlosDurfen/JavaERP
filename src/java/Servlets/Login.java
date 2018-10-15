package Servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
@WebServlet(urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesion = request.getSession();
        Conexion conex = new Conexion();
        int id;        
        //Taking the parameters from the form
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");     
        //chech if the username and password is correct
        if((id=conex.conectar(usuario,password))!=0){
            sesion.setAttribute("usuario", id);
            response.sendRedirect("inicio.jsp");    
        }else{
            response.sendRedirect("loginerroneo.html");
        }
    }

}
