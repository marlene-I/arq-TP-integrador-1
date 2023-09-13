package com.tpe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySQLFacturaDAO implements FacturaDAO{


  @Override
  public Factura getFactura(Integer id) {
    // query que obtiene la factura, el cliente al que corresponde y los 
    // productos que incluye
    // String query = "SELECT FROM factura f 
    // INNER JOIN factura_producto fp ON f.idFactura = fp.idFactura // inner join de factura_producto - producto
    // INNER JOIN cliente c ON f.idCliente = c.idCliente 
    // WHERE idFactura == " + id;
 /////////////////////////////////////////////////////////////////
    // Factura factura= new Factura(...); // pasarle los datos de clientes y productos y que lo arme 
    // Cliente cliente = new Cliente (...);
    // // iterar sobre los productos

    // ArrayList<Producto> prods = new ArrayList();
    // for (int i = 0; i < prods.length; i++) {
    //   Producto prod = new Producto(...);
    //   prods.push(prod);
    // }
    return null;
  }
  // 1. trae todo con solo select y arma los DTOS de Producto y Cliente 
  // en base a la respuesta que obtiene/ 
  // 2. en base a el id de factura, consulta al MySQLClienteDAO y obtiene el cliente
  // correspondiente a la factura. Lo mismo hace para obtener los productos
  // asociados a la factura.

  @Override
  public void insert(Factura element) throws SQLException {
    String query = "INSERT INTO factura (idFactura, idCliente) VALUES (?, ?)";
    
    Connection conn = MySQLJDBCDAOFactory.getConnection();

    PreparedStatement ps = conn.prepareStatement(query);

    ps.setInt(1, element.getId());
    ps.setInt(2, element.getIdCliente());
    ps.executeUpdate();

  }

  @Override
  public void createTable() throws SQLException {
    Connection conn = MySQLJDBCDAOFactory.getConnection();

    String query = "CREATE TABLE factura(idFactura INT, idCliente INT)";
  
    PreparedStatement ps = conn.prepareStatement(query);

    ps.execute();
    conn.commit();
  }
}


