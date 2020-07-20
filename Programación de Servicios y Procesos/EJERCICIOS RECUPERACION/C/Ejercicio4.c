#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <wait.h>

// Crea un proceso hijo en C. El programa desde el que se crea al hijo, y antes de crearlo, 
// define una variable con un valor inicial de 10. Haz que el hijo divida el valor de esa variable entre 2 
// y que el padre la multiplique por 3. Muestra el resultado de la variable desde el padre y desde el hijo.

void main() {
	int pid;
    // Variable inicial
	int numero = 10;
    // Mostramos el valor original de la variable
	printf("Valor inicial de la variable: %d\n", numero);
    // Creamos el proceso hijo
	pid = fork();

    // Ha ocurrido un error
	if (pid == -1) {
		printf("No se ha podido crear el proceso hijo...\n");
		exit(-1);
	}
    //Nos encontramos en Proceso hijo
	if (pid == 0) {
		// Mostramos la variable
		printf("Variable en proceso Hijo: %d\n", numero / 2);
	}

    //Nos encontramos en el proceso padre
	else {
        // Espera la finalización del proceso hijo
		wait(NULL); 
		// Mostramos la variable
		printf("Variable en proceso Padre: %d\n", numero * 3);
	}

    // Terminamos el programa
	exit(0);
}