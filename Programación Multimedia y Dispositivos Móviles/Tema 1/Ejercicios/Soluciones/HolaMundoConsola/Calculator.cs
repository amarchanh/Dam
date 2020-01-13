using System;
using System.Collections.Generic;
using System.Text;

namespace HolaMundoConsola {
    class Calculator {
        public static double DoOperation(double num1, double num2, string op) {
            // Variable que almacena el resultado que se devolvera
            double result = double.NaN;
            // Posibles opciones para realizar. Se recuperara la operacion logica elegida por el usuario
            switch (op) {
                // Si se elige "a" (Suma)
                case "a":
                    // Se suma el numero y se almacena en la variable que se devolvera
                    result = num1 + num2;
                    break;
                // Si se elige "s" (Restar)
                case "s":
                    // Se resta el numero y se almacena en la variable que se devolvera
                    result = num1 - num2;
                    break;
                // Si se elige "m" (Multiplicar)
                case "m":
                    // Se multiplica el numero y se almacena en la variable que se devolvera
                    result = num1 * num2;
                    break;
                // Si se elige "d" (Dividir)
                case "d":
                    // Si el segundo numero es difrente de 0... (Si no, dara un problema matematico)
                    if (num2 != 0) {
                    // Se divide el numero y se almacena en la variable que se devolvera
                        result = num1 / num2;
                    }
                    break;
                    // Por defecto, y si no se selecciona ninguna opcion de las definidas, devolvera un error
                default:
                    break;
            }
            // Se devuelve la variable con el resultado
            return result;
        }
    }
}
