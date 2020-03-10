import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Scanner;

public class EjecutaEjercicio7 {

	public static int continuar() {
		Scanner sc = new Scanner(System.in);
		int h;
		h = sc.nextInt();
		return h;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File fOut = new File("salida.txt");

		File directorio = new File(".\\bin");
		ProcessBuilder pb = new ProcessBuilder("java", "Ejercicio7");
		pb.directory(directorio);
		Process p = pb.start();

		OutputStream os = p.getOutputStream();
		String g = "";

		System.out.println("Continuar???");
		int k = continuar();
		while (k != 1) {
			System.out.println("Cadena??");
			Scanner sc = new Scanner(System.in);
			g=sc.nextLine();
			g=g+"\n";
			os.write(g.getBytes());
			os.flush();
			System.out.println("Seguir (número)");
			k = continuar();
		}
		
		//p.destroy(); Tomás puso esto para matar el proceso

		InputStream is = p.getInputStream();
		int c;
		while ((c = is.read()) != -1) {
			System.out.print((char) c);

		}
		is.close();
	}

}
