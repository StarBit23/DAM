//Desestructuración
const listado = [1, 65, 85, 5, 26, 18];
const fecha = ['06', 'Octubre', '2021'];

//Desestructura dia, mes y año e imprime la fecha.
const [day, month, year] = fecha
console.log(`${day}/${month}/${year}` + "\n");
console.log("-------------------------------------------------------------------\n");

//Desestructura los números en posiciones impares
const [one, , three, , five, ] = listado;
console.log(`one: ${one} three: ${three} five: ${five}`+"\n");
console.log("-------------------------------------------------------------------\n");

//Desestructura el primer número, el segundo y el resto en otra variable
const [uno, dos, ...resto] = listado
console.log(`Uno: ${uno} Dos: ${dos} Resto: ${resto}`+"\n");
console.log("-------------------------------------------------------------------\n");

//Desestructura nombre, apellidos y teléfono.
const person = {
    nombre: 'Luis',
    apellidos: 'Molina',
    telefono: '+34666554433',
    toString: function () {
        return `${nombre} ${this.apellidos}`
    }
};
const {nombre,apellidos,telefono} = person;
console.log(`${nombre} ${apellidos} ${telefono}`+"\n");
console.log("-------------------------------------------------------------------\n");

/*Cambia el siguiente bucle para desestructurar cada entrada e imprimir llave, valor por separado.*/
for (const propertie of Object.entries(person)) {
    const [key, value] = propertie;
    console.log(`${key} ${value}`);
}
console.log("-------------------------------------------------------------------\n");


/*Desestructura los puntos en las variables x1, y1, x2, y2*/
let points = [{x: 1, y: 2}, {x: 3, y: 4}];

const [{x: x1, y: y1}, {x: x2, y: y2}] = points;
console.log(`Variables 1: ${x1} ${y1} Variables 2: ${x2} ${y2}`);