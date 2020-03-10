
public class HiloCadena extends Thread {
	private ObjetoCompartido objeto;
	String cad;
	
	public HiloCadena (ObjetoCompartido c, String s) {
		this.objeto = c;
		this.cad = s;
	}
	
	public void run(){
		synchronized (objeto) {
			for (int j= 0; j < 10; j++) {
				objeto.PintaCadena(cad);
				objeto.notify(); //aviso que ya he usado el objeto
				try{
					objeto.wait(); //esperar que llegue un notify
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}	
			
			objeto.notify();
		}
		
		System.out.print("\n" + cad + " finalizado");
	}
}
