package actividad3_7;

public class Numeros3_7 {
	int numero;
	long cuadrado;
	long cubo;
	
	public Numeros3_7(){
		numero = 0;
		cuadrado = 0;
		cubo = 0;
	}

	public Numeros3_7(int numero, long cuadrado, long cubo) {
		super();
		this.numero = numero;
		this.cuadrado = cuadrado;
		this.cubo = cubo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public long getCuadrado() {
		return cuadrado;
	}

	public void setCuadrado(long cuadrado) {
		this.cuadrado = cuadrado;
	}

	public long getCubo() {
		return cubo;
	}

	public void setCubo(long cubo) {
		this.cubo = cubo;
	}
	
	
	
	
}
