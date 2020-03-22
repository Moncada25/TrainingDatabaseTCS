package com.tcs.training10.ejerciciobd.model;

public class Empleado {

    private String clave_empleado;
    private String nombre;
    private String apellidos;
    private int clave_depto;

    public Empleado(String clave_empleado, String nombre, String apellidos, int clave_depto) {
        this.clave_empleado = clave_empleado;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.clave_depto = clave_depto;
    }

    public String getClave_empleado() {
        return clave_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getClave_depto() {
        return clave_depto;
    }
}
