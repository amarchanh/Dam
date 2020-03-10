import java.io.IOException;

public class Ejemplo9 {
	public static void main(String[] args) throws IOException{
		ProcessBuilder pb = new ProcessBuilder("CMD","/C","DIR");
		pb.redirectOutput(ProcessBuilder.Redirect.INHERIT); //coge la entrada del proceso actual
		Process p = pb.start();
	}
}
