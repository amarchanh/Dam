import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Scanner;


public class EjecutaEjercicio7 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File fOut = new File("salida.txt");
		
		File directorio = new File(".\\bin");
		ProcessBuilder pb = new ProcessBuilder("java","Ejercicio7");
		pb.directory(directorio);
		Process p = pb.start();
		
		OutputStream os = p.getOutputStream();
		
		os.write(("hola\n").getBytes()); //importante el \n
		os.write(("adios\n").getBytes());
		os.write(("*\n").getBytes());
		os.flush();
		
		InputStream is = p.getInputStream();
		int c;
		while((c=is.read()) != -1) {
			System.out.print((char) c);
			
		}
		is.close();
	}

}
