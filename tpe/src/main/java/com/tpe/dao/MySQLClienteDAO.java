package com.tpe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tpe.dto.Cliente;
import com.tpe.dto.ClienteConFacturacion;
import com.tpe.factory.MySQLJDBCDAOFactory;
import com.tpe.interfaces.ClienteDAO;

public class MySQLClienteDAO implements ClienteDAO {

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

    String query = "CREATE TABLE IF NOT EXISTS cliente(idCliente INT, nombre VARCHAR(500), email VARCHAR(150), PRIMARY KEY (idCliente))";

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

  @Override
  public List<Cliente> getClientesPorFacturacion() throws SQLException {
    ArrayList<Cliente> clientesPorFacturacion = new ArrayList<Cliente>();
      String query = "SELECT f.idCliente, c.nombre, c.email, SUM(facturaP.cantidad * prod.valor) AS total_facturado FROM factura_producto facturaP INNER JOIN producto prod ON prod.idProducto = facturaP.idProducto INNER JOIN factura f ON f.idFactura = facturaP.idFactura INNER JOIN cliente c ON c.idCliente = f.idCliente GROUP BY f.idCliente, c.nombre, c.email ORDER BY total_facturado DESC";
      Connection conn = MySQLJDBCDAOFactory.getConnection();

      PreparedStatement ps = conn.prepareStatement(query);

      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        Cliente cliente = new ClienteConFacturacion(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4));
        clientesPorFacturacion.add(cliente);
      }
    
    return clientesPorFacturacion;
  }

}
