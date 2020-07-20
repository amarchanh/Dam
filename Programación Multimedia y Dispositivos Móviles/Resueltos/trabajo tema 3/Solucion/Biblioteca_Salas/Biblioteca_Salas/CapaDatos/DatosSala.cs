using System.Collections.Generic;
using System.Threading.Tasks;
using SQLite;
using Biblioteca_Salas.CapaNegocio;
using System;

namespace Biblioteca_Salas.CapaDatos {
	public class DatosSala {
		/** Campos. */
		readonly SQLiteAsyncConnection _database;

		/** Métodos. */
		public DatosSala(string dbPath) {
			/** Crea la conexión a la base de datos y crea una tabla en caso de no existir. */
			_database = new SQLiteAsyncConnection(dbPath);
			_database.CreateTableAsync<Sala>().Wait();
		}

		public Task<List<Sala>> GetSalaAsync() {
			/** Devuelve una lista de usuarios. */
			return _database.Table<Sala>().ToListAsync();
		}

		public async Task<int> GuardarSalaAsync(Sala sala) {
			try {
				/** Almacena la sala que devuelve la consulta en una lista de salas. */
				List<Sala> lista = await _database.Table<Sala>()
									 .Where(i => i.Nombre_Sala.Equals(sala.Nombre_Sala)).ToListAsync();
				/** Si existe la sala actualiza sus datos. */
				if (lista.Count == 1) {
					await _database.UpdateAsync(sala);
					/** Si se ha actualizado correctamente devuelve un número. */
					return 1;
				}
				/** Si no existe la sala la crea. */
				else {
					await _database.InsertAsync(sala);
					/** Si se ha insertado correctamente devuelve un número. */
					return 2;

				}
			}
			catch (Exception) {
				/** Si hay un error devuelve un número. */
				return 0;
			}
		}

		public Task<int> BorrarSalaAsync(Sala sala) {
			/** Borra la sala introducida y devuelve un entero. */
			return _database.DeleteAsync(sala);
		}
	}
}
