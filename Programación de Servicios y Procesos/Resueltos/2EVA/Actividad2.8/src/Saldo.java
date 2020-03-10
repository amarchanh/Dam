
public class Saldo extends Thread {

	private int saldo;
	
	Saldo(int saldo){
		this.saldo = saldo;
	}

	public int getSaldo() {
		try {
			sleep((long)Math.random()* 100);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
		try {
			sleep((long)Math.random()* 100);
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public synchronized void añadirSaldo(String usuario, int cantidad) {
		System.out.println("Va a sacar saldo el usuario: " + usuario);
		System.out.println("Cantidad inicial de saldo: " + getSaldo() + "€");
		System.out.println("Se va a añadir la cantidad de: " + cantidad + "€");
		int saldoFinal = getSaldo() + cantidad;
		System.out.println("El saldo final es: " + saldoFinal + "€");
		setSaldo(saldoFinal);
	}
	
	
}
