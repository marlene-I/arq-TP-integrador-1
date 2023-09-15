package com.tpe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.tpe.dto.FacturaProducto;
import com.tpe.factory.MySQLJDBCDAOFactory;
import com.tpe.interfaces.FacturaProductoDAO;

public class MySQLFacturaProductoDAO implements FacturaProductoDAO{

  @Override
  public void insert(FacturaProducto element) throws SQLException {
    String query = "INSERT INTO factura_producto (idFactura, idProducto, cantidad) VALUES (?, ?)";
    
    Connection conn = MySQLJDBCDAOFactory.getConnection();

    PreparedStatement ps = conn.prepareStatement(query);

    ps.setInt(1, element.getIdFactura());
    ps.setInt(2, element.getIdProducto());
    ps.setInt(2, element.getCantidad());
    ps.executeUpdate();
   
  }

  @Override
  public void createTable() throws SQLException {
    Connection conn = MySQLJDBCDAOFactory.getConnection();

    String query = "CREATE TABLE factura_producto(idFactura INT, idProducto INT, cantidad INT)";
  
    PreparedStatement ps = conn.prepareStatement(query);

    ps.execute();
    conn.commit();
  }
  
}
