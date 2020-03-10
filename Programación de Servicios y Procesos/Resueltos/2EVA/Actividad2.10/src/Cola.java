
public class Cola {

	private String cadena;
	private boolean disponible = false;
	
	public synchronized String get() {
		while(!disponible) {
			try {
				wait();
			}
			catch (InterruptedException e) {
				
			}
		}
		disponible = false;
		notify();
		return cadena;
	}
	
	public synchronized void put(String valor) {
		while(disponible) {
			try {
				wait();
			}
			catch (InterruptedException e) {
				
			}
		}
		cadena = valor;
		disponible = true;
		notify();
	}
}
