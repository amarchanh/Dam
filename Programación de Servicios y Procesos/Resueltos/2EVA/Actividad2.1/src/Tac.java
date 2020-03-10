
public class Tac extends Thread {
	public void run() {
		try {
			while(true) {
			System.out.println("TAC");
			Thread.sleep(500);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
