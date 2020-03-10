import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class Ejemplo5 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// creamos objeto File al directorio donde esta Ejmplo2
		File directorio = new File(".\\bin");

		// El proceso a ejecutar es Ejemplo2
		ProcessBuilder pb = new ProcessBuilder("java", "EjemploLectura");
		pb.directory(directorio);
		
		//se ejecuta el proceso
		Process p = pb.start();
		
		// escritura - se envia la entrada
		OutputStream os = p.getOutputStream();
		os.write("Hola manuel\n".getBytes()); //importante el \n
		os.flush(); //vacía el buffer de salida
		
		InputStream is = p.getInputStream();
		int c;
		while((c=is.read()) != -1) {
			System.out.print((char) c);
			
		}
		is.close();
	}
}
