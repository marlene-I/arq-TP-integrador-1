package com.tpe.interfaces;

import com.tpe.dto.Cliente;

import java.sql.SQLException;
import java.util.List;

public interface ClienteDAO extends DAO<Cliente> {
  public Cliente getCliente(Integer id);

  public Cliente updateCliente(Integer id, String nombre, String email);

  public List<Cliente> obtenerClientesQueMasFacturaron() throws SQLException;;
}
