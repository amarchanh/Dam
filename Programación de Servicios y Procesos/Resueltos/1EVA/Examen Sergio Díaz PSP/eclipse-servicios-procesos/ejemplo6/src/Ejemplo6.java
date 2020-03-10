import java.io.*;
import java.util.*;

public class Ejemplo6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProcessBuilder test = new ProcessBuilder();
		Map entorno = test.environment();
		System.out.println("Variables de entorno: ");
		System.out.println(entorno);
		
		test = new ProcessBuilder("java","LeerNombre","Maria Jesús");
		
		//devueve el nombre del proceso y sus argumentos
		List l = test.command();
		Iterator iter = l.iterator();
		System.out.println("\nArgumentos del comando:");
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		test = test.command("CMD","/C","DIR");
		try {
			Process p = test.start(); //se ejecuta DIR
			InputStream is = p.getInputStream();
			
			System.out.println();
			
			int c;
			while((c= is.read()) != -1){
				System.out.print((char) c);
			}
			is.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
