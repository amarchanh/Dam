package herencia;

public class Entrenador extends SeleccionFutbol {

	private String idFedereacion;
	
	public Entrenador() {
		super();
	}

	public Entrenador(int id, String nombre, String apellidos, int edad, String idFedereacion) {
		super(id, nombre, apellidos, edad);
		this.idFedereacion = idFedereacion;
	}
	
	public void dirigirPartido() {
		System.out.print("Dirige un partido \n");
	}
	
	public void dirigirEntreno() {
		System.out.print("Dirige un entrenamiento \n");
	}

	public String getIdFedereacion() {
		return idFedereacion;
	}

	public void setIdFedereacion(String idFedereacion) {
		this.idFedereacion = idFedereacion;
	}
	
}
