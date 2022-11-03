#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/types.h>

int main(){
    int op = 1, estado;
    pid_t pid;

    switch (pid=fork())
    {
    case -1:
        printf ("Ha pasado algo y error inesperado\n");
        exit(-1);
    
    case 0:
        printf ("Soy el hijo con pid %d \n",getpid());
        break;

    default:
        printf ("Soy el padre con pid %d y estoy esperando a que acabe el hijo con pid %d \n",getpid(), pid);
        wait(estado);
        printf ("Ahora si que muero");
    }
}