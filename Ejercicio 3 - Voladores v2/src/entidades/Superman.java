package entidades;

public class Superman extends Volador{
	//Attributes
	private String fnac;
	
	//Getters and Setters
	public String getFnac() {
		return fnac;
	}


	public void setFnac(String fnac) {
		this.fnac = fnac;
	}


	//Constructor
	public Superman(String pnom, String pfnac) {
		super(pnom);
		this.fnac = pfnac;
	}
}
