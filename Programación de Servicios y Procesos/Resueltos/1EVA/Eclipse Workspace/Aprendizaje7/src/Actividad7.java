import java.util.Scanner;

public class Actividad7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String cadena;
		do {
			cadena = sc.nextLine();
			System.out.println(cadena);
		}while (!cadena.equals("*"));
		System.out.println("El programa ha terminado.");
		sc.close();

	}

}
