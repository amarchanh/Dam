using System;
using System.Collections.Generic;
using NotasConsola.CapaNegocio;
using NotasConsola.CapaDatos;

namespace NotasConsola {
	class Program {
		static void Main(string[] args) {

			/** Bandera que indica que se ha seleccionado la opción salir. */
			bool fin = false;

			/** Inicializa el identificador de la nota. */
			int id;

			/** Indica si el identificador es un número válido. */
			bool resultado;

			/** Colección de tipo Lista para almacenar objetos de tipo Nota. */
			List<Nota> notas = new List<Nota>();

			/** Crea un objeto de tipo Archivo. */
			Archivo archivo = new Archivo();
			
			/** Inicializa la lista con las notas almacenadas en el archivo. */
			foreach (string linea in archivo.LeeArchivo()) {
				/** Almacena la lineas dividida por ;. */
				string[] lineaDividida = linea.Split(";");
				/** Instancia un objeto de la clase Nota e inicializa sus propiedades. */
				Nota nota = new Nota {
					Texto = lineaDividida[0],
					Fecha = DateTime.Parse(lineaDividida[1])
				};
				/** Añade un objeto de tipo Nota a la lista notas. */
				notas.Add(nota);
			}

			/** Mientras no se pulse s... */
			while (!fin) {
				/** Muestra el menú al usuario. */
				Console.WriteLine();
				Console.WriteLine("--------------------------------------");
				Console.WriteLine("\tMenú principal");
				Console.WriteLine("--------------------------------------");
				Console.WriteLine("\ta - Añadir una nota");
				Console.WriteLine("\te - Eliminar una nota");
				Console.WriteLine("\tm - Modificar una nota");
				Console.WriteLine("\tv - Visualizar todas las notas");
				Console.WriteLine("\tg - Guardar las notas");
				Console.WriteLine("\ts - Salir");
				Console.Write("Elige una opción: ");

				/** Dependiendo de la elección... */
				switch (Console.ReadLine()) {
					case "a":
						Console.WriteLine("\nAñadir una nota\n");
						/** Inicializa la propiedad Texto del objeto. */
						Console.Write("Escribe el texto de la nota: ");
						/** Instancia un objeto de la clase Nota. */
						Nota notaAñadir = new Nota();
						notaAñadir.Texto = Console.ReadLine();
						/** Inicializa la propiedad Fecha del objeto. */
						notaAñadir.Fecha = DateTime.Now;
						/** Añade la nota a la lista. */
						notas.Add(notaAñadir);
						Console.WriteLine("Nota añadida");
						break;
					case "e":
						Console.WriteLine("\nEliminar una nota\n");
						/** Si existen notas... */
						if (notas.Count > 0) {
							/** Comprueba que el identificador sea un entero entre 1 y el 
							 *  número de notas. */
							do {
								Console.Write("Escribe el identificador de la nota: ");
								/** Almacena el identificador de la nota a eliminar. */
								resultado = Int32.TryParse(Console.ReadLine(), out id);
							} while (id < 1 || id > notas.Count);
							/** Si el identificador es válido...*/
							if (resultado) {
								/** Elimina la nota. */
								notas.RemoveAt(id - 1);
								Console.WriteLine("Nota eliminada");
							}
						}
						else {
							Console.WriteLine("No existen notas que eliminar");
						}
						break;
					case "m":
						Console.WriteLine("\nModificar una nota\n");
						/** Si existen notas... */
						if (notas.Count > 0) {
							/** Comprueba que el identificador sea un entero entre 1 y el 
							 *  número de notas. */
							do {
								Console.Write("Escribe el identificador de la nota: ");
								/** Almacena el identificador de la nota a eliminar. */
								resultado = Int32.TryParse(Console.ReadLine(), out id);
							} while (id < 1 || id > notas.Count);
							/** Si el identificador es válido...*/
							if (resultado) {
								/** Instancia un objeto de la clase Nota. */
								Nota notaModificar = new Nota();
								/** Inicializa la propiedad Texto del objeto. */
								Console.Write("Escribe el texto de la nota: ");
								notaModificar.Texto = Console.ReadLine();
								/** Inicializa la propiedad Fecha del objeto. */
								notaModificar.Fecha = DateTime.Now;
								notas[id - 1] = notaModificar;
								Console.WriteLine("Nota modificada");
							}
						}
						else {
							Console.WriteLine("No existen notas que modificar");
						}
						break;
					case "v":
						Console.WriteLine("\nVisualizar todas las notas\n");
						/** Si existen notas... */
						if (notas.Count > 0) {
							/** Recorre la lista de notas y las muestra. */
							int i = 1;
							foreach (Nota unaNota in notas) {
								Console.WriteLine($"Id: {i}\tTexto: {unaNota.Texto}\tFecha: {unaNota.Fecha}");
								i++;
							}
						}
						else {
							Console.WriteLine("No existen notas que visualizar");
						}
						break;
					case "g":
						Console.WriteLine("\nGuardar las notas\n");
						/** Recorre la lista de notas y las almacena. */
						int j = 0;
						string[] lineas = new string[notas.Count];
						foreach (Nota unaNota in notas) {
							lineas[j] = unaNota.Texto + ";" + unaNota.Fecha;
							/** Almacena el array de lineas en el archivo. */
							j++;
						}
						archivo.AlmacenaArchivo(lineas);
						Console.WriteLine("Notas guardadas");
						break;
					case "s":
						/** Fin del bucle while y finaliza la aplicación. */
						fin = true;
						break;
					default:
						Console.WriteLine("\nLa opción seleccionada no es correcta\n");
						break;
				}
			}
		}
	}
}
