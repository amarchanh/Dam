package actividad2_4;

public class myhilo extends Thread {

	private solicitasuspender metodosuspender = new solicitasuspender();
	public int contador = 0;

	public void suspende() {
		metodosuspender.set(true);
	}

	public void reanuda() {
		metodosuspender.set(false);
	}

	public void mostrar() {
		System.out.println(contador);
	}

	Thread.State state = Thread.currentThread().getState();

	public void run() {
		try {
			while (state.toString() != "WAITING") {
				contador++;
				System.out.println("Contador = " + contador);
				sleep(1000);
				metodosuspender.esperandoparareanudar();
			} // while
			System.out.println("Valor del contador final" + contador);
		} catch (InterruptedException exception) {
		}
	}

}
