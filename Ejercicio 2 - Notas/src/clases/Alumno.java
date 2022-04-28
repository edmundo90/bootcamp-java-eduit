package clases;

/*La escuela primaria xyz solicita el desarrollo de una aplicación para poder llevar el
 control de notas para cada alumno.
 
 El programa solicitará el ingreso la cantidad de alumnos a procesar.
 Para cada alumno se deberá ingresar los siguientes datos:
 - nombre (string)
 - apellido (string)
 - número de examen
 - nota que obtuvo el alumno (numérico >=0 <=10)
 Al finalizar la carga de datos, se procederá a listar la siguiente información:
 1- alumno/s con la calificación mas alta
 2- alumno/s con la calificación mas baja
 3- alumnos que promocionan, aquellos que obtuvieron un promedio >= 7
 4- alumnos que deben recursar la materia, aquellos que obtuvieron un promedio < 7"
 
*/

public class Alumno {
	//Atributos
	private String nombre;
	private String apellido;
	private int nroExamen;
	private int nota;
	
	//Getters y Setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getNroExamen() {
		return nroExamen;
	}
	public void setNroExamen(int nroExamen) {
		this.nroExamen = nroExamen;
	}
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
	
	//Constructores
	public Alumno() {}
	
	public Alumno(String pnombre, String papellido, int pnroExamen, int pnota) {
		this.setNombre(pnombre);
		this.setApellido(papellido);
		this.setNroExamen(pnroExamen);
		this.setNota(pnota);
	}
}
