package mcServidor;

import java.io.*;
import java.net.*;

public class MCServidor {
	public static void main(String[] args) throws IOException{
		//FLUJO PARA ENTRADA ESTÁNDAR
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//Se crea el socket multicast
		MulticastSocket ms = new MulticastSocket();
		
		int Puerto = 12345; //Puerto multicast
		InetAddress grupo = InetAddress.getByName("225.0.0.1"); //Grupo
		
		String cadena="";
		
		while(!cadena.trim().equals("*")) {
			System.out.println("Datos a enviar al grupo: ");
			cadena = in.readLine();
			//ENVIANDO AL GRUPO
			DatagramPacket paquete = new DatagramPacket(cadena.getBytes(), cadena.length(), grupo, Puerto);
			ms.send(paquete);
		}
		
		ms.close(); //cierro socket
		System.out.println("Socket cerrado...");
	}

}
