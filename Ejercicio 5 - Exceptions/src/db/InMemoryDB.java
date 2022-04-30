package db;

import java.util.HashMap;

import entidades.*;
import exceptions.*;

import java.util.Map;
import java.util.zip.DataFormatException;

/*
 * Crear un branch con el nombre practica-adicional-semana6 - DONE
- Tomar como base la clase19, donde creamos una clase InMemoryDB - DONE
- crear una exception por cada operación que realiza la base de datos. DONE
- modificar la interface IAction para poder lanzar dichas exceptions. 
- modificar la clase MainMap para controlar e informar los errores.
*/

public class InMemoryDB {

	static private Map<Long,Articulo> db = new HashMap<>();
	static String msj = "";
	static Throwable thw = null;
	
	public static void save(Long key,Articulo valor) throws SaveException{
		if (key != null && valor != null)
		{
			throw new SaveException("La llave o el valor no pueden ser nulos");
		}
		else {			
			InMemoryDB.db.put(key, valor);
		}
	}
	
	public static void update(Long key, Articulo newValue) throws UpdateException{
		if(InMemoryDB.db.containsKey(key)) {
			InMemoryDB.db.replace(key,newValue);
		} else {
			throw new UpdateException("No existe la llave, no se pudo modificar el artículo");
		}
	}
	
	public static void delete(Long key) throws DeleteException{
		if(InMemoryDB.db.containsKey(key)) {
			InMemoryDB.db.remove(key);
		}
		else {
			throw new DeleteException("No existe un artículo con tal llave, no es posible borrar");
		}
	}
	
	public static Articulo getById(Long key) throws GetArtByIdException{
		Articulo value = null;
		if(InMemoryDB.db.containsKey(key)) {
			value = InMemoryDB.db.get(key);
		}
		else{
			throw new GetArtByIdException("No existe un Artículo con esa llave");
		}
		return value;
	}

	public static void listAll() throws ListAllException{
		if (db.size() < 1)
		{
			throw new ListAllException("No hay elementos para listar");
		}
		else {			
			System.out.println(InMemoryDB.db.values());		
		}
	}
}
