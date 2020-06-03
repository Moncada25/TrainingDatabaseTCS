package com.tcs.training10.ejerciciobd.model;

public class Departamento {

  private int clave_depto;
  private String nombre;
  private int presupueto;

  public Departamento(int clave_depto, String nombre, int presupueto) {
    this.clave_depto = clave_depto;
    this.nombre = nombre;
    this.presupueto = presupueto;
  }

  public int getClave_depto() {
    return clave_depto;
  }

  public String getNombre() {
    return nombre;
  }

  public int getPresupueto() {
    return presupueto;
  }
}
