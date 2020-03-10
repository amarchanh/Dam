package actividad3_5;

import java.io.*;
import java.net.*;

public class TCPServidor3_5 {

	public static void main(String[] args) throws IOException {
		int numeroPuerto = 6000;
		
		ServerSocket servidor = new ServerSocket(numeroPuerto);
		for (int i = 1; i <= 3; i++) {
			Socket clienteConectado = servidor.accept();
			OutputStream salida = clienteConectado.getOutputStream();
			DataOutputStream flujoSalida = new DataOutputStream(salida);
			flujoSalida.writeInt(i);
			clienteConectado.close();
		}
		servidor.close();

	}

}
