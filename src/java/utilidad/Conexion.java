/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidad;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Durfen
 */
//Singleton class
public class Conexion {
    //Declaration of the comun variables
    private Connection cn = null;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String url = "jdbc:mysql://localhost:3306/controlusuarios?autoReconnect=true&useSSL=false";
    private String usuariodb = "root";
    private String passworddb = "rootrootroot";
    private PreparedStatement stmt;
    private boolean resultado = false;
    private List<String> datostabla;

    /*Login funcion*/
    public int conectar(String usuario, String password) {
        int id = 0;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(url, usuariodb, passworddb);
            String sql = "SELECT id FROM usuarios WHERE  usuario= ? and pas = ?";
            stmt = cn.prepareStatement(sql);
            stmt.setString(1, usuario);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                id = rs.getInt(1);
            }

            cn.close();
            stmt.close();
            rs.close();
        } catch (Exception ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;

    }

    /*List for the dinamic tables*/
    public List<String> tablaUsuarios(Integer usuario) {
        try {
            datostabla = new ArrayList<String>();
            Class.forName("com.mysql.jdbc.Driver");
            int id = 1;
            cn = DriverManager.getConnection(url, usuariodb, passworddb);
            stmt = cn.prepareStatement("SELECT * FROM empleados WHERE idusuarios = ?");
            stmt.setInt(1, id);

            rs = stmt.executeQuery();
            //loop to introduce the data into de List
            while (rs.next()) {
                datostabla.add("" + rs.getString(1));
                datostabla.add("" + rs.getString(3));
                datostabla.add("" + rs.getString(4));
                datostabla.add("" + rs.getString(5));
                datostabla.add("" + rs.getString(6));
                System.out.println(datostabla.get(0) + "");
            }

            cn.close();
            stmt.close();
            rs.close();
            return datostabla;

        } catch (Exception ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<String> tablaClientes(Integer usuario) {
        try {
            datostabla = new ArrayList<String>();
            Class.forName("com.mysql.jdbc.Driver");

            cn = DriverManager.getConnection(url, usuariodb, passworddb);
            stmt = cn.prepareStatement("SELECT idcliente,nombre,telefono FROM clientes WHERE idusuarios = ?");
            stmt.setInt(1, usuario);
            
            rs = stmt.executeQuery();
            //loop to introduce the data into de List
            while (rs.next()) {

                datostabla.add("" + rs.getString(1));
                datostabla.add("" + rs.getString(2));
                datostabla.add("" + rs.getString(3));

            }
            
            cn.close();
            stmt.close();
            rs.close();
            return datostabla;

        } catch (Exception ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<String> tablaProductos(Integer usuarios) {
        try {
            datostabla = new ArrayList<String>();
            Class.forName("com.mysql.jdbc.Driver");
            int id = 1;
            cn = DriverManager.getConnection(url, usuariodb, passworddb);
            stmt = cn.prepareStatement("SELECT idproducto,nombre,descripcion,precio FROM productos WHERE idusuarios = ?");
            stmt.setInt(1, id);

            rs = stmt.executeQuery();
            //loop to introduce the data into de List
            while (rs.next()) {

                datostabla.add("" + rs.getString(1));
                datostabla.add("" + rs.getString(2));
                datostabla.add("" + rs.getString(3));
                datostabla.add("" + rs.getString(4));

            }

            cn.close();
            stmt.close();
            rs.close();
            return datostabla;

        } catch (Exception ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    /*Functions to delete a register of the DB
    at all the calls will be use prepare statement and a doble check to prevent SQLInjection
    */
    
    public void eliminarEmpleado(int idempleado, int idusuario) {
        try {
            datostabla = new ArrayList<String>();
            Class.forName("com.mysql.jdbc.Driver");

            cn = DriverManager.getConnection(url, usuariodb, passworddb);
            
            stmt = cn.prepareStatement("delete from empleados  where idempleado = ? and idusuarios = ?");
            stmt.setInt(1, idempleado);
            stmt.setInt(2, idusuario);

            stmt.executeUpdate();
            
            cn.close();
            stmt.close();

        } catch (Exception ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void eliminarCliente(int idcliente, int idusuario) {
        try {
            datostabla = new ArrayList<String>();
            Class.forName("com.mysql.jdbc.Driver");

            cn = DriverManager.getConnection(url, usuariodb, passworddb);

            stmt = cn.prepareStatement("delete from clientes  where idcliente = ? and idusuarios = ?");
            stmt.setInt(1, idcliente);
            stmt.setInt(2, idusuario);

            stmt.executeUpdate();

            cn.close();
            stmt.close();

        } catch (Exception ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void eliminarProducto(int idcliente, int idusuario) {
        try {
            datostabla = new ArrayList<String>();
            Class.forName("com.mysql.jdbc.Driver");

            cn = DriverManager.getConnection(url, usuariodb, passworddb);
            
            stmt = cn.prepareStatement("delete from productos  where idproducto = ? and idusuarios = ?");
            stmt.setInt(1, idcliente);
            stmt.setInt(2, idusuario);

            stmt.executeUpdate();

            cn.close();
            stmt.close();
            
        } catch (Exception ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /*Update a register of the db
    Doble check and prepare statement to prevent SQLInjection
    */
    public void actualizarEmpleado(int idusuario, int idempleado, String nombre, String fecha, String fechafin, String sueldo) {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Date fechaini = Date.valueOf(fecha);
            Date ffin = Date.valueOf(fechafin);
            int sueldos = Integer.parseInt(sueldo);
            cn = DriverManager.getConnection(url, usuariodb, passworddb);
            stmt = cn.prepareStatement("update empleados set nombre= ?, fechacontrato = ?, fechafincontrato= ?, sueldo = ?  where idempleado = ?"
                    + " and idusuarios = ?");
            stmt.setString(1, nombre);
            stmt.setDate(2, fechaini);
            stmt.setDate(3, ffin);
            stmt.setInt(4, sueldos);
            stmt.setInt(5, idempleado);
            stmt.setInt(6, idusuario);

            stmt.executeUpdate();
            cn.close();
            stmt.close();

        } catch (Exception ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualizarCliente(Integer idusuario, int idcliente, String nombre, int telefono) {
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(url, usuariodb, passworddb);
            stmt = cn.prepareStatement("update clientes set nombre = ?, telefono= ?  where idcliente = ? and idusuarios = ?");
            stmt.setString(1, nombre);
            stmt.setInt(2, telefono);
            stmt.setInt(3, idcliente);
            stmt.setInt(4, idusuario);
            stmt.executeUpdate();
            cn.close();
            stmt.close();

        } catch (Exception ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualizarProducto(int idusuario,int idproducto, String nombre, String descripcion, int precio) {
        try {

            Class.forName("com.mysql.jdbc.Driver");

            cn = DriverManager.getConnection(url, usuariodb, passworddb);
            stmt = cn.prepareStatement("update productos set nombre = ?, descripcion= ?, precio = ?  where idproducto = ? and idusuarios = ?");
            stmt.setString(1, nombre);
            stmt.setString(2, descripcion);
            stmt.setInt(3, precio);
            stmt.setInt(4, idproducto);
            stmt.setInt(5, idusuario);
            System.out.println(nombre);

            stmt.executeUpdate();
            cn.close();
            stmt.close();

        } catch (Exception ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*Create new data into de DB*/
    public void crearEmpleado(Integer idusuario, String nombre, String fecha, String fechafin, String sueldo) {
        try {
            int idempleado;
            ResultSet rss;
            System.out.println(idusuario + nombre + fecha + fechafin + sueldo);

            Class.forName("com.mysql.jdbc.Driver");
            Date d = Date.valueOf(fecha);
            Date dd = Date.valueOf(fechafin);
            int a = Integer.parseInt(sueldo);
            cn = DriverManager.getConnection(url, usuariodb, passworddb);
            //Check the last id
            stmt = cn.prepareStatement("SELECT max(idempleado) FROM empleados");
            rs = stmt.executeQuery();
            rs.next();
            //Id of the new register
            idempleado = rs.getInt(1) + 1;
            rs.close();
            //Inserting the new data
            stmt = cn.prepareStatement("insert into empleados values(?,?,?,?,?,?)");
            stmt.setInt(1, idempleado);
            stmt.setInt(2, idusuario);
            stmt.setString(3, nombre);
            stmt.setDate(4, d);
            stmt.setDate(5, dd);
            stmt.setInt(6, a);
            System.out.println(nombre);

            stmt.executeUpdate();
            cn.close();
            stmt.close();
        } catch (Exception ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void crearCliente(Integer idusuario, String nombre, int telefono) {
        try {
            int idcliente;
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(url, usuariodb, passworddb);
            //Check the last id
            stmt = cn.prepareStatement("SELECT max(idcliente) FROM clientes");
            rs = stmt.executeQuery();
            rs.next();
            //Id of the new row
            idcliente = rs.getInt(1) + 1;
            rs.close();
            //Inserting the new data
            stmt = cn.prepareStatement("insert into clientes values(?,?,?,?)");
            stmt.setInt(1, idcliente);
            stmt.setInt(2, idusuario);
            stmt.setString(3, nombre);
            stmt.setInt(4, telefono);
            System.out.println(nombre);
            stmt.executeUpdate();
            
            
            cn.close();
            stmt.close();
        } catch (Exception ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void crearProducto(Integer idusuario, String nombre, String descripcion, int precio) {
        try {
            int idproducto;
            Class.forName("com.mysql.jdbc.Driver");

            cn = DriverManager.getConnection(url, usuariodb, passworddb);
            //Check the last id
            stmt = cn.prepareStatement("SELECT max(idproducto) FROM productos");
            rs = stmt.executeQuery();
            rs.next();
            //Id of the new row
            idproducto = rs.getInt(1) + 1;
            rs.close();
            //Inserting the new data
            stmt = cn.prepareStatement("insert into productos values(?,?,?,?,?)");
            stmt.setInt(1, idproducto);
            stmt.setString(2, nombre);
            stmt.setString(3, descripcion);
            stmt.setInt(4, precio);
            stmt.setInt(5, idusuario);
            stmt.executeUpdate();
            
            cn.close();
            stmt.close();
        } catch (Exception ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
