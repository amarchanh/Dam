import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPObjectoCliente1 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		System.out.println("PROGRAM CLIENTE INICIADO...");
		
		String Host = "localhost";
		int Puerto = 6000; // Puerto remoto

		try {
			Socket cliente = new Socket(Host, Puerto);

			Scanner sc = new Scanner(System.in);
			int numero = 1;

			while (numero > 0) {
				System.out.println("Introduce un número:");
				numero = sc.nextInt();
				// Creo el objeto de tipo Numeros
				Numeros num = new Numeros(numero, 0, 0);

				// FLUJO DE salida para objetos
				ObjectOutputStream numSal = new ObjectOutputStream(cliente.getOutputStream());

				// Se envía el objeto
				numSal.writeObject(num);
				System.out.println("Envio: " + num.getNumero() + "," + num.getCuadrado() + "," + num.getCubo());

				// Flujo de entrada para objetos
				ObjectInputStream perEnt = new ObjectInputStream(cliente.getInputStream());

				// Se recibe un objeto
				Numeros dato = (Numeros) perEnt.readObject();
				System.out.println("Recibo: " + dato.getNumero() + "," + dato.getCuadrado() + "," + dato.getCubo());

				// perEnt.close();
				// numSal.close();
			}
			System.out.println("Cerrando conexión...");
			cliente.close();
		} catch (ConnectException e) {
			System.out.println("El servidor no está conectado.");
		}
	}

}
