package com.tpe.factory;

import java.sql.Connection;

import com.tpe.interfaces.ClienteDAO;
import com.tpe.interfaces.FacturaDAO;
import com.tpe.interfaces.ProductoDAO;

public abstract class DAOFactory {
  public static final int MYSQL_JDBC = 1;

  public abstract FacturaDAO getFacturaDAO();
  public abstract ProductoDAO getProductoDAO();
  public abstract ClienteDAO getClienteDAO();

  public static DAOFactory getDAOFactory(int whichFactory) {
    switch (whichFactory) {
      case MYSQL_JDBC : return new MySQLJDBCDAOFactory();
        default: return null;
    }
  } 
}