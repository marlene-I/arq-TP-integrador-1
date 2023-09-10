## DAOFactory
Clase Factory que devuelve la instancia de Factory db que se le solicite

## DAOS
Se tiene una interfaz DAO para cada entidad de db.
Cada interfaz DAO debe ser implementada por una clase que contenga el codigo para realizar las consultas a la db correspondiente ?? (no estoy segura pero creo que seria como en la clase MySQLFacturaDAO)

## DTOS
Se tienen clases DTOS con los atributos correspondientes a cada entidad.


## Revisar 
* El metodo del dao factory implementado (mysql) debe retornar la conexion ? 

## TODO
* Completar DAOS
  * Agregar a las interfaces los metodos que vamos a usar.
  * Implementar el codigo de los DAOS (las clases que se comunican con la DB ej: MySQLFacturaDAO). Falta crear el MySQLClienteDAO.
* Implementar el código para cargar los CSVS
* Mar: Investigar como crear un schema al levantar un compose de docker
* Gestionar que el MySQLDAOFactory le pase la conexion al DAO que retorna
* Escribir la lógica del servicio.