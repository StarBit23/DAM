//Dada la variable nota. Imprime suspenso<5,bien<8, excelente<=10 
const nota = 5;
if (nota<5) {
    console.log("Has sacado un " + nota + ". Suspenso, hay que mejorar\n")
}if (nota<8) {
    console.log("Has sacado un " + nota + ". Bien ¡Te sabes el tema!\n")
} else {
    console.log("Has sacado un " + nota + ". ¡Excelente! Eres insuperable\n")
}

//Usa while para calcular la suma de los 100 primeros números impares
let num=0;
let contador=0;
let listaImpar = [];
while (contador<100) {
    contador++;
    if(contador%2 != 0){
        num += contador;
        //listaImpar.push(num);
    }
}
console.log("La suma de todos los impares hasta 100 vale "+num + "\n");


//Imprime los números del 1 al 100 con for
let listaNumHastaCien=[];
for (let i = 1; i <= 100; i++) {
    listaNumHastaCien.push(i);
}
console.log(listaNumHastaCien + "\n");

//Crea un array de cadenas. Imprime el array completo con for-of
let listadoCadenas = ["manzana","coche","minecraft","USB"];
for (const iterator of listadoCadenas) {
    console.log(iterator)
}
console.log("\n")

//Crea una función que genere los 100 primeros números primos.
const listaPrimos = [];
function esPrimo(numero) {
    for(let i = 2,raiz=Math.sqrt(numero); i <= raiz; i++)
        if(numero % i === 0) return false;
    return numero > 1;
    }

    for (let x=0;x<=100;x++) {
        if (esPrimo(x))
        listaPrimos.push(x);
    }
    console.log(`Lista de numeros primos: ${listaPrimos}\n`);

/*Tenemos let bandera = null. Si bandera es verdadero la variable num será 0, en caso contrario será 1.
Usa el operador ternario.
Prueba con el valor bandera = undefined.
Prueba con bandera = false
Prueba con bandera = true
*/
let bandera = null;

bandera=undefined;
console.log("bandera=undefined");
console.log(bandera ? num=1 : num=0 +"\n");

bandera=false;
console.log("bandera=false");
console.log(bandera ? num=1 : num=0 +"\n");

bandera=true;
console.log("bandera=true");
console.log(bandera ? num=1 : num=0);