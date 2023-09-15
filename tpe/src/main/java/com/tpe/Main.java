package com.tpe;

import com.tpe.factory.DAOFactory;
import com.tpe.interfaces.ClienteDAO;
import com.tpe.interfaces.FacturaDAO;
import com.tpe.interfaces.FacturaProductoDAO;
import com.tpe.interfaces.ProductoDAO;

public class Main {

  public static void main(String[] args) {

    DAOFactory mysqlDaoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL_JDBC);
  
    // // // 2. pedirle a la dbFactory los DAOS de entidades requeridos
      FacturaDAO daoFactura = mysqlDaoFactory.getFacturaDAO();
      ClienteDAO daoCliente = mysqlDaoFactory.getClienteDAO();
      ProductoDAO daoProducto = mysqlDaoFactory.getProductoDAO();
      FacturaProductoDAO daoFacturaProducto = mysqlDaoFactory.getFacturaProductoDAO();

      try {
        CSVLoader loader = new CSVLoader();

        daoCliente.createTable();
        loader.loadClientes(daoCliente);
        
        daoProducto.createTable();
        loader.loadProductos(daoProducto);

        daoFactura.createTable();
        loader.loadFacturas(daoFactura);  

        daoFacturaProducto.createTable();
        loader.loadFacturaProductos(daoFacturaProducto);
      
    } catch (Exception e) {
      e.printStackTrace();
      // TODO: handle exception
    }


  }  
}


