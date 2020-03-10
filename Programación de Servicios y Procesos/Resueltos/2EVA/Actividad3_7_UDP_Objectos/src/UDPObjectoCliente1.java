import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class UDPObjectoCliente1 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		System.out.println("PROGRAMA CLIENTE INICIADO..");
		InetAddress destino = InetAddress.getLocalHost();
		int portDestino = 12345; // puerto al que envio el datagrama

		// ASOCIO EL SOCKET EL PUERTO 4444 QUE ME INVENTO
		DatagramSocket socket = new DatagramSocket(4444); // 4444 Puerto local

		Scanner sc = new Scanner(System.in);
		int numero = 1;

		while (numero > 0) {
			System.out.println("Introduce un número: ");
			numero = sc.nextInt();

			// OBJETO NUMEROS QUE ENVIAREMOS AL SERVIDOR
			Numeros numeroEnviar = new Numeros(numero, 0, 0);

			byte[] recibidos = new byte[1024];

			// DATAGRAMA QUE CONTENDRÁ LO QUE ENVIAREMOS AL SERVIDOR
			DatagramPacket envio = new DatagramPacket(recibidos, recibidos.length);

			// CONVERTIMOS OBJETO A BYTES
			ByteArrayOutputStream bs = new ByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(bs);
			out.writeObject(numeroEnviar); // Escribir objeto Persona en el stream
			out.close(); // cerrar stream
			byte[] bytesNumeroEnviar = bs.toByteArray();// objeto en bytes

			// DATAGRAMA CON EL OBJETO EN BYTES
			DatagramPacket enviar = new DatagramPacket(bytesNumeroEnviar, bytesNumeroEnviar.length, destino,
					portDestino);

			System.out.println("Envío: " + numeroEnviar.getNumero() + "," + numeroEnviar.getCuadrado() + ","
					+ numeroEnviar.getCubo());

			// ENVÍO EL DATAGRAMA AL CLIENTE
			socket.send(enviar);

			// DATAGRAMA QUE CONTENDRÁ LO QUE NOS ENVÍE EL CLIENTE
			DatagramPacket recibo = new DatagramPacket(recibidos, recibidos.length);

			// ESPERANDO DATAGRAMA DEL CLIENTE
			socket.receive(recibo); // RECIBO el datagrama

			// CONVERTIMOS BYTES A OBJETO
			ByteArrayInputStream bais = new ByteArrayInputStream(recibo.getData());
			ObjectInputStream in = new ObjectInputStream(bais);
			Numeros objNumeroRecibo = (Numeros) in.readObject();// obtengo objeto

			System.out.println("Recibo: " + objNumeroRecibo.getNumero() + "," + objNumeroRecibo.getCuadrado() + ","
					+ objNumeroRecibo.getCubo());
		}
		
		System.out.println("Deteniendo cliente...");
		socket.close();

	}

}
