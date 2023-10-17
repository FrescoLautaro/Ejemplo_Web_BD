/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectarBD {

    private static Connection con;
    private static String bd = "INSTITUTO";
    private static String usuario = "root";
    private static String passw = "";
    private static String url = "jdbc:mysql://localhost/" + bd;

    public static Connection abrir() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, usuario, passw);
        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se puedo cargar el controlador JDBC.");
            throw new SQLException("Error en la conexion.", e);
        }
        return con;
    }

    public static void cerrar() {
        try {
            if (con != null) 
                con.close();
        } catch (SQLException e) {
            System.out.println("Error: No se logro cerrar la conexion:\n" + e);
        }
    }

}
