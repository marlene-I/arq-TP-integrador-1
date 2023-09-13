package com.tpe;

public class Cliente {
  Integer id;
  String nombre;
  String email;

  public Cliente(){
    super();
  }
  
  public Cliente(Integer id, String nombre, String email){
    this.id = id;
    this.nombre = nombre;
    this.email = email;
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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }



}


