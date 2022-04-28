package entidades;

import interfaces.IAterrizable;

public class Helicoptero extends Volador implements IAterrizable{
	//Atributos
	private int elices;
	private boolean aterrizado;
	
	//Getters and Setters
	public int getElices() {
		return elices;
	}
	
	public void setElices(int elices) {
		this.elices = elices;
	}
	
	public boolean isAterrizado() {
		return aterrizado;
	}
	
	public void setAterrizado(boolean aterrizado) {
		this.aterrizado = aterrizado;
	}
	
	//Constructor
	public Helicoptero(String pnom, int pcantElices, boolean paterrizado) {
		super(pnom);
		this.elices = pcantElices;
		this.aterrizado = paterrizado;
	}
	
	public boolean aterrizar(){
		if (!this.isAterrizado()) {
			this.setAterrizado(true);
		}
		return this.aterrizado;
	}
}
