package actividad3_4;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPCliente3_4{

	public static void main(String[] args) throws IOException {
		String Host = "localhost";
		int Puerto = 6000; //puerto remoto
		Scanner sc = new Scanner(System.in);
		System.out.println("PROGRAMA CLIENTE INICIADO...");
		Socket Cliente = new Socket(Host, Puerto);
		System.out.println("Introduzca un entero número por teclado para mostrar su cuadrado");
		int num = sc.nextInt();
		//CREO FLUJO DE SALIDA AL SERVIDOR
		DataOutputStream flujoSalida = new DataOutputStream(Cliente.getOutputStream());
		
		//ENVIIO UN SALUDO AL SERVIDOR
		flujoSalida.writeInt(num);
		
		//CREO FLUJO DE ENTRADA AL SERVIDOR
		DataInputStream flujoEntrada = new DataInputStream(Cliente.getInputStream());
		
		//EL SERVIDOR ME ENVIA UN MENSAJE
		System.out.println("Recibiendo del SERVIDOR: \n\t" + flujoEntrada.readInt());
		
		//CERRAR STREAM Y SOCKETS
		flujoEntrada.close();
		flujoSalida.close();
		Cliente.close();
		sc.close();

	}

}
