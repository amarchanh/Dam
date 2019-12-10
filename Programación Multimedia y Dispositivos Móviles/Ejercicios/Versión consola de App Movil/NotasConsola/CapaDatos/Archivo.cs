using System.IO;

namespace NotasConsola.CapaDatos {
	class Archivo {
		/** Campos. */
		private string NombreArchivo = "notas.txt";

		/** Métodos. */
		public void AlmacenaArchivo(string[] lineas) {
			/** Almacena el array de strings en el archivo. */
			File.WriteAllLines(NombreArchivo, lineas);
		}

		public string[] LeeArchivo() {
			/** Almacena el array de notas en el archivo. */
			string[] lineas;
			/** Lee todas la líneas del archivo y las almacena en un array de strings. */
			lineas = File.ReadAllLines(NombreArchivo);
			/** Devuelve el array de strings. */
			return lineas;
		}

	}
}
