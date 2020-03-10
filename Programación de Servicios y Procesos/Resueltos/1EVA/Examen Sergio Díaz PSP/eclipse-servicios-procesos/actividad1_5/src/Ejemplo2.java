
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejemplo2 {

	public static void main(String[] args) throws IOException {

		Process p = new ProcessBuilder("CMD", "/C", "DIR").start(); // /C para que se cierre

		try {
			InputStream is = p.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is)); // buffer almacena temporalmente
			String linea;
			while ((linea = br.readLine()) != null) { // lee una linea
				System.out.println(linea);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		int exitVal;
		try {
			exitVal = p.waitFor(); //recoge lo que System.exit() devuelve
			System.out.println("Valor de salida: " + exitVal);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
