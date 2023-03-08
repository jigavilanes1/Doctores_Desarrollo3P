/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class DoctorModel {
    private int Id;
    private String Nombre;
    private String Apellido;
    private String Correo;
    private String Celular;
    private int idHospital;
    private int idEspecialidad;
    private String Hospital;
    private String Especialidad;

    public DoctorModel() {
    }

    public DoctorModel(int Id, String Nombre, String Apellido, String Correo, String Celular, int idHospital, int idEspecialidad) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Correo = Correo;
        this.Celular = Celular;
        this.idHospital = idHospital;
        this.idEspecialidad = idEspecialidad;
    }
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public int getIdHospital() {
        return idHospital;
    }

    public void setIdHospital(int idHospital) {
        this.idHospital = idHospital;
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getHospital() {
        return Hospital;
    }

    public void setHospital(String Hospital) {
        this.Hospital = Hospital;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String Especialidad) {
        this.Especialidad = Especialidad;
    }
    
    
}
