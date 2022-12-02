//PARTE A
console.log("PARTE A");
console.log("Creo objeto p1{nombre, apellidos}");
var p1 = new Object();
p1.nombre = "Pepe";
p1.apellidos = "Perez";
console.log(p1);
console.log("\n");

//PARTE B
console.log("Creo objeto p2 que hereda de p1")
console.log("PARTE B");
const p2 = p1;
console.log(p2);
console.log("\n");

//PARTE C
console.log("Añado parámetros 'edad' y 'altura' a p2")
console.log("PARTE C");
p2.edad = 24;
p2.altura = "162cm"
console.log(p2);
console.log("\n");

//PARTE D
console.log("PARTE D");
console.log("Recorro el objeto p2 con un bucle for...in");
for (const propiedad in p2) {
    console.log(`${propiedad}: ${p2[propiedad]}`)
}
console.log("\n");