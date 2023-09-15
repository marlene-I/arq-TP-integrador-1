package com.tpe.dto;

public class ProductoConTotal extends Producto{

  Float total; 

  public ProductoConTotal(Integer id, String nombre, Float valor, Float total) {
    super(id, nombre, valor);
    this.total = total;
  }

  public Float getTotal() {
    return total;
  }

  public void setTotal(Float total) {
    this.total = total;
  }
}
