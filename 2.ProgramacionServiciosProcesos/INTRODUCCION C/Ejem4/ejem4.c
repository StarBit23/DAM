#include <stdio.h>
#include <unistd.h>

int main(){
    incrementa();
    return 0;
}

void incrementa(){
    int conta = 1;
    if (fork()){
        for (int i=0; i < 5000000; i++)
            conta = conta;
        printf ("Soy el padre y voy a incrementar la variable conta = %d \n", ++conta);
    }else{
        for (int i=0; i < 5000; i++)
            conta = conta;
        printf ("Soy el hijo y voy a decrementar la variable conta = %d \n", --conta);

    }
}