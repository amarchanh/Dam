
public class AņadirSaldo extends Thread {
	String usuario;
	Saldo saldo;
	int cantidad;
	
	AņadirSaldo(String usuario, Saldo saldo, int cantidad){
		this.usuario = usuario;
		this.saldo = saldo;
		this.cantidad = cantidad;
		
	}
	public void run(){
		saldo.aņadirSaldo(usuario, cantidad);
	}

}
