package com.tpe;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.Client;

public class Main {

  public static void main(String[] args) {

    DAOFactory mysqlDaoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL_JDBC);
  
    // // // 2. pedirle a la dbFactory los DAOS de entidades requeridos
    FacturaDAO daoFactura = mysqlDaoFactory.getFacturaDAO();
    try {
      daoFactura.createTable();
      CSVLoader loader = new CSVLoader();
      loader.loadFacturas(daoFactura);
          
      
    } catch (Exception e) {
      // TODO: handle exception
    }


      // try {
      //   String pathCSVProductos = "C:\\Users\\Maarl\\Downloads\\Materias\\TUDAI\\ARQUI\\TP1\\TPE\\tpe\\src\\main\\resources\\productos.csv";
      //   ClientCreator cCreator = new ClientCreator();
      //   loader.read1(pathCSVProductos);

        
      // } catch (IOException e) {
      //   System.out.println(e);
      // } 
      // ClienteDAO clienteDAO = mysqlDaoFactory.getClienteDAO();
    

      
      // // 3. ejecutar lo que pide el enunciado
      // Factura factura = daoFactura.getFactura(123);
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

  // private static void initializeDB() throws SQLException{
  //   MySQLConnector connector = new MySQLConnector();
  //   Connection conn = connector.getConnection();

  //   ArrayList<String> queries = new ArrayList<String>();
  //   queries.add("CREATE TABLE cliente(idCliente INT, nombre VARCHAR(200), email VARCHAR(200))");
  //   queries.add("CREATE TABLE factura(idFactura INT, idCliente INT)");
  //   queries.add("CREATE TABLE producto(idProducto INT, nombre VARCHAR(200), valor INT)");
  //   queries.add("CREATE TABLE factura_producto(idFactura INT, idProducto INT, cantidad INT)");

  //   for (String query : queries) {
  //     PreparedStatement ps = conn.prepareStatement(query);
  //     ps.execute();
  //   }

  //   conn.commit();
  //   conn.close();
  // }

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
        String query = "INSERT INTO people (id, name, age, adress_id) VALUES (?,?,?,?), ()";
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


