package com.tpe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.tpe.dto.Cliente;
import com.tpe.factory.MySQLJDBCDAOFactory;
import com.tpe.interfaces.ClienteDAO;

public class MySQLClienteDAO implements ClienteDAO{

  @Override
  public Cliente getCliente(Integer id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getCliente'");
  }

  @Override
  public Cliente updateCliente(Integer id, String nombre, String email) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'updateCliente'");
  }

  @Override
  public void createTable() throws SQLException {
    Connection conn = MySQLJDBCDAOFactory.getConnection();

    String query = "CREATE TABLE IF NOT EXISTS cliente(idCliente INT, nombre VARCHAR(500), email VARCHAR(150)), PRIMARY KEY (idCliente)";
  
    PreparedStatement ps = conn.prepareStatement(query);

    ps.execute();
    conn.commit();
  }

  @Override
  public void insert(Cliente element) throws SQLException {
    String query = "INSERT INTO cliente (idCliente, nombre, email) VALUES (?, ?, ?)";
    
    Connection conn = MySQLJDBCDAOFactory.getConnection();

    PreparedStatement ps = conn.prepareStatement(query);

    ps.setInt(1, element.getId());
    ps.setString(2, element.getNombre());
    ps.setString(3, element.getEmail());
    ps.executeUpdate();

  }

  
}
