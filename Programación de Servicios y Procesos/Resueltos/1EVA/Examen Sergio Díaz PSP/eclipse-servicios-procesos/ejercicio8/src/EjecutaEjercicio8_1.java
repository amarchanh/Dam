import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.io.OutputStream;


public class EjecutaEjercicio8_1 {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File directorio = new File(".\\bin");
		
		ProcessBuilder pb = new ProcessBuilder("java","Ejercicio8_1");
		pb.directory(directorio);
		
		Process p = pb.start();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce una cadena o un número");
		String cadena = sc.nextLine();
		
		OutputStream os = p.getOutputStream();
		os.write((cadena+"\n").getBytes());
		os.flush();
		
		InputStream is = p.getInputStream();
		int c;
		while((c=is.read()) != -1) {
			System.out.print((char) c);
			
		}
		is.close();
	}
}
