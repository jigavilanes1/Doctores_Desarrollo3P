/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.HospitalDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.HospitalModel;

public class HospitalController extends HttpServlet {

    HospitalDAO hDAO = new HospitalDAO();
    HospitalModel hModel = new HospitalModel();

    protected void listarHospitales(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("hospitales", hDAO.BuscarTodos());
            request.getRequestDispatcher("Hospital/listarHosp.jsp").forward(request, response);
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
                    listarHospitales(request, response);
                    break;
                case "Nuevo":
                    response.sendRedirect("Hospital/nuevoHosp.jsp");
                    break;
                case "Editar":
                    request.setAttribute("hospital", hDAO.BuscarPorId(id));
                    request.getRequestDispatcher("Hospital/editarHosp.jsp").forward(request, response);
                    break;
                case "Eliminar":
                    hDAO.Eliminar(id);
                    listarHospitales(request, response);
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
            String telefono = request.getParameter("telefono") == null ? "" : request.getParameter("telefono");
            String direccion = request.getParameter("direccion") == null ? "" : request.getParameter("direccion");
                                   
            hModel.setNombre(nombre);
            hModel.setTelefono(telefono);
            hModel.setDireccion(direccion);            

            switch (accion) {
                case "Guardar":
                    hDAO.Insertar(hModel);
                    break;
                case "Actualizar":
                    hModel.setId(Integer.parseInt(request.getParameter("id")));
                    hDAO.Actualizar(hModel);                    
                    break;
                default:
                    throw new AssertionError();
            }
            listarHospitales(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HospitalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
