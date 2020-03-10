import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;


public class EjecutaLeerNombre {

	public static void main(String[] args) throws IOException, InterruptedException{
		// TODO Auto-generated method stub
		File directorio = new File(".\\bin");
		ProcessBuilder pb = new ProcessBuilder("java","LeerNombre","Jesús"); // "Jesús" es el argumento que le paso al programa
		pb.directory(directorio);
		Process p = pb.start();
		InputStream is = p.getInputStream();
		
		int n = p.waitFor(); // 1 si se pasa argumentos, -1 si no se pasa argumentos
		System.out.println(n);
		
		int c;
		while((c=is.read()) != -1) {
			System.out.print((char) c);
			
		}
		is.close();
	}

}
