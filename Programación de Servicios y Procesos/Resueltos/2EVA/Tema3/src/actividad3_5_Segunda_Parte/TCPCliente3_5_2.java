package actividad3_5_Segunda_Parte;

import java.io.*;
import java.net.*;

public class TCPCliente3_5_2 {

	public static int num = 0;
	public static void main(String[] args) throws IOException {
		String Host = "localhost";
		int Puerto = 6020; // puerto remoto
		System.out.println("PROGRAMA CLIENTE INICIADO...");
		Socket Cliente = null;
		for (int i = 1; i <= num; i++) {
			Cliente = new Socket(Host, Puerto);
			DataInputStream flujoEntrada = new DataInputStream(Cliente.getInputStream());
			int num = flujoEntrada.readInt();
			System.out.println(num);
		}
		System.out.println("Programa cliente finalizado");
		Cliente.close();

	}

}
