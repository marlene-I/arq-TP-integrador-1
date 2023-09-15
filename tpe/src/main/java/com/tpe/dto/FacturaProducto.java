package com.tpe.dto;

public class FacturaProducto {
  Integer idFactura;
  Integer idProducto;
  Integer cantidad;
  
  public FacturaProducto(Integer idFactura, Integer idProducto, Integer cantidad) {
    this.idFactura = idFactura;
    this.idProducto = idProducto;
    this.cantidad = cantidad;
  }

  public Integer getIdFactura() {
    return idFactura;
  }

  public void setIdFactura(Integer idFactura) {
    this.idFactura = idFactura;
  }

  public Integer getIdProducto() {
    return idProducto;
  }

  public void setIdProducto(Integer idProducto) {
    this.idProducto = idProducto;
  }

  public Integer getCantidad() {
    return cantidad;
  }

  public void setCantidad(Integer cantidad) {
    this.cantidad = cantidad;
  }
 
}
