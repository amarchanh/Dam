using System;
using SQLite;

namespace Biblioteca_Salas.CapaNegocio {
	public class Reserva {
		/** Campos. */
		[PrimaryKey, AutoIncrement]
		public int Id_Reserva { get; set; }
		public string Nombre_Sala { get; set; }
		public string Nombre_Usuario { get; set; }
		public string Hora_Reserva { get; set; }
		public string Motivo_Reserva { get; set; }

	}
}
