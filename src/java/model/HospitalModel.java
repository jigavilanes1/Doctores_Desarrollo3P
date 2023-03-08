/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class HospitalModel {
    private int Id;
    private String Nombre;
    private String Telefono;
    private String Direccion;

    public HospitalModel() {
    }

    public HospitalModel(int Id, String Nombre, String Telefono, String Direccion) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Telefono = Telefono;
        this.Direccion = Direccion;
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

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }
}
