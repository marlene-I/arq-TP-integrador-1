package com.tpe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySQLProductoDAO implements ProductoDAO{

  @Override
  public Producto getProducto(Integer id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getProducto'");
  }
  
  public ArrayList<Producto> getProductosByIdFactura(Integer idFactura){
    return null;
  }

  @Override
  public void insert(Producto element) throws SQLException {
    String query = "INSERT INTO producto (idProducto, nombre, valor) VALUES (?, ?, ?)";
    
    Connection conn = MySQLJDBCDAOFactory.getConnection();

    PreparedStatement ps = conn.prepareStatement(query);

    ps.setInt(1, element.getId());
    ps.setString(2, element.getNombre());
    ps.setInt(3, element.getValor());
    ps.executeUpdate();
  }

  @Override
  public void createTable() throws SQLException {
    Connection conn = MySQLJDBCDAOFactory.getConnection();

    String query = "CREATE TABLE producto(idProducto INT, nombre INT)";
  
    PreparedStatement ps = conn.prepareStatement(query);

    ps.execute();
    conn.commit();
  }

}
