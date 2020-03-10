package actividad3_6_2;

import java.io.IOException;
import java.net.*;

public class UPDServidor3_6 {

	public static void main(String[] args) throws IOException {
		// ASOCIO EL SOCKET AL PUERTO 12345
		DatagramSocket socket = new DatagramSocket(12345);

		String mensaje = "";
		while (!mensaje.equals("*")) {
			// ESPERANDO DATAGRAMA
			System.out.println("Servidor Esperando Datagrama ....");
			DatagramPacket recibo;

			byte[] bufer = new byte[1024];
			recibo = new DatagramPacket(bufer, bufer.length);
			socket.receive(recibo); // RECIBO DATAGRAMA

			mensaje = new String(recibo.getData()).trim();
			if(!mensaje.equals("*"))
				System.out.println("Servidor Recibe: " + mensaje);
			mensaje = mensaje.toUpperCase();

			// DIRECCIÓN ORIGEN DEL MENSAJE
			InetAddress IPOrigen = recibo.getAddress();
			int puerto = recibo.getPort();

			// ENVIANDO DATAGRAMA AL CLIENTE
			byte[] enviados = mensaje.getBytes();

			DatagramPacket envio = new DatagramPacket(enviados, enviados.length, IPOrigen, puerto);
			socket.send(envio);
		}
		// CERRAR SOCKET
		System.out.println("Cerrando conexión...");
		socket.close();

	}

}
