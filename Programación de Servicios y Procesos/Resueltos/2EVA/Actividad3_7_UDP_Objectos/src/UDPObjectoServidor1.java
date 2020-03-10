import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class UDPObjectoServidor1 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		System.out.println("PROGRAMA SERVIDOR INICIADO...");
		InetAddress destino = InetAddress.getLocalHost();
		int port = 12345; //Mi puerto donde escucharé

		// ASOCIO EL SOCKET EL PUERTO 12345
		DatagramSocket socket = new DatagramSocket(port);

		byte[] recibidos = new byte[1024];

		// DATAGRAMA QUE CONTENDRÁ LO QUE NOS ENVÍE EL CLIENTE
		DatagramPacket recibo = new DatagramPacket(recibidos, recibidos.length);
		
		
		Numeros numRecibido = new Numeros(1,0,0);
		
		while(numRecibido.getNumero()>0) {
			// ESPERANDO DATAGRAMA DEL CLIENTE
			socket.receive(recibo); // RECIBO el datagrama	
			
			// CONVERTIMOS BYTES A OBJETO
			ByteArrayInputStream bais = new ByteArrayInputStream(recibo.getData());
			ObjectInputStream in = new ObjectInputStream(bais);
			numRecibido = (Numeros) in.readObject();// obtengo objeto
			
			System.out.println("Recibo: "+numRecibido.getNumero()+","+numRecibido.getCuadrado()+","+numRecibido.getCubo());

			
			//MODIFICO EL OBJETO NUMEROS
			numRecibido.setCuadrado(numRecibido.getNumero()*numRecibido.getNumero());
			numRecibido.setCubo(numRecibido.getNumero()*numRecibido.getNumero()*numRecibido.getNumero());
			
			System.out.println("Envío: "+numRecibido.getNumero()+","+numRecibido.getCuadrado()+","+numRecibido.getCubo());
			
			//CONVERTIMOS OBJETO A BYTES
			ByteArrayOutputStream bs = new ByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(bs);
			out.writeObject(numRecibido); //Escribir objeto Persona en el stream
			out.close(); //cerrar stream
			byte[] bytesPersona = bs.toByteArray();//objeto en bytes
			
			//DATAGRAMA CON EL OBJETO MODIFICADO EN BYTES
			DatagramPacket enviar = new DatagramPacket(bytesPersona, bytesPersona.length, recibo.getAddress(), recibo.getPort());
			//ENVÍO EL DATAGRAMA AL CLIENTE
			socket.send(enviar);
		}
		System.out.println("Deteniendo servidor...");
		socket.close();
	}

}
