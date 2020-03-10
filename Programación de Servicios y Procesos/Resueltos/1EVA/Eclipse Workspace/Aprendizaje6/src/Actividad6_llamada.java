import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Actividad6_llamada {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String cadena="";
		System.out.println("Dame la cadena a repetir: ");
		cadena = sc.nextLine();
		File directorio = new File(".\\bin");
		ProcessBuilder pb = new ProcessBuilder("java", "Actividad6", cadena);
		pb.directory(directorio);
		File fOut = new File("salida.txt");
		File fErrores = new File("errores.txt");

		pb.redirectOutput(fOut);
		pb.redirectError(fErrores);
		pb.start();
		System.out.println("Ficheros creados satisfactoriamente.");

	}

}
