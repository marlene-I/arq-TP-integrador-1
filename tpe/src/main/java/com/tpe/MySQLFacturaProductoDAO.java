package com.tpe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySQLFacturaProductoDAO implements FacturaProductoDAO{

  @Override
  public void insert(FacturaProducto element) throws SQLException {
    String query = "INSERT INTO factura_producto (idFactura, idProducto, cantidad) VALUES (?, ?)";
    
    Connection conn = MySQLJDBCDAOFactory.getConnection();

    PreparedStatement ps = conn.prepareStatement(query);

    ps.setInt(1, element.getIdFactura());
    ps.setInt(2, element.getIdProducto());
    ps.setInt(3, element.getCantidad());
    ps.executeUpdate();
   
  }

  @Override
  public void createTable() throws SQLException {
    Connection conn = MySQLJDBCDAOFactory.getConnection();

    String query = "CREATE TABLE IF NOT EXISTS factura_producto(idFactura INT, idProducto INT, cantidad INT), FOREIGN KEY (idProducto) REFERENCES producto (idProducto), FOREIGN KEY (idFactura) REFERENCES factura (idFactura)";
  
    PreparedStatement ps = conn.prepareStatement(query);

    ps.execute();
    conn.commit();
  }
  
}
