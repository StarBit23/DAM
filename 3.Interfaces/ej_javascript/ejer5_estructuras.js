//Dada la variable nota. Imprime suspenso<5,bien<8, excelente<=10
console.log("Dada la variable nota. Imprime suspenso<5,bien<8, excelente<=10");
let nota=5;
if(nota<5){
    console.log("Suspenso");
}else if (nota<8) {
    console.log("Bien");
} else if(nota<=10){
    console.log("Excelente");
}
console.log("-------------------------------");

//Usa while para calcular la suma de los 100 primeros números impares
console.log("Usa while para calcular la suma de los 100 primeros números impares");
let num=0;
let contador=0;
let arrayImpar = [];
while (contador<100) {
    contador++;
    num++;
    if(num%2 != 0){
        arrayImpar.push(num);
    }
}
console.log(arrayImpar);
console.log("-------------------------------");

//Imprime los números del 1 al 100 con for
console.log("Imprime los números del 1 al 100 con for");
let arrNum=[];
for (let i = 0; i <= 100; i++) {
    arrNum.push(i);
}
console.log(arrNum);
console.log("-------------------------------");

//Crea un array de cadenas. Imprime el array completo con for-of
let arrayCadenas = ["pepe","ana","lorenzo","mario","gustavo"]; 
for (const i of arrayCadenas) {
    console.log(i);
}
console.log("-------------------------------");

//Crea una función que genere los 100 primeros números primos.

/*Tenemos let bandera = null. Si bandera es verdadero la variable num será 0, en caso contrario será 1.
Usa el operador ternario.
Prueba con el valor bandera = undefined.
Prueba con bandera = false
Prueba con bandera = true
*/
console.log("bandera=null");
let bandera = null;
console.log(bandera ? num=1 : num=0);
console.log("-------------------------------");

console.log("bandera=undefined");
bandera = undefined;
console.log(bandera ? num=1 : num=0);
console.log("-------------------------------");

console.log("bandera=true");
bandera = true;
console.log(bandera ? num=1 : num=0);
