package entidades;

public class Ovni extends Volador{
	//Attributes
	private String planeta;

	//Getters and Setters
	public String getPlaneta() {
		return planeta;
	}

	public void setPlaneta(String planeta) {
		this.planeta = planeta;
	}
	
	//Constructor
	public Ovni(String pnom, String pplaneta) {
		super(pnom);
		this.planeta = pplaneta;
	}	
}
