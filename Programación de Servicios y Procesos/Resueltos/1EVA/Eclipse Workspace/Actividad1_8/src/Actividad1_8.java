import java.io.*;
public class Actividad1_8{

	public static void main(String[] args) throws IOException, InterruptedException {
		
		File fInput = new File("manolo.txt");
		File fOut = new File("salida.txt");
		File fErr = new File("error.txt");

		File directorio = new File(".\\bin");
		ProcessBuilder pb = new ProcessBuilder("java", "EjemploLectura");
		pb.directory(directorio);
		
		pb.redirectInput(fInput);
		pb.redirectOutput(fOut);
		pb.redirectError(ProcessBuilder.Redirect.appendTo(fErr));
		Process p = pb.start();

		
		int exitval = p.waitFor();
		
		String cadena;
		FileReader f = new FileReader("salida.txt");
		BufferedReader b = new BufferedReader(f);
		while((cadena = b.readLine()) != null) {
			System.out.println(cadena);
		}
		b.close();
	}

}
