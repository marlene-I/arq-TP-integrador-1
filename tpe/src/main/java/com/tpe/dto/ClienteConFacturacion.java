package com.tpe.dto;

public class ClienteConFacturacion extends Cliente {
  Float totalFacturacion;

  public ClienteConFacturacion(Integer id, String nombre, String email, Float totalFacturacion) {
    super(id, nombre, email);
    this.totalFacturacion = totalFacturacion;
  }

  public Float getTotalFacturacion() {
    return totalFacturacion;
  }

  public void setTotalFacturacion(Float totalFacturacion) {
    this.totalFacturacion = totalFacturacion;
  }

  
}
