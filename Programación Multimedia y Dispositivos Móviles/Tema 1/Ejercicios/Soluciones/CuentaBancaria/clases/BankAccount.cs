using System;
using System.Collections.Generic;
using System.Text;

namespace CuentaBancaria {
    class BankAccount {
        // Numero de cuenta. Tambien se añade el metodo get para poder acceder a el
        public string Number { get; }
        // Nombre del propietario de la cuenta. Tambien se añade el metodo get para poder acceder a el
        public string Owner { get; }
        // Saldo de la cuenta. Tambien se añade el metodo get para poder acceder a el. Por cada transaccion, se suma el importe de la transaccion al saldo
        public decimal Balance {
            get {
                //  Variable que alamacenará el total del saldo de la cuenta. Se inicializa a 0
                decimal balance = 0;
                // Bucle que recorre todas las transacciones
                foreach (var item in allTransactions) {
                    // Se añade el total de cada transaccion a la variable 
                    balance += item.Amount;
                }
                // Se devuelve el saldo total
                return balance;
            }
        }

        // Numero predeterminado de cuenta
        private static int accountNumberSeed = 1234567890;
        
        // Lista de transacciones
        private List<Transaction> allTransactions = new List<Transaction>();

        // Constructor. Recibe como parametros el nombre del propietario de la cuenta y el saldo inicial
        public BankAccount (string name, decimal initialBalance) {
            // Se establece el numero de la cuenta
            this.Number = accountNumberSeed.ToString();
            // Al número base para la cuenta, se le añade uno, para que no haya dos cuentas repetidas con el mismo numero
            accountNumberSeed++;
            // Se establece el nombre del propietario 
            this.Owner = name;
            // Se realiza un deposito en la cuenta, con el saldo inicial y la fecha actual
            MakeDeposit(initialBalance, DateTime.Now, "Saldo inicial");
        }


        // Metodo que realiza depositos en la cuenta. Se necesita la cantidad, la fecha en que se realiza el deposito, y una descripción del deposito
        public void MakeDeposit(decimal amount, DateTime date, string note) {
            // Se comprueba que la cantidad no sea menor que 0
            if (amount <= 0 ) {
                // Si la cantidad es negativa, se lanza una excepcion y un  mensaje de error
                throw new ArgumentOutOfRangeException(nameof(amount), "La cantidad del ingreso debe ser positiva");
            }

            // Se crea el nuevo movimiento
            var deposit = new Transaction(amount, date, note);
            // Se añade el movimiento a la lista de transacciones
            allTransactions.Add(deposit);
        }

        // Metodo que realiza retiradas en la cuenta.
        public void MakeWithdrawal(decimal amount, DateTime date, string note) {
            // Si la cantidad es negativa, se lanza un error y un mensaje
            if(amount <= 0) {
                throw new ArgumentOutOfRangeException(nameof(amount), "La cantidad debe ser positiva");
            }
            // Si el total de la cuenta menos la cantidad a retirar es negativa, se muestra un error. No hay suficiente dinero en la cuenta.
            if (Balance - amount < 0) {
                throw new InvalidOperationException("No existe suficiente saldo para el reintegro");
            }
            // Si la cantidad no es negativa y hay suficiente dinero en la cuenta, se crea el movimiento
            var withdrawal = new Transaction(-amount, date, note);
            // Se añade el movimiento a la lista de transacciones
            allTransactions.Add(withdrawal);
        }

        // Metodo que devuelve el historico de movimientos de la cuenta
        public string GetAccountHistory() {
            // Se crea un elemento report, en el que se añadiran todos los movimientos de la cuenta
            var report = new System.Text.StringBuilder();

            // Cabecera del desglose de movimientos
            report.AppendLine("Fecha\t\tCantidad\tApunte");
            // Bucle que recorre la lista de movimientos
            foreach (var item in allTransactions) {
                // Para cada movimiento, se añade una linea con su fecha, cantidad y descripcion
                report.AppendLine($"{item.Date.ToShortDateString()}\t{item.Amount}\t\t{item.Notes}");
            }

            // Se devuelve y muestra por pantalla el registro.
            return report.ToString();
        }

    }
}
