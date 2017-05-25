/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basedatos;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jquesadaabeijon
 */
public class Metodos{
    static Connection con = null;
    static Statement s = null;
    public static String db = "base.db";
    public static String url = "jdbc:sqlite:" +db;

    public static Connection conectar(){
     
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            DatabaseMetaData meta = conn.getMetaData();
            System.out.println("El driver es " + meta.getDriverName());
            System.out.println("Estás conectado");
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return conn;
    }
    
    public void crearTabla(){
//        String url = "jdbc:sqlite:" +db;
        String sql = "CREATE TABLE IF NOT EXISTS alumnos (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	nombre text NOT NULL,\n"
                + "	apellidos text NOT NULL,\n"
                + "     edad REAL\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
