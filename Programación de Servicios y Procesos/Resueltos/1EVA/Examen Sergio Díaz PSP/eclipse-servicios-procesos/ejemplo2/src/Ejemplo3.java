
import java.io.*;

public class Ejemplo3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// creamos objeto File al directorio donde esta Ejmplo2
		File directorio = new File(".\\bin");

		// El proceso a ejecutar es Ejemplo2
		ProcessBuilder pb = new ProcessBuilder("java", "Ejemplo2aaaaaa");

		// se estblece el directorio donde se encuetra el ejecutable
		pb.directory(directorio);

		System.out.printf("Directorio de trabajo: %s%n", pb.directory());

		// se ejecuta el proceso
		Process p = pb.start();

		// obtener la salida devuelta por el proceso
		try {
			/*
			 * InputStream is = p.getInputStream(); int c; while((c = is.read()) != -1)
			 * System.out.print((char) c);
			 */
			InputStream is = p.getInputStream(); // recoger lo que devuelve el proceso
			BufferedReader br = new BufferedReader(new InputStreamReader(is)); // buffer almacena temporalmente
			String linea;
			while ((linea = br.readLine()) != null) { // lee una linea
				System.out.println(linea);
			}
			is.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

		try {
			InputStream er = p.getErrorStream();
			BufferedReader brer = new BufferedReader(new InputStreamReader(er));
			String liner = null;
			while ((liner = brer.readLine()) != null) {
				System.out.println("ERROR >" + liner);
			}
		} 
		catch (IOException ioe) {
			ioe.printStackTrace();

		}

	}
}
