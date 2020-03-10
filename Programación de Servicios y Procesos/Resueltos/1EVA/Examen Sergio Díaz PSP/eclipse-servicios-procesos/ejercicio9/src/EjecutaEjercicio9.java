import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Scanner;


public class EjecutaEjercicio9 {

	public static void main(String[] args) throws IOException{
		File fEntrada = new File("entrada.txt");
		File fOut = new File("salida.txt");
		
		File directorio = new File(".\\bin");
		ProcessBuilder pb = new ProcessBuilder("java","Ejercicio9");
		pb.directory(directorio);
		
		pb.redirectInput(fEntrada); //la entrada del programa la coge del fichero
		pb.redirectError(fOut);
		
		Process p = pb.start();
		
		InputStream is = p.getInputStream();
		int c;
		while((c=is.read()) != -1) {
			System.out.print((char) c);
			
		}
		is.close();
	}

}
