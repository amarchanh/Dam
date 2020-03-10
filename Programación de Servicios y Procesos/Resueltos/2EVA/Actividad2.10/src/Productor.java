
public class Productor extends Thread {
	private Cola cola;
	private String n;
	
	public Productor(Cola c, String n) {
		cola = c;
		this.n = n;
	}
	
	public void run() {
		for (int i = 0; i < 20; i++) {
			if(i%2==0) {
				cola.put("PING");
				
			}
			else {
				cola.put("PONG");
			}
			try {
				sleep (100);
			}
			catch (InterruptedException e) {
				
			}
		} 
	}

}
