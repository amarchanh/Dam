import java.io.*;

public class Ejemplo4 {
	public static void main(String[] args) throws IOException {
		Process p = new ProcessBuilder("CMD","/C","DATE").start();
		// escritura -- envia entrada a DATE
		OutputStream os = p.getOutputStream();
		os.write("15-06-18".getBytes());
		os.flush(); //vacía el buffer de salida
		
		//lectura -- obtiene la salida de DATE
		InputStream is = p.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is)); // buffer almacena temporalmente
		String linea;
		while ((linea = br.readLine()) != null) { // lee una linea
			System.out.println(linea);
		}
		
		//COMPROBACION DE ERROR - 0 bien - 1 mal
		int exitVal;
		try {
			exitVal = p.waitFor(); //recoge lo que System.exit() devuelve
			System.out.println("Valor de salida: " + exitVal);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//Muestra el error
		try {
			InputStream er = p.getErrorStream();
			BufferedReader brer = new BufferedReader(new InputStreamReader(er));
			String liner = null;
			while ((liner = brer.readLine()) != null) {
				System.out.println("ERROR >" + liner);
			}
		} 
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
