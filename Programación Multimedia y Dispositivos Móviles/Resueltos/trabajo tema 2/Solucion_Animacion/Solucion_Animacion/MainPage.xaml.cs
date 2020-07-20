using System.ComponentModel;
using System.Threading.Tasks;
using Xamarin.Forms;

namespace Solucion_Animacion {
	[DesignTimeVisible(false)]
	public partial class MainPage : ContentPage {
		public MainPage() {
			/** Inicializa el XAML. */
			InitializeComponent();
		}
		/** Métodos. */

		/** Método que se llama al visualizar la página. */
		protected override void OnAppearing() {
			/** Llama al mismo método de una clase de jerarquía superior. */
			base.OnAppearing();
			/** Llamada a los métodos para iniciar la animación. */
			AnimaciónLibro();
			AnimaciónTexto();
			
		}

		/** Método que contiene las instrucciones de animación de la imagen del libro. */
		public async void AnimaciónLibro() {
			for (int i = 0; i < 3; i++) {
				/** Rotación de la imagen simulando un bucle que indica que se está cargando la aplicación. */
				await libro.RotateTo(1080, 3000, Easing.CubicInOut);
				libro.Rotation = 0;
			}
			/** Retraso en la animación para que coincida con la animación del texto. */
			await Task.Delay(500);
			/** Aumento de la imagen al terminar de cargar la aplicación. */
			await libro.ScaleTo(1.5, 500);
		}

		/** Método que contiene las instrucciones de animación de todos los textos. */
		public async void AnimaciónTexto() {
			/** Oculta parte del texto. */
			await bienvenidos_label.FadeTo(0, 0);
			await biblioteca_label.FadeTo(0, 0);

			/** Bucle que hace aparecer y desaparecer un texto. */
			for (int i = 0; i < 9; i++) {
				/** Retraso para que se puedan apreciar los cambios en el texto. */
				await Task.Delay(1000);
				/** El texto aparece y desaparece intermitentemente. */
				await animacion_cargando.FadeTo(i%2, 0);
			}

			/** A partir de aquí la aplicación ya está cargada. */
			/** Los textos "cargando" y "." desaparecen. */
			await animacion_cargando.FadeTo(0);
			await cargando.FadeTo(0);

			/** Animación del texto superior. */
			/** Posiciona el texto para empezar la animación. */
			await bienvenidos_label.TranslateTo(-100, 0, 0);
			/** Hace aparecer el texto. */
			await bienvenidos_label.FadeTo(1);
			/** El texto vuelve a su posición original. */
			await bienvenidos_label.TranslateTo(0, 0, 1500, Easing.SinOut);
			/** Animación del texto inferior. */
			/** Posiciona el texto para empezar la animación. */
			await biblioteca_label.TranslateTo(100, 0, 0);
			/** Hace aparecer el texto. */
			await biblioteca_label.FadeTo(1);
			/** El texto vuelve a su posición original. */
			await biblioteca_label.TranslateTo(0, 0, 1500, Easing.SinOut);
		}
	}
}
