package com.tpe.factory;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.tpe.dao.MySQLClienteDAO;
import com.tpe.dao.MySQLFacturaDAO;
import com.tpe.dao.MySQLProductoDAO;
import com.tpe.interfaces.ClienteDAO;
import com.tpe.interfaces.FacturaDAO;
import com.tpe.interfaces.ProductoDAO;



public class MySQLJDBCDAOFactory extends DAOFactory{
  
  static String driver = "com.mysql.cj.jdbc.Driver";
  static String uri = "jdbc:mysql://localhost:3306/integrador1";
  static String user = "root";
  static String password = "password";
  static Connection connection;

  public static Connection getConnection() throws SQLException{
    if(connection != null){
      return connection;
    }

    try {
      Class.forName(driver).getDeclaredConstructor().newInstance();
      connection = DriverManager.getConnection(uri, user, password);
      connection.setAutoCommit(false);
      return connection;
    } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException ex) {
      throw new RuntimeException(ex);
    } catch (SQLException e) {
      e.printStackTrace();
      throw new RuntimeException(e);        
    }

  }
  @Override
  public FacturaDAO getFacturaDAO() {
    return new MySQLFacturaDAO();
  }

  @Override
  public ProductoDAO getProductoDAO() {
    return new MySQLProductoDAO();
  }

  @Override
  public ClienteDAO getClienteDAO() {
    return new MySQLClienteDAO();
  }


}
