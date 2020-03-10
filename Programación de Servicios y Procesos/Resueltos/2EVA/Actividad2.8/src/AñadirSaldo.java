
public class AñadirSaldo extends Thread {
	String usuario;
	Saldo saldo;
	int cantidad;
	
	AñadirSaldo(String usuario, Saldo saldo, int cantidad){
		this.usuario = usuario;
		this.saldo = saldo;
		this.cantidad = cantidad;
		
	}
	public void run(){
		saldo.añadirSaldo(usuario, cantidad);
	}

}
