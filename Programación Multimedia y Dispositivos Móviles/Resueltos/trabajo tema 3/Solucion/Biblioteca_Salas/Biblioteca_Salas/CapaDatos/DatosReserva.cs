using System.Collections.Generic;
using System.Threading.Tasks;
using SQLite;
using Biblioteca_Salas.CapaNegocio;
using System;

namespace Biblioteca_Salas.CapaDatos {
	public class DatosReserva {

		/** Campos. */
		readonly SQLiteAsyncConnection _database;

		/** Métodos. */
		public DatosReserva(string dbPath) {
			/** Crea la conexión a la base de datos y crea una tabla en caso de no existir. */
			_database = new SQLiteAsyncConnection(dbPath);
			_database.CreateTableAsync<Reserva>().Wait();
		}

		public Task<int> DropTable() {
			/** Borra la tabla y devuelve un entero. */
			return _database.DropTableAsync<Reserva>();
		}

		public Task<List<Reserva>> GetReservaAsync(string sala) {
			/** Devuelve la lista de reservas de una sala. */
			return _database.Table<Reserva>().Where(i => i.Nombre_Sala == sala).ToListAsync();
		}

		public async Task<bool> GetReservaAsync(string sala, string hora) {
			/** Almacena la reserva que devuelve la consulta en una lista de reservas. */
			List<Reserva> lista = await _database.Table<Reserva>()
							.Where(i => i.Nombre_Sala.Equals(sala) && i.Hora_Reserva.Equals(hora)).ToListAsync();
			/** Si existe la reserva devuelve true. */
			if (lista.Count == 1)
				return true;
			/** Si no existe devuelve false. */
			return false;
		}


		public async Task<int> SaveReservaAsync(Reserva reserva) {
			try {
				/** Almacena la reserva que devuelve la consulta en una lista de reservas. */
				List<Reserva> lista = await _database.Table<Reserva>()
						.Where(i => i.Nombre_Sala.Equals(reserva.Nombre_Sala) && i.Hora_Reserva.Equals(reserva.Hora_Reserva)).ToListAsync();
				/** Si existe la reserva... */
				if (lista.Count == 1) {
					/** Recorremos la lista. */
					foreach (Reserva r in lista) {
						/** Asignamos los campos del objeto. */
						reserva.Id_Reserva = r.Id_Reserva;
					}
					/** Actualiza la reserva. */
					await _database.UpdateAsync(reserva);
					/** Si se ha actualizado correctamente devuelve un número. */
					return 1;
				}
				/** Si no existe la reserva... */
				else {
					/** Crea la reserva. */
					await _database.InsertAsync(reserva);
					/** Si se ha insertado correctamente devuelve un número. */
					return 2;
				}
			}
			catch (Exception) {
				/** Si hay un error devuelve un número. */
				return 0;
			}
		}
		public async Task<int> DeleteReservaAsync(Reserva reserva) {
			/** Almacena la reserva que devuelve la consulta en una lista de reservas. */
			List<Reserva> lista = await _database.Table<Reserva>()
						.Where(i => i.Nombre_Sala.Equals(reserva.Nombre_Sala) && i.Hora_Reserva.Equals(reserva.Hora_Reserva)).ToListAsync();
			/** Si existe la reserva... */
			if (lista.Count == 1) {
				/** Recorremos la lista. */
				foreach (Reserva r in lista) {
					/** Asignamos los campos del objeto. */
					reserva.Id_Reserva = r.Id_Reserva;
				}
				/** Borra la reserva. */
				await _database.DeleteAsync(reserva);
				/** Si se ha borrado correctamente devuelve un número. */
				return 1;

			}
			/** Si no existe devuelve un número. */
			return 0;
		}
	}
}
