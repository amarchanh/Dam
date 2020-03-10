package actividad3_2;

import java.io.*;
import java.net.*;

public class TCPServidor3_2 {

	public static void main(String[] args) throws IOException {
		int numeroPuerto = 6000;
		ServerSocket servidor = new ServerSocket(numeroPuerto);
		
		System.out.println("Esperando al cliente 1...");
		Socket clienteConectado = servidor.accept();
		System.out.println("Puerto local cliente 1: " + clienteConectado.getLocalPort());
		System.out.println("Puerto remoto cliente 1: " + clienteConectado.getPort());
		
		System.out.println("Esperando al cliente 2...");
		Socket clienteConectado2 = servidor.accept();
		System.out.println("Puerto local cliente 2: " + clienteConectado2.getLocalPort());
		System.out.println("Puerto remoto cliente 2: " + clienteConectado2.getPort());
		
		
		clienteConectado.close();
		clienteConectado2.close();
		servidor.close();

	}

}
