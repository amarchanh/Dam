import java.util.ArrayList;
import java.util.List;

public class SubList {

	public static void main(String[] args) {

		List<Integer> lista = new ArrayList<Integer>();
		
		lista.add(1);
		lista.add(2);
		lista.add(3);
//		lista.add(4);
//		lista.add(5);
//		lista.add(6);
//		lista.add(7);
//		lista.add(8);
//		lista.add(9);
//		lista.add(10);
		
		System.out.println("Total elementos de la lista  -- > " + lista.size());
		
		Integer porcentaje = 50;
		
		if(lista.size() <= 1) {
			System.out.println(lista);
		}
		else {
			System.out.println(lista.subList(0, (lista.size()*porcentaje/100) ));
		}
	}

}
