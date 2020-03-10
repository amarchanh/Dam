import java.io.*;
public class Ejemplo3 {

	public static void main(String[] args) throws IOException{
		//creamos el objeto File al directorio donde est� Ejemplo2
		File directorio = new File("..\\Ejemplo2\\bin");
		
		ProcessBuilder pb = new ProcessBuilder("java", "Ejemplo2");
		
		pb.directory(directorio);
		
		System.out.printf("Directorio de trabajo: %s%n",pb.directory());
		
		Process p = pb.start();
		
		try {
			InputStream is = p.getInputStream();
			int c;
			while ((c = is.read()) != -1)
				System.out.print((char) c);
			is.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
