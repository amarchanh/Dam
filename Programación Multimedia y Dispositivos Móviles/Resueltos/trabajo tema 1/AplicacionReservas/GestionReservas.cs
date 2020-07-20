using System;
using System.Collections.Generic;
using System.Text;

namespace AplicacionReservas {
	class GestionReservas {
		/* Lista de Strings que contiene las horas reservadas de la sala de audiovisuales. */
		public static List<String> audiovisuales = new List<String>();
		/* Lista de Strings que contiene las horas reservadas de la mediateca. */
		public static List<String> mediateca = new List<String>();
		/* Lista de Strings que contiene las horas reservadas del aula de talleres. */
		public static List<String> talleres = new List<String>();
		/* Lista de Strings que contiene las horas reservadas de la sala de humanidades. */
		public static List<String> humanidades = new List<String>();


		
		/* Método que permite elegir la sala sobre la quieres realizar la reserva.
		 * Param String opcion Selecciona el caso de uso que quieres realizar en el switch-case.
		 * Return void
		 */
		public static int ElegirSala(string opcion) {
			/* Var Integer Almacena un número relativo al caso de uso que hemos elegido. */
			int resultado;
			/* Switch-case que asigna un número dependiendo del caso de uso elegido. */
			switch (opcion) {
				case "a":
					resultado = 1;
					break;
				case "m":
					resultado = 2;
					break;
				case "t":
					resultado = 3;
					break;
				case "h":
					resultado = 4;
					break;
				/* La opción por defecto es 0.*/
				default:
					resultado = 0;
					break;
			}
			/* Devolvemos el número escogido. */
			return resultado;
		}


		/* Método que muestra almacena todas las horas de reserva de la lista de la sala de audiovisuales. 
		 * Return String Almacena todas las horas reservadas.*/
		public static string mostrarAudiovisuales() {
			string lineas = "";
			DatosReserva dr = new DatosReserva();
			foreach(string linea in dr.ObtenerReservasAudiovisuales()) {
				lineas += (linea + "\n");
			}
			/* Devolvemos el resultado del array en forma de String. */
			return lineas;
		}

		/* Método que añade una hora de reserva a la lista de horas de la sala de audiovisuales. 
		 * Param String hora Almacena la hora a la que se quiere realizar la reserva.
		 * Return Boolean True en caso de que todo se haya realizado correctamente.
		 *				  False en caso contrario. */
		public static bool ReservarAudioVisuales(string hora) {
			/* Comprueba la hora introducida sea válida. */
			if (hora.Length >= 4 && hora.Length <= 5
				&& int.Parse(hora.Substring(0, hora.IndexOf(":"))) < 24
				&& int.Parse(hora.Substring(0, hora.IndexOf(":"))) >= 0
				&& hora.Substring(hora.IndexOf(":") + 1).Equals("00")) {

				/*Var Boolean Bandera que indica si la hora a la que se quiere modificar existe o no. */
				bool horaExistente = false;
				/* Recorre la lista en busca de coincidencias. */
				foreach (String horas in GestionReservas.audiovisuales) {
					/* En caso de encontrar una coincidencia, la bandera cambia a true. */
					if (horas.Equals(hora))
						horaExistente = true;
				}
				/* Si no existe la hora la añade. */
				if (!horaExistente) {
					/* Añade la hora a la lista de horas y la ordena. */
					audiovisuales.Add(hora);
					audiovisuales.Sort();
					/* Llama a la clase que conecta con el fichero y guarda el array. */
					DatosReserva dr = new DatosReserva();
					dr.GuardarReservasAudiovisuales(audiovisuales);
					/* Devuelve si todo ha sido correcto. */
					return true;
				}
				/* Si ya existe, devuelve el error. */
				else {
					return false;
				}
			}
			else {
				/* Si no existe la hora, devuelve que no se ha podido realizar la reserva. */
				return false;
			}
		}

		/* Método que modifica una hora de reserva a otra distinta de la lista de horas de la sala de audiovisuales. 
		 * Param String horaVieja Almacena la hora antigua de la reserva.
		 * Param String horaNueva Almacena la hora a la que se quiere modificar la reserva.
		 * Return Boolean True en caso de que todo se haya realizado correctamente.
		 *				  False en caso contrario. */
		public static bool ModificarAudioVisuales(string horaVieja, string horaNueva) {
			DatosReserva dr = new DatosReserva();
			audiovisuales = dr.ObtenerReservasAudiovisuales();

			/*Var Boolean Bandera que indica si la hora a la que se quiere modificar existe o no. */
			bool horaExistente = false;
			/* Recorre la lista en busca de coincidencias. */
			foreach (String horas in GestionReservas.audiovisuales) {
				/* En caso de encontrar una coincidencia, la bandera cambia a true. */
				if (horas.Equals(horaVieja))
					horaExistente = true;
			}
			/* Comprueba la nueva hora introducida sea válida. */
			if (horaNueva.Length >= 4 && horaNueva.Length <= 5
				&& int.Parse(horaNueva.Substring(0, horaNueva.IndexOf(":"))) < 24
				&& int.Parse(horaNueva.Substring(0, horaNueva.IndexOf(":"))) >= 0
				&& horaNueva.Substring(horaNueva.IndexOf(":") + 1).Equals("00")) {

				/* Reiniciamos la bandera para el siguiente parámetro de entrada. */
				horaExistente = false;
				/* Recorre la lista en busca de coincidencias. */
				foreach (String horas in GestionReservas.audiovisuales) {
					/* En caso de encontrar una coincidencia, la bandera cambia a true. */
					if (horas.Equals(horaNueva))
						horaExistente = true;
				}


				/* Si no existe la hora la modifica. */
				if (!horaExistente) {
					/* Modifica la hora y ordena lista de horas. */
					audiovisuales[audiovisuales.FindIndex(x => x == horaVieja)] = horaNueva;
					audiovisuales.Sort();
					/* Llama a la clase que conecta con el fichero y guarda el array. */
					dr.GuardarReservasAudiovisuales(audiovisuales);
					/* Devuelve si todo ha sido correcto. */
					return true;
				}
			}
			return false;
		}

		/* Método que elimina una hora de reserva de la lista de horas de la sala de audiovisuales. 
		 * Param String hora Almacena la hora a la que se quiere eliminar la reserva.
		 * Return Boolean True en caso de que todo se haya realizado correctamente.
		 *				  False en caso contrario. */
		public static bool EliminarReservaAudioVisuales(string hora) {
			/*Var Boolean Bandera que indica si la hora que se quiere eliminar existe o no. */
			bool horaExistente = false;
			/* Recorre la lista en busca de coincidencias. */
			foreach (String horas in GestionReservas.audiovisuales) {
				/* En caso de encontrar una coincidencia, la bandera cambia a true. */
				if(horas.Equals(hora))
					horaExistente = true;
			}
			/* Si existe la hora la elimina. */
			if (horaExistente) {
				audiovisuales.RemoveAt(audiovisuales.FindIndex(x => x == hora));
				/* Llama a la clase que conecta con el fichero y guarda el array. */
				DatosReserva dr = new DatosReserva();
				dr.GuardarReservasAudiovisuales(audiovisuales);
				/* Devuelve si todo ha sido correcto. */
				return true;
			}
			/* Si no existe la hora, devuelve que no se ha podido realizar la eliminación. */
			else {
				return false;
			}
		}

		/* Método que muestra almacena todas las horas de reserva de la lista de la mediateca. 
		 * Return String Almacena todas las horas reservadas.*/
		public static string mostrarMediateca() {
			string lineas = "";
			DatosReserva dr = new DatosReserva();
			foreach (string linea in dr.ObtenerReservasMediateca()) {
				lineas += (linea + "\n");
			}
			/* Devolvemos el resultado del array en forma de String. */
			return lineas;
		}

		/* Método que añade una hora de reserva a la lista de horas de la mediateca. 
		 * Param String hora Almacena la hora a la que se quiere realizar la reserva.
		 * Return Boolean True en caso de que todo se haya realizado correctamente.
		 *				  False en caso contrario. */
		public static bool ReservarMediateca(string hora) {
			/* Comprueba la hora introducida sea válida. */
			if (hora.Length >= 4 && hora.Length <= 5
				&& int.Parse(hora.Substring(0, hora.IndexOf(":"))) < 24
				&& int.Parse(hora.Substring(0, hora.IndexOf(":"))) >= 0
				&& hora.Substring(hora.IndexOf(":") + 1).Equals("00")) {

				/*Var Boolean Bandera que indica si la hora a la que se quiere modificar existe o no. */
				bool horaExistente = false;
				/* Recorre la lista en busca de coincidencias. */
				foreach (String horas in GestionReservas.mediateca) {
					/* En caso de encontrar una coincidencia, la bandera cambia a true. */
					if (horas.Equals(hora))
						horaExistente = true;
				}
				/* Si no existe la hora la añade. */
				if (!horaExistente) {
					/* Añade la hora a la lista de horas y la ordena. */
					mediateca.Add(hora);
					mediateca.Sort();
					/* Llama a la clase que conecta con el fichero y guarda el array. */
					DatosReserva dr = new DatosReserva();
					dr.GuardarReservasMediateca(mediateca);
					/* Devuelve si todo ha sido correcto. */
					return true;
				}
				/* Si ya existe, devuelve el error. */
				else {
					return false;
				}
			}
			else {
				/* Si no existe la hora, devuelve que no se ha podido realizar la reserva. */
				return false;
			}
		}

		/* Método que modifica una hora de reserva a otra distinta de la lista de horas de la mediateca. 
		 * Param String horaVieja Almacena la hora antigua de la reserva.
		 * Param String horaNueva Almacena la hora a la que se quiere modificar la reserva.
		 * Return Boolean True en caso de que todo se haya realizado correctamente.
		 *				  False en caso contrario. */
		public static bool ModificarMediateca(string horaVieja, string horaNueva) {
			DatosReserva dr = new DatosReserva();
			mediateca = dr.ObtenerReservasMediateca();
			/*Var Boolean Bandera que indica si la hora a la que se quiere modificar existe o no. */
			bool horaExistente = false;
			/* Recorre la lista en busca de coincidencias. */
			foreach (String horas in GestionReservas.mediateca) {
				/* En caso de encontrar una coincidencia, la bandera cambia a true. */
				if (horas.Equals(horaVieja))
					horaExistente = true;
			}
			/* Comprueba la nueva hora introducida sea válida. */
			if (horaNueva.Length >= 4 && horaNueva.Length <= 5
				&& int.Parse(horaNueva.Substring(0, horaNueva.IndexOf(":"))) < 24
				&& int.Parse(horaNueva.Substring(0, horaNueva.IndexOf(":"))) >= 0
				&& horaNueva.Substring(horaNueva.IndexOf(":") + 1).Equals("00")) {

				/* Reiniciamos la bandera para el siguiente parámetro de entrada. */
				horaExistente = false;
				/* Recorre la lista en busca de coincidencias. */
				foreach (String horas in GestionReservas.mediateca) {
					/* En caso de encontrar una coincidencia, la bandera cambia a true. */
					if (horas.Equals(horaNueva))
						horaExistente = true;
				}


				/* Si no existe la hora la modifica. */
				if (!horaExistente) {
					/* Modifica la hora y ordena lista de horas. */
					mediateca[mediateca.FindIndex(x => x == horaVieja)] = horaNueva;
					mediateca.Sort();
					/* Guarda el array en el fichero. */
					dr.GuardarReservasMediateca(mediateca);
					/* Devuelve si todo ha sido correcto. */
					return true;
				}
				/* Si ya existe, devuelve el error. */
				else {
					return false;
				}
			}
			else {
				/* Si no existe la hora, devuelve que no se ha podido realizar la modificación. */
				return false;
			}
		}

		/* Método que elimina una hora de reserva de la lista de horas de la mediateca. 
		 * Param String hora Almacena la hora a la que se quiere eliminar la reserva.
		 * Return Boolean True en caso de que todo se haya realizado correctamente.
		 *				  False en caso contrario. */
		public static bool EliminarReservaMediateca(string hora) {
			/*Var Boolean Bandera que indica si la hora que se quiere eliminar existe o no. */
			bool horaExistente = false;
			/* Recorre la lista en busca de coincidencias. */
			foreach (String horas in GestionReservas.mediateca) {
				/* En caso de encontrar una coincidencia, la bandera cambia a true. */
				if (horas.Equals(hora))
					horaExistente = true;
			}
			/* Si existe la hora la elimina. */
			if (horaExistente) {
				mediateca.RemoveAt(mediateca.FindIndex(x => x == hora));
				/* Llama a la clase que conecta con el fichero y guarda el array. */
				DatosReserva dr = new DatosReserva();
				dr.GuardarReservasMediateca(mediateca);
				/* Devuelve si todo ha sido correcto. */
				return true;
			}
			/* Si no existe la hora, devuelve que no se ha podido realizar la eliminación. */
			else {
				return false;
			}
		}

		/* Método que muestra almacena todas las horas de reserva de la lista del aula de talleres. 
		 * Return String Almacena todas las horas reservadas.*/
		public static string mostrarTalleres() {
			string lineas = "";
			DatosReserva dr = new DatosReserva();
			foreach (string linea in dr.ObtenerReservasTalleres()) {
				lineas += (linea + "\n");
			}
			/* Devolvemos el resultado del array en forma de String. */
			return lineas;
		}

		/* Método que añade una hora de reserva a la lista de horas del aula de talleres. 
		 * Param String hora Almacena la hora a la que se quiere realizar la reserva.
		 * Return Boolean True en caso de que todo se haya realizado correctamente.
		 *				  False en caso contrario. */
		public static bool ReservarTalleres(string hora) {
			/* Comprueba la hora introducida sea válida. */
			if (hora.Length >= 4 && hora.Length <= 5
				&& int.Parse(hora.Substring(0, hora.IndexOf(":"))) < 24
				&& int.Parse(hora.Substring(0, hora.IndexOf(":"))) >= 0
				&& hora.Substring(hora.IndexOf(":") + 1).Equals("00")) {

				/*Var Boolean Bandera que indica si la hora a la que se quiere modificar existe o no. */
				bool horaExistente = false;
				/* Recorre la lista en busca de coincidencias. */
				foreach (String horas in GestionReservas.talleres) {
					/* En caso de encontrar una coincidencia, la bandera cambia a true. */
					if (horas.Equals(hora))
						horaExistente = true;
				}
				/* Si no existe la hora la añade. */
				if (!horaExistente) {
					/* Añade la hora a la lista de horas y la ordena. */
					talleres.Add(hora);
					talleres.Sort();
					/* Llama a la clase que conecta con el fichero y guarda el array. */
					DatosReserva dr = new DatosReserva();
					dr.GuardarReservasTalleres(talleres);
					/* Devuelve si todo ha sido correcto. */
					return true;
				}
				/* Si ya existe, devuelve el error. */
				else {
					return false;
				}
			}
			else {
				/* Si no existe la hora, devuelve que no se ha podido realizar la reserva. */
				return false;
			}
		}

		/* Método que modifica una hora de reserva a otra distinta de la lista de horas del aula de talleres.
		 * Param String horaVieja Almacena la hora antigua de la reserva.
		 * Param String horaNueva Almacena la hora a la que se quiere modificar la reserva.
		 * Return Boolean True en caso de que todo se haya realizado correctamente.
		 *				  False en caso contrario. */
		public static bool ModificarTalleres(string horaVieja, string horaNueva) {
			DatosReserva dr = new DatosReserva();
			talleres = dr.ObtenerReservasTalleres();
			/*Var Boolean Bandera que indica si la hora a la que se quiere modificar existe o no. */
			bool horaExistente = false;
			/* Recorre la lista en busca de coincidencias. */
			foreach (String horas in GestionReservas.talleres) {
				/* En caso de encontrar una coincidencia, la bandera cambia a true. */
				if (horas.Equals(horaVieja))
					horaExistente = true;
			}
			/* Comprueba la nueva hora introducida sea válida. */
			if (horaNueva.Length >= 4 && horaNueva.Length <= 5
				&& int.Parse(horaNueva.Substring(0, horaNueva.IndexOf(":"))) < 24
				&& int.Parse(horaNueva.Substring(0, horaNueva.IndexOf(":"))) >= 0
				&& horaNueva.Substring(horaNueva.IndexOf(":") + 1).Equals("00")) {

				/* Reiniciamos la bandera para el siguiente parámetro de entrada. */
				horaExistente = false;
				/* Recorre la lista en busca de coincidencias. */
				foreach (String horas in GestionReservas.talleres) {
					/* En caso de encontrar una coincidencia, la bandera cambia a true. */
					if (horas.Equals(horaNueva))
						horaExistente = true;
				}


				/* Si no existe la hora la modifica. */
				if (!horaExistente) {
					/* Modifica la hora y ordena lista de horas. */
					talleres[talleres.FindIndex(x => x == horaVieja)] = horaNueva;
					talleres.Sort();
					/* Llama a la clase que conecta con el fichero y guarda el array. */
					dr.GuardarReservasTalleres(talleres);
					/* Devuelve si todo ha sido correcto. */
					return true;
				}
				/* Si ya existe, devuelve el error. */
				else {
					return false;
				}
			}
			else {
				/* Si no existe la hora, devuelve que no se ha podido realizar la modificación. */
				return false;
			}
		}

		/* Método que elimina una hora de reserva de la lista de horas del aula de talleres.
		 * Param String hora Almacena la hora a la que se quiere eliminar la reserva.
		 * Return Boolean True en caso de que todo se haya realizado correctamente.
		 *				  False en caso contrario. */
		public static bool EliminarReservaTalleres(string hora) {
			/*Var Boolean Bandera que indica si la hora que se quiere eliminar existe o no. */
			bool horaExistente = false;
			/* Recorre la lista en busca de coincidencias. */
			foreach (String horas in GestionReservas.talleres) {
				/* En caso de encontrar una coincidencia, la bandera cambia a true. */
				if (horas.Equals(hora))
					horaExistente = true;
			}
			/* Si existe la hora la elimina. */
			if (horaExistente) {
				talleres.RemoveAt(talleres.FindIndex(x => x == hora));
				/* Llama a la clase que conecta con el fichero y guarda el array. */
				DatosReserva dr = new DatosReserva();
				dr.GuardarReservasTalleres(talleres);
				/* Devuelve si todo ha sido correcto. */
				return true;
			}
			/* Si no existe la hora, devuelve que no se ha podido realizar la eliminación. */
			else {
				return false;
			}
		}

		/* Método que muestra almacena todas las horas de reserva de la lista de la sala de humanidades. 
		 * Return String Almacena todas las horas reservadas.*/
		public static string mostrarHumanidades() {
			string lineas = "";
			DatosReserva dr = new DatosReserva();
			foreach (string linea in dr.ObtenerReservasHumanidades()) {
				lineas += (linea + "\n");
			}
			/* Devolvemos el resultado del array en forma de String. */
			return lineas;
		}


		/* Método que añade una hora de reserva a la lista de horas de la sala de humanidades. 
		 * Param String hora Almacena la hora a la que se quiere realizar la reserva.
		 * Return Boolean True en caso de que todo se haya realizado correctamente.
		 *				  False en caso contrario. */
		public static bool ReservarHumanidades(string hora) {
			/* Comprueba la hora introducida sea válida. */
			if (hora.Length >= 4 && hora.Length <= 5
				&&int.Parse(hora.Substring(0, hora.IndexOf(":"))) < 24
				&& int.Parse(hora.Substring(0, hora.IndexOf(":"))) >= 0
				&& hora.Substring(hora.IndexOf(":") + 1).Equals("00")) {

				/*Var Boolean Bandera que indica si la hora a la que se quiere modificar existe o no. */
				bool horaExistente = false;
				/* Recorre la lista en busca de coincidencias. */
				foreach (String horas in GestionReservas.humanidades) {
					/* En caso de encontrar una coincidencia, la bandera cambia a true. */
					if (horas.Equals(hora))
						horaExistente = true;
				}
				/* Si no existe la hora la añade. */
				if (!horaExistente) {
					/* Añade la hora a la lista de horas y la ordena. */
					humanidades.Add(hora);
					humanidades.Sort();
					/* Llama a la clase que conecta con el fichero y guarda el array. */
					DatosReserva dr = new DatosReserva();
					dr.GuardarReservasHumanidades(humanidades);
					/* Devuelve si todo ha sido correcto. */
					return true;
				}
				/* Si ya existe, devuelve el error. */
				else {
					return false;
				}
			}
			else {
				/* Si no existe la hora, devuelve que no se ha podido realizar la reserva. */
				return false;
			}
		}

		/* Método que modifica una hora de reserva a otra distinta de la lista de horas de la sala de humanidades. 
		 * Param String horaVieja Almacena la hora antigua de la reserva.
		 * Param String horaNueva Almacena la hora a la que se quiere modificar la reserva.
		 * Return Boolean True en caso de que todo se haya realizado correctamente.
		 *				  False en caso contrario. */
		public static bool ModificarHumanidades(string horaVieja, string horaNueva) {
			DatosReserva dr = new DatosReserva();
			humanidades = dr.ObtenerReservasHumanidades();
			/*Var Boolean Bandera que indica si la hora a la que se quiere modificar existe o no. */
			bool horaExistente = false;
			/* Recorre la lista en busca de coincidencias. */
			foreach (String horas in GestionReservas.humanidades) {
				/* En caso de encontrar una coincidencia, la bandera cambia a true. */
				if (horas.Equals(horaVieja))
					horaExistente = true;
			}
			/* Comprueba la nueva hora introducida sea válida. */
			if (horaNueva.Length >= 4 && horaNueva.Length <= 5
				&& int.Parse(horaNueva.Substring(0, horaNueva.IndexOf(":"))) < 24
				&& int.Parse(horaNueva.Substring(0, horaNueva.IndexOf(":"))) >= 0
				&& horaNueva.Substring(horaNueva.IndexOf(":") + 1).Equals("00")) {

				/* Reiniciamos la bandera para el siguiente parámetro de entrada. */
				horaExistente = false;
				/* Recorre la lista en busca de coincidencias. */
				foreach (String horas in GestionReservas.humanidades) {
					/* En caso de encontrar una coincidencia, la bandera cambia a true. */
					if (horas.Equals(horaNueva))
						horaExistente = true;
				}


				/* Si no existe la hora la modifica. */
				if (!horaExistente) {
					/* Modifica la hora y ordena lista de horas. */
					humanidades[humanidades.FindIndex(x => x == horaVieja)] = horaNueva;
					humanidades.Sort();
					/* Llama a la clase que conecta con el fichero y guarda el array. */
					dr.GuardarReservasHumanidades(humanidades);
					/* Devuelve si todo ha sido correcto. */
					return true;
				}
				/* Si ya existe, devuelve el error. */
				else {
					return false;
				}
			}
			else {
				/* Si no existe la hora, devuelve que no se ha podido realizar la modificación. */
				return false;
			}
		}

		/* Método que elimina una hora de reserva de la lista de horas de la sala de humanidades. 
		 * Param String hora Almacena la hora a la que se quiere eliminar la reserva.
		 * Return Boolean True en caso de que todo se haya realizado correctamente.
		 *				  False en caso contrario. */
		public static bool EliminarReservaHumanidades(string hora) {
			/*Var Boolean Bandera que indica si la hora que se quiere eliminar existe o no. */
			bool horaExistente = false;
			/* Recorre la lista en busca de coincidencias. */
			foreach (String horas in GestionReservas.humanidades) {
				/* En caso de encontrar una coincidencia, la bandera cambia a true. */
				if (horas.Equals(hora))
					horaExistente = true;
			}
			/* Si existe la hora la elimina. */
			if (horaExistente) {
				humanidades.RemoveAt(humanidades.FindIndex(x => x == hora));
				/* Llama a la clase que conecta con el fichero y guarda el array. */
				DatosReserva dr = new DatosReserva();
				dr.GuardarReservasHumanidades(humanidades);
				/* Devuelve si todo ha sido correcto. */
				return true;
			}
			/* Si no existe la hora, devuelve que no se ha podido realizar la eliminación. */
			else {
				return false;
			}
		}

	}
}
