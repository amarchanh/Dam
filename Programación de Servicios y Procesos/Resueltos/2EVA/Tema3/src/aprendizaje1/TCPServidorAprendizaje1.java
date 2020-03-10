package aprendizaje1;

import java.io.*;
import java.net.*;

public class TCPServidorAprendizaje1 {

	public static void main(String[] args) throws IOException {
		int numeroPuerto = 6000;
		ServerSocket servidor = new ServerSocket(numeroPuerto, 1);
		Socket clienteConectado = null;
		System.out.println("Esperando al cliente...");
		clienteConectado = servidor.accept();

		// CREO FLUJO DE ENTRADA DEL CLIENTE
		InputStream entrada = null;
		entrada = clienteConectado.getInputStream();
		DataInputStream flujoEntrada = new DataInputStream(entrada);
		String mensaje = flujoEntrada.readUTF();

		OutputStream salida = null;
		DataOutputStream flujoSalida = null;

		try {
			while (true) {
				// CREO FLUJO DE SALIDA AL CLIENTE
				salida = clienteConectado.getOutputStream();
				flujoSalida = new DataOutputStream(salida);

				// ENVIO UN SALUDO AL CLIENTE
				flujoSalida.writeInt(mensaje.length());
				mensaje = flujoEntrada.readUTF();

			}

		} catch (EOFException e) {
			System.out.println("Conexión terminada");
		}
		// CERRAR STREAM Y SOCKETS
		entrada.close();
		flujoEntrada.close();
		salida.close();
		flujoSalida.close();
		clienteConectado.close();
		servidor.close();

	}

}
