using System;
using SQLite;

namespace Biblioteca_Salas.CapaNegocio {
	public class Usuario {
		/** Campos. */
		[PrimaryKey]
		public string Nombre_Usuario { get; set; }
		public string Nombre_Completo { get; set; }
	}
}
