using System;
using Xamarin.Forms;
using Biblioteca_Salas.CapaNegocio;

namespace Biblioteca_Salas {

	public partial class MainPage : ContentPage {
		/** Constructor. */
		public MainPage() {
			/** Inicializa el XAML. */
			InitializeComponent();
		}

		/** Métodos. */

		/** Método que recoge el evento del botón y manda información a otra página. */
		async void ReservarAudiovisuales(object sender, EventArgs e) {
			/** Crea un objeto e inicializa sus parámetros. */
			var sala = new Sala {
				Nombre_Sala = "Audiovisuales"
			};
			await Navigation.PushAsync(new GestionarReserva {
				BindingContext = sala
			});
		}

		/** Método que recoge el evento del botón y manda información a otra página. */
		async void ReservarMediateca(object sender, EventArgs e) {
			/** Crea un objeto e inicializa sus parámetros. */
			var sala = new Sala {
				Nombre_Sala = "Mediateca"
			};
			/** Crea una nueva página y te envía a ella. */
			await Navigation.PushAsync(new GestionarReserva {
				/** Envía la información del objeto creado a la nueva página. */
				BindingContext = sala
			});
		}

		/** Método que recoge el evento del botón y manda información a otra página. */
		async void ReservarTalleres(object sender, EventArgs e) {
			/** Crea un objeto e inicializa sus parámetros. */
			var sala = new Sala {
				Nombre_Sala = "Talleres"
			};
			/** Crea una nueva página y te envía a ella. */
			await Navigation.PushAsync(new GestionarReserva {
				/** Envía la información del objeto creado a la nueva página. */
				BindingContext = sala
			});
		}

		/** Método que recoge el evento del botón y manda información a otra página. */
		async void ReservarHumanidades(object sender, EventArgs e) {
			/** Crea un objeto e inicializa sus parámetros. */
			var sala = new Sala {
				Nombre_Sala = "Humanidades"
			};
			/** Crea una nueva página y te envía a ella. */
			await Navigation.PushAsync(new GestionarReserva {
				/** Envía la información del objeto creado a la nueva página. */
				BindingContext = sala
			});
		}
	}
}
