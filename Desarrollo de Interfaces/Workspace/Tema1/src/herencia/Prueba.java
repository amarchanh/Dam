package herencia;

public class Prueba {

	public static void main(String[] args) {

		
		for (int i = 0; i<2; i++) {
			try {
				System.out.println("Inicio");
				break;
			}
			catch (Exception e) {
				System.out.println("Exception");
			}
			finally {
				System.out.println("Finally");
			}
		}
	}

}
