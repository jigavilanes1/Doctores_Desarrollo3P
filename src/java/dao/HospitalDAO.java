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
import model.HospitalModel;

public class HospitalDAO {
    PreparedStatement ps;
    ResultSet rs;
    Conexion conexion = new Conexion();
    Connection conn;
    boolean respuesta = false;
    
    public ArrayList<HospitalModel> BuscarTodos() throws ClassNotFoundException{
        ArrayList<HospitalModel>lista = new ArrayList<HospitalModel>();
        String sql = "select * from hospital";
        try{
            conn = conexion.Conectar();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                HospitalModel hospitalTemp = new HospitalModel();
                hospitalTemp.setId(Integer.parseInt(rs.getString("Id_Hospital")));
                hospitalTemp.setNombre(rs.getString("Nombre_H"));
                hospitalTemp.setTelefono(rs.getString("Telefono"));
                hospitalTemp.setDireccion(rs.getString("Direccion"));
                lista.add(hospitalTemp);
            }
        }catch(SQLException ex){
            System.out.println("Error al Buscar Todos los hospitales()"+ex.getMessage());
        } finally {
            conexion.Cerrar(conn);
        }
        return lista;
    }
    
    public HospitalModel BuscarPorId(int id) throws ClassNotFoundException{
        HospitalModel hospitalTemp = new HospitalModel();
        String sql = "select * from hospital where id_hospital = ?";
        try{
            conn = conexion.Conectar();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                hospitalTemp.setId(rs.getInt("Id_Hospital"));
                hospitalTemp.setNombre(rs.getString("Nombre_H"));
                hospitalTemp.setTelefono(rs.getString("Telefono"));
                hospitalTemp.setDireccion(rs.getString("Direccion"));
            }
        }catch(SQLException ex){
           System.out.println("Error al Buscar por ID el hospital()"+ex.getMessage());
        } finally {
            conexion.Cerrar(conn);
        }
        return hospitalTemp;
    }
    
    public boolean Insertar(HospitalModel hModel) throws ClassNotFoundException{
        String sql = "insert into hospital(Nombre_H,telefono,direccion) values(?,?,?)";
        try{
            conn = conexion.Conectar();
            ps = conn.prepareStatement(sql);
            ps.setString(1, hModel.getNombre());
            ps.setString(2, hModel.getTelefono());
            ps.setString(3, hModel.getDireccion());
            if(ps.executeUpdate()>0){
                respuesta = true;
            }
        }catch(SQLException ex){
           System.out.println("Error al Insertar el hospital"+ex.getMessage());
        } finally {
            conexion.Cerrar(conn);
        }
        return respuesta;
    }
    
    public boolean Actualizar(HospitalModel hModel) throws ClassNotFoundException{
        String sql = "update hospital set Nombre_H =?, telefono =?, direccion=? where id_hospital =?";
        try{
            conn = conexion.Conectar();
            ps = conn.prepareStatement(sql);
            ps.setString(1, hModel.getNombre());
            ps.setString(2, hModel.getTelefono());
            ps.setString(3, hModel.getDireccion());
            ps.setInt(4,hModel.getId());
            if(ps.executeUpdate()>0){
                respuesta = true;
            }
        }catch(SQLException ex){
           System.out.println("Error al Actualizar el hospital"+ex.getMessage());
        } finally {
            conexion.Cerrar(conn);
        }
        return respuesta;
    }
    
    public boolean Eliminar(int id) throws ClassNotFoundException{
        String sql = "delete from hospital where id_hospital =?";
        try{
            conn = conexion.Conectar();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            if(ps.executeUpdate()>0){
                respuesta = true;
            }
        }catch(SQLException ex){
           System.out.println("Error al Eliminar el hospital"+ex.getMessage());
        } finally {
            conexion.Cerrar(conn);
        }
        return respuesta;
    }
}
