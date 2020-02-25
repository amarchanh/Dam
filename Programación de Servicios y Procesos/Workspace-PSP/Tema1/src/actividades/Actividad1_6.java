package actividades;

/*
 * Escribe un programa Java que lea 2 numeros desde la entrada estandar y visualice su suma
 * Controla que se escriben los argumentos necesarios y que sean numericos. Haz otro programa
 * Java para ejecutar el anterior.
 */
public class Actividad1_6 {

	public static void main (String[] args) {
		Runtime r =  Runtime.getRuntime();
		
		if (args.length > 2) {
			
			try {
				Integer num1 = Integer.parseInt(args[0]);
				Integer num2 = Integer.parseInt(args[1]);
				
				System.out.println("La suma de los números es: " + (num1 + num2));
			}
			catch (NumberFormatException nbe) {
				System.out.println("Formato de números no válido.");
				nbe.printStackTrace();
			}
		}
		else {
			System.out.println("Por favor, introduce dos numeros para visualizar su suma.");
		}
		
	}
}
