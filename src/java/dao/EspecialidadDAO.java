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
import model.EspecialidadModel;

public class EspecialidadDAO {
    PreparedStatement ps;
    ResultSet rs;
    Conexion conexion = new Conexion();
    Connection conn;
    boolean respuesta = false;
    
    public ArrayList<EspecialidadModel> BuscarTodos() throws ClassNotFoundException{
        ArrayList<EspecialidadModel>lista = new ArrayList<EspecialidadModel>();
        String sql = "select * from especialidad";
        try{
            conn = conexion.Conectar();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                EspecialidadModel especialidadTemp = new EspecialidadModel();
                especialidadTemp.setId(Integer.parseInt(rs.getString("Id_Especialidad")));
                especialidadTemp.setNombre(rs.getString("Nombre_E"));
                lista.add(especialidadTemp);
            }
        }catch(SQLException ex){
            System.out.println("Error al Buscar Todas las especializaciones()"+ex.getMessage());
        } finally {
            conexion.Cerrar(conn);
        }
        return lista;
    }
    
    public EspecialidadModel BuscarPorId(int id) throws ClassNotFoundException{
        EspecialidadModel especialidadTemp = new EspecialidadModel();
        String sql = "select * from especialidad where id_especialidad = ?";
        try{
            conn = conexion.Conectar();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                especialidadTemp.setId(rs.getInt("Id_Especialidad"));
                especialidadTemp.setNombre(rs.getString("Nombre_E"));
            }
        }catch(SQLException ex){
           System.out.println("Error al Buscar por ID la especialidad()"+ex.getMessage());
        } finally {
            conexion.Cerrar(conn);
        }
        return especialidadTemp;
    }
    
    public boolean Insertar(EspecialidadModel eModel) throws ClassNotFoundException{
        String sql = "insert into especialidad(Nombre_E) values(?)";
        try{
            conn = conexion.Conectar();
            ps = conn.prepareStatement(sql);
            ps.setString(1, eModel.getNombre());
            if(ps.executeUpdate()>0){
                respuesta = true;
            }
        }catch(SQLException ex){
           System.out.println("Error al Insertar la especialidad"+ex.getMessage());
        } finally {
            conexion.Cerrar(conn);
        }
        return respuesta;
    }
    
    public boolean Actualizar(EspecialidadModel eModel) throws ClassNotFoundException{
        String sql = "update especialidad set Nombre_E =? where id_especialidad = ?";
        try{
            conn = conexion.Conectar();
            ps = conn.prepareStatement(sql);
            ps.setString(1, eModel.getNombre());
            ps.setInt(2,eModel.getId());
            if(ps.executeUpdate()>0){
                respuesta = true;
            }
        }catch(SQLException ex){
           System.out.println("Error al Actualizar la especialidad"+ex.getMessage());
        } finally {
            conexion.Cerrar(conn);
        }
        return respuesta;
    }
    
    public boolean Eliminar(int id) throws ClassNotFoundException{
        String sql = "delete from especialidad where id_especialidad = ?";
        try{
            conn = conexion.Conectar();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            if(ps.executeUpdate()>0){
                respuesta = true;
            }
        }catch(SQLException ex){
           System.out.println("Error al Eliminar la especialidad"+ex.getMessage());
        } finally {
            conexion.Cerrar(conn);
        }
        return respuesta;
    }
}