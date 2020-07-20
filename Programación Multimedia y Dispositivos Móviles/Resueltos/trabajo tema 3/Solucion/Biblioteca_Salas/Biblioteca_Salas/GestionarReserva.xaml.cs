using System;
using Xamarin.Forms;
using Xamarin.Forms.Xaml;
using Biblioteca_Salas.CapaNegocio;
using System.Collections.Generic;

namespace Biblioteca_Salas {
	public partial class GestionarReserva : ContentPage {

		/** Constructor. */
		public GestionarReserva() {
			/** Inicializa el XAML. */
			InitializeComponent();
		}

		/** Métodos. */

		/** Método que se llama al visualizar la página. */
		protected override void OnAppearing() {
			/** Llama al mismo método de una clase de jerarquía superior. */
			base.OnAppearing();
			/** Muestra las horas reservadas. */
			MostrarHoras();
		}

		/** Método que muestra las horas reservadas de la sala que seleccionemos. */
		private async void MostrarHoras() {
			/** Almacena todas las horas reservadas concatenándolas. */
			String cadena = "";
			/** Almacena las reservas que devuelve el método en una lista de reservas. */
			List<Reserva> res = await App.DatabaseReserva.GetReservaAsync(sala.Text);
			/** Recorremos la lista. */
			foreach (Reserva r in res) {
				/** Concatenamos los resultados. */
				cadena += r.Hora_Reserva + "  ";
			}
			/** Muestra el resultado en un label. */
			horas_reservadas.Text = cadena;
		}

		/** Método que maneja el evento de la view "picker". */
		private async void MostrarMotivoReserva(object sender, EventArgs e) {
			/** Vaciamos los labels por si tenían información almacenada. */
			error.Text = "";
			info_reserva.Text = "";
			/** Comprueba si ya existe la reserva y lo almacena. */
			bool existe = await App.DatabaseReserva.GetReservaAsync(sala.Text, picker.SelectedItem.ToString());
			/** Si existe la reserva... */
			if (existe) {
				/** Almacena en un lista todas las reservas de la sala. */
				List<Reserva> res = await App.DatabaseReserva.GetReservaAsync(sala.Text);
				/** Recorremos la lista. */
				foreach (Reserva r in res) {
					/** Si coincide la hora de la base de datos con la seleccionada del selector...*/
					if (r.Hora_Reserva.Equals(picker.SelectedItem.ToString())) {
						/** Se muestra en el editor. */
						motivo.Text = r.Motivo_Reserva;
					}
				}
			}
			/** Si no existe... */
			else {
				/** Vacía el editor. */
				motivo.Text = "";
			}
		}

		/** Método que almacena la reserva en la base de datos. */
		async void OnSaveButtonClicked(object sender, EventArgs e) {
			/** Vaciamos los labels por si tenían información almacenada. */
			error.Text = "";
			info_reserva.Text = "";
			try {
				/** Crea un objeto e inicializa sus parámetros. */
				var reserva = new Reserva {
					Nombre_Usuario = "admin",
					Nombre_Sala = sala.Text,
					Hora_Reserva = picker.SelectedItem.ToString(),
					Motivo_Reserva = motivo.Text
				};
				/** Almacenamos el resultado de guardar el objeto en la base de datos. */
				int num = await App.DatabaseReserva.SaveReservaAsync(reserva);
				/** Si se ha actualizado. */
				if (num == 1) {
					/** Muestra el mensaje. */
					info_reserva.Text = "La reserva ha sido cambiada.";
				}
				/** Si se ha creado. */
				else if (num == 2) {
					/** Muestra el mensaje. */
					info_reserva.Text = "La reserva ha sido exitosa.";
					/** Volvemos a mostrar las horas reservadas. */
					MostrarHoras();
				}
				/** Si hay un error. */
				else {
					/** Mostramos el mensaje. */
					error.Text = "Ha habido un error en la base.";
				}

			}
			catch (Exception) {
				/** Mostramos el mensaje de error. */
				error.Text = "Ha habido un error en la reserva.";
			}
		}

		/** Método que borra la reserva de la base de datos. */
		async void OnDeleteButtonClicked(object sender, EventArgs e) {
			/** Vaciamos los labels por si tenían información almacenada. */
			error.Text = "";
			info_reserva.Text = "";
			try {
				/** Crea un objeto e inicializa sus parámetros. */
				var reserva = new Reserva {
					Nombre_Usuario = "admin",
					Nombre_Sala = sala.Text,
					Hora_Reserva = picker.SelectedItem.ToString()
				};
				/** Almacenamos el resultado de borrar el objeto de la base de datos. */
				int num = await App.DatabaseReserva.DeleteReservaAsync(reserva);
				/** Si el borrado se ha relizado correctamente. */
				if (num == 1) {
					/** Muestra el mensaje. */
					info_reserva.Text = "La reserva ha sido borrada.";
					/** Volvemos a mostrar las horas reservadas. */
					MostrarHoras();
				}
				/** Si hay un error. */
				else {
					/** Mostramos el mensaje. */
					error.Text = "La hora seleccionada no está reservada.";
				}

			}
			catch (Exception) {
				/** Mostramos el mensaje de error. */
				error.Text = "Selecciona una hora.";
			}
		}
	}
}