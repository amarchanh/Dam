package actividad2_4;

import java.util.Scanner;

public class principal {

	public static void main(String[] args) {
		solicitasuspender metodosuspender = new solicitasuspender();
		Scanner teclado = new Scanner(System.in);
		char cad1;
		cad1 = teclado.next().charAt(0);
		myhilo h = new myhilo();
		h.start();
		while (cad1 != '*') {
			if (cad1 == 's') {
				System.out.println("Has metido S");
				h.suspende(); // pone a true la vble suspender
			} // if s
			try {
				if (cad1 == 'r') {
					System.out.println("Has metido R");
					metodosuspender.esperandoparareanudar();
					h.reanuda(); // pone a false la variable suspender
				} // if r
			} catch (InterruptedException exception) {
			} // catch
			cad1 = teclado.next().charAt(0);
		} // while
		System.out.println("Fin de datos");
		System.out.print("Valor final del contador ");
		h.mostrar();
		h.stop();
		// habría que matar el programa
	}

}
