//Desestructuración

//Desestructura dia, mes y año e imprime la fecha.
const fecha = ['06', 'Octubre', '2021'];

//Desestructura los números en posiciones impares
//Desestructura el primer número, el segundo y el resto en otra variable
const listado = [1, 65, 85, 5, 26, 18];

//Desestructura nombre, apellidos y teléfono.
const person = {
    nombre: 'Luis', 
    apellidos: 'Molina', 
    telefono: '+34666554433',
    toString: function () { return `${nombre} ${this.apellidos}`}
};


/*Cambia el siguiente bucle para desestructurar cada entrada
e imprimir llave, valor por separado.
*/
for(const propertie of Object.entries(person)) {
    console.log(propertie);
}

/*Desestructura los puntos en las variables x1, y1, x2, y2*/
let points = [{x: 1, y: 2}, {x: 3, y: 4}];