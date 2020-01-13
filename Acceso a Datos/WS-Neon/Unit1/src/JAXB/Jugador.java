package JAXB;

public class Jugador {

	String nombre;
	int dorsal;
	int puntos;
	int faltas;
	boolean expulsado;
	
	Jugador (int dorsal, String nombre) {
		this.dorsal = dorsal;
		this.nombre = nombre;
		puntos = 0;
		faltas = 0;
		expulsado = false;
	}
	
	void anotar(int n) {
		puntos += n;
	}
	
	void cometerFalta() {
		if (faltas == 5) {
			System.out.println("El jugador " +nombre+ " ya está expulsado;");
		}
		else {
			faltas++;
			if(faltas == 5) {
				System.out.println("Jugador "+nombre+" expulsado por 5 faltas.");
				expulsado = true;
			}
		}
		
	}
	
	void verDatos() {
		String expul;
		if(expulsado) {
			expul = "expulsado";
		}
		else {
			expul = "no expulsado";
		}
		
		System.out.println(nombre+", "+dorsal+", "+puntos+", "+faltas+", "+expul);
	}
}
