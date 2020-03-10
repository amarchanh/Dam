import java.io.*;
public class Ejemplo5 {

	public static void main(String[] args) throws IOException{
		//creamos el objeto File al directorio donde está Ejemplo2
		File directorio = new File(".\\bin");
		
		ProcessBuilder pb = new ProcessBuilder("java", "EjemploLectura");
		
		pb.directory(directorio);
		
		Process p = pb.start();
		
		OutputStream os = p.getOutputStream();
		os.write("Hola Manuel\n".getBytes());
		os.flush();
		
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