
public class Profesor extends Thread {
	Bienvenida b;
	
	Profesor(Bienvenida b){
		this.b = b;
	}
	
	public synchronized void run() {
		b.llegadaProfesor();
	}
}
