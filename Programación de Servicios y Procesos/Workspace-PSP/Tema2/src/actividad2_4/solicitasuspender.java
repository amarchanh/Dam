package actividad2_4;

public class solicitasuspender {

	private boolean suspender;

	public synchronized void set(boolean b) {
		suspender = b;
		notifyAll();
	}

	public synchronized void esperandoparareanudar() throws InterruptedException {
		while (suspender)
			wait();
	}

}
