import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Scanner;

public class PrincipalB {

	public static void main(String[] args) throws IOException {
		File directorio = new File(".\\bin");
		ProcessBuilder pb = new ProcessBuilder("java", "LlamadoB");
		pb.directory(directorio);

		File fin = new File("entrada.txt");
		File fout = new File("salida.txt");
		File ferr = new File("error.txt");

		pb.redirectOutput(fout);
		pb.redirectError(ferr);
		pb.redirectInput(fin);

		Process p = pb.start();

		try {
			InputStream er = p.getErrorStream();
			BufferedReader brer = new BufferedReader(new InputStreamReader(er));
			String liner = null;
			while ((liner = brer.readLine()) != null)
				System.out.println("Error >" + liner);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
