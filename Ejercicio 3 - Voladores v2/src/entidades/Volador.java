package entidades;

public abstract class Volador {
	//Atributos
	private String nombre;
	
	
	//Getters & Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	//Constructor
	public Volador(String pnom) {
		this.nombre = pnom;
	}
}
