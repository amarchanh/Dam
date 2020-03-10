import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;


public class EjecutaEjercicio5 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File directorio = new File(".\\bin");
		ProcessBuilder pb = new ProcessBuilder("java","Ejercicio5","Hola me llamo Jesús"); // -1 es el argumento que le paso al programa
		pb.directory(directorio);
		Process p = pb.start();
		InputStream is = p.getInputStream();
		
		int c;
		while((c=is.read()) != -1) {
			System.out.print((char) c);
			
		}
		is.close();
	}

}
