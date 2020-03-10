package UPDServidor2;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class UDPclienteEjemplo2 {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException{
		DatagramSocket clientSocket = new DatagramSocket();
		
		//DATOS DEL SERVIDOR AL QUE ENVIAR MENSAJE
		InetAddress IPServidor = InetAddress.getLocalHost();
		int puerto = 12345; //puerto por el que escucha
		
		//INTRODUCIR DATOS POR TECLADO
		System.out.println("Introduce mensaje: ");
		String cadena = sc.nextLine();
		
		byte[] enviados = new byte[1024];
		enviados = cadena.getBytes(); //convertir cadena a bytes
		
		//ENVIANDO DATAGRAMA AL SERVIDOR
		DatagramPacket envio = new DatagramPacket(enviados, enviados.length, IPServidor, puerto);
		clientSocket.send(envio);
		
		//RECIBIENDO DATAGRAMA DEL SERVIDOR
		byte[] recibidos = new byte[2];
		DatagramPacket recibo = new DatagramPacket(recibidos, recibidos.length);
		System.out.println("Esperan datagrama....");
		clientSocket.receive(recibo);
		
		//Obtener el n�mero de caracteres
		byte[] hh = recibo.getData();
		int numero = hh[0];
		
		System.out.println("Recibo N� de caracteres que son a=> " + numero);
		
		clientSocket.close(); //cerrar socket
		
	}

}
