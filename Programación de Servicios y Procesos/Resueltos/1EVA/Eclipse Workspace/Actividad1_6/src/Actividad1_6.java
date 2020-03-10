import java.util.*;

public class Actividad1_6 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int num1 = 0, num2 = 0, suma;
		
		try {
			System.out.println("Dame el primer número.");
			num1 = Integer.parseInt(sc.nextLine());
			System.out.println("Dame el segundo número.");
			num2 = Integer.parseInt(sc.nextLine());
			suma = num1 + num2;
			System.out.println("La suma es: " + suma);
			sc.close();
		}
		catch(Exception e) {
			System.out.println("Hay que introducir números enteros. FIN DEL PROGRAMA");
		}


	}

}
