package polimorfismo2;

public class Entrenador extends SeleccionFutbol {

	private int idFederacion;

	
	
	// constructor, getter y setter

	public Entrenador() {
		super();
	}

	public Entrenador(int id, String nombre, String apellidos, int edad, int idFederacion) {
		super(id, nombre, apellidos, edad);
		this.idFederacion = idFederacion;
	}
	

	@Override
	public void partidoFutbol() {
		System.out.println("Dirige un Partido (Clase Entrenador)");
	}

	public void planificarEntrenamiento() {
		System.out.println("Planificar un Entrenamiento");
	}

	@Override
	public void entrenar() {
		System.out.println("Dirige el entrenamiento (Clase Entrenador)");
		
	}

	@Override
	public void jugarPartido() {
		System.out.println("Dirige el partido (Clase Entrenador)");
		
	}
}
