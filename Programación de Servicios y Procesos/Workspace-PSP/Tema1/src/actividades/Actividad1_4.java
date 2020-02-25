package actividades;

import java.io.IOException;
import java.io.InputStream;


/*
 * Realiza un programa Java que ejecute el ejemplo (Ejemplo2) anterior usando
 * Runtime y Process. Crea otro programa Java que reciba desde la linea de comandos un nombre
 * y lo visualice. Utiliza el programa anterior para ejecutarlo
 * 
 */
public class Actividad1_4 {

	public static void main(String[] args) throws IOException {

		//Process p = new ProcessBuilder("CMD", "/C", "DIR").start();
		Process p = Runtime.getRuntime().exec("cmd /c dir");
		try {

			InputStream is = p.getInputStream();

			// mostramos en pantalla caracter a caracter
			 int c;
			 while ((c = is.read()) != -1)
				System.out.print((char) c);
			 is.close();

		
		} catch (Exception e) {
			e.printStackTrace();
		}

		// COMPROBACION DE ERROR - 0 bien - 1 mal
		int exitVal;
		try {
			exitVal = p.waitFor();
			System.out.println("Valor de Salida: " + exitVal);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
