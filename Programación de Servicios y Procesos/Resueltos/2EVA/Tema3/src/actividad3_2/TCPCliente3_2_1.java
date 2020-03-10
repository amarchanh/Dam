package actividad3_2;

import java.io.*;
import java.net.*;

public class TCPCliente3_2_1{

	public static void main(String[] args) throws IOException {
		String Host = "localhost";
		int Puerto = 6000; //puerto remoto
		
		System.out.println("PROGRAMA CLIENTE INICIADO...");
		Socket Cliente = new Socket(Host, Puerto);
		
		System.out.println("Dirección del servidor: " + Cliente.getInetAddress());
		System.out.println("Dirección del puerto: " + Cliente.getPort());
		System.out.println("Dirección del puerto local: " + Cliente.getLocalPort());
		
		Cliente.close();

	}

}
