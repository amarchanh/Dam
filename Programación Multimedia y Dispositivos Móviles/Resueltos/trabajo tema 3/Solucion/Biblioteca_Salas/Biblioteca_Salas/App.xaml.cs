using System;
using System.IO;
using Xamarin.Forms;
using Biblioteca_Salas.CapaDatos;

namespace Biblioteca_Salas {
	public partial class App : Application {
		/** Declaramos objetos estáticos. */
		static DatosReserva database_reserva;
		static DatosSala database_sala;
		static DatosUsuario database_usuario;
		/** Campos. */
		public static DatosReserva DatabaseReserva {
			get {
				/** Si no existe el objeto... */
				if (database_reserva == null) {
					/** Instancia el objeto con la ruta de la base de datos local del dispositivo. */
					database_reserva = new DatosReserva(Path.Combine(Environment.GetFolderPath(Environment.SpecialFolder.LocalApplicationData), "Biblioteca.db3"));
				}
				/** Devuelve el objeto instanciado. */
				return database_reserva;
			}
		}

		public static DatosSala DatabaseSala {
			get {
				/** Si no existe el objeto... */
				if (database_sala == null) {
					/** Instancia el objeto con la ruta de la base de datos local del dispositivo. */
					database_sala = new DatosSala(Path.Combine(Environment.GetFolderPath(Environment.SpecialFolder.LocalApplicationData), "Biblioteca.db3"));
				}
				/** Devuelve el objeto instanciado. */
				return database_sala;
			}
		}


		public static DatosUsuario DatabaseUsuario {
			get {
				/** Si no existe el objeto... */
				if (database_usuario == null) {
					/** Instancia el objeto con la ruta de la base de datos local del dispositivo. */
					database_usuario = new DatosUsuario(Path.Combine(Environment.GetFolderPath(Environment.SpecialFolder.LocalApplicationData), "Biblioteca.db3"));
				}
				/** Devuelve el objeto instanciado. */
				return database_usuario;
			}
		}

		/** Constructor. */
		public App() {
			/** Inicializa el XAML. */
			InitializeComponent();
			/** Indica la página de inicio de la apliación. */
			MainPage = new NavigationPage(new MainPage());
		}

	}
}
