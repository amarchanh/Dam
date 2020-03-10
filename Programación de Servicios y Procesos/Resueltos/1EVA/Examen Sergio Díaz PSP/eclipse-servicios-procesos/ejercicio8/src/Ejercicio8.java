import java.util.Scanner;

public class Ejercicio8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Dime un n�mero: ");
		String a = sc.nextLine();
		
		if(a.length()>0) {
			String aInvertido=""; //si a contiene 123, aInvertido tendr� 321
			for(int i=0;i<a.length();i++) {
				//a�ade valores al principio, el �ltimo valor de a, ser� el primero de aInvertido
				aInvertido=a.charAt(i)+aInvertido;
			}
			
			//Si a es igual aInvertido, es pal�ndromo
			if(a.equals(aInvertido)) {
				System.out.println(a+" es pal�ndromo");
			}
			else{
				System.out.println(a+ " no es pal�ndromo");
			}
		}
		else {
			System.out.println("La longitud es 0");
		}
	}
}
