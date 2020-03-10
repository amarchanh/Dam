
public class Aprendizaje2 implements Runnable {

	private String cadena;
	
	Aprendizaje2(String cadena){
		this.cadena = cadena;
	}
	
	public void run() {
		
		try {
			Thread.sleep(Thread.currentThread().getId()*30);
			System.out.println("Hola mundo. " + this.cadena + " -> " + Thread.currentThread().getId());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
