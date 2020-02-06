#include <stdio.h>
#include <stdlib.h>
#include <pvm3.h>          

int main()
  {     
      int tabla[10];   /* Tabla con los números a sumar */
      int tresult[2];  /* resultados de la suma por los esclavos*/
      int tareas, cc, tid[2], i, sum =0 ; 
      int etqenvio=1, etqrecibe=2; /*etiquetas de envio y recepcion*/

      printf("PROCESO MAESTRO: t%x\n", pvm_mytid());

      //se llena la tabla con numeros
      for(i = 0; i < 10; i++) tabla[i] = i;
    
      //se crean los esclavos
      tareas = pvm_spawn("sumesclavo", (char**)0, 0, "", 2, tid);
      printf("TAREAS: %d\n", tareas);

      //SE ENVIAN LOS DATOS    
      for(i = 0; i < 2; i++) {
          pvm_initsend(PvmDataDefault);
          pvm_pkint(tabla + i*5, 5, 1); //10 numeros, 5 para cada esclavo
          pvm_send(tid[i], etqenvio); //se envían los datos a los esclavos  
      }
      //SE RECIBEN LOS DATOS    
      for(i = 0; i < 2; i++) {        
          cc = pvm_recv(tid[i], etqrecibe);
          pvm_upkint(tresult + i, 1, 1); //desempaqueta un entero
          printf("- RECIBO DE t%x: %d\n", tid[i], tresult[i]);
      }
         
      //se obtiene la suma
      for(i = 0; i < 2; i++) sum = sum + tresult[i];
      printf("LA SUMA ES = %d\n", sum);
   
      pvm_exit();    
      exit(0);
  } 
          
  
