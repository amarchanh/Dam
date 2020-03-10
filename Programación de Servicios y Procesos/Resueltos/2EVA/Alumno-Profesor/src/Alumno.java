
public class Alumno extends Thread{
	Bienvenida b;
	
	Alumno(Bienvenida b){
		this.b = b;
	}
	
	public synchronized void run() {
		b.llegadaAlumno();
		b.saludarProfesor();
		
	}
	
}
