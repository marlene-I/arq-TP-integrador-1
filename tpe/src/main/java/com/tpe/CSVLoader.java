package com.tpe;

import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.tpe.dto.Cliente;
import com.tpe.dto.Factura;
import com.tpe.dto.FacturaProducto;
import com.tpe.dto.Producto;
import com.tpe.interfaces.DAO;

public class CSVLoader{
  
  public CSVParser getParser(String filePath) throws IOException{
    return CSVFormat.DEFAULT.withHeader().parse(new FileReader(filePath));
  }

  

  public void loadClientes(DAO<Cliente> daoCliente){
   try {
    
    CSVParser parser = this.getParser("tpe\\src\\main\\resources\\clientes.csv");
    for(CSVRecord row: parser) {     
      daoCliente.insert(new Cliente(Integer.parseInt(row.get("idCliente")), row.get("nombre"), row.get("email")));
    }
   } catch (Exception e) {
      e.printStackTrace();
   }
  }


  public void loadProductos(DAO<Producto> daoProducto){
   try {
    
    CSVParser parser = this.getParser("tpe\\src\\main\\resources\\productos.csv");
    for(CSVRecord row: parser) {     
      daoProducto.insert(new Producto(Integer.parseInt(row.get("idProducto")), row.get("nombre"), Float.parseFloat(row.get("valor"))));
    }
   } catch (Exception e) {
      e.printStackTrace();
   }
  }


  
  public void loadFacturas(DAO<Factura> daoFactura){
   try {
    
    CSVParser parser = this.getParser("tpe\\src\\main\\resources\\facturas.csv");
    for(CSVRecord row: parser) {     
      daoFactura.insert(new Factura(Integer.parseInt(row.get("idFactura")), Integer.parseInt(row.get("idCliente"))));
    }
   } catch (Exception e) {
      e.printStackTrace();
   }
  }

    
  public void loadFacturaProductos(DAO<FacturaProducto> daoFacturaProducto){
   try {
    
    CSVParser parser = this.getParser("tpe\\src\\main\\resources\\facturas-productos.csv");
    for(CSVRecord row: parser) {     
      daoFacturaProducto.insert(new FacturaProducto(Integer.parseInt(row.get("idFactura")), Integer.parseInt(row.get("idProducto")), Integer.parseInt(row.get("cantidad"))));
    }
   } catch (Exception e) {
      e.printStackTrace();
   }
  }
}
