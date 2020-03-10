import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class Actividad7_llamada {

	public static int continuar() {
		Scanner sc = new Scanner(System.in);
		int h;
		System.out.println("Continuar??");
		h = sc.nextInt();
		return h;
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {

		File directorio = new File(".\\bin");

		ProcessBuilder pb = new ProcessBuilder("java", "Actividad7");
		pb.directory(directorio);

		Process p = pb.start();
		
		OutputStream os = p.getOutputStream();
		String g = "";
		int k = continuar();
		while(k!=1) { // g != *
			System.out.println("Cadena??");
			Scanner sch = new Scanner(System.in);
			g = sch.nextLine();
			g = g+"\n";
			os.write(g.getBytes());
			os.flush();
			System.out.println("Seguir? (0 para parar, 1 para continuar.)");
			k=continuar();
		}//while
			
		/*os.write(("jaimito\n").getBytes());
		os.write(("juanito\n").getBytes());
		os.write(("jorgito\n").getBytes());
		os.write(("*\n").getBytes());
		os.flush();*/
		
		try {
			InputStream is = p.getInputStream();
			int c;
			while ((c = is.read()) != -1)
				System.out.print((char) c);
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
