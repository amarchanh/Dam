
public class Aprendizaje1 extends Thread {

	public void run() {
		System.out.println("Hola mundo. " + getName() + " ID " + getId());
	}

	public static void main(String[] args) {
		for (int i = 1; i<=5 ;i++) {
			Aprendizaje1 a = new Aprendizaje1();
			a.setName("hilo " + i);
			a.start();
		}
		
		/*Aprendizaje1 h1 = new Aprendizaje1();
		h1.setName("hilo 1");
		Aprendizaje1 h2 = new Aprendizaje1();
		h2.setName("hilo 2");
		Aprendizaje1 h3 = new Aprendizaje1();
		h3.setName("hilo 3");
		Aprendizaje1 h4 = new Aprendizaje1();
		h4.setName("hilo 4");
		Aprendizaje1 h5 = new Aprendizaje1();
		h5.setName("hilo 5");

		h1.start();
		h2.start();
		h3.start();
		h4.start();
		h5.start();*/

	}

}
