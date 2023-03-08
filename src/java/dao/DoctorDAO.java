/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.DoctorModel;

public class DoctorDAO {
    PreparedStatement ps;
    ResultSet rs;
    Conexion conexion = new Conexion();
    Connection conn;
    boolean respuesta = false;
    
    public ArrayList<DoctorModel> BuscarTodos() throws ClassNotFoundException{
        ArrayList<DoctorModel>lista = new ArrayList<DoctorModel>();
        String sql = "select * from doctor inner join especialidad on especialidad.id_especialidad = doctor.id_especialidad inner join hospital on hospital.id_hospital = doctor.id_hospital"; 
        try{
            conn = conexion.Conectar();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                DoctorModel doctorTemp = new DoctorModel();
                doctorTemp.setId(Integer.parseInt(rs.getString("Id_Doctor")));
                doctorTemp.setNombre(rs.getString("Nombre"));
                doctorTemp.setApellido(rs.getString("Apellido"));
                doctorTemp.setCorreo(rs.getString("Correo"));
                doctorTemp.setCelular(rs.getString("Celular"));                
                doctorTemp.setEspecialidad(rs.getString("Nombre_E"));
                doctorTemp.setHospital(rs.getString("Nombre_H"));
                lista.add(doctorTemp);
            }
        }catch(SQLException ex){
            System.out.println("Error al Buscar Todos los doctores()"+ex.getMessage());
        } finally {
            conexion.Cerrar(conn);
        }
        return lista;
    }
    
    public DoctorModel BuscarPorId(int id) throws ClassNotFoundException{
        DoctorModel doctorTemp = new DoctorModel();
        String sql = "select * from doctor where id_doctor =?";
        try{
            conn = conexion.Conectar();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                doctorTemp.setId(rs.getInt("Id_Doctor"));
                doctorTemp.setNombre(rs.getString("Nombre"));
                doctorTemp.setApellido(rs.getString("Apellido"));
                doctorTemp.setCorreo(rs.getString("Correo"));
                doctorTemp.setCelular(rs.getString("Celular"));
                doctorTemp.setIdHospital(rs.getInt("Id_Hospital"));
                doctorTemp.setIdEspecialidad(rs.getInt("Id_Especialidad"));                
            }
        }catch(SQLException ex){
           System.out.println("Error al Buscar por ID al doctor()"+ex.getMessage());
        } finally {
            conexion.Cerrar(conn);
        }
        return doctorTemp;
    }
    
    public boolean Insertar(DoctorModel dModel) throws ClassNotFoundException{
        String sql = "insert into doctor(nombre,apellido,correo,celular,id_hospital,id_especialidad) values(?,?,?,?,?,?)";
        try{
            conn = conexion.Conectar();
            ps = conn.prepareStatement(sql);
            ps.setString(1, dModel.getNombre());
            ps.setString(2, dModel.getApellido());
            ps.setString(3, dModel.getCorreo());
            ps.setString(4, dModel.getCelular());
            ps.setInt(5, dModel.getIdHospital());
            ps.setInt(6, dModel.getIdEspecialidad());
            if(ps.executeUpdate()>0){
                respuesta = true;
            }
        }catch(SQLException ex){
           System.out.println("Error al Insertar al doctor"+ex.getMessage());
        } finally {
            conexion.Cerrar(conn);
        }
        return respuesta;
    }
    
    public boolean Actualizar(DoctorModel dModel) throws ClassNotFoundException{
        String sql = "update doctor set nombre = ?, apellido = ?, correo = ?, celular = ?, id_hospital = ?, id_especialidad = ? where id_doctor = ?";
        try{
            conn = conexion.Conectar();
            ps = conn.prepareStatement(sql);
            ps.setString(1, dModel.getNombre());
            ps.setString(2, dModel.getApellido());
            ps.setString(3, dModel.getCorreo());
            ps.setString(4, dModel.getCelular());
            ps.setInt(5, dModel.getIdHospital());
            ps.setInt(6, dModel.getIdEspecialidad());
            ps.setInt(7,dModel.getId());
            if(ps.executeUpdate()>0){
                respuesta = true;
            }
        }catch(SQLException ex){
           System.out.println("Error al Actualizar al doctor"+ex.getMessage());
        } finally {
            conexion.Cerrar(conn);
        }
        return respuesta;
    }
    
    public boolean Eliminar(int id) throws ClassNotFoundException{
        String sql = "delete from doctor where id_doctor =?";
        try{
            conn = conexion.Conectar();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            if(ps.executeUpdate()>0){
                respuesta = true;
            }
        }catch(SQLException ex){
           System.out.println("Error al Eliminar al doctor"+ex.getMessage());
        } finally {
            conexion.Cerrar(conn);
        }
        return respuesta;
    }
}
