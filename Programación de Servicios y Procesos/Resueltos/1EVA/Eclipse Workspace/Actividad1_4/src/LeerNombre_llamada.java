import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class LeerNombre_llamada {

	public static void main(String[] args) throws IOException, InterruptedException {

		File directorio = new File(".\\bin");

		ProcessBuilder pb = new ProcessBuilder("java", "LeerNombre", "Jesús", "hola");
		pb.directory(directorio);

		Process p = pb.start();
		int n = p.waitFor();
		System.out.println(n);

		InputStream is = p.getInputStream();
		int c;
		while ((c = is.read()) != -1)
			System.out.print((char) c);
		is.close();

	}

}
