import java.util.Scanner;

public class Interfaz{

	/* LETRA:
	 	
	Crear un paquete con el nombre practica-semanal-semana2:
 	Validación de fechas:
 	Ingresar una fecha por teclado  dd/mm/yyyy (dd int, mm int, yyyy int)
 	validar que dd >=1 && <=31 TENIENDO EN CUENTA EL MES
 	validar que mes >=1 && <=12
 	validar que año >=1900 && <= 2099
 	Ojo, si el año es bisiesto febrero tiene 29  días.
 	Informar por consola  si la fecha es correcta.
	
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String fecha = pedirDatos();
		if (controlarFecha(fecha))
		{
			System.out.println("Fecha con formato correcto");
		}
			
		
	}
	
	public static String pedirDatos()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Ingrese una fecha en formato 'dd/mm/aaaa'");
		String fecha = scan.next();		
		scan.close();
		return fecha;
	}
	
	public static boolean controlarFecha(String fecha)
	{
		
		boolean cumple = false;
		//Creo las variables para dividir y guardar el día, el mes y el año mediante una función por cada dato.
		int dia = obtenerDia(fecha);
		int mes = obtenerMes(fecha);
		int anio = obtenerAnio(fecha);
		
		//Controlo que el día, mes y anio sean correctos.
		if (fecha.length() == 10)
		{
				
			if (dia > 0 && dia < 32 && mes > 0 && mes < 13)
			{
				if (dia > 28 && mes == 02 && anio % 4 != 0)
				{
					System.out.println("En años no biciestos febero tiene 28 días");
				}
				else {
					cumple = true;
				}
			}
			else
			{
				System.out.println("El día no puede ser menor a 1 ni mayor que 31");
			}
		}
		return cumple;
	}
	
	public static int obtenerDia(String fecha)
	{
		/*int dia = (int)fecha.indexOf("/"); fecha.substring(1, dia);
		return dia;*/
		String[] split = fecha.split("/");
		
		int dia = Integer.parseInt(split[0]);
		return dia;
	}
	
	public static int obtenerMes(String fecha)
	{
		/*int dia = (int)fecha.indexOf("/"); fecha.substring(1, dia);
		return dia;*/
		String[] split = fecha.split("/");
		int mes = Integer.parseInt(split[1]);
		return mes;
	}
	
	public static int obtenerAnio(String fecha)
	{
		/*int dia = (int)fecha.indexOf("/"); fecha.substring(1, dia);
		return dia;*/
		String[] split = fecha.split("/");
		int anio = Integer.parseInt(split[2]);
		return anio;
	}
}
