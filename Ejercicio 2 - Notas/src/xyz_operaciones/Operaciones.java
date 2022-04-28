package xyz_operaciones;

import java.util.Scanner;
import clases.Alumno;

public class Operaciones {
	
/*La escuela primaria xyz solicita el desarrollo de una aplicaci�n para poder llevar el
 control de notas para cada alumno.
 
 El programa solicitar� el ingreso la cantidad de alumnos a procesar.
 Para cada alumno se deber� ingresar los siguientes datos:
 - nombre (string)
 - apellido (string)
 - n�mero de examen
 - nota que obtuvo el alumno (num�rico >=0 <=10)
 Al finalizar la carga de datos, se proceder� a listar la siguiente informaci�n:
 1- alumno/s con la calificaci�n mas alta
 2- alumno/s con la calificaci�n mas baja
 3- alumnos que promocionan, aquellos que obtuvieron un promedio >= 7
 4- alumnos que deben recursar la materia, aquellos que obtuvieron un promedio < 7"
 
*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		int cantAlumnos = pedirCant(teclado);
		Alumno[] alumnos = altaAlumno(cantAlumnos, teclado);
		listarDatos(alumnos);
		teclado.close();
	}


	public static int pedirCant(Scanner teclado)
	{
		int cantidad = 0;
		
		System.out.println("Ingrese la cantidad de alumnos a procesar");
		cantidad = teclado.nextInt();
		//teclado.close();
		return cantidad;
	}
	
	private static Alumno[] altaAlumno(int cantAlumnos, Scanner teclado) {
		// TODO Auto-generated method stub
		Alumno[] alumnos = new Alumno[cantAlumnos];
		if (cantAlumnos <1)
		{
			System.out.println("la cantidad de alumnos a procesar debe ser mayor a 0");
		}
		else {
			/*if(System.in.available() == 1) {
				System.out.println("si");
			} */
			
			System.out.println("ALTA DE ALUMNO");
			
			for(int i = 0; i<cantAlumnos; i++)
			{
				Alumno nuevo = new Alumno();
				System.out.println("Ingrese el nombre");
				nuevo.setNombre(teclado.next());
				System.out.println("Ingrese el apellido");
				nuevo.setApellido(teclado.next());
				System.out.println("Ingrese el n�mero de examen");
				nuevo.setNroExamen(teclado.nextInt());
				System.out.println("Ingrese la nota");
				nuevo.setNota(teclado.nextInt());
	
				alumnos[i] = nuevo;
			}
		}
		return alumnos;
	}
	
	private static void listarDatos(Alumno[] alumnos) {
		// TODO Auto-generated method stub
	 /*
	 * 1- alumno/s con la calificaci�n mas alta
	 * 2- alumno/s con la calificaci�n mas baja
	 * 3- alumnos que promocionan, aquellos que obtuvieron un promedio >= 7
	 * 4- alumnos que deben recursar la materia, aquellos que obtuvieron un promedio < 7"
	 * */
		
							// DEFINICI�N DE VARIABLES
		int masAlta = 0;
		int masBaja = alumnos[0].getNota();
		int[] posMasAlta = null;
		int[] posMasBaja = null;
		/*Creo un contador para asignar las posiciones correctamente en el vector
		 * "posMasAlta" en caso de que haya m�s de un alumno con la nota m�s alta*/
		int contMasAlta = 0;
		int contMasBaja = 0;
		Alumno[] promocionan = null;
		Alumno[] recursan = null;
		
		
							//CONTROL DE LAS NOTAS M�S ALTAS Y M�S BAJAS
		
		
		for(int i = 0; i<alumnos.length; i++) {
			/*Controlo por cada iteraci�n si la nota es m�s alta que la �ltima mayor
			 * y actualizo la nota m�s alta, borro el vector con las posiciones
			 * de los alumnos con la nota m�s alta, seteo el contador de notas altas
			 * en 1 y guardo la posici�n del alumno con la nueva nota m�s alta en el
			 * vector de posiciones m�s altas ("posMasAlta")
			 */
			
								//SI ES M�S ALTA QUE LA M�S ALTA ACTUAL
			
			if (alumnos[i].getNota() > masAlta) {
				masAlta = alumnos[i].getNota();
				contMasAlta = 1;
				if (posMasAlta == null)
				{
					posMasAlta = new int[1];
					posMasAlta[0] = i;
				}
			}else {
				/*Si la nota actual es igual a la �ltima mayor sumo al vector de posiciones
				 *  con nota m�s alta la posici�n del alumno en el vector de alumnos
				 *  y le sumo 1 al contador de notas m�s altas */
				//SI ES IGUAL A LA M�S ALTA
				if (alumnos[i].getNota() == masAlta) {
					posMasAlta[contMasAlta] = i;
					contMasAlta++;
				}
			}
			
			
			/*Controlo por cada iteraci�n si la nota es m�s baja que la �ltima menor
			 * y actualizo la nota m�s baja, borro el vector con las posiciones
			 * de los alumnos con la nota m�s baja, seteo el contador de notas bajas
			 * en 1 y guardo la posici�n del alumno con la nueva nota m�s baja en el
			 * vector de posiciones m�s bajas ("posMasBaja")
			 */
			
							//SI LA NOTA ES M�S BAJA QUE LA M�S BAJA ACTUAL
			
			if (alumnos[i].getNota() < masBaja) {
				masBaja = alumnos[i].getNota();
				posMasBaja = new int[alumnos.length];
				posMasBaja[0] = i;
				contMasBaja = 1;
			}
			/*Si la nota actual es igual a la �ltima menor sumo al vector de posiciones
			 *  con nota m�s baja la posici�n del alumno en el vector de alumnos
			 *  y le sumo 1 al contador de notas m�s bajas */
			
								//SI LA NOA ES IGUAL A LA M�S BAJA
			
			if (alumnos[i].getNota() == masBaja) {
				if (posMasBaja == null) {
					posMasBaja = new int[1];
					posMasBaja[contMasBaja] = i;
					contMasBaja++;
				} 
			}
			/*Pregunto si la nota actual es igual o mayor a 6 y en ese caso agrego al
			 * alumno al vector de alumnos que promocionan ("promocionan")*/
			
								//CONTROL DE LOS ALUMNOS QUE APRUEBAN
			
			if (alumnos[i].getNota() >= 7)
			{
				if (promocionan == null) {
					promocionan = new Alumno[1];
					promocionan[0] = alumnos[i];
				}
				else {
					promocionan[promocionan.length] = alumnos[i];
				}
			}
			/*De lo contrario agrego al alumno al vector de alumnos que recursan*/
			else {
				if (recursan == null) {
					recursan = new Alumno[1];
					recursan[0] = alumnos[i];
				}
				else {
					recursan[recursan.length] = alumnos[i];
				}
			}
		}
		
							//LISTADO DE LA INFORMACI�N
		
		//Muestro el/los alumnos con nota m�s alta
		System.out.println("El/Los alumnos con la nota m�s alta es/son: ");
		for(int p:posMasAlta) {
			System.out.println(alumnos[p].getNombre() + " " + alumnos[p].getApellido());
		}
		System.out.println("con nota " +  alumnos[posMasAlta[0]].getNota());
		//Muestro el/los alumnos con nota m�s alta
		System.out.println("El/Los alumnos con la nota m�s baja es/son: ");
		for(int p:posMasBaja) {
			System.out.println(alumnos[p].getNombre() + " " + alumnos[p].getApellido());
		}
		System.out.println("con nota " +  alumnos[posMasBaja[0]].getNota());
		//Muestro los alumnos que promocionan
		System.out.println("Los siguientes alumnos han promocionado en el curso:");
		for(Alumno p:promocionan) {
			System.out.println(p.getNombre() + " " + p.getApellido());
		}
		//Muestro los alumnos que recursan
		for(Alumno r:recursan) {
			System.out.println(r.getNombre() + " " + r.getApellido());
		}
	}
}
