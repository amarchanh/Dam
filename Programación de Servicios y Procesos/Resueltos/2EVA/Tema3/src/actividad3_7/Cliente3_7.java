package actividad3_7;

import java.util.Scanner;

public class Cliente3_7 {

	public static void main(String[] args) {
		System.out.println("Programa cliente iniciado.");
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el número:");
		int num = sc.nextInt();
		Numeros3_7 n = new Numeros3_7();
		n.setNumero(num);
	}

}
