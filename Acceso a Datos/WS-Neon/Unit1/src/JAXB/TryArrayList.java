package JAXB;

import java.util.ArrayList;
import java.util.List;

public class TryArrayList {

	public static void main(String[] args) {
		// Creamos una lista sin tamaño definido
		List<Jugador> lj = new ArrayList<Jugador>();
		
		// Creamos un objeto jugador
		Jugador j = new Jugador(17, "Pepe");
		lj.add(j);
		
		j = new Jugador(23, "Gasol");
		lj.add(j);
		
		j = new Jugador(5, "Ana");
		lj.add(j);
		
		System.out.println("Mostramos los datos de la lista");
		
		for(Jugador jugador : lj) {
			jugador.verDatos();
		}
		
		lj.remove(1);
		//lj.subList(1, lj.size()-1);
		
		System.out.println("Mostramos los datos de la lista después de borrar un jugador");
		for(Jugador jugador : lj) {
			jugador.verDatos();
		}
		
		
	}

}
