package actividad2_4modificada;

import java.util.Scanner;

import actividad2_4.myhilo;

public class principalI {

	public static void main(String[] args) {
		solicitasuspenderI objetosuspender = new solicitasuspenderI();
		
		Scanner teclado=new Scanner(System.in);
		char cad1;
		cad1 = teclado.next().charAt(0);
		myhiloI h = new myhiloI();
		h.start();
				
		while (cad1  != '*') {
			if (cad1 =='s') {
				System.out.println("Has metido s");
				h.suspende(); //pone a true la vble suspender
			}//if s
				
			if (cad1 == 'r') {
				System.out.println("Has metido R");
				h.reanuda(); //pone a false la variable suspender
							
			}//if r
			cad1 = teclado.next().charAt(0);
		
		}//while *
		h.matarhilo();
		
	}

}
