package com.tpe;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// IMPORTANT!!!  Must be a singleton

public class MySQLJDBCDAOFactory extends DAOFactory{

  static String driver = "com.mysql.cj.jdbc.Driver";
  static String uri = "jdbc:mysql://localhost:3306/tpe1";
  static String user = "root";
  static String password = "password";
   
  public static Connection createConnection() {
  // Use DRIVER and DBURL to create a connection
    try {
      Class.forName(driver).getDeclaredConstructor().newInstance();
  
      Connection connection = DriverManager.getConnection(uri, user, password);
      // createTablePeople(connection);
      // addPerson(connection, 1, "JUAN VENA", 20);
      // addPerson(connection, 2, "CLAUDIO CARMUSCIANO", 20);
      // showAllPeople(connection);
      // connection.close();
      return connection;
      } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
             NoSuchMethodException | ClassNotFoundException ex) {
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
    return null;
    
    // return new MySQLProductoDAO();
  }

  @Override
  public ClienteDAO getClienteDAO() {
    return null;
    // return new MySQLClienteDAO();
  }
}
