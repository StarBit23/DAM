#include <stdio.h>
#include <unistd.h>
int main(){
	int pid=fork();
    if (pid==0)
	    printf ("Soy el proceso hijo, mi pid es %d \n",getpid());
	else
	    printf ("Soy el proceso padre y el pid de mi hijo es %d y el mio es %d",pid, getpid());
	return 0;
}