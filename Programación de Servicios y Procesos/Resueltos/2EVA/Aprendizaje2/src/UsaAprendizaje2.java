
public class UsaAprendizaje2 {

	public static void main(String[] args) {
		/*for(int i = 0; i < 5; i++) {
			Aprendizaje2 a = new Aprendizaje2("Adios Mundo.");
			new Thread(a).start();			
		}*/
		System.out.println("Cargando");
		Aprendizaje2 a1 = new Aprendizaje2("Adios Mundo.");
		Aprendizaje2 a2 = new Aprendizaje2("Adios Mundo.");
		Aprendizaje2 a3 = new Aprendizaje2("Adios Mundo.");
		Aprendizaje2 a4 = new Aprendizaje2("Adios Mundo.");
		Aprendizaje2 a5 = new Aprendizaje2("Adios Mundo.");
		new Thread(a1).start();	
		new Thread(a2).start();	
		new Thread(a3).start();	
		new Thread(a4).start();	
		new Thread(a5).start();	
	}

}
