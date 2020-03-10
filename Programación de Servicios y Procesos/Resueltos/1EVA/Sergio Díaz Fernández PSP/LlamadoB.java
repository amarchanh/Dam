import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class LlamadoB {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String cadena;
		cadena = sc.nextLine();
		for (int i=0;i<Integer.parseInt(cadena);i++) {
			cadena = sc.nextLine();
			System.out.println("La longitud de hola es: " + cadena.length());
		}
		
		
		sc.close();
	}

}
