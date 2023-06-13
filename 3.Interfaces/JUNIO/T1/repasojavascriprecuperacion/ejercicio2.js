//Numbers

//Calcula la raíz cuadrada de 1234567890.
const num = 1234567890;
const raiz = Math.sqrt(num);
console.log("Raiz de "+num+": "+raiz)
console.log("\n")

//Redondea el resultado anterior hacia arriba.
const raizRedondeo = Math.round(raiz);
console.log("Redondeo de "+raiz+": "+raizRedondeo)
console.log("\n")

//Obten el valor máximo y mínimo de una lista de valores.
let listaNumeros = [1,2,3,4,5,6,7,8,9,10];
console.log("Lista de numeros:");
for (let i=0;i<listaNumeros.length;i++){
    console.log(listaNumeros[i]);
}
const maximo = Math.max(...listaNumeros);
console.log("Valor máximo: "+maximo)
const minimo = Math.min(...listaNumeros);
console.log("Valor minimo: "+minimo+"\n");

//Calcula la longitud de una circunferencia de radio r.
const radio = 5;
const circunferencia = 2 * Math.PI * radio;
console.log("Longitud circunferencia de radio "+radio+": "+circunferencia+"\n");

//Calcula el valor de x de la ecuación 2x+x+1=0.
var a = 3;
var b = 1;

var x = -b/a;

console.log("La solución de la ecuación es: x = " + x+"\n");


//Calcula los 100 primeros números primos.
const listaPrimos = [];
function esPrimo(numero) {
    for(let i = 2,raiz=Math.sqrt(numero); i <= raiz; i++)
        if(numero % i === 0) return false;
    return numero > 1;
    }

    for (let x=0;x<=100;x++) {
        if (esPrimo(x))
        listaPrimos.push(x);
            //console.log("El número " + x + " es primo");
    }
    console.log(`Lista de numeros primos: ${listaPrimos}\n tamaño: ${listaPrimos.length}\n`);
    

//Genera una lista con 100 números aleatorios de 0 a 99.
function getRandomInt(min, max) {
    min = Math.ceil(min);
    max = Math.floor(max);
    return Math.floor(Math.random() * (max - min) + min);
}

let listaRandom = [];
for (let i=0;i<100;i++){
    listaRandom[i] = getRandomInt(0, 99); 
}
console.log(`Array de aleatorios: ${listaRandom}\n tamaño: ${listaRandom.length}\n`);

//Calcula la media aritmética de la lista anterior.
let numerosSumados=0;
for (let i = 0; i < listaRandom.length; i++) {
    numerosSumados += listaRandom[i];
}
const mediaAleatorios = numerosSumados/listaRandom.length;
console.log(`La media de listaRandom es de ${mediaAleatorios}\n`);

//Crea otra lista que contenga solo los números de la lista anterior que sean menores de 50
const listaMenor50=[];
for (let i = 0; i < listaRandom.length; i++) {
    if (listaRandom[i] <50) {
        listaMenor50.push(listaRandom[i]);
    }
}
console.log(`Array de aleatorios menores que 50: ${listaMenor50}\n tamaño: ${listaMenor50.length}`);

