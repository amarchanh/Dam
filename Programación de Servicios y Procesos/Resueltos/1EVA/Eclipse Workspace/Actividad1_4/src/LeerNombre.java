
public class LeerNombre {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if (args.length > 0) {
			for (int i = 0; i < args.length; i++) {
				System.out.print(" " + args[i]);
			}
			System.out.println("El sistema devuelve 1");
			System.exit(1);
		} else {
			System.out.println("El sistema devuelve -1");
			System.exit(-1);
		}
	}

}
