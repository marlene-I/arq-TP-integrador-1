package com.tpe;
public interface ClienteDAO {
  public Cliente getCliente(Integer id);
  
  public Cliente updateCliente(Integer id, String nombre, String email);
}
