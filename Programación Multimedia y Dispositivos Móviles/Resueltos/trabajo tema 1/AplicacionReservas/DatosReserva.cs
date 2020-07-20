using System;
using System.Collections.Generic;
using System.IO;
using System.Text;

namespace AplicacionReservas {
	class DatosReserva {
		/* Creamos la variables que almacenan la ruta del fichero. */
		string archivoAudiovisuales = "reservasAudiovisuales.txt";
		string archivoMediateca = "reservasoMediateca.txt";
		string archivoTalleres = "reservasTalleres.txt";
		string archivoHumanidades = "reservasHumanidades.txt";


		/* Método que almacena la hora de la reserva en el fichero. 
		 * Param List<string> almacena la lista de horas de reserva.
		   Return void*/
		public void GuardarReservasAudiovisuales(List<string> array) {
			/* Object StreamWriter crea el fichero o si ya existe lo sobreescribe. */
			StreamWriter fichero = File.CreateText(archivoAudiovisuales);
			/* Recorre el array y lo va guardando en el fichero*/
			foreach(string linea in array) {
				fichero.WriteLine(linea);
			}
			/* Cierre del fichero para que se guarde. */
			fichero.Close();
		}

		/* Método que devuelve la información almacena en el fichero. 
		 * Return List<string> Lista de horas reservadas. */
		public List<string> ObtenerReservasAudiovisuales() {
			/* List<String> Lista que almacena las horas reservadas del fichero. */
			List<string> reservas = new List<string>();
			/* Si el fichero existe lo lee. */
			if (File.Exists(archivoAudiovisuales)) {
				/* Object StreamReader lee el fichero. */
				StreamReader sr = new StreamReader(archivoAudiovisuales);
				/* Var String Almacena una línea del fichero. */
				string linea = "";
				/* Mientras que haya líneas en el archivo sigue leyendo. */
				while ((linea = sr.ReadLine()) != null) {
					/* Añade a la lista la línea leída en el fichero. */
					reservas.Add(linea);
				}
				/* Cierre del fichero. */
				sr.Close();
			}
			/* Devuelve la información del fichero recopilada en una lista. */
			return reservas;
		}

		/* Método que almacena la hora de la reserva en el fichero. 
		 * Param List<string> almacena la lista de horas de reserva.
		   Return void*/
		public void GuardarReservasMediateca(List<string> array) {
			/* Object StreamWriter crea el fichero o si ya existe lo sobreescribe. */
			StreamWriter fichero = File.CreateText(archivoMediateca);
			/* Recorre el array y lo va guardando en el fichero*/
			foreach (string linea in array) {
				/* Var String Almacena una línea del fichero. */
				fichero.WriteLine(linea);
			}
			/* Cierre del fichero para que se guarde. */
			fichero.Close();
		}

		/* Método que devuelve la información almacena en el fichero. 
		 * Return List<string> Lista de horas reservadas. */
		public List<string> ObtenerReservasMediateca() {
			/* List<String> Lista que almacena las horas reservadas del fichero. */
			List<string> reservas = new List<string>();
			/* Si el fichero existe lo lee. */
			if (File.Exists(archivoMediateca)) {
				/* Object StreamReader lee el fichero. */
				StreamReader sr = new StreamReader(archivoMediateca);
				/* Var String Almacena una línea del fichero. */
				string linea = "";
				/* Mientras que haya líneas en el archivo sigue leyendo. */
				while ((linea = sr.ReadLine()) != null) {
					/* Añade a la lista la línea leída en el fichero. */
					reservas.Add(linea);

				}
				/* Cierre del fichero. */
				sr.Close();
			}
			/* Devuelve la información del fichero recopilada en una lista. */
			return reservas;
		}

		/* Método que almacena la hora de la reserva en el fichero. 
		 * Param List<string> almacena la lista de horas de reserva.
		   Return void*/
		public void GuardarReservasTalleres(List<string> array) {
			/* Object StreamWriter crea el fichero o si ya existe lo sobreescribe. */
			StreamWriter fichero = File.CreateText(archivoTalleres);
			/* Recorre el array y lo va guardando en el fichero*/
			foreach (string linea in array) {
				fichero.WriteLine(linea);
			}
			/* Cierre del fichero para que se guarde. */
			fichero.Close();
		}

		/* Método que devuelve la información almacena en el fichero. 
		 * Return List<string> Lista de horas reservadas. */
		public List<string> ObtenerReservasTalleres() {
			/* List<String> Lista que almacena las horas reservadas del fichero. */
			List<string> reservas = new List<string>();
			/* Si el fichero existe lo lee. */
			if (File.Exists(archivoTalleres)) {
				/* Object StreamReader lee el fichero. */
				StreamReader sr = new StreamReader(archivoTalleres);
				/* Var String Almacena una línea del fichero. */
				string linea = "";
				/* Mientras que haya líneas en el archivo sigue leyendo. */
				while ((linea = sr.ReadLine()) != null) {
					/* Añade a la lista la línea leída en el fichero. */
					reservas.Add(linea);
				}
				/* Cierre del fichero. */
				sr.Close();
			}
			/* Devuelve la información del fichero recopilada en una lista. */
			return reservas;
		}

		/* Método que almacena la hora de la reserva en el fichero. 
		 * Param List<string> almacena la lista de horas de reserva.
		   Return void*/
		public void GuardarReservasHumanidades(List<string> array) {
			/* Object StreamWriter crea el fichero o si ya existe lo sobreescribe. */
			StreamWriter fichero = File.CreateText(archivoHumanidades);
			/* Recorre el array y lo va guardando en el fichero*/
			foreach (string linea in array) {
				fichero.WriteLine(linea);
			}
			/* Cierre del fichero para que se guarde. */
			fichero.Close();
		}

		/* Método que devuelve la información almacena en el fichero. 
		 * Return List<string> Lista de horas reservadas. */
		public List<string> ObtenerReservasHumanidades() {
			/* List<String> Lista que almacena las horas reservadas del fichero. */
			List<string> reservas = new List<string>();
			/* Si el fichero existe lo lee. */
			if (File.Exists(archivoHumanidades)) {
				/* Object StreamReader lee el fichero. */
				StreamReader sr = new StreamReader(archivoHumanidades);
				/* Var String Almacena una línea del fichero. */
				string linea = "";
				/* Mientras que haya líneas en el archivo sigue leyendo. */
				while ((linea = sr.ReadLine()) != null) {
					/* Añade a la lista la línea leída en el fichero. */
					reservas.Add(linea);
				}
				/* Cierre del fichero. */
				sr.Close();
			}
			/* Devuelve la información del fichero recopilada en una lista. */
			return reservas;
		}

	}
}
