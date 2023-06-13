//Desestructuración

//Desestructura dia, mes y año e imprime la fecha.
const fecha = ['06', 'Octubre', '2021'];
const [dia,mes,año] = fecha;
console.log("Dia: " + dia);
console.log("Mes: " + mes);
console.log("Año: " + año + "\n");

//////////////////////////////////////////////////////

const listado = [1, 65, 85, 5, 26, 18];
//Desestructura los números en posiciones impares
const [a,,b,,c] = listado;
console.log("Numeros en las posiciones impares:")
console.log(a, b, c);
console.log("\n")

//Desestructura el primer número, el segundo y el resto en otra variable
const [x, y, ...z] = listado;
console.log("Primero: " + x);
console.log("Segundo: " + y);
console.log("Resto: " + z + "\n");

//////////////////////////////////////////////////////

const person = {
    nombre: 'Luis', 
    apellidos: 'Molina', 
    telefono: '+34666554433',
    toString: function () { return `${nombre} ${this.apellidos}`}
};
//Desestructura nombre, apellidos y teléfono.
console.log("Nombre: " + person.nombre);
console.log("Apellidos: " + person.apellidos);
console.log("Teléfono: " + person.telefono + "\n");

/*Cambia el siguiente bucle para desestructurar cada entrada
e imprimir llave, valor por separado.
*/
for(const propertie of Object.entries(person)) {
    const [key, value] = propertie;
    console.log(`${key} ${value}`);
}
console.log("\n")

/*Desestructura los puntos en las variables x1, y1, x2, y2*/
let points = [{x: 1, y: 2}, {x: 3, y: 4}];
let [{x: x1, y: y1}, {x: x2, y: y2}] = points;
console.log("x1: " + x1);
console.log("y1: " + y1);
console.log("x2: " + x2);
console.log("y2: " + y2 + "\n");