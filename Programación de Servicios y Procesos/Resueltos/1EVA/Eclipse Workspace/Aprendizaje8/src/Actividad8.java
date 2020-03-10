import java.util.Scanner;

public class Actividad8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String cadena = "";
		cadena = sc.nextLine();
		String invertida = "";
		for (int i = 0; i < cadena.length(); i++) {
			invertida = cadena.charAt(i) + invertida;
		}
		
		if (cadena.length() == 0) {
			System.out.println("Cadena vacía.");
		}
		else if (cadena.equals(invertida)) {
			System.out.println("La cadena " + cadena + " es un palíndromo.");
		}
		else {
			System.out.println("La cadena " + invertida + " no es un palíndromo.");
		}
		

	}

}
