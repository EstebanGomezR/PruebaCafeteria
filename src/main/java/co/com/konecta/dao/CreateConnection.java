/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.konecta.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author esteban gomez
 */
public class CreateConnection {
    protected Connection conectar = null;
    private final String url = "jdbc:mysql://localhost/bd_cafeteria";
    private final String usuario = "root";
    private final String password = "";
    
    
    public Connection abrirConexion() throws ClassNotFoundException
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); // De esta forma cargamos la clase Driver de MySQL.
            conectar = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexión Exitosa");
        }catch(SQLException ex){
            System.out.println("Error al abrir Conexión: " + ex.getMessage());
        } 
        return conectar;
    }
    
}
