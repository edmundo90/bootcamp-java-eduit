package entidades;

import interfaces.*;

public class Avion extends Volador implements IAterrizable{
	//Attributes
	private int cantAsientos;
	private boolean aterrizado = false;
	

	//Getters and Setters
	public int getCantAsientos() {
		return cantAsientos;
	}

	public void setCantAsientos(int cantAsientos) {
		this.cantAsientos = cantAsientos;
	}

	public boolean getAterrizado() {
		return aterrizado;
	}
	
	public void setAterrizado(boolean aterrizado) {
		this.aterrizado = aterrizado;
	}
	
	//Constructor
	public Avion(String pnom, int pcantAsientos, boolean paterrizado) {
		super(pnom);
		this.setCantAsientos(pcantAsientos);
		this.setAterrizado(paterrizado);
	}
	
	//Methods
	public boolean aterrizar(){
		if (!this.getAterrizado()) {
			this.setAterrizado(true);	
		}
		return this.aterrizado;
	}
}
