/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GestorBD {

    Connection conn = null;
    Statement stm = null;
    ResultSet rs;
    int legajo;
    String nombre;
    String apellido;
    Double promedio;
    Alumno alEncontrado;

    public boolean registrar(String nombre, String apellido, Double promedio) {
        int resultUpdate = 0;

        try {
            conn = ConectarBD.abrir();
            stm = conn.createStatement();
            String sql = "INSERT INTO Alumno(nombre,apellido,promedio) values( '" + nombre + "','" + apellido + "'," + promedio + ")";

            resultUpdate = stm.executeUpdate(sql);
            if (resultUpdate != 0) {
                ConectarBD.cerrar();
                return true;

            } else {
                ConectarBD.cerrar();
                return false;
            }

        } catch (Exception e) {
            System.out.println("Error en la Base de Datos");
            e.printStackTrace();
            return false;
        }
    }

    public Alumno consultar(int legajo) {

        try {
            conn = ConectarBD.abrir();
            stm = conn.createStatement();
            String sql = "SELECT * FROM ALUMNO WHERE legajo=" + legajo;
            rs = stm.executeQuery(sql);
            if (!rs.next()) {
                System.out.println("No se encontro el registro");
                ConectarBD.cerrar();
                return null;
            } else {
                System.out.println("Se encontro el registro");
                this.legajo = rs.getInt("legajo");
                nombre = rs.getString("nombre");
                apellido = rs.getString("apellido");
                promedio = rs.getDouble("promedio");
                alEncontrado = new Alumno(this.legajo, nombre, apellido, promedio);
                ConectarBD.cerrar();
                return alEncontrado;
            }
        } catch (SQLException ex) {
            System.out.println("Error en la base de datos");
            return null;
        }
    }

    public ArrayList<Alumno> leerTodos() {
        ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
        try {
            conn = ConectarBD.abrir();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from ALUMNO");
            if (!rs.next()) {
                System.out.println("No se encontraron registros");
                ConectarBD.cerrar();
                return null;
            } else {
                do {
                    legajo = rs.getInt("legajo");
                    nombre = rs.getString("nombre");
                    apellido = rs.getString("apellido");
                    promedio = rs.getDouble("promedio");
                    alEncontrado = new Alumno(this.legajo, nombre, apellido, promedio);
                    alumnos.add(alEncontrado);
                } while (rs.next());
                ConectarBD.cerrar();
                return alumnos;
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return null;
        }

    }
}
