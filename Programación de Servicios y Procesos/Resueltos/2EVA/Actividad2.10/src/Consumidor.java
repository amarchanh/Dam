
public class Consumidor extends Thread{

	private Cola cola;
	private String cadena;
	
	public Consumidor(Cola c, String n) {
		cola = c;
		this.cadena = n;
	}
	
	public void run() {
		String valor = "";
		for (int i= 0; i < 20; i++) {
			valor = cola.get();
			try {
				sleep (100);
				System.out.print(valor + " ");
			}
			catch (InterruptedException e) {
				
			}
		}
	}
}
