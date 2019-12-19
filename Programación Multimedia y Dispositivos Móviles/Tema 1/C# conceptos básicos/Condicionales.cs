using System;

namespace conceptosBasicos
{
    class Condicionales {

        public void condicionalIf () {
            int a = 5;
            int b = 6;

            if (a + b > 10) 
                Console.WriteLine("The answer is greater than 10.");
        }

        public void condicionalIfElse () {
            int a = 5;
            int b = 3;
            if( a + b > 10 )
                Console.WriteLine("The answer is greater than 10.");
            else
                Console.WriteLine("The answer is not greater than 10.");
        }

        public void condicionalIfElseMultilinea () {
            int a = 5;
            int b = 3;
            if( (a + b > 10) && (a == b) ) {
                Console.WriteLine("The answer is greater than 10.");
                Console.WriteLine("And the first number is equal to the second");
            }
            else{
                Console.WriteLine("The answer is not greater than 10.");
                Console.WriteLine("Or the first number is not equal to the second");
            }
        }

        public void bucleWhile () {
            int counter = 0;
            while (counter < 10) {
                Console.WriteLine($"Hello World! The counter is {counter}");
                counter++;
            }
        }

        public void bucleDoWhile () {
            int counter = 0;
            do {
                Console.WriteLine($"Hello World! The counter is {counter}");
                counter++;
            } while (counter < 10);
        }

        public void bucleFor () {
            for(int counter = 0; counter < 10; counter++) {
                Console.WriteLine($"Hello World! The counter is {counter}");
            }
        }

        public void bucleForAndIf () {
            int sum = 0;
            for ( int number = 1; number < 21; number++ ) {
                if (number % 3 == 0) {
                    sum = sum + number;
                }
            }
            Console.WriteLine($"The sum is {sum}");
        }
    }
}