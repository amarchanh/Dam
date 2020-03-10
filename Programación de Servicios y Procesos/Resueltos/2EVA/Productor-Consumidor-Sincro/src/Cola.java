
public class Cola {

	private int numero;
	private boolean disponible = false;
	
	public synchronized int get() {
		while(!disponible) {
			try {
				wait();
			}
			catch (InterruptedException e) {
				
			}
		}
		disponible = false;
		notify();
		System.out.println("Consumidor: " + numero );
		return numero;
	}
	
	public synchronized void put(int valor) {
		while(disponible) {
			try {
				wait();
			}
			catch (InterruptedException e) {
				
			}
		}
		numero = valor;
		disponible = true;
		System.out.println("Productor: " + numero );
		notify();
	}
}
