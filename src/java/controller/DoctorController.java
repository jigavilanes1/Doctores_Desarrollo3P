/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.DoctorDAO;
import dao.EspecialidadDAO;
import dao.HospitalDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DoctorModel;

public class DoctorController extends HttpServlet {
   
    DoctorDAO dDAO = new DoctorDAO();
    DoctorModel dModel = new DoctorModel();
    HospitalDAO hDAO = new HospitalDAO();
    EspecialidadDAO eDAO = new EspecialidadDAO();

    protected void listarDoctores(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("doctores", dDAO.BuscarTodos());
            request.getRequestDispatcher("Doctor/listarDoctor.jsp").forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HospitalController.class.getName()).log(Level.SEVERE, null, ex);
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
                    listarDoctores(request, response);
                    break;
                case "Nuevo":                    
                    request.setAttribute("hospitales", hDAO.BuscarTodos());               
                    request.setAttribute("especialidades", eDAO.BuscarTodos());
                    request.getRequestDispatcher("Doctor/nuevoDoctor.jsp").forward(request, response);                                  
                    break;
                case "Editar":                    
                    request.setAttribute("doctor", dDAO.BuscarPorId(id));
                    request.setAttribute("especialidad", eDAO.BuscarPorId(id));
                    request.setAttribute("hospital", hDAO.BuscarPorId(id));
                    request.setAttribute("hospitales", hDAO.BuscarTodos());               
                    request.setAttribute("especialidades", eDAO.BuscarTodos());
                    request.getRequestDispatcher("Doctor/editarDoctor.jsp").forward(request, response);
                    break;
                case "Eliminar":
                    dDAO.Eliminar(id);
                    listarDoctores(request, response);
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
            String apellido = request.getParameter("apellido") == null ? "" : request.getParameter("apellido");
            String correo = request.getParameter("correo") == null ? "" : request.getParameter("correo");
            String celular = request.getParameter("celular") == null ? "" : request.getParameter("celular");
                                   
            dModel.setNombre(nombre);
            dModel.setApellido(apellido);
            dModel.setCorreo(correo);
            dModel.setCelular(celular);
            dModel.setIdHospital(Integer.parseInt(request.getParameter("idHospital")));
            dModel.setIdEspecialidad(Integer.parseInt(request.getParameter("idEspecialidad")));
            
            switch (accion) {
                case "Guardar":
                    dDAO.Insertar(dModel);
                    break;
                case "Actualizar":
                    dModel.setId(Integer.parseInt(request.getParameter("id")));
                    dDAO.Actualizar(dModel);                    
                    break;
                default:
                    throw new AssertionError();
            }
            listarDoctores(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DoctorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
