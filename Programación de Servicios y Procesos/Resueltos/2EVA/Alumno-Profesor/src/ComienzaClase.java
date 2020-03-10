
public class ComienzaClase {
	public static void main(String[] args) {
		Bienvenida b = new Bienvenida();
		Profesor p = new Profesor (b);
		for (int i = 0; i < 5; i++) {
			Alumno a = new Alumno(b);
			a.start();
		}
		p.start();
		
	}
}
