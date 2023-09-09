package tpe.src;
public class Main {

  // 1. pedirle la instancia de dbFactory deseada al daoFactory 
  DAOFactory mysqlDaoFactory = DAOFactory.getDAOFactory(1);

  // 2. pedirle a la dbFactory los DAOS de entidades requeridos
  FacturaDAO daoFactura = mysqlDaoFactory.getFacturaDAO();

  // 3. ejecutar lo que pide el enunciado
  
  ProductoDAO daoProducto = mysqlDaoFactory.getProductoDAO();
  ClienteDAO daoCliente = mysqlDaoFactory.getClienteDAO();
}


