import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class PrincipalB {


	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Número de palabras:");
		String num = sc.nextLine();
		String palabra = "";
		File directorio = new File(".\\bin");

		ProcessBuilder pb = new ProcessBuilder("java", "LlamadoB");
		pb.directory(directorio);

		Process p = pb.start();
		
		File fin = new File("entrada.txt");
		File ferr = new File ("error.txt");
		
		pb.redirectInput(fin);
		pb.redirectError(ferr);
		
		OutputStream os = p.getOutputStream();
		
		for (int i=0;i<Integer.parseInt(num);i++) {
			System.out.println("Introduce palabra.");
			palabra = sc.nextLine();
			os.write(palabra.getBytes());
		}
		os.flush();
		
		


	}
	
}
