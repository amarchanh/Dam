package herencia;

import java.util.ArrayList;

public class Main {

	// ArrayList de objetos SeleccionFutbol. Idenpendientemente de la clase hija a la que pertenezca el objeto
	public static ArrayList<SeleccionFutbol> integrantes = new ArrayList<SeleccionFutbol>();

	public static void main(String[] args) {



			Entrenador delBosque = new Entrenador(1, "Vicente", "Del Bosque", 60, "284EZ89");
			Futbolista iniesta = new Futbolista(2, "Andres", "Iniesta", 29, 6, "Interior Derecho");
			Masajista raulMartinez = new Masajista(3, "Ra�l", "Martinez", 41, "Licenciado en Fisioterapia", 18);

			integrantes.add(delBosque);
			integrantes.add(iniesta);
			integrantes.add(raulMartinez);

			// CONCENTRACION
			System.out.println("Todos los integrantes comienzan una concentracion. (Todos ejecutan el mismo m�todo)");
			for (SeleccionFutbol integrante : integrantes) {
				System.out.print(integrante.getNombre()+" "+integrante.getApellidos()+" -> ");
				integrante.concentrarse();
			}

			// VIAJE
			System.out.println("nTodos los integrantes viajan para jugar un partido. (Todos ejecutan el mismo m�todo)");
			for (SeleccionFutbol integrante : integrantes) {
				System.out.print(integrante.getNombre()+" "+integrante.getApellidos()+" -> ");
				integrante.viajar();
			}
		
			// ENTRENAMIENTO
			System.out.println("nEntrenamiento: Solamente el entrenador y el futbolista tiene metodos para entrenar:");
			System.out.print(delBosque.getNombre()+" "+delBosque.getApellidos()+" -> ");
			delBosque.dirigirEntreno();
			System.out.print(iniesta.getNombre()+" "+iniesta.getApellidos()+" -> ");
			iniesta.entrenar();

			// MASAJE
			System.out.println("nMasaje: Solo el masajista tiene el m�todo para dar un masaje:");
			System.out.print(raulMartinez.getNombre()+" "+raulMartinez.getApellidos()+" -> ");
			raulMartinez.darMasaje();

			// PARTIDO DE FUTBOL
			System.out.println("nPartido de F�tbol: Solamente el entrenador y el futbolista tiene metodos para el partido de f�tbol:");
			System.out.print(delBosque.getNombre()+" "+delBosque.getApellidos()+" -> ");
			delBosque.dirigirPartido();
			System.out.print(iniesta.getNombre()+" "+iniesta.getApellidos()+" -> ");
			iniesta.jugarPartido();
			
	}

}
