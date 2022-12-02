//PARTE A
console.log("PARTE A");
console.log("arrayAleatorio con 100 números aleatorios del 0 al 10");
let arrayAleatorio = Array.from({
    length: 100
}, () => Math.floor(Math.random() * 11));
console.log(arrayAleatorio);
console.log("\n");

//PARTE B
console.log("PARTE B");
console.log("Creo copia de arrayAleatorio");
var copiaArrayAleatorio = arrayAleatorio.slice([])
console.log(copiaArrayAleatorio)
console.log("\n");

//PARTE C
console.log("PARTE C");
const [a, b, ...rest] = copiaArrayAleatorio
console.log("Primero, segundo, resto:\n" + a, b, rest)
console.log("\n");

//PARTE D
console.log("PARTE D");

function maxArray(copiaArrayAleatorio) {
    return Math.max.apply(null, copiaArrayAleatorio);
}

function minArray(copiaArrayAleatorio) {
    return Math.min.apply(null, copiaArrayAleatorio);
}
let arrayMaxMin = new Array();
arrayMaxMin.push(maxArray(copiaArrayAleatorio));
arrayMaxMin.push(minArray(copiaArrayAleatorio))
console.log("Valores MAX y Min de arrayAleatorio: " + arrayMaxMin)
console.log("\n");

//PARTE E
console.log("PARTE E");
console.log("Doble de arrayAleatorio con función map");
const mapArrayAleatorio = copiaArrayAleatorio.map(x => x * 2);
console.log(mapArrayAleatorio);
console.log("\n");

//PARTE F
console.log("PARTE F");
console.log("Muestro números menores que 5 de arrayAleatorio");
const result = copiaArrayAleatorio.filter(num => num < 5);
console.log(result);
console.log("\n");

console.log("Hecho por Jorge Ortega Morales")