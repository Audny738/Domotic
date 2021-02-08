/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * 
 */
public class conectionDB {
    public static String url = "jdbc:mysql://localhost:3306/dbdomotic";
    public static String usuario = "root";
    public static String contraseña ="" ;
    public static String clase = "com.mysql.jdbc.Driver";
    
    public static Connection conectar(){
        Connection conexion = null;
        try {
            Class.forName(clase);
            conexion = (Connection)DriverManager.getConnection(url, usuario, contraseña);
        } catch (ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
        return conexion;
    }
    
    
}
