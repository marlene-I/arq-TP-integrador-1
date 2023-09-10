package com.tpe;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

  public static void main(String[] args) {

      // TODO: cargar los CSV
      // VER SI CREAMOS UNA CLASE O QUE

    
      // // 1. pedirle la instancia de dbFactory deseada al daoFactory 
      DAOFactory mysqlDaoFactory = DAOFactory.getDAOFactory(1);
    
      // // 2. pedirle a la dbFactory los DAOS de entidades requeridos
      FacturaDAO daoFactura = mysqlDaoFactory.getFacturaDAO();

      
      // // 3. ejecutar lo que pide el enunciado
      Factura factura = daoFactura.getFactura(123);
      // ProductoDAO daoProducto = mysqlDaoFactory.getProductoDAO();
      // ClienteDAO daoCliente = mysqlDaoFactory.getClienteDAO();
    
    // // Use DRIVER and DBURL to create a connection
    // try {
    //   Class.forName(driver).getDeclaredConstructor().newInstance();

    //   Connection connection = DriverManager.getConnection(uri, user, password);
    //   connection.setAutoCommit(false);
    //   // createTablePeople(connection);
    //   // addPerson(connection, 1, "Pedro", 10);
    //   // addPerson(connection, 2, "Carlos", 11);
    //   selectAll(connection);
    //   connection.close();
    //   } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
    //           NoSuchMethodException | ClassNotFoundException ex) {
    //     throw new RuntimeException(ex);
    // } catch (SQLException e) {
    //     e.printStackTrace();
    //     throw new RuntimeException(e);        
    // }
  }

  private static void selectAll(Connection conn)  throws SQLException{
    String query = "SELECT * FROM people";
    PreparedStatement ps = conn.prepareStatement(query);
    ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getInt("id") + ", " + rs.getString("name") + ", " + rs.getInt("age") );
          }
        conn.commit();
    ps.executeQuery();
    ps.close();
  }
  private static void addPerson(Connection connection, int id, String name, int age) throws SQLException {
        String query = "INSERT INTO people (id, name, age, adress_id) VALUES (?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setInt(3, age);
        ps.setInt(4, 1);
        ps.executeUpdate();
        ps.close();
        connection.commit();
    }

  
  private static void createTablePeople(Connection connection) throws SQLException {
    String query = "CREATE TABLE people(id INT, name VARCHAR(200), age INT, adress_id INT, PRIMARY KEY(id))";
    connection.prepareStatement(query).execute();
    connection.commit();
}

  
}


