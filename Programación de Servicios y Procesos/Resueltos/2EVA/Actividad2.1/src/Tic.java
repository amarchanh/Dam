
public class Tic extends Thread{
	public void run() {
		try {
			while(true) {
				System.out.println("TIC");
				Thread.sleep(500);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
