
public class Bienvenida {

	private boolean disponible = false;
	
	
	public synchronized void saludarProfesor() {
		while(!disponible) {
			try {
				wait();
			}
			catch (InterruptedException e) {
				
			}
		}
		notify();
		System.out.println("Buenos díaz profesor");
	}
	
	public synchronized void llegadaProfesor() {
		while(disponible) {
			try {
				wait();
			}
			catch (InterruptedException e) {
				
			}
		}
		disponible = true;
		notify();
		System.out.println("Ramón Ramírez llegó");
	}
	
	public synchronized void llegadaAlumno() {
		System.out.println("Alumno llegó");
	}
	
	
	
}
