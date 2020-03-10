import java.io.IOException;

public class Ejemplo1 {

	public static void main(String[] args) throws IOException {

		//Process pb = new ProcessBuilder("NOTEPAD").start();
		ProcessBuilder pb = new ProcessBuilder("NOTEPAD");
		Process p = pb.start();
	}

}
