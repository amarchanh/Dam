package actividad2_4modificada;

public class solicitasuspenderI {
	
	public boolean suspender = false;
	
	public synchronized void set(boolean b) {
		suspender = b;
		notifyAll();
	}
	
	public synchronized void esperandoreanudar() 
			throws InterruptedException{
		while(suspender) {
			wait();
		}
	}

}
