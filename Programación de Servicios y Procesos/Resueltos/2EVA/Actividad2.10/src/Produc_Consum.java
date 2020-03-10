
public class Produc_Consum {

	public static void main(String[] args) {
		Cola cola = new Cola();
		Productor p = new Productor(cola, "1");
		Consumidor c1 = new Consumidor(cola, "1");
		p.start();
		c1.start();
	}

}
