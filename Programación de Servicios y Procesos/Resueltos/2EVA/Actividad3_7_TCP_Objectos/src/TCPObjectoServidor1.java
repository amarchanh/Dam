import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPObjectoServidor1 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		System.out.println("PROGRAMA SERVIDOR INICIADO...");
		int numeroPuerto = 6000; // Puerto
		ServerSocket servidor = new ServerSocket(numeroPuerto);

		System.out.println("Esperando al cliente...");
		Socket cliente = servidor.accept();

		Numeros num = new Numeros();
		try {
			while (true) {
				// Se obtiene un stream para leer objetos, si el cliente cierra conexión, salta
				// EOFException
				ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream());

				// Objeto que recibo
				num = (Numeros) inObjeto.readObject(); //salta excepcion si el cliente ha cerrado conexion

				System.out.println("Recibo: " + num.getNumero() + "," + num.getCuadrado() + "," + num.getCubo());
				// Cambio las propiedades
				num.setCuadrado(num.getNumero() * num.getNumero());
				num.setCubo(num.getNumero() * num.getNumero() * num.getNumero());

				System.out.println("Envío: " + num.getNumero() + "," + num.getCuadrado() + "," + num.getCubo());

				// Se prepara un flujo de salida para objectos
				ObjectOutputStream outObjecto = new ObjectOutputStream(cliente.getOutputStream());

				// Se prepara un objeto y se envía
				outObjecto.writeObject(num); // enviando objeto

				// outObjecto.close();
				// inObjeto.close();
			} //while
		} catch (EOFException e) {
			System.out.println("El cliente ha cerrado la conexión");
		}

		// Cuando usamos un bucle para enviar objetos se recomienda utilizar reset(), se
		// ignorara el estado de cualquier objeto ya escrito
		// outObjecto.reset()
		// OutObjecto.writeObject(per);

		// CERRAR STREAMS Y SOCKETS
		cliente.close();
		servidor.close();
	}

}
