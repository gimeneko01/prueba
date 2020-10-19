package com.chiri.chiri.courseraagenda;


public class Contacto {

    private String nombre;
    private String telefono;
    private String email;
    private String nacimiento;
    private String descripcion;

    public Contacto(String nombre, String telefono, String email, String nacimiento, String descripcion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.nacimiento = nacimiento;
        this.descripcion = descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
