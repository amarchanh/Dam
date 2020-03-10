import java.util.Scanner;

public class MyHilo extends Thread {
	private int contador = 0;
	public boolean finHilo = false;
	private SolicitaSuspender suspender = new SolicitaSuspender();
	
	public int getContador() {
		return this.contador;
	}
	// petición de SUSPENDER HILO
	public void Suspende() {
		suspender.set(true);
	}
	// petición de CONTINUAR
	public void Reanuda() {
		suspender.set(false);
	}
	
	public void run() {
		try {
			while(!finHilo) {
				suspender.esperandoParaReanudar(); //comprobar
				contador++;
				Thread.sleep(1000);
			}
			System.out.println("Final del bucle.");
		}
		catch(InterruptedException exception) {
			exception.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		MyHilo h1 = new MyHilo();
		Scanner sc = new Scanner(System.in);
		boolean asterisco = false;
		System.out.println("Introduce una cadena.");
		String cadena = sc.nextLine();
		h1.start();
		if(cadena.equals("*")) {
			asterisco = true;
			h1.finHilo = true;
		}
		while(!asterisco) {
			System.out.println("Introduce una cadena.");
			cadena = sc.nextLine();
			
			if(cadena.equals("*")) {
				asterisco = true;
				h1.finHilo = true;
			}
			
			if(cadena.equals("S")) {
				h1.Suspende();
				System.out.println("Contador suspendido.\n");
			}
			
			if(cadena.equals("R")) {
				h1.Reanuda();
				System.out.println("Contador reanudado.\n");				
			}
		}
		System.out.println("Contador: " + h1.getContador());
		sc.close();
	}
}
