import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Scanner;


public class EjecutaEjercicio8 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File fEntrada = new File("entrada.txt");
		File fErr = new File("error.txt");
		File directorio = new File(".\\bin");
		
		ProcessBuilder pb = new ProcessBuilder("java","Ejercicio8");
		pb.directory(directorio);
		
		pb.redirectInput(fEntrada);
		pb.redirectError(fErr);
		
		Process p = pb.start();
		
		InputStream is = p.getInputStream();
		int c;
		while((c=is.read()) != -1) {
			System.out.print((char) c);
			
		}
		is.close();
	}

}
