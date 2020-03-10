
public class usaSaldo {

	public static void main(String[] args) {

		Saldo s = new Saldo(500);
		AñadirSaldo a1 = new AñadirSaldo("Raul", s, 100);
		AñadirSaldo a2 = new AñadirSaldo("Mario", s, 200);
		AñadirSaldo a3 = new AñadirSaldo("Isma", s, 300);
		a1.start();
		a2.start();
		a3.start();
		
		
	}

}
