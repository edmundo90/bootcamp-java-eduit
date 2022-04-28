package operaciones;

import entidades.*;

public class main {
	/*
	 * Crear un branch con el nombre practica-adicional-semana4.

	La idea es desarrollar un peque�o programa para incorporar los conceptos de clases, atributos, m�todos, clases abstractas,
	interfaces, composici�n, agregaci�n. 

	-Existe una torre de control donde operadores pueden determinar ciertos voladores que pueden aterrizar en la pista de 
	aterrizaje. 
	Los voladores son, avi�n, helic�ptero, Superman, ovni. 
	Los atributos que comparten son: nombre, (agregar otros de ser necesario) 
	Cada volador tiene atributos particulares (decidir los que crean convenientes). 
	Ej: avi�n puede tener cantidad de asientos, el helic�ptero puede tener color, marca, modelo etc. 
	En la pista solo podr�n aterrizar aquellos voladores que cumplan con la interfaz Aterrizable. 
	Escribir las clases e interfaces, adem�s de las relaciones de herencias necesarias para poder resolverlo.*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Volador[] voladores = new Volador[4];
		Superman sm = new Superman("Superman cl�sico", "12/04/1974");
		Helicoptero hc = new Helicoptero("De Guerra", 2, true);
		Avion av = new Avion("F64", 26, true);
		Ovni ov = new Ovni("Ovalo", "Saturno");
		voladores[0] = sm;
		voladores[1] = hc;
		voladores[2] = av;
		voladores[3] = ov;
		
		for(Volador v: voladores) {
			if (v instanceof Avion) {
				((Avion)v).aterrizar();
			}else {
				if( v instanceof Helicoptero) {
					if (((Helicoptero) v).aterrizar()) {
						System.out.println("El helic�ptero ha aterrizado");
					}else {
						System.out.println("El helic�ptero ya se encuentra aterrizado!");			
					}
					}
					else {
						System.out.println("El objeto no puede aterrizar en la pista");
					}
			}
		}
	}

}
