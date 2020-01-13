using System;
using System.Collections.Generic;
using System.Text;

namespace CuentaBancaria {
    // Clase que define las propiedades y metodos que atañen a una transaccion
    class Transaction {
        // Variable cantidad. También se implementa un método get para acceder a esta propiedad
        public decimal Amount { get; }

        // Variable Fecha. También se implementa un método get para acceder a esta propiedadd
        public DateTime Date { get; }

        // Variable descripcion. También se implementa un método get para acceder a esta propiedad
        public string Notes { get; }

        // Constructor. Crea una nueva transaccion cuando se le pasa una cantidad, fecha y descripcion
        public Transaction(decimal amount, DateTime date, string note) {
            this.Amount = amount;
            this.Date = date;
            this.Notes = note;
        }
    }
}
