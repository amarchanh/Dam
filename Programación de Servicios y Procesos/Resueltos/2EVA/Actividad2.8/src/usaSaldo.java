
public class usaSaldo {

	public static void main(String[] args) {

		Saldo s = new Saldo(500);
		AņadirSaldo a1 = new AņadirSaldo("Raul", s, 100);
		AņadirSaldo a2 = new AņadirSaldo("Mario", s, 200);
		AņadirSaldo a3 = new AņadirSaldo("Isma", s, 300);
		a1.start();
		a2.start();
		a3.start();
		
		
	}

}
