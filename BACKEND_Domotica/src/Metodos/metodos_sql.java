/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
/**
 *
 * 
 */
public class metodos_sql {
    public static conectionDB conexion = new conectionDB();
    
    public static PreparedStatement sentenciaPreparada;
    public static ResultSet resultado;
    public static String sql;
    public static int resultadoNum = 0;
    
    public int guardar(String nombre, String correo, String contra, String repetirContra){
        int resultado = 0;
        Connection conexion = null;
        
        String sentencia_guardar = ("INSERT INTO users(user,mail,pass) VALUES (?,?,?) ");
        try{
            conexion = conectionDB.conectar();
            sentenciaPreparada = conexion.prepareStatement(sentencia_guardar);
            sentenciaPreparada.setString(1, nombre);
            sentenciaPreparada.setString(2, correo);
            sentenciaPreparada.setString(3, contra);
            
            resultado = sentenciaPreparada.executeUpdate();
            sentenciaPreparada.close();
            conexion.close();
        } catch (Exception e){
            System.out.println(e);
        }
        return resultado;
    }
    
    
    public static String buscarNombre(String nombre){
        String busquedaNombre = null;
        Connection conexion = null;
        try{
            conexion = conectionDB.conectar();
            String sentenciaBuscar =("SELECT mail FROM users WHERE user = '" + nombre + "'");
            sentenciaPreparada = conexion.prepareStatement(sentenciaBuscar);
            resultado = sentenciaPreparada.executeQuery();
            if(resultado.next()){
                String correo = resultado.getString("mail");
                busquedaNombre = (correo);
            }
            conexion.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return busquedaNombre; 
    }
    
    public static String buscarUsuarioRegistrado (String nombre, String contra){
        String busquedaUsuario = null;
        Connection conexion = null;
        
        try{
            conexion = conectionDB.conectar();
            String sentenciaBuscarUsuario = ("SELECT user,mail,pass FROM users WHERE user = '"+nombre+"' && pass = '"+contra+"'");
            sentenciaPreparada = conexion.prepareStatement(sentenciaBuscarUsuario);
            resultado = sentenciaPreparada.executeQuery();
            if(resultado.next()){
                busquedaUsuario = "usuario encontrado";
            }else{
                busquedaUsuario = "usuario no encontrado";
            }
            conexion.close();
        }catch (Exception e){
            System.out.println(e);
        }
        
        return busquedaUsuario;
    }
}
