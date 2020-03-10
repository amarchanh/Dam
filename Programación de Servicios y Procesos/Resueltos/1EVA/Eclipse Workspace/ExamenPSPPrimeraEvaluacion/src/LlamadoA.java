import java.util.Scanner;

public class LlamadoA {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String vueltas = "";
		vueltas = sc.nextLine();
		String cadena = "";
		for (int i=0;i<Integer.parseInt(vueltas);i++) {
			cadena = sc.nextLine();
			System.out.println("La longitud de "+ cadena +" es: " + cadena.length());
		}
		
		
		sc.close();
	}

}
