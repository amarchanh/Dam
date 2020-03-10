package UDPServidor;

import java.net.InetAddress;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPcliente {

	public static void main(String[] args) throws Exception{
		InetAddress destino = InetAddress.getLocalHost();
		int port = 12345; //puerto al que envio el datagrama
		byte[] mensaje = new byte[1024];
		String Saludo = "Enviando Saludos !!";
		mensaje = Saludo.getBytes(); //codifico String a bytes
		
		//CONSTRUYO EL DATAGRAMA A ENVIAR
		DatagramPacket envio = new DatagramPacket (mensaje, mensaje.length, destino, port);
		DatagramSocket socket = new DatagramSocket(34567); //Puerto local
		
		System.out.println("Enviando Datagrama de longitud: " + mensaje.length);
		System.out.println("Host destino : " + destino.getHostName());
		System.out.println("IP Destino   : " + destino.getHostAddress());
		System.out.println("Puerto local del socket: " + socket.getLocalPort());
		System.out.println("Puerto al que envío: " + envio.getPort());
		
		//ENVIO DATAGRAMA
		socket.send(envio);
		socket.close(); //cierro el socket

	}

}
