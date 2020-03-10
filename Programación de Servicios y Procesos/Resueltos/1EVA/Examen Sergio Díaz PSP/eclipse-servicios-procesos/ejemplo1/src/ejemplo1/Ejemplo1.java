package ejemplo1;

import java.io.IOException;

public class Ejemplo1 {

	public static void main(String[] args) throws IOException {
		Process pb1 = new ProcessBuilder("Notepad").start();
		
		ProcessBuilder pb = new ProcessBuilder("Notepad");
		Process p = pb.start();
	}

}
