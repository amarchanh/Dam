package aprendizaje1;

import java.io.*;
import java.net.*;
import java.util.*;

public class TCPClienteAprendizaje1{

	public static void main(String[] args) throws IOException {
		String Host = "localhost";
		int Puerto = 6000; //puerto remoto
		String mensaje = "";
		System.out.println("PROGRAMA CLIENTE INICIADO...");
		Socket Cliente = new Socket(Host, Puerto);
		DataOutputStream flujoSalida = null;
		DataInputStream flujoEntrada = null;
		
		
		while (!mensaje.equals("*")) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Introduzca la palabra");
			mensaje = sc.nextLine();
			//CREO FLUJO DE SALIDA AL SERVIDOR
			flujoSalida = new DataOutputStream(Cliente.getOutputStream());
			
			//ENVIO UN SALUDO AL SERVIDOR
			flujoSalida.writeUTF(mensaje);
			
			//CREO FLUJO DE ENTRADA AL SERVIDOR
			flujoEntrada = new DataInputStream(Cliente.getInputStream());
			int num = flujoEntrada.readInt();
			
			//EL SERVIDOR ME ENVIA UN MENSAJE
			System.out.println("Tamaño de la palabra: " + num);
			
		}
		
		//CERRAR STREAM Y SOCKETS
		flujoEntrada.close();
		flujoSalida.close();
		Cliente.close();

	}

}
