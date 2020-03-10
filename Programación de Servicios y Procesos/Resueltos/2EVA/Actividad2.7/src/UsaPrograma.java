
public class UsaPrograma {

	public static void main(String[] args) {
		Contador cont = new Contador(0);
		Hilo a = new Hilo("HiloA", cont);
		Hilo b = new Hilo("HiloB", cont);
		Hilo c = new Hilo("HiloC", cont);
		Hilo d = new Hilo("HiloD", cont);
		Hilo e = new Hilo("HiloE", cont);
		a.start();
		b.start();
		c.start();
		d.start();
		e.start();

	}

}
