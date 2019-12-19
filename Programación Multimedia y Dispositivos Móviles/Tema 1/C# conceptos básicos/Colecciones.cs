using System;
using System.Collections.Generic;

class Colecciones {

    // ArrayList
    List<int> array = new List<int>();
   
    // Hash Map
    Dictionary<int, string> map = new Dictionary<int, string>();

    public void creacionListas () {
        var names = new List<string> { "<name>", "Ana", "Felipe"};
        foreach ( var name in names ) {
            Console.WriteLine($"Hello {name.ToUpper()}");
        }
    }   

    public void eliminacionElementos () {
        var names = new List<string> { "<name>", "Ana", "Felipe"};
        Console.WriteLine();
        names.Add("Maria");
        names.Add("Bill");
        names.Remove("Ana");

        Console.WriteLine($"The list has {names.Count} people in it");

        foreach (var name in names) {
            Console.WriteLine($"Hello {name.ToUpper()}!");
        }

        Console.WriteLine($"My name is {names[0]}.");
        Console.WriteLine($"I've added {names[2]} and {names[3]} to the list.");
    }

    public void indexOfList () {
        var names = new List<string> { "<name>", "Ana", "Felipe"};
        var index = names.IndexOf("Felipe");
        if (index != -1) 
            Console.WriteLine($"The name {names[index]} is at index {index}");
        else {
            var notFound = names.IndexOf("Not Found");
            Console.WriteLine($"When an item is not found, IndexOf returns {notFound}");
        }
    }

    public void sortList () {
        var names = new List<string> { "<name>", "Ana", "Felipe"};
        names.Sort();
        foreach (var name in names) {
            Console.WriteLine($"Hello {name.ToUpper()}!");
        }
    }

    public void fibonacci () {
        var fibonacciNumbers = new List<int> {1, 1};
        
        var previous = fibonacciNumbers[fibonacciNumbers.Count - 1];
        var previous2 = fibonacciNumbers[fibonacciNumbers.Count - 2];

        fibonacciNumbers.Add(previous + previous2);

        foreach ( var item in fibonacciNumbers) 
            Console.WriteLine(item);
    }


    public void fibonacci20 () {
        var fibonacciNumbers = new List<int> {1, 1};

        while (fibonacciNumbers.Count < 20) {
            var previous = fibonacciNumbers[fibonacciNumbers.Count - 1];
            var previous2 = fibonacciNumbers[fibonacciNumbers.Count - 2];

            fibonacciNumbers.Add(previous + previous2);
        }
        foreach(var item in fibonacciNumbers)
            Console.WriteLine(item);
    }
    
}