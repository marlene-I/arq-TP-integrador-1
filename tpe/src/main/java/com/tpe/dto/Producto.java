package com.tpe;

public class Producto {
  Integer id;
  String nombre;
  Integer valor;

  
  public Producto(){
    super();
  }
  
   
  public Producto(Integer id, String nombre, Integer valor) {
    this.id = id;
    this.nombre = nombre;
    this.valor = valor;
  }


  public Integer getId() {
    return id;
  }


  public void setId(Integer id) {
    this.id = id;
  }


  public String getNombre() {
    return nombre;
  }


  public void setNombre(String nombre) {
    this.nombre = nombre;
  }


  public Integer getValor() {
    return valor;
  }


  public void setValor(Integer valor) {
    this.valor = valor;
  }

}
