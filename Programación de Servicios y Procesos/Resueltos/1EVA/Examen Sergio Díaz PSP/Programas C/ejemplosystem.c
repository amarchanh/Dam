#include <stdio.h>
#include <stdlib.h>
void main()
{
  printf("Ejemplo de uso de system():");
  printf("\nListado del directorio actual y envío a un fichero:");
  printf("%d",system("ls > ficsalida"));
  printf("\nAbrimos con el nano el fichero...");
  printf("%d", system("nano ficsalida"));
  printf("\nEste comando es erróneo: %d",system("ged"));
  printf("\nFin de programa....\n");
}//main
