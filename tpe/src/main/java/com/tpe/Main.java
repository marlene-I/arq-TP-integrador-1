package com.tpe;

import java.util.List;

import com.tpe.dto.Cliente;
import com.tpe.dto.ClienteConFacturacion;
import com.tpe.dto.Producto;
import com.tpe.dto.ProductoConTotal;
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

        // daoCliente.createTable();
        // loader.loadClientes(daoCliente);
        
        // daoProducto.createTable();
        // loader.loadProductos(daoProducto);

        // daoFactura.createTable();
        // loader.loadFacturas(daoFactura);  

        // daoFacturaProducto.createTable();
        // loader.loadFacturaProductos(daoFacturaProducto);

        Producto producto = daoProducto.getProductoMayorRecaudacion();
        ProductoConTotal productoMayorRecaudacion = (ProductoConTotal) producto;
        if (productoMayorRecaudacion != null) {
            System.out.println("Producto con mayor recaudación:");
            System.out.println("ID: " + productoMayorRecaudacion.getId());
            System.out.println("Nombre: " + productoMayorRecaudacion.getNombre());
            System.out.println("Valor Unitario: " + productoMayorRecaudacion.getValor());
            System.out.println("Total recaudado: " + productoMayorRecaudacion.getTotal());
        } else {
            System.out.println("No se encontró ningún producto con recaudación.");
        }
      
        List<Cliente> clientesPorFacturacion = daoCliente.getClientesPorFacturacion();

        System.out.println("id   |   nombre  | email  |  total_facturado ");
        for (Cliente cliente : clientesPorFacturacion) {
          ClienteConFacturacion clienteFacturacion = (ClienteConFacturacion) cliente;
          System.out.print(cliente.getId() + " | ");
          System.out.print(cliente.getNombre() + " | " );
          System.out.print(cliente.getEmail() + " | ");
          System.out.print(clienteFacturacion.getTotalFacturacion() + " \n");
        }
        
    } catch (Exception e) {
      e.printStackTrace();
      // TODO: handle exception
    }


  }  
}


