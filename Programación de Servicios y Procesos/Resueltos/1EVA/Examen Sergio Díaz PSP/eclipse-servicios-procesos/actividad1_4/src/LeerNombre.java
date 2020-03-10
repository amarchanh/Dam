
public class LeerNombre {
	public static void main(String[] args) {
		// Número de argmentos < 1
		if (args.length > 0) {
			System.out.println(args[0]);
			//bucle for recorriendo los argumentos
			System.exit(1);
		}
		else {
			System.exit(-1);
		}

	}
}
