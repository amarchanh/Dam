package herencia;

public class Futbolista extends SeleccionFutbol {

	private Integer dorsal;
	private String demarcacion;
	
	public Futbolista() {
		super();
	}

	public Futbolista(int id, String nombre, String apellidos, int edad, int dorsal, String demarcacion) {
		super(id, nombre, apellidos, edad);
		this.dorsal = dorsal;
		this.demarcacion = demarcacion;
	}
	
	public void jugarPartido() {
		System.out.print("Juega un partido \n");
	}
	
	public void entrenar() {
		System.out.print("Entrena \n");
	}

	public Integer getDorsal() {
		return dorsal;
	}

	public void setDorsal(Integer dorsal) {
		this.dorsal = dorsal;
	}

	public String getDemarcacion() {
		return demarcacion;
	}

	public void setDemarcacion(String demarcacion) {
		this.demarcacion = demarcacion;
	}
	
	
}
