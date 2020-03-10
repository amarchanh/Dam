import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class PrincipalA {


	public static void main(String[] args) throws IOException {
		File directorio = new File(".\\bin");
		ProcessBuilder pb = new ProcessBuilder("java", "LlamadoA");
		pb.directory(directorio);
		Scanner sc = new Scanner(System.in);
		System.out.println("Número de palabras: ");
		String num = sc.nextLine();
		int vueltas = Integer.parseInt(num);
		num += "\n";
		String palabra = "";
		Process p = pb.start();
		OutputStream os = p.getOutputStream();
		os.write(num.getBytes());
		
		for (int i=0;i< vueltas; i++) {
			System.out.println("Introduce palabra.");
			palabra = sc.next();
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

		sc.close();
	}
	
}
