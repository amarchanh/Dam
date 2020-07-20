using System.Collections.Generic;
using System.Threading.Tasks;
using SQLite;
using Biblioteca_Salas.CapaNegocio;
using System;

namespace Biblioteca_Salas.CapaDatos {
	public class DatosUsuario {
		/** Campos. */
		readonly SQLiteAsyncConnection _database;

		/** Métodos. */
		public DatosUsuario(string dbPath) {
			/** Crea la conexión a la base de datos y crea una tabla en caso de no existir. */
			_database = new SQLiteAsyncConnection(dbPath);
			_database.CreateTableAsync<Usuario>().Wait();
		}

		public Task<List<Usuario>> GetUsuarioAsync() {
			/** Devuelve una lista de usuarios. */
			return _database.Table<Usuario>().ToListAsync();
		}

		public async Task<int> GuardarUsuarioAsync(Usuario usuario) {
			try {
				/** Almacena el usuario que devuelve la consulta en una lista de usuarios. */
				List<Usuario> lista = await _database.Table<Usuario>()
						.Where(i => i.Nombre_Usuario.Equals(usuario.Nombre_Usuario)).ToListAsync();
				/** Si existe el usuario lo actualiza. */
				if (lista.Count == 1) {
					await _database.UpdateAsync(usuario);
					/** Si se ha actualizado correctamente devuelve un número. */
					return 1;
				}
				/** Si no existe el usuario lo crea. */
				else {
					await _database.InsertAsync(usuario);
					/** Si se ha insertado correctamente devuelve un número. */
					return 2;
				}
			}
			catch (Exception) {
				/** Si hay un error devuelve un número. */
				return 0;
			}
		}

		public Task<int> BorrarUsuarioAsync(Usuario usuario) {
			/** Borra el usuario introducido y devuelve un entero. */
			return _database.DeleteAsync(usuario);
		}
	}
}
