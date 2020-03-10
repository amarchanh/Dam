package actividad2_4modificada;

public class myhiloI extends Thread{
	
	private solicitasuspenderI objetosuspender = new solicitasuspenderI();
	public int contador = 0;
	public boolean stophilo = false;
	public void suspende() {objetosuspender.set(true);}
	public void reanuda() {objetosuspender.set(false);}
	
	public void matarhilo() {
		stophilo = true;
		System.out.println("El valor final del contador es: " + contador);
	}
	
	public void mostrarcontador() {
		System.out.println("Contador" + contador);
	};
	
	public void run() {
		while(!stophilo) {
			mostrarcontador();
			try {
				sleep(1000);
				objetosuspender.esperandoreanudar();
			} catch (InterruptedException e) {}
			contador ++;
		}//while
		//System.out.println(Thread.currentThread().getState());
		
	}//run

}
