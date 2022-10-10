#include <stdio.h>
#include <unistd.h>
int main(){
	int i=0;
	printf ("Soy un proceso, padre o Hijo?\n");
	fork();
	printf ("Hola mundo desde c\n");
	return 0;
}
