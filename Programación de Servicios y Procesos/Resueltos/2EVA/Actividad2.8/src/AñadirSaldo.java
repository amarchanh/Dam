
public class A�adirSaldo extends Thread {
	String usuario;
	Saldo saldo;
	int cantidad;
	
	A�adirSaldo(String usuario, Saldo saldo, int cantidad){
		this.usuario = usuario;
		this.saldo = saldo;
		this.cantidad = cantidad;
		
	}
	public void run(){
		saldo.a�adirSaldo(usuario, cantidad);
	}

}
