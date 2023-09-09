package tpe.src;
import java.util.ArrayList;

public class MySQLProductoDAO implements ProductoDAO{

  @Override
  public Producto getProducto(Integer id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getProducto'");
  }
  
  public ArrayList<Producto> getProductosByIdFactura(Integer idFactura){
    return null;
  }

}
