using System;
using System.Collections.Generic;

public class Genericos<T> {
    public T field;

    LinkedList<string> llist = new LinkedList<string>();
}

public class Runnable {
      public static void Main() {
        Genericos<string> g = new Genericos<string>();
        g.field = "A string";

        Console.WriteLine("Generic.Field           = \"{0}\"", g.field);
        Console.WriteLine("Generic.Field.GetType() = {0}", g.field.GetType().FullName);
    }
}


// Ejemplo de clase con método genérico
public class Generic<T> {
    T M(T arg) {
        T temp = arg;

        return temp;
    }
}