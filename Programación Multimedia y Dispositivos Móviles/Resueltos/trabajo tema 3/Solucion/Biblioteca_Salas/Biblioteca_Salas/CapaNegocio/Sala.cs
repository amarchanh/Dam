using System;
using SQLite;

namespace Biblioteca_Salas.CapaNegocio {
	public class Sala {
		/** Campos. */
		[PrimaryKey]
		public string Nombre_Sala { get; set; }
		public string Descripción { get; set; }

	}
}
