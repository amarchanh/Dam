import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class Actividad1_8 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Creamos objeto File al directorio donde esta EjemploLectura
		File directorio = new File(".\\bin");
		
		File entrada = new File("entrada.txt");
		File fOut = new File("salida.txt");
		File fErr = new File("error.txt");
		
		//ProcessBuilder 1 (redirige la salida al archivo)
		ProcessBuilder pb = new ProcessBuilder("java", "EjemploLectura"); 
		pb.directory(directorio);
		
		pb.redirectInput(ProcessBuilder.Redirect.from(entrada)); // igual que pb.redirectInput(entrada)
		pb.redirectOutput(fOut); // fuente salida el fichero salida.txt
		pb.redirectError(ProcessBuilder.Redirect.appendTo(fErr));
		Process p = pb.start();
		
		try {
			//Espera a que acabe el proceso
			p.waitFor();
			//Muestra por pantalla lo que contiene el archivo salida.txt
			FileReader fr = new FileReader("salida.txt");
		    BufferedReader br = new BufferedReader(fr);
			String linea = null;
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
			br.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
