//Numbers

//Calcula la raíz cuadrada de 1234567890.
 const raiz = Math.sqrt(1234567890);

//Redondea el resultado anterior hacia arriba.
Math.round(raiz);

//Obten el valor máximo y mínimo de una lista de valores.
let arrayNumeros = [1,2,3,4,5,6,7,8,9,10];
console.log("Array de numeros:");
for (let i=0;i<arrayNumeros.length;i++){
    console.log(arrayNumeros[i]);
}
const maximo = Math.max(...arrayNumeros);
console.log("Numero máximo: "+maximo)
const minimo = Math.min(...arrayNumeros);
console.log("Numero minimo: "+minimo+"\n");

//Calcula la longitud de una circunferencia de radio r.
const radio = 5;
const circunferencia = 2 * Math.PI * radio;
console.log("Longitud circunferencia de radio 5: "+circunferencia+"\n");

//Calcula los 100 primeros números primos.
function esPrimo(numero) {
for(let i = 2,raiz=Math.sqrt(numero); i <= raiz; i++)
    if(numero % i === 0) return false;
return numero > 1;
}  
for (let x=0;x<=100;x++) {
    if (esPrimo(x))
        console.log("El número " + x + " es primo");
}
console.log("\n");
//Genera una lista con 100 números aleatorios de 0 a 99.
function getRandomInt(min, max) {
    min = Math.ceil(min);
    max = Math.floor(max);
    return Math.floor(Math.random() * (max - min) + min);
}

let arrayRandom = [];
for (let i=0;i<100;i++){
    arrayRandom[i] = getRandomInt(0, 99); 
}
console.log(`Array de aleatorios ${arrayRandom}, tam: ${arrayRandom.length}\n`);

//Calcula la media aritmética de la lista anterior.
let sumatoria = 0;
for (let i = 0; i < arrayRandom.length; i++) {
    sumatoria += arrayRandom[i];
}
let mediaAritmetica = sumatoria / arrayRandom.length;
console.log("La media del array aleatorio vale "+mediaAritmetica+"\n");

//Crea otra lista que contenga solo los números de la lista anterior que sean menores de 50
let arrayMenor50 = [];
for (let i = 0; i < arrayRandom.length; i++) {
    if (arrayRandom[i] <= 50){
        let varRandom = arrayRandom[i];
        arrayMenor50.push(varRandom);
    }
}
console.log(`Array de aleatorios menor que 50: ${arrayMenor50}, tam: ${arrayMenor50.length}`);

