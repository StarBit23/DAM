#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/types.h>


int main(){
    pid_t pid;
    int estado;
    pid = fork(); //creo un nuevo proceso
    char *argumentos[3] = {"ls","-l", NULL};


    switch (pid=fork())
    {
    case -1:
        printf ("Error inesperado\n");
        exit(-1);
    
    case 0:
        printf ("Soy el hijo y voy a ejecutar el comando cat con pid %d \n",getpid());
        if (execvp(argumentos[0],argumentos)){
            printf("Error de cojones");
            exit(-2);
        }
        
        printf ("Jajaja, ya he ejecutado el comando pasado y sigo siendo %d, ¿Que ha pasado?", getpid());
        break;

    default:
        printf ("Soy el padre con pid %d y voy a esperar a mi hijo hijo con pid %d\n",getpid(), pid);
        wait(estado);
        printf ("Ahora si que muero");
        break;
    }
}