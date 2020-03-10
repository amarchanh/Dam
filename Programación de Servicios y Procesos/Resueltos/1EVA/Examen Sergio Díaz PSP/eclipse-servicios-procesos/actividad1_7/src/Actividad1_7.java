
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Actividad1_7 {

	public static void main(String[] args) throws IOException {
		File entrada = new File("entrada.txt"); //Fichero de entrada
		File fOut = new File("salida.txt");
		File fErr = new File("error.txt");
		
		File directorio = new File(".\\bin");

		// El proceso a ejecutar es EjemploLectura
		ProcessBuilder pb = new ProcessBuilder("java", "EjemploLectura");
		pb.directory(directorio);
		
		pb.redirectInput(entrada); //El process builder toma como entrada el fichero indicado
		pb.redirectOutput(fOut);
		pb.redirectError(fErr);
		
		//se ejecuta el proceso
		Process p = pb.start();
		
	}

}
