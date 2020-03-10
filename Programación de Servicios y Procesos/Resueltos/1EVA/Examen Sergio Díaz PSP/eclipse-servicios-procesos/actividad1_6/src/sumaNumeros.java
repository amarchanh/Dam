import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sumaNumeros {

	public static void main(String[] args) throws IOException {
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		
		boolean aValido = false;
		boolean bValido = false;
		
		int a=0;
		while(!aValido) {
			try {
				a = Integer.parseInt(br.readLine());
				aValido = true;
			}
			catch(Exception e) {
				System.out.println("Número \"a\" no válido");
			}
			
		}
		
		int b=0;
		while(!bValido) {
			try {
				b = Integer.parseInt(br.readLine());
				bValido = true;
			}
			catch(Exception e) {
				System.out.println("Número \"b\" no válido");
			}
		}
		in.close();
		
		System.out.println("La suma es: "+ (a+b));
	}

}
