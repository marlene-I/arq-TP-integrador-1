package com.tpe.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tpe.dto.Producto;
import com.tpe.factory.MySQLJDBCDAOFactory;
import com.tpe.interfaces.ProductoDAO;

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

    String query = "CREATE TABLE IF NOT EXISTS producto(idProducto INT, nombre VARCHAR(45), valor FLOAT, PRIMARY KEY (idProducto))";
  
    PreparedStatement ps = conn.prepareStatement(query);

    ps.execute();
    conn.commit();
  }
  public Producto getProductoMayorRecaudacion() throws SQLException{
    Connection conn = MySQLJDBCDAOFactory.getConnection();

    String query = "SELECT p.idProducto, p.nombre AS nombre_producto, p.valor AS valor_unitario, SUM(fp.cantidad * p.valor) AS recaudacion_total " +
            "FROM producto p " +
            "JOIN factura_producto fp ON p.idProducto = fp.idProducto " +
            "GROUP BY p.idProducto, p.nombre, p.valor " +
            "ORDER BY recaudacion_total DESC " +
            "LIMIT 1";

    PreparedStatement ps = conn.prepareStatement(query);

    ps.execute();
    return null;

  }

}
