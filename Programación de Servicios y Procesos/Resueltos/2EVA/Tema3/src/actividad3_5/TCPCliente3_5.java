package actividad3_5;

import java.io.*;
import java.net.*;

public class TCPCliente3_5{

	public static void main(String[] args) throws IOException {
		String Host = "localhost";
		int Puerto = 6000; //puerto remoto
		
		System.out.println("PROGRAMA CLIENTE INICIADO...");
		for (int i = 1; i <= 3 ; i++) {
			Socket Cliente = new Socket(Host, Puerto);
			DataInputStream flujoEntrada = new DataInputStream(Cliente.getInputStream());
			System.out.println(flujoEntrada.readInt());
			
			Cliente.close();
		}
		
		
		
		

	}

}
