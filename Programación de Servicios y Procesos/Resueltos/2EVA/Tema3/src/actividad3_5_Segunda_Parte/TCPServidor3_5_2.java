package actividad3_5_Segunda_Parte;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPServidor3_5_2 {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		int numero;
		System.out.println("Introduzca el número de clientes");		
		numero = sc.nextInt();
		TCPCliente3_5_2.num = numero;
		
		int numeroPuerto = 6020;
		ServerSocket servidor = new ServerSocket(numeroPuerto);
		DataOutputStream flujoSalida = null;
		Socket clienteConectado = null;
		
		for (int i = 1; i <= numero; i++) {
			clienteConectado = servidor.accept();
			OutputStream salida = clienteConectado.getOutputStream();
			flujoSalida = new DataOutputStream(salida);
			flujoSalida.writeInt(i);
			
			if(i < numero) {
				clienteConectado.close();
			}
			
		}
		System.out.println("Programa servidor finalizado");
		sc.close();
		servidor.close();

	}

}
