using System;

namespace HolaMundoConsola {
    class Program {
        static void Main(string[] args) {
            // Flag para ejecutar la aplicacion hasta que se cambie su valor
            bool endApp = false;

            // Inicio de la aplicacion
            Console.WriteLine("Console Calculator in C#\r");
            Console.WriteLine("--------------------------\n");

            // Bucle para ejecutar la aplicacion mientras que no cambie el flag
            while (!endApp) {
                // Definicion de variables
                string numInput1 = "";
                string numInput2 = "";
                double result = 0;

                // Mensaje y almacenamiento para el numero 1 en la variable numInput1
                Console.WriteLine("Type a number, and then press Enter: ");
                numInput1 = Console.ReadLine();

                // Variable para almacenar el valor (double) de la variable numInput1
                double cleanNum1 = 0;

                // Bucle para parsear a Double el valor de la variable numInput1 (string)
                while (!double.TryParse(numInput1, out cleanNum1)) {
                    // Si el parseo no se puede realizar, vuelve a pedir el numero hasta que se introduzca uno valido
                    Console.WriteLine("This is not valid input. Please, enter an integer value: ");
                    numInput1 = Console.ReadLine();
                }

                // Mensaje y almacenamiento para el numero 2 en la variable numInput2
                Console.WriteLine("Type another number, and then press Enter: ");
                numInput2 = Console.ReadLine();

                // Variable para almacenar el valor (double) de la variable numInput2
                double cleanNum2 = 0;

                // Bucle para parsear a Double el valor de la variable numInput2 (string)
                while(!double.TryParse(numInput2, out cleanNum2)) {
                    // Si el parseo no se puede realizar, vuelve a pedir el numero hasta que se introduzca uno valido
                    Console.WriteLine("This is not valid input. Please, enter an integer value: ");
                    numInput2 = Console.ReadLine();
                }

                // Mensaje para dar las diferentes opciones logicas que se pueden realizar con ambos numeros
                Console.WriteLine("Choose an operator from the following list: ");
                // Sumar
                Console.WriteLine("\ta - Add");
                // Restar
                Console.WriteLine("\ts - Subtract");
                // Multiplicar
                Console.WriteLine("\tm - Multiply");
                // Dividir
                Console.WriteLine("\td - Divide");

                Console.WriteLine("Your option? ");

                // Almacenamiento de la opcion del usuario
                string op = Console.ReadLine();

                try {
                    // Se llama al metodo de la clase Calculator que realiza la logica de la aplicacion. Se envian ambos numeros, y la operacion logica seleccionada por el usuario
                    result = Calculator.DoOperation(cleanNum1, cleanNum2, op);

                    // Si el resultado no es un numero, se muestra un mensaje de error
                    if (double.IsNaN(result)) {
                        Console.WriteLine("This operation will result in mathematical error.\n");
                    }
                    // En caso contrario, se muestra el resultado
                    else {
                        // Se muestra el resultado en una linea. En tiempo de ejecucion, se sustituirá el valor del texto entre corchetes ( { } ), por el resultado. 
                        // En el interior de los corchetes se muestra el formato deseado para mostrar el resultado por pantalla. En este caso, un numero con decimales
                        Console.WriteLine("Your result: {0:0.##}\n", result);
                    }
                }
                // Si ocurre algun problema durante la ejecucion, se muestra un mensaje de error, y la descripcion del mismo.
                catch (Exception e) {

                    Console.WriteLine("Oh no! An exception occurred trying to do the math.\n - Details: " + e.Message);
                }

                // Se muestra un mensaje que permite volver a realizar otra operacion
                Console.WriteLine("------------------------\n");
                Console.Write("Press 'n' and Enter to close the app, or press any other key and Enter to continue: ");

                // Si el usuario presiona la letra "n" y pulsa enter, se finaliza la ejecucion de la aplicacion. 
                // Si se presiona cualquier otra tecla y se presiona Enter, se realiza una nueva operacion
                if (Console.ReadLine() == "n") endApp = true;
                
                Console.WriteLine("\n");

            }
        }

        // Se finaliza el programa

    }
}

