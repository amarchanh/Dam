
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.omg.CORBA.portable.OutputStream;

public class EjemploLectura {
	public static void main(String[] srgs) throws IOException{
		
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		String texto;
		try {
			System.out.println("Introduce una cadena...");
			texto = br.readLine();
			System.out.println("Cadena escrita: "+texto);
			//Segunda cadena escrita...
			in.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}