
public class usaSaldo {

	public static void main(String[] args) {

		Saldo s = new Saldo(500);
		A�adirSaldo a1 = new A�adirSaldo("Raul", s, 100);
		A�adirSaldo a2 = new A�adirSaldo("Mario", s, 200);
		A�adirSaldo a3 = new A�adirSaldo("Isma", s, 300);
		a1.start();
		a2.start();
		a3.start();
		
		
	}

}
