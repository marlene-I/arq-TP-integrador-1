package com.tpe;
public interface ClienteDAO extends DAO<Cliente> {
  public Cliente getCliente(Integer id);
  
  public Cliente updateCliente(Integer id, String nombre, String email);

}
