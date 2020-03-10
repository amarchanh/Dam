import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;


public class EjecutaEjercicio6 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File fOut = new File("salida.txt");
		
		File directorio = new File(".\\bin");
		ProcessBuilder pb = new ProcessBuilder("java","Ejercicio6","Hola me llamo Jesús"); // -1 es el argumento que le paso al programa
		pb.directory(directorio);
		
		pb.redirectOutput(fOut); //Envía la salida al fichero salida.txt
		
		Process p = pb.start();
	}

}
