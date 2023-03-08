/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.EspecialidadDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.EspecialidadModel;

public class EspecialidadController extends HttpServlet {

    EspecialidadDAO eDAO = new EspecialidadDAO();
    EspecialidadModel eModel = new EspecialidadModel();

    protected void listarEspecialidades(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("especialidades", eDAO.BuscarTodos());
            request.getRequestDispatcher("Especialidad/listarEsp.jsp").forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EspecialidadController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String accion = request.getParameter("accion") == null ? "" : request.getParameter("accion");
            int id = request.getParameter("id") == null ? 0 : Integer.parseInt(request.getParameter("id"));

            switch (accion) {
                case "":
                    listarEspecialidades(request, response);
                    break;
                case "Nuevo":
                    response.sendRedirect("Especialidad/nuevoEsp.jsp");
                    break;
                case "Editar":
                    request.setAttribute("especialidad", eDAO.BuscarPorId(id));
                    request.getRequestDispatcher("Especialidad/editarEsp.jsp").forward(request, response);
                    break;
                case "Eliminar":
                    eDAO.Eliminar(id);
                    listarEspecialidades(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HospitalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String accion = request.getParameter("accion") == null ? "" : request.getParameter("accion");                        
            String nombre = request.getParameter("nombre") == null ? "" : request.getParameter("nombre");            
                                   
            eModel.setNombre(nombre);                  

            switch (accion) {
                case "Guardar":
                    eDAO.Insertar(eModel);
                    break;
                case "Actualizar":
                    eModel.setId(Integer.parseInt(request.getParameter("id")));
                    eDAO.Actualizar(eModel);                    
                    break;
                default:
                    throw new AssertionError();
            }
            listarEspecialidades(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EspecialidadController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}