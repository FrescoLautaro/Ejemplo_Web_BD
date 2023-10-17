/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author ET36
 */
public class Alumno {
    private int legajo;
    private String nombre;
    private String apellido;
    private double  promedio;

    public Alumno(int legajo, String nombre, String apellido, double promedio) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.promedio = promedio;
    }
    
}
