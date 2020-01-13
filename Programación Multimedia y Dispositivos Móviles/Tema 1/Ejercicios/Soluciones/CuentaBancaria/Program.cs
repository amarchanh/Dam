using System;

namespace CuentaBancaria {
    class Program {
        static void Main(string[] args) {
            var account = new BankAccount("Pedro Andrés Mancebo", 1000);

            Console.WriteLine($"La cuenta {account.Number} creada por " +
                $"{account.Owner} con un saldo inicial de {account.Balance} .");

            account.MakeWithdrawal(500, DateTime.Now, "Pago del alquiler");
            Console.WriteLine(account.Balance);
            account.MakeDeposit(100, DateTime.Now, "Ingreso nómina");
            Console.WriteLine(account.Balance);

            // Test that the initial balances must be positive.
            try {
                var invalidAccount = new BankAccount("Incorrecto", -55);
            }
            catch (ArgumentOutOfRangeException e) {
                Console.WriteLine("Error al crear una cuenta con saldo negativo.");
                Console.WriteLine(e.ToString());
            }

            // Test for negative balance.
            try {
                account.MakeWithdrawal(750, DateTime.Now, "Intento de descubierto.");
            }
            catch (InvalidOperationException e) {
                Console.WriteLine("Error al intentar un descubierto.");
                Console.WriteLine(e.ToString());
            }

            Console.WriteLine(account.GetAccountHistory());

            Console.WriteLine("\nPulsa una tecla para finalizar");
            Console.ReadLine();
        }
    }
}
