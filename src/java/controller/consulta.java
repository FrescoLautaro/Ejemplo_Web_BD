/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Alumno;
import modelo.GestorBD;

@WebServlet(name = "consulta", urlPatterns = {"/consulta"})
public class consulta extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int legajo = Integer.parseInt(request.getParameter("legajo"));

        try {
            Alumno al;
            GestorBD gestorBD = new GestorBD();
            al = gestorBD.consultar(legajo);
            if (al != null) {
                request.setAttribute("unAlumno", al);
                request.getRequestDispatcher("/muestraUnAlumno.jsp").forward(request, response);
            } else {

                request.getRequestDispatcher("/AlumnoNoEncontrado.jsp").forward(request, response);

            }

        } finally {
            out.close();
        }

    }
}
