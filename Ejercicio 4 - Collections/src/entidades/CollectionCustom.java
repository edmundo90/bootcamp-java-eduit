package entidades;
/*
 * Crear un clase CollectionCustom<T>
 * La clase tiene un atributo T[] “un array de T” en el cual se deben guardar los tipos una vez 
 * creada la implementación.
 * 
 * - debe tener los métodos:
 * size():int LISTO
 * addFirst(T): void LISTO
 * addLast(T):void DUDAS
 * add(T):void
 * remove(T): T remueve el primer elemento indicado y lo retorna
 * removeAll(T): void remueve todos los elementos.
 * boolean empty(): indica si la colección está vacía

 *	Crear la clase Main para probar cada método.
 *	No usar collection vistas en clase, deben trabajar con array de T, uds deben implementar la 
	logica.
	*/

public class CollectionCustom<T> {
	//                      Atributos
	private Object[] tipos = new Object[1];
	//                     Propiedades
	
	//                       Métodos
	//size()
	public int size() {
		return tipos.length;
	}
	//addFirst()
	public void addFirst(Object T) {
		Object[] aux = tipos;
		int flag = 1;
		tipos[0] = T;
		for(int i = 0; i<tipos.length; i++) {
			tipos[flag] = aux[i];
			flag++;
		}
	}
	//addLast()
	/*public void addLast(Object T) {
		Object[] aux = tipos;
		int flag = 1;
		tipos[0] = T;
		for(int i = 0; i<tipos.length; i++) {
			tipos[flag] = aux[i];
			flag++;
		}
	}*/
	//add()
	public void add(Object T) {
		this.tipos[tipos.length] = T;
	}
	//remove()
	public Object remove(Object T)
	{
		Object removed = null;
		int locator = 0;
		boolean encontrado = false;
		for(int i = 0; i<this.tipos.length; i++){
			if (encontrado) {
				this.tipos[locator] = this.tipos[i];
				locator++;
			}
			if(tipos[i].equals(T) && removed != null) {
				locator = i;
				removed = tipos[i];
				encontrado = true;
			}
		}
		return removed;
	}
	//removeAll()
	public void removeAll(Object T)
	{
		int locator = 0;
		boolean encontrado = false;
		for(int i = 0; i<this.tipos.length; i++){
			if (encontrado) {
				this.tipos[locator] = this.tipos[i];
				locator++;
			}
			if(tipos[i].equals(T)) {
				locator = i;
				encontrado = true;
			}
		}
	}
	//empty()
	public boolean empty() {
		return this.tipos.length > 0 ? true : false;
	}
	
	public Object[] getTipos() {
		return this.tipos;
	}
}
