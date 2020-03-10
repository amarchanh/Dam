import java.util.Scanner;

public class Ejercicio7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a="";
		//Mientras (a) no contenga un *
		while(!a.contains("*")) {
			System.out.print("Introduce una cadena: ");
			a = sc.nextLine(); //lee cadena
			System.out.print(a+"\n"); //muestra lo que ha leido
		}
		System.out.println("Programa finalizado");
	}
}
