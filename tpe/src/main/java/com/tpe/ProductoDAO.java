
package com.tpe;
public interface ProductoDAO extends DAO<Producto>{
  public Producto getProducto(Integer id);
}