#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/types.h>

void pruebaParametros(int args, char ** argv){
    printf ("El numero de argumentos son %d\n",args);
    for (int i = 0; i < args; i++){
        printf ("Arg(%d) = %s\n", i, argv[i]);
    }
    
}

int main(int args, char **argv){
    pid_t pid;
    int estado;
    pid = fork(); //creo un nuevo proceso
    switch (pid=fork())
    {
    case -1:
        printf ("Error inesperado\n");
        exit(-1);
    
    case 0:
        printf ("Soy el hijo y voy a ejecutar el comando cat con pid %d \n",getpid());
        if (execvp(argv[1], & argv[1] <0)){
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