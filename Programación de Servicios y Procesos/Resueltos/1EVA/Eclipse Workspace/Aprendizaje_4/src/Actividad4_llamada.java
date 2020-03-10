import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Actividad4_llamada {

	public static void main(String[] args) throws IOException {

		File directorio = new File(".\\bin");

		ProcessBuilder pb = new ProcessBuilder("java", "Actividad4", "87");
		pb.directory(directorio);

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
