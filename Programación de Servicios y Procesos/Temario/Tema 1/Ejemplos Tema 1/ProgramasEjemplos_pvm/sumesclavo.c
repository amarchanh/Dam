#include <stdlib.h>
#include <stdio.h>
#include <pvm3.h>
    
int main()
{
      int mytid, parent_tid;
      int tabla[5];   //tabla para enviar al maestro
      int sum =0, i;
      
      mytid = pvm_mytid();    
      parent_tid = pvm_parent();
    
      //se reciben los datos del maestro 
      pvm_recv(parent_tid, 1); //recibo con etiqueta 1 los 5 elementos del array
      pvm_upkint(tabla, 5, 1);
    
      //se calcula la suma
      for(i = 0; i < 5; i++) sum = sum + tabla[i];    
     
      //se envia el resultado al maestro
      pvm_initsend(PvmDataDefault);
      pvm_pkint(&sum, 1, 1);
      printf("\tESCLAVO t%x Suma = %d ", mytid,  sum);      
      pvm_send(parent_tid, 2); //envio con la etiqueta 2
    
      pvm_exit();      
      exit(0);
 } 

