using System;

namespace AplicacionReservas {
	class Program {
		static void Main(string[] args) {
			/* Var Boolean Bandera que indica si el usuario quiere finalizar el proceso o no. */
			bool endApp = false;
			/* Var String Almacena la hora que se quiere reservar. */
			string horaReserva;
			/* Var String Almacena la hora de la reserva antes de la modificación. */
			string horaVieja;
			/* Var String Almacena la opción de reserva que ha introducido el usuario. */
			string opcion;

			/* Muestra el título de la aplicación. */
			Console.WriteLine("Bienvenido al sistema de aplicaciones de reserva de la biblioteca\r");
			Console.WriteLine("------------------------\n");
			/* Inicializa horas de reserva para realizar pruebas. */
			//GestionReservas.IniciarHorarios();
			/* Bucle que mientras que el usuario no quiera finalizar el programa, este no para de repetirse. */
			while (!endApp) {
				
				/* Var Integer Almacena el resultado del caso de uso que utiliza el usuario. */
				int resultado;

				/* Muestra por pantalla las salas disponibles para reservar. */
				Console.WriteLine("Elige la sala que quieres reservar:");
				Console.WriteLine("\ta - Audiovisuales");
				Console.WriteLine("\tm - Mediateca");
				Console.WriteLine("\tt - Aula de talleres");
				Console.WriteLine("\th - Sala de humaninades");
				Console.Write("Elige y una opción y pulsa enter: ");

				/*Var String Almacena el resultado que el usuario introduce por pantalla. */
				string sala = Console.ReadLine();

				/* Almacena el id de la sala que ha elegido el usuario. */
				resultado = GestionReservas.ElegirSala(sala);
				/* Si el resultado ha sido audiovisuales. */
				if (resultado == 1) {

					Console.WriteLine("Ha elegido la sala de audiovisuales. Estas son todas las horas reservadas:");

					/* Se muestran todas las horas*/
					Console.WriteLine(GestionReservas.mostrarAudiovisuales());

					/* Muestra por pantalla las opciones de reserva disponibles. */
					Console.WriteLine("¿Qué quiere hacer? Las reservas siempre son a las horas en punto.");
					Console.WriteLine("\tr - Reservar");
					Console.WriteLine("\tm - Modificar");
					Console.WriteLine("\te - Eliminar Reserva");
					Console.Write("Elige y una opción y pulsa enter: ");

					/* Almacena la opcion que el usuario introduce por pantalla. */
					opcion = Console.ReadLine();

					/* Switch-case que permite al usuario realizar, modificar, o eliminar una reserva. */
					switch (opcion) {

						/* Caso Reservar. */
						case "r":
							Console.WriteLine("Seleccione la hora que quiere reservar (Recuerde, entre las 0:00 y las 23:00. Solo horas en punto.)");
							/* Almacena la hora que el usuario introduce por pantalla. */
							horaReserva = Console.ReadLine();

							/* Si la hora introducida es correcta se realiza la reserva. */
							if (GestionReservas.ReservarAudioVisuales(horaReserva))
								Console.WriteLine("La reserva ha sido realizada correctamente a las " + horaReserva + " horas");
							/* Si no, muestra el error. */
							else
								Console.WriteLine("No se ha podido realizar la reserva a esa hora.");
							break;

						/* Caso Modificar. */
						case "m":
							Console.WriteLine("Seleccione la hora que quiere modificar");
							/* Almacena la hora que el usuario introduce por pantalla. */
							horaVieja = Console.ReadLine();
							Console.WriteLine("Indique la nueva hora a la que quiere reservar.");
							/* Almacena la hora que el usuario introduce por pantalla. */
							horaReserva = Console.ReadLine();

							/* Si la hora introducida es correcta se realiza la modificación de la reserva. */
							if (GestionReservas.ModificarAudioVisuales(horaVieja, horaReserva))
								Console.WriteLine("La reserva de las " + horaVieja + " ha sido modificada correctamente a las " + horaReserva + " horas");
							/* Si no, muestra el error. */
							else
								Console.WriteLine("No se ha podido modificar la reserva a esa hora.");
							break;
						/* Caso Eliminar Reserva. */
						case "e":
							Console.WriteLine("Seleccione la hora de la reserva que quiere eliminar. ");
							/* Almacena la hora que el usuario introduce por pantalla. */
							horaReserva = Console.ReadLine();
							/* Si la hora introducida es correcta se realiza la eliminación de la reserva. */
							if (GestionReservas.EliminarReservaAudioVisuales(horaReserva))
								Console.WriteLine("La reserva de las " + horaReserva + " ha sido eliminada correctamente.");
							/* Si no, muestra el error. */
							else
								Console.WriteLine("No se ha podido eliminar la reserva a esa hora.");
							break;
						/* Si no se ha elegido una opción correcta, el programa llega al final. */
						default:
							break;
					}
				}

				else if (resultado == 2) {
					Console.WriteLine("Ha elegido la mediateca. Estas son todas las horas reservadas:");

					/* Se muestran todas las horas*/
						Console.WriteLine(GestionReservas.mostrarMediateca());
				
					/* Muestra por pantalla las opciones de reserva disponibles. */
					Console.WriteLine("¿Qué quiere hacer? Las reservas siempre son a las horas en punto.");
					Console.WriteLine("\tr - Reservar");
					Console.WriteLine("\tm - Modificar");
					Console.WriteLine("\te - Eliminar Reserva");
					Console.Write("Elige y una opción y pulsa enter: ");

					/* Almacena la opcion que el usuario introduce por pantalla. */
					opcion = Console.ReadLine();

					/* Switch-case que permite al usuario realizar, modificar, o eliminar una reserva. */
					switch (opcion) {

						/* Caso Reservar. */
						case "r":
							Console.WriteLine("Seleccione la hora que quiere reservar (Recuerde, entre las 0:00 y las 23:00. Solo horas en punto.)");
							/* Almacena la hora que el usuario introduce por pantalla. */
							horaReserva = Console.ReadLine();

							/* Si la hora introducida es correcta se realiza la reserva. */
							if (GestionReservas.ReservarMediateca(horaReserva))
								Console.WriteLine("La reserva ha sido realizada correctamente a las " + horaReserva + " horas");
							/* Si no, muestra el error. */
							else
								Console.WriteLine("No se ha podido realizar la reserva a esa hora.");
							break;

						/* Caso Modificar. */
						case "m":
							Console.WriteLine("Seleccione la hora que quiere modificar");
							/* Almacena la hora que el usuario introduce por pantalla. */
							horaVieja = Console.ReadLine();
							Console.WriteLine("Indique la nueva hora a la que quiere reservar.");
							/* Almacena la hora que el usuario introduce por pantalla. */
							horaReserva = Console.ReadLine();

							/* Si la hora introducida es correcta se realiza la modificación de la reserva. */
							if (GestionReservas.ModificarMediateca(horaVieja, horaReserva))
								Console.WriteLine("La reserva de las " + horaVieja + " ha sido modificada correctamente a las " + horaReserva + " horas");
							/* Si no, muestra el error. */
							else
								Console.WriteLine("No se ha podido modificar la reserva a esa hora.");
							break;
						/* Caso Eliminar Reserva. */
						case "e":
							Console.WriteLine("Seleccione la hora de la reserva que quiere eliminar. ");
							/* Almacena la hora que el usuario introduce por pantalla. */
							horaReserva = Console.ReadLine();
							/* Si la hora introducida es correcta se realiza la eliminación de la reserva. */
							if (GestionReservas.EliminarReservaMediateca(horaReserva))
								Console.WriteLine("La reserva de las " + horaReserva + " ha sido eliminada correctamente.");
							/* Si no, muestra el error. */
							else
								Console.WriteLine("No se ha podido eliminar la reserva a esa hora.");
							break;
						/* Si no se ha elegido una opción correcta, el programa llega al final. */
						default:
							break;
					}
				}

				else if (resultado == 3) {
					Console.WriteLine("Ha elegido el aula de talleres. Estas son todas las horas reservadas:");

					/* Se muestran todas las horas*/
					Console.WriteLine(GestionReservas.mostrarTalleres());
					/* Muestra por pantalla las opciones de reserva disponibles. */
					Console.WriteLine("¿Qué quiere hacer? Las reservas siempre son a las horas en punto.");
					Console.WriteLine("\tr - Reservar");
					Console.WriteLine("\tm - Modificar");
					Console.WriteLine("\te - Eliminar Reserva");
					Console.Write("Elige y una opción y pulsa enter: ");

					/* Almacena la opcion que el usuario introduce por pantalla. */
					opcion = Console.ReadLine();

					/* Switch-case que permite al usuario realizar, modificar, o eliminar una reserva. */
					switch (opcion) {

						/* Caso Reservar. */
						case "r":
							Console.WriteLine("Seleccione la hora que quiere reservar (Recuerde, entre las 0:00 y las 23:00. Solo horas en punto.)");
							/* Almacena la hora que el usuario introduce por pantalla. */
							horaReserva = Console.ReadLine();

							/* Si la hora introducida es correcta se realiza la reserva. */
							if (GestionReservas.ReservarTalleres(horaReserva))
								Console.WriteLine("La reserva ha sido realizada correctamente a las " + horaReserva + " horas");
							/* Si no, muestra el error. */
							else
								Console.WriteLine("No se ha podido realizar la reserva a esa hora.");
							break;

						/* Caso Modificar. */
						case "m":
							Console.WriteLine("Seleccione la hora que quiere modificar");
							/* Almacena la hora que el usuario introduce por pantalla. */
							horaVieja = Console.ReadLine();
							Console.WriteLine("Indique la nueva hora a la que quiere reservar.");
							/* Almacena la hora que el usuario introduce por pantalla. */
							horaReserva = Console.ReadLine();

							/* Si la hora introducida es correcta se realiza la modificación de la reserva. */
							if (GestionReservas.ModificarTalleres(horaVieja, horaReserva))
								Console.WriteLine("La reserva de las " + horaVieja + " ha sido modificada correctamente a las " + horaReserva + " horas");
							/* Si no, muestra el error. */
							else
								Console.WriteLine("No se ha podido modificar la reserva a esa hora.");
							break;
						/* Caso Eliminar Reserva. */
						case "e":
							Console.WriteLine("Seleccione la hora de la reserva que quiere eliminar. ");
							/* Almacena la hora que el usuario introduce por pantalla. */
							horaReserva = Console.ReadLine();
							/* Si la hora introducida es correcta se realiza la eliminación de la reserva. */
							if (GestionReservas.EliminarReservaTalleres(horaReserva))
								Console.WriteLine("La reserva de las " + horaReserva + " ha sido eliminada correctamente.");
							/* Si no, muestra el error. */
							else
								Console.WriteLine("No se ha podido eliminar la reserva a esa hora.");
							break;
						/* Si no se ha elegido una opción correcta, el programa llega al final. */
						default:
							break;
					}
				}

				else if (resultado == 4) {
					Console.WriteLine("Ha elegido la sala de humanidades. Estas son todas las horas reservadas:");

					/* Se muestran todas las horas*/
					Console.WriteLine(GestionReservas.mostrarHumanidades());
					/* Muestra por pantalla las opciones de reserva disponibles. */
					Console.WriteLine("¿Qué quiere hacer? Las reservas siempre son a las horas en punto.");
					Console.WriteLine("\tr - Reservar");
					Console.WriteLine("\tm - Modificar");
					Console.WriteLine("\te - Eliminar Reserva");
					Console.Write("Elige y una opción y pulsa enter: ");

					/* Almacena la opcion que el usuario introduce por pantalla. */
					opcion = Console.ReadLine();

					/* Switch-case que permite al usuario realizar, modificar, o eliminar una reserva. */
					switch (opcion) {

						/* Caso Reservar. */
						case "r":
							Console.WriteLine("Seleccione la hora que quiere reservar (Recuerde, entre las 0:00 y las 23:00. Solo horas en punto.)");
							/* Almacena la hora que el usuario introduce por pantalla. */
							horaReserva = Console.ReadLine();

							/* Si la hora introducida es correcta se realiza la reserva. */
							if (GestionReservas.ReservarHumanidades(horaReserva))
								Console.WriteLine("La reserva ha sido realizada correctamente a las " + horaReserva + " horas");
							/* Si no, muestra el error. */
							else
								Console.WriteLine("No se ha podido realizar la reserva a esa hora.");
							break;

						/* Caso Modificar. */
						case "m":
							Console.WriteLine("Seleccione la hora que quiere modificar");
							/* Almacena la hora que el usuario introduce por pantalla. */
							horaVieja = Console.ReadLine();
							Console.WriteLine("Indique la nueva hora a la que quiere reservar.");
							/* Almacena la hora que el usuario introduce por pantalla. */
							horaReserva = Console.ReadLine();

							/* Si la hora introducida es correcta se realiza la modificación de la reserva. */
							if (GestionReservas.ModificarHumanidades(horaVieja, horaReserva))
								Console.WriteLine("La reserva de las " + horaVieja + " ha sido modificada correctamente a las " + horaReserva + " horas");
							/* Si no, muestra el error. */
							else
								Console.WriteLine("No se ha podido modificar la reserva a esa hora.");
							break;
						/* Caso Eliminar Reserva. */
						case "e":
							Console.WriteLine("Seleccione la hora de la reserva que quiere eliminar. ");
							/* Almacena la hora que el usuario introduce por pantalla. */
							horaReserva = Console.ReadLine();
							/* Si la hora introducida es correcta se realiza la eliminación de la reserva. */
							if (GestionReservas.EliminarReservaHumanidades(horaReserva))
								Console.WriteLine("La reserva de las " + horaReserva + " ha sido eliminada correctamente.");
							/* Si no, muestra el error. */
							else
								Console.WriteLine("No se ha podido eliminar la reserva a esa hora.");
							break;
						/* Si no se ha elegido una opción correcta, el programa llega al final. */
						default:
							break;
					}
				}

				Console.WriteLine("\n------------------------\n");

				// Wait for the user to respond before closing.
				Console.Write("Muchas gracias por usar nuestros servicios. Si quiere hacer cualquier otra consulta, pulse cualquier tecla. Y si quiere salir, pulse la tecla 'n'");
				if (Console.ReadLine() == "n") 
						endApp = true;
				Console.WriteLine("\n"); // Friendly linespacing.
			}
		}
	}
}
