package actividad3_2;

import java.io.*;
import java.net.*;

public class TCPCliente3_2_2 {

	public static void main(String[] args) throws IOException {
		String Host = "localhost";
		int Puerto = 6000; //puerto remoto
		
		System.out.println("PROGRAMA CLIENTE2 INICIADO...");
		Socket Cliente = new Socket(Host, Puerto);
		
		System.out.println("Direcci�n del servidor: " + Cliente.getInetAddress());
		System.out.println("Direcci�n del puerto: " + Cliente.getPort());
		System.out.println("Direcci�n del puerto local: " + Cliente.getLocalPort());
		
		Cliente.close();


	}

}
