import java.io.File;
import java.io.IOException;

//Página 42, reemplazar cogiendo el ejemplo 8
public class Ejemplo10 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ProcessBuilder pb = new ProcessBuilder("CMD");

		File fBat = new File("fichero.bat");
		File fOut = new File("salida.txt");
		File fErr = new File("error.txt");

		pb.redirectInput(ProcessBuilder.Redirect.from(fBat)); //.from para coger la entrada
		pb.redirectOutput(ProcessBuilder.Redirect.to(fOut));
		pb.redirectError(ProcessBuilder.Redirect.to(fErr));
		pb.start();
	}
}
