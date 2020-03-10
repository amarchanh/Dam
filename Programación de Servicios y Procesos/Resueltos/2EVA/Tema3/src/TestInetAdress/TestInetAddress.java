package TestInetAdress;

import java.net.*;
public class TestInetAddress {

	public static void main(String[] args) {
		InetAddress dir = null;
		System.out.println("================================");
		System.out.println("SALIDA PARA LOCALHOST: ");
		try {
			//LOCALHOST
			dir = InetAddress.getByName("localhost");
			pruebaMetodos(dir);
			
			//URL www.google.es
			System.out.println("=============================");
			System.out.println("SALIDA PARA UN URL:");
			dir = InetAddress.getByName("www.google.es");
			pruebaMetodos(dir);
			
			//Array de tipo InetAddress con todas las direcciones IP asignadas a google.es
			System.out.println("\t DIRRECCIONES IP PARA: " + dir.getHostName());
			InetAddress[] direcciones = InetAddress.getAllByName(dir.getHostName());
			for (int i = 0; i < direcciones.length; i++) {
				System.out.println("\t\t" + direcciones[i].toString());
			}
			System.out.println("================================");
		}
		catch(UnknownHostException e) {
			e.printStackTrace();
		}
	}
		
	private static void pruebaMetodos(InetAddress dir) {
		System.out.println("\t Metodo getByName(): " + dir);
		InetAddress dir2;
		try {
			dir2 = InetAddress.getLocalHost();
			System.out.println("\t Metodo getLocalHost(): " + dir2);
		}
		catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		//USAMOS MÉTODOS DE LA CLASE
		System.out.println("\t Metodo getHostName(): " + dir.getHostName());
		System.out.println("\t Metoddo getHostAddress(): " + dir.getHostAddress());
		System.out.println("\t Metodo toString(): " + dir.toString());
		System.out.println("\t Metodo getCanonicalHostName(): " + dir.getCanonicalHostName());
	}//pruebaMetodos
		
		

}
