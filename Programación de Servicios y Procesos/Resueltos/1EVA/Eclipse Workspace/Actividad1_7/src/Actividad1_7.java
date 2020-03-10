import java.io.*;
public class Actividad1_7 {

	public static void main(String[] args) throws IOException {


		
		File fInput = new File("manolo.txt");
		File fOut = new File("salida.txt");
		File fErr = new File("error.txt");

		File directorio = new File(".\\bin");
		ProcessBuilder pb = new ProcessBuilder("java", "EjemploLectura");
		pb.directory(directorio);
		
		pb.redirectInput(fInput);
		pb.redirectOutput(fOut);
		pb.redirectError(fErr);
		pb.start();

	}

}
