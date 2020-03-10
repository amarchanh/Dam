import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class Actividad8_llamada {

	public static void main(String[] args) throws IOException {

		File directorio = new File(".\\bin");

		ProcessBuilder pb = new ProcessBuilder("java", "Actividad8");
		pb.directory(directorio);

		Process p = pb.start();
		
		Scanner sc = new Scanner(System.in);
		String cadena ="";
		System.out.println("Dame una cadena: ");
		cadena = sc.nextLine();
		
		cadena = cadena+"\n";
		
		OutputStream os = p.getOutputStream();
		os.write(cadena.getBytes());
		os.flush();
		
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
