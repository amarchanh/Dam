import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class PrincipalA {


	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Número de palabras:");
		String num = sc.nextLine();
		String palabra = "";
		File directorio = new File(".\\bin");

		ProcessBuilder pb = new ProcessBuilder("java", "LlamadoA");
		pb.directory(directorio);

		Process p = pb.start();
		
		OutputStream os = p.getOutputStream();
		
		for (int i=0;i<Integer.parseInt(num);i++) {
			System.out.println("Introduce palabra.");
			palabra = sc.nextLine();
			palabra += "\n";
			os.write(palabra.getBytes());
		}
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
