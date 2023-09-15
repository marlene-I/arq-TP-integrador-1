package com.tpe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.tpe.dto.Factura;
import com.tpe.factory.MySQLJDBCDAOFactory;
import com.tpe.interfaces.FacturaDAO;

public class MySQLFacturaDAO implements FacturaDAO{

  @Override
  public void insert(Factura element) throws SQLException {
    String query = "INSERT INTO factura (idFactura, idCliente) VALUES (?, ?)";
    
    Connection conn = MySQLJDBCDAOFactory.getConnection();

    PreparedStatement ps = conn.prepareStatement(query);
    
    ps.setInt(1, element.getId());
    ps.setInt(2, element.getIdCliente());
    ps.executeUpdate();
    conn.commit();
  }

  @Override
  public void createTable() throws SQLException {
    Connection conn = MySQLJDBCDAOFactory.getConnection();

    String query = "CREATE TABLE IF NOT EXISTS factura (idFactura INT, idCliente INT, PRIMARY KEY (idFactura), FOREIGN KEY (idCliente) REFERENCES cliente (idCliente))";
  
    PreparedStatement ps = conn.prepareStatement(query);

    ps.execute();
    conn.commit();
  }
}