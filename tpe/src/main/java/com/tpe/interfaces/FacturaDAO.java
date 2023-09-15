package com.tpe.interfaces;

import com.tpe.dto.Factura;

public interface FacturaDAO extends DAO<Factura>{
  public Factura getFactura(Integer id);
  // mas metodos de la factura 
}
