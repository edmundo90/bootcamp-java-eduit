package ui;

import entidades.CollectionCustom;

public class pruebas {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
	// TODO Auto-generated method stub	
	/*
	* Crear un clase CollectionCustom<T> *
	La clase tiene un atributo T[] “un array de T” en el cual se deben guardar los tipos una vez 
	creada 	la implementación.
	
	- Debe tener los métodos: -size():int
							  -addFirst(T): void		  -		
							  -addLast(T):void
							  -add(T):void
							  -remove(T): T remueve el primer elemento indicado y lo retorna
							  -removeAll(T): void remueve todos los elementos.
							  -boolean empty(): indica si la colección está vacía
	
	Crear la clase Main para probar cada método.
	No usar collection vistas en clase, deben trabajar con array de T, uds deben implementar la 
	logica.
	*/
		
		CollectionCustom<Object> col = new CollectionCustom<>();
		col.add("Hola, este array tiene");
		col.addFirst("primero que nada ");
		col.addFirst(1);
		col.add(col.size());
		col.addFirst(1);
		col.addFirst(1);
		col.remove(1);
		System.out.println(aString(col.getTipos(), col));
		col.removeAll(1);
		System.out.println(aString(col.getTipos(), col));
		System.out.println(esVacia(col));
	}
	
	public static String aString(Object[] arreglo, CollectionCustom<Object> col) {
		String cadena = null;
		for(int i = 0; i < arreglo.length; i++) {
			cadena += col.getTipos()[i];
		}
		return cadena;
	}
	
	public static String esVacia(CollectionCustom<Object> col) {
		return col.empty() ? "La lista es vacía" : "La lista es vacía";
	}
}
