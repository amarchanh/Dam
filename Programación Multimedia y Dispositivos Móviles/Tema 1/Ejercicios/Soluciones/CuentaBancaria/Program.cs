using System;

namespace CuentaBancaria {
    // Clase que ejecuta el programa principal
    class Program {
        static void Main(string[] args) {
            // Se crea una nueva cuenta bancaria
            var account = new BankAccount("Pedro Andrés Mancebo", 1000);

            // Se muestra la informacion por pantalla
            Console.WriteLine($"La cuenta {account.Number} creada por " +
                $"{account.Owner} con un saldo inicial de {account.Balance} .");

            // Se hace una retirada de dinero
            account.MakeWithdrawal(500, DateTime.Now, "Pago del alquiler");
            // Se muestra por consola el saldo de la cuenta
            Console.WriteLine(account.Balance);
            // Se hace un deposito en la cuenta
            account.MakeDeposit(100, DateTime.Now, "Ingreso nómina");
            // Se muestra por consola el saldo de la cuenta
            Console.WriteLine(account.Balance);

            // Comprueba que el saldo de la cuenta se debe inicializar positivamente
            try {
                // Se crea una nueva cuenta, con un saldo inicial negativo
                var invalidAccount = new BankAccount("Incorrecto", -55);
            }
            catch (ArgumentOutOfRangeException e) {
                // Se muestra el error por pantalla
                Console.WriteLine("Error al crear una cuenta con saldo negativo.");
                Console.WriteLine(e.ToString());
            }

            // Se comprueba que una cuenta no puede quedarse con saldo negativo
            try {
                // Se crea una retirada de dinero de la cuenta
                account.MakeWithdrawal(750, DateTime.Now, "Intento de descubierto.");
            }
            catch (InvalidOperationException e) {
                // Si el saldo llega a negativo, se muestra el error por pantalla
                Console.WriteLine("Error al intentar un descubierto.");
                Console.WriteLine(e.ToString());
            }

            // Se muestra el historico de transacciones de la cuenta
            Console.WriteLine(account.GetAccountHistory());

            // Se finaliza el programa
            Console.WriteLine("\nPulsa una tecla para finalizar");
            Console.ReadLine();
        }
    }
}
