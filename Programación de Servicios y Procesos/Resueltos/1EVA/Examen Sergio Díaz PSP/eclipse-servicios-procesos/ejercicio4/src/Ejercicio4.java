
public class Ejercicio4 {
	public static void main(String[] args) {
		// Número de argmentos < 1
		if (args.length < 1) {
			System.out.println(1 +" - número de argumentos es < 1.");
			System.exit(1);
		}
		// El argumento es una cadena
		else if (args.length > 1) {
			System.out.println(2+" - el argumento es una cadena (multiples argumentos).");
			System.exit(2);
		}
		// Si el argumento es un número entero menor que 0
		else if (esEntero(args[0])) { // Si es un num entero
			if (Integer.parseInt(args[0]) < 0) { // si es menor que 0
				System.out.println(3+" - el argumento es un entero menor que 0.");
				System.exit(3);
			}
		} else {
			System.out.println(0+" - otra situación");
			System.exit(0);
		}

	}
	
	//Comprueba si es un entero
	public static boolean esEntero(String num) {
		try {
			int a = Integer.parseInt(num);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
