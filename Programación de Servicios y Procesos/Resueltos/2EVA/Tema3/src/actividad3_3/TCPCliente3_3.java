package actividad3_3;

import java.io.*;
import java.net.*;

public class TCPCliente3_3{

	public static void main(String[] args) throws IOException {
		String Host = "localhost";
		int Puerto = 6000; //puerto remoto
		
		System.out.println("PROGRAMA CLIENTE INICIADO...");
		Socket Cliente = new Socket(Host, Puerto);
		
		//CREO FLUJO DE ENTRADA AL SERVIDOR
		DataInputStream flujoEntrada = new DataInputStream(Cliente.getInputStream());
		
		String texto = flujoEntrada.readUTF();
		
		//EL SERVIDOR ME ENVIA UN MENSAJE
		System.out.println("El servidor envía: \n\t" + texto);
		
		//CREO FLUJO DE SALIDA AL SERVIDOR
		DataOutputStream flujoSalida = new DataOutputStream(Cliente.getOutputStream());
		
		//ENVIO UN SALUDO AL SERVIDOR
		flujoSalida.writeUTF(texto.toLowerCase());
		
		
		//CERRAR STREAM Y SOCKETS
		flujoEntrada.close();
		flujoSalida.close();
		Cliente.close();

	}

}
