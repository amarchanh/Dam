
public class Aprendizaje1 implements Runnable {

	public void run() {
		System.out.println("Hola mundo. " + Thread.currentThread().getName() + " ID " + Thread.currentThread().getId());
	}

	public static void main(String[] args) {
		for (int i = 1; i <= 5; i++) {
			Aprendizaje1 a = new Aprendizaje1();
			Thread hilo = new Thread(a);
			hilo.setName("hilo " + i);
			hilo.start();
		}

	}

}
