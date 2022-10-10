#include <stdio.h>
#include <unistd.h>
int main(){
	int i=0;
	printf ("Soy el padre y generaré 8 procesos en forma de arbol\n");
	fork();
    fork();
	fork();
	printf ("Soy un padre o un hijo?/n");
	return 0;
}