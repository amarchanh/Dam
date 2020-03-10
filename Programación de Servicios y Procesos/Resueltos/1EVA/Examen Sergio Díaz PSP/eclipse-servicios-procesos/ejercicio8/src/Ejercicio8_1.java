import java.util.Scanner;

public class Ejercicio8_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String a = sc.nextLine();

		if (a.length() > 0) {
			String aInvertido = ""; // si a contiene 123, aInvertido tendrá 321
			for (int i = 0; i < a.length(); i++) {
				// añade valores al principio, el último valor de a, será el primero de
				// aInvertido
				aInvertido = a.charAt(i) + aInvertido;
			}

			// Si a es igual aInvertido, es palíndromo
			if (a.equals(aInvertido)) {
				System.out.println(a + " es palíndromo");
			} else {
				System.out.println(a + " no es palíndromo");
			}
		} else {
			System.out.println("La longitud es 0");
		}
	}
}
