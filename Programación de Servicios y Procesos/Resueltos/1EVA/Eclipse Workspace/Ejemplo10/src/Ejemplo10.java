import java.io.*;
public class Ejemplo10 {
/*Modificando el ejemplo 8 con el to y el from Processbuild.Rediect.to*/
	public static void main(String[] args) throws IOException {
		ProcessBuilder pb = new ProcessBuilder("CMD");
		
		File fBat = new File("fichero.bat");
		File fOut = new File("salida.txt");
		File fErr = new File("error.txt");

		
		pb.redirectInput(ProcessBuilder.Redirect.from(fBat));
		pb.redirectOutput(ProcessBuilder.Redirect.to(fOut));
		pb.redirectError(ProcessBuilder.Redirect.to(fErr));
		pb.start();
	}

}
