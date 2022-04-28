package xyz_operaciones;

import java.util.Scanner;
import clases.Alumno;

public class Operaciones {
	
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
				System.out.println("Ingrese el número de examen");
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
	 * 1- alumno/s con la calificación mas alta
	 * 2- alumno/s con la calificación mas baja
	 * 3- alumnos que promocionan, aquellos que obtuvieron un promedio >= 7
	 * 4- alumnos que deben recursar la materia, aquellos que obtuvieron un promedio < 7"
	 * */
		
							// DEFINICIÓN DE VARIABLES
		int masAlta = 0;
		int masBaja = alumnos[0].getNota();
		int[] posMasAlta = null;
		int[] posMasBaja = null;
		/*Creo un contador para asignar las posiciones correctamente en el vector
		 * "posMasAlta" en caso de que haya más de un alumno con la nota más alta*/
		int contMasAlta = 0;
		int contMasBaja = 0;
		Alumno[] promocionan = null;
		Alumno[] recursan = null;
		
		
							//CONTROL DE LAS NOTAS MÁS ALTAS Y MÁS BAJAS
		
		
		for(int i = 0; i<alumnos.length; i++) {
			/*Controlo por cada iteración si la nota es más alta que la última mayor
			 * y actualizo la nota más alta, borro el vector con las posiciones
			 * de los alumnos con la nota más alta, seteo el contador de notas altas
			 * en 1 y guardo la posición del alumno con la nueva nota más alta en el
			 * vector de posiciones más altas ("posMasAlta")
			 */
			
								//SI ES MÁS ALTA QUE LA MÁS ALTA ACTUAL
			
			if (alumnos[i].getNota() > masAlta) {
				masAlta = alumnos[i].getNota();
				contMasAlta = 1;
				if (posMasAlta == null)
				{
					posMasAlta = new int[1];
					posMasAlta[0] = i;
				}
			}else {
				/*Si la nota actual es igual a la última mayor sumo al vector de posiciones
				 *  con nota más alta la posición del alumno en el vector de alumnos
				 *  y le sumo 1 al contador de notas más altas */
				//SI ES IGUAL A LA MÁS ALTA
				if (alumnos[i].getNota() == masAlta) {
					posMasAlta[contMasAlta] = i;
					contMasAlta++;
				}
			}
			
			
			/*Controlo por cada iteración si la nota es más baja que la última menor
			 * y actualizo la nota más baja, borro el vector con las posiciones
			 * de los alumnos con la nota más baja, seteo el contador de notas bajas
			 * en 1 y guardo la posición del alumno con la nueva nota más baja en el
			 * vector de posiciones más bajas ("posMasBaja")
			 */
			
							//SI LA NOTA ES MÁS BAJA QUE LA MÁS BAJA ACTUAL
			
			if (alumnos[i].getNota() < masBaja) {
				masBaja = alumnos[i].getNota();
				posMasBaja = new int[alumnos.length];
				posMasBaja[0] = i;
				contMasBaja = 1;
			}
			/*Si la nota actual es igual a la última menor sumo al vector de posiciones
			 *  con nota más baja la posición del alumno en el vector de alumnos
			 *  y le sumo 1 al contador de notas más bajas */
			
								//SI LA NOA ES IGUAL A LA MÁS BAJA
			
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
		
							//LISTADO DE LA INFORMACIÓN
		
		//Muestro el/los alumnos con nota más alta
		System.out.println("El/Los alumnos con la nota más alta es/son: ");
		for(int p:posMasAlta) {
			System.out.println(alumnos[p].getNombre() + " " + alumnos[p].getApellido());
		}
		System.out.println("con nota " +  alumnos[posMasAlta[0]].getNota());
		//Muestro el/los alumnos con nota más alta
		System.out.println("El/Los alumnos con la nota más baja es/son: ");
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
