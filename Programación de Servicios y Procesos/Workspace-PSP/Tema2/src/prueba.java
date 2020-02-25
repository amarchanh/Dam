import ejerciciosResueltos.HiloEjemplo2;

public class prueba extends Thread {

	public void run () {
		System.out.println("Dentro del Hilo:" +this.getName() + ", Prioridad: " + this.getPriority()
		+ ", ID: " +this.getId());
		
	}
	
	public static void main(String [] args) {
		HiloEjemplo2 h = null;
		for (int i = 0; i < 3 ; i++) {
			h = new HiloEjemplo2(); // crear hilo
			h.setName("Hilo "+i); // Damos un nombre al hilo
			h.setPriority(i+1); // Damos una prioridad al hilo
			h.start(); // iniciamos el hilo
			System.out.println("Información del " + h.getName() +": " + h.toString());
		}
	}
	
}
