import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Scanner;

public class ejecutaSumaNumeros {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		// creamos objeto File al directorio donde esta Ejmplo2
		File directorio = new File(".\\bin");

		// El proceso a ejecutar es Ejemplo2
		ProcessBuilder pb = new ProcessBuilder("java", "sumaNumeros");
		pb.directory(directorio);
		
		//se ejecuta el proceso
		Process p = pb.start();
		
		System.out.println("Dime un número");
		int a = Integer.parseInt(sc.nextLine());
		System.out.println("Dime otro número");
		int b = Integer.parseInt(sc.nextLine());
		
		// escritura - se envia la entrada
		OutputStream os = p.getOutputStream();
		
		os.write((a+"\n").getBytes()); //importante el \n
		os.write((b+"\n").getBytes());
		os.flush(); //vacía el buffer de salida
		
		
		InputStream is = p.getInputStream();
		int c;
		while((c=is.read()) != -1) {
			System.out.print((char) c);
			
		}
		is.close();
	}
}
