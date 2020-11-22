package edu.upc.dsa.models;

import java.util.Date;

public class Caso implements Comparable<Caso>
{
    String nombre;
    String apellidos;
    int ID;
    String fechaNacimiento;           // Formato yyyy/mm/dd
    String fechaInforme;              // Formato yyyy/mm/dd
    String nivelRiesgo;             // Alto, medio o bajo
    String genero;
    String correoElectronico;
    int telf;
    String direccion;
    String clasificacion;           // Sospechoso, confirmado o no caso

    public Caso(String nombre, String apellidos, String fechaNacimiento, String fechaInforme, String nivelRiesgo, String genero, String correoElectronico, int telf, String direccion, String clasificacion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaInforme = fechaInforme;
        this.nivelRiesgo = nivelRiesgo;
        this.genero = genero;
        this.correoElectronico = correoElectronico;
        this.telf = telf;
        this.direccion = direccion;
        this.clasificacion = clasificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFechaInforme() {
        return fechaInforme;
    }

    public void setFechaInforme(String fechaInforme) {
        this.fechaInforme = fechaInforme;
    }

    public String getNivelRiesgo() {
        return nivelRiesgo;
    }

    public void setNivelRiesgo(String nivelRiesgo) {
        this.nivelRiesgo = nivelRiesgo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public int getTelf() {
        return telf;
    }

    public void setTelf(int telf) {
        this.telf = telf;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    @Override
    public String toString() {
        return "Caso{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", ID=" + ID +
                ", fechaNacimiento=" + fechaNacimiento +
                ", fechaInforme=" + fechaInforme +
                ", nivelRiesgo='" + nivelRiesgo + '\'' +
                ", genero='" + genero + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", telf=" + telf +
                ", direccion='" + direccion + '\'' +
                ", clasificacion='" + clasificacion + '\'' +
                '}';
    }

    @Override
    public int compareTo(Caso o) {
        return -(int)o.getFechaInforme().compareTo((this.getFechaInforme()));
    }
}
