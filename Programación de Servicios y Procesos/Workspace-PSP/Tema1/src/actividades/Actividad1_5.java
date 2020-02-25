package actividades;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
/*
 * Guarda en un fichero de nombre SVCHOST.TXT los servicios que se están ejecutando bajo el proceso 
 * svchost.exe
 */
public class Actividad1_5 {

	public static void main(String[] args) throws IOException {

		Runtime r = Runtime.getRuntime();
		// Comando a ejecutar en la linea de comandos
		String comando = "CMD /C svchost -k DcomLaunch";
		Process p = null;
		
		try {
			p = r.exec(comando);
			// lectura de la salida
			InputStream is = p.getInputStream();
			BufferedReader br =  new BufferedReader (new InputStreamReader (is));
			
			
			String linea;
			// Mientras haya lineas que leer, se escriben 
			while ((linea  = br.readLine()) != null) {
				FileOutputStream fos = new FileOutputStream(linea);
				PrintWriter pw = new PrintWriter(fos);
				System.out.println(linea);
				pw.println(linea);
			}
			br.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		// Comprobacion de error - 0 bien 1 - mal
		int exitVal;
		try {
			exitVal =  p.waitFor();
			System.out.println("Valor de Salida: " + exitVal);
		}
		catch ( InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
