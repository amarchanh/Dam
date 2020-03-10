package actividad3_6;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class UDPCliente3_6 {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException{
		DatagramSocket clientSocket = new DatagramSocket();
		
		//DATOS DEL SERVIDOR AL QUE ENVIAR MENSAJE
		InetAddress IPServidor = InetAddress.getLocalHost();
		int puerto = 12345; //puerto por el que escucha
		String cadena = "";
		
		while (!cadena.equals("*")) {
			//INTRODUCIR DATOS POR TECLADO
			System.out.println("Introduce mensaje: ");
			cadena = sc.nextLine();
			
			byte[] enviados = new byte[1024];
			enviados = cadena.getBytes(); //convertir cadena a bytes
			
			//ENVIANDO DATAGRAMA AL SERVIDOR
			DatagramPacket envio = new DatagramPacket(enviados, enviados.length, IPServidor, puerto);
			clientSocket.send(envio);
			
			//RECIBIENDO DATAGRAMA DEL SERVIDOR
			byte[] recibidos = new byte[1024];
			DatagramPacket recibo = new DatagramPacket(recibidos, recibidos.length);
			System.out.println("Esperando datagrama....");
			clientSocket.receive(recibo);
			
			//Obtener el número de caracteres
			String mensaje = new String(recibo.getData()).trim();
			if(!mensaje.equals("*"))
				System.out.println("Servidor devuelve " + cadena + " en mayúscula: " + mensaje);
			
			
		}
		System.out.println("Cerrando Conexión");
		clientSocket.close(); //cerrar socket
		
	}

}
