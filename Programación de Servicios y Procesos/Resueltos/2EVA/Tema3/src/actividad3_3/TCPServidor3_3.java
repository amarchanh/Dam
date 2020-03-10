package actividad3_3;

import java.io.*;
import java.net.*;

public class TCPServidor3_3 {

	public static void main(String[] args) throws IOException {
		int numeroPuerto = 6000;
		ServerSocket servidor = new ServerSocket(numeroPuerto);
		Socket clienteConectado = null;
		System.out.println("Esperando al cliente...");
		clienteConectado = servidor.accept();
		
		//CREO FLUJO DE SALIDA AL CLIENTE
		OutputStream salida = null;
		salida = clienteConectado.getOutputStream();
		DataOutputStream flujoSalida = new DataOutputStream(salida);
		
		//ENVIO UN SALUDO AL CLIENTE
		flujoSalida.writeUTF("HOLA MUNDO!");
		
		//CREO FLUJO DE ENTRADA DEL CLIENTE
		InputStream entrada = null;
		entrada = clienteConectado.getInputStream();
		DataInputStream flujoEntrada = new DataInputStream(entrada);
		
		//EL CLIENTE ME ENVIA UN MENSAJE
		System.out.println("El cliente envía: \n\t" + flujoEntrada.readUTF());
		
		//CERRAR STREAM Y SOCKETS
		entrada.close();
		flujoEntrada.close();
		salida.close();
		flujoSalida.close();
		clienteConectado.close();
		servidor.close();

	}

}
