package com.tpe;

public class Factura {
  Integer id;
  Integer idCliente;

  
  public Factura(Integer id, Integer idCliente) {
    this.id = id;
    this.idCliente = idCliente;
  }


  public Integer getId() {
    return id;
  }


  public void setId(Integer id) {
    this.id = id;
  }


  public Integer getIdCliente() {
    return idCliente;
  }


  public void setIdCliente(Integer idCliente) {
    this.idCliente = idCliente;
  }
  
  
}
