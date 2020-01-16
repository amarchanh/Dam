package herencia;

public class Masajista extends SeleccionFutbol {

	private String titulacion;
	private Integer aniosExperiencia;
	
	public Masajista() {
		super();
	}

	public Masajista(int id, String nombre, String apellidos, Integer edad, String titulacion, Integer aniosExperiencia) {
		super(id, nombre, apellidos, edad);
		this.titulacion = titulacion;
		this.aniosExperiencia = aniosExperiencia;
	}
	
	public void darMasaje() {
		System.out.print("Da un masaje \n");
	}


	public String getTitulacion() {
		return titulacion;
	}


	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}


	public Integer getAniosExperiencia() {
		return aniosExperiencia;
	}


	public void setAniosExperiencia(Integer aniosExperiencia) {
		this.aniosExperiencia = aniosExperiencia;
	}
	
	
	
	
}
