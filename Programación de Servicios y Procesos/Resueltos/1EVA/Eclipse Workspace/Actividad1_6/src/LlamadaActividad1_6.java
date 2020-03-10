import java.io.*;

public class LlamadaActividad1_6 {

	public static void main(String[] args) throws IOException {


		File directorio = new File(".\\bin");
		
		ProcessBuilder pb = new ProcessBuilder("java", "Actividad1_6");
		pb.directory(directorio);
		
		Process p = pb.start();
		
		// escritura - se envía la entrada
		OutputStream os = p.getOutputStream();
		os.write("\n".getBytes());
		os.write("\n".getBytes());
		os.flush();
		
		try {
			InputStream is = p.getInputStream();
			int c;
			while ((c = is.read()) != -1)
				System.out.print((char) c);
			is.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
