import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class Actividad9_llamada {

	public static void main(String[] args) throws IOException, InterruptedException {

		File directorio = new File(".\\bin");

		ProcessBuilder pb = new ProcessBuilder("java", "Actividad9");
		pb.directory(directorio);

		File fin = new File("entrada.txt");
		File ferr = new File ("error.txt");
		
		pb.redirectInput(fin);
		pb.redirectError(ferr);
		
		Process p = pb.start();
		
		try {
			InputStream is = p.getInputStream();
			int c;
			while ((c = is.read()) != -1)
				System.out.print((char) c);
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
