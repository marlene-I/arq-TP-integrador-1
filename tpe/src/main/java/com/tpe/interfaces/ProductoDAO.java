
package com.tpe.interfaces;

import java.sql.SQLException;

import com.tpe.dto.Producto;

public interface ProductoDAO extends DAO<Producto>{
  public Producto getProducto(Integer id);
  public Producto getProductoMayorRecaudacion() throws SQLException;
}