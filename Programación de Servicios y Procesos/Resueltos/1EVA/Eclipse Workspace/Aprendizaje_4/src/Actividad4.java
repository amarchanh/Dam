public class Actividad4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if (args.length < 1) {
			System.out.println("Salida 1");
			System.exit(1);
		} else {
			if (esNumerico(args[0]) && Integer.parseInt(args[0]) < 0) {
				System.out.println("Salida 3");
				System.exit(3);
			} else {
				if (args[0] == args[0].toString()) {
					System.out.println("Salida 2");
					System.exit(2);
				} else {
					System.out.println("Salida 0");
					System.exit(0);
				}
			}
		}

	}

	public static boolean esNumerico(String numero) {
		try {
			Integer.parseInt(numero);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
