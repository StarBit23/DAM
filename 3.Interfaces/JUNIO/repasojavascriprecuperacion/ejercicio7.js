console.log("1.- Crea un array \"datos\" vacío con un literal");
const datos = [];
console.log(datos);

console.log();
console.log("2.- Añade a \"datos\" los números del 1 al 50 con un bucle for");
for (let i = 0; i < 50; i++) {
    datos[i] = i + 1;
}
console.log(datos);

console.log();
console.log("3.- Elimina los elementos del 25 al 50 asignando un nuevo tamaño a la propiedad length");
datos.length = 25;
console.log(datos);

console.log();
console.log("4.- Añade una propiedad \"last\" que sea un método que retorna el último elemento del array");
datos.last = function () {
    return this[this.length - 1];
};
console.log("Ultimo numero del array: " + datos.last());
console.log(datos);

console.log();
console.log("5.- Usa el operador spread para hacer una copia del array anterior.");
const copiaDatos = [...datos];
console.log(copiaDatos);
console.log("El operador spread no copia los métodos, solo los datos del array original");

console.log();
console.log("6.- Crea un array de tamaño 50 con el constructor Array");
const arrayNuevo = new Array(50);
console.log("Tamaño de arrayNuevo: " + arrayNuevo.length);

console.log();
console.log("7.- Copia el array anterior a otro con la factoría from");
const arrayNuevoCopia = Array.from(arrayNuevo);
console.log("Tamaño de arrayNuevoCopia: " + arrayNuevoCopia.length);

console.log();
console.log("8.- Crea un array multidimensional de 10 filas (i) y 10 columnas (j). Inicializa cada celda con el valor i*j.");
const matriz = [];

for (let i = 0; i < 10; i++) {
  matriz[i] = [];
  for (let j = 0; j < 10; j++) {
    matriz[i][j] = i * j;
  }
}

console.log(matriz);

console.log();
console.log("9.- Crea un array con la factoría of con los números del 1 al 5. Después añade un elemento en la posición 10 y otro en la 50.");
const arrayOf = Array.of(1, 2, 3, 4, 5);
arrayOf[9] = 10;
arrayOf[49] = 10;
console.log(arrayOf);
console.log("\n");

console.log("Recorre el array con for imprimiendo valores y después con forEach. ¿Cuál es la diferencia? ¿Cuál es el tamaño del array?");
//usando for
console.log("Usando for:");
for (let i = 0; i < arrayOf.length; i++) {
    console.log(arrayOf[i]);
}
console.log("\n");

//usando forEach
console.log("Usando for-each:");
arrayOf.forEach((valor, indice) => {
    console.log(`Valor ${indice}: ${valor}`);
});
console.log("\n");

console.log("El bucle for muestra todos los datos, incluso los no definidos.\nEl bucle for-each sin embargo solo muestra los datos definidos del array\n");

console.log("Elimina dos elementos con delete");
delete arrayOf[9];
delete arrayOf[49];
console.log(arrayOf);

console.log();
console.log("10.- Calcula el producto de todos los números del array \"datos\" con forEach");
let producto = 1;
datos.forEach((num) => {
    producto *= num;
});
console.log(producto);

console.log();
console.log("11.- Cada elemento x del array datos debe cambiarse por x*x. Usa forEach");
datos.forEach((num, i) => {
    datos[i] = num * num;
});
console.log(datos);

console.log("");
console.log("12.- Crea un nuevo array con map recorriendo cada elemento x de \"datos\", donde cada elemento sea un string \"El valor es: x\". Usa template string.");
const mapDatos = datos.map(num => `El valor es ${num}`);
console.log(mapDatos);

console.log("");
console.log("13.- Crea un array nuevo mediante map que incremente cada elemento de \"datos\" en 5 unidades.");
const mapDatosPlus = datos.map(num => num += 5);
console.log(mapDatosPlus);

console.log("");
console.log("14.- Mediante filter quédate con los números impares en un nuevo array impares");
const arrayImpares = mapDatosPlus.filter(num => num % 2 !== 0);
console.log(arrayImpares);

console.log("");
console.log("15.- Usa find para buscar el número 13.");
datos.push(13);
const buscar = datos.find(num => num === 13);
if (buscar) {
    console.log("Numero 13 encontrado en el array");
} else {
  console.log("Numero 13 NO encontrado");
}

console.log("");
console.log("16.- Usa every para comprobar si todos los números son positivos");
const todosPositivos = datos.every(num => num > 0);
console.log(todosPositivos);

console.log("");
console.log("17.- Calcula la sumatoria del array datos mediante reduce");
const sumatoriaDatos = datos.reduce((sum, num) => {
    return sum + num;
}, 0);
console.log("el total de la suma del array datos es: " + sumatoriaDatos);

console.log("");
console.log("18.- Calcula el valor más pequeño del array mediante reduce");
const numPequeDatos = datos.reduce((min, num) => {
    if (min > num) {
        min = num;
    }
    return min;
}, datos[0]);
console.log(numPequeDatos);

console.log("");
console.log("19.- Usa flat para aplanar el array multidimensional que creaste anteriormente");
const arrayPlano = matriz.flat();
console.log(arrayPlano);

console.log("");
console.log("20.- Tenemos la cadena: \"Vamos a usar flatMap. Es igual que map. Pero aplana los arraysSepara mediante split las distintas frases\"");
const stringToSplit = "Vamos a usar flatMap. Es igual que map. Pero aplana los arrays";
const splitString = stringToSplit.split(".");
console.log(splitString);

console.log("");
console.log("Después mediante map quita los espacios sobrantes (trim).");
for (let i = 0; i < splitString.length; i++) {
    splitString[i] = splitString[i].trim();
}
console.log(splitString);

console.log("")
console.log("A continuación usa flatMap para extraer todas las palabras de cada frase en un único array.");
const flatSplitString = splitString.flatMap(str => str.split(" "));
console.log(flatSplitString);

console.log("");
console.log("21.- Crea el array a [1,2,3,4,5] y b [6,7,8,9,10] con literales.");
const a = [1, 2, 3, 4, 5];
const b = [6, 7, 8, 9, 10];
console.log(a, b);

console.log("");
console.log("Concatena los arrays a y b con concat. Después con operador spread.");
let c = a.concat(b);
console.log(c);
c = [...a, ...b];
console.log(c);

console.log("");
console.log("22.- Crea una variable const cola. Usa unshift y shift para añadir y quitar elementos");
let cola = ["toyota", "land rover", "peugeot", "citroen", "ford"];
console.log(cola);
console.log("ahora hago shift");
const eliminado = cola.shift();
console.log("Se ha eliminado el elemento " + eliminado);
console.log("ahora hago unshift y añado toyota, honda y chevrolet");
console.log("La longitud del array ahora es de " + cola.unshift("toyota","honda","chevrolet"));
console.log(cola);

console.log("");
console.log("23.- Dado el array resultante de la concatenación de a y b. Obten el subarray desde el índice 2 al penúltimo elemento (slice)");
const d = c.slice(1, -1);
console.log(d);

console.log("");
console.log("24.- Usa splice para quitar los 2 últimos elementos de un array");
const cmenos2 = c.splice(0, c.length - 2);
console.log(cmenos2);

console.log("");
console.log("25.- Rellena con fill un array de 100 elementos con -1");
const arrayNegativo = new Array(100);
arrayNegativo.fill(-1, 0, arrayNegativo.length)
console.log(arrayNegativo);

console.log("");
console.log("26.- Crea un array de cadenas. Busca con indexOf  una cadena.");
cola.push("suzuki");
cola.push("opel");
cola.push("ferrari");
cola.push("shelby");
console.log(cola);
console.log("Ferrari esta en el indice " + cola.indexOf("ferrari"));

console.log("");
console.log("27.- Comprueba si la cadena \"hola\" está dentro del array anterior.");
const cad = "hola";
const n = cola.indexOf(cad);
if (n === -1) {
    console.log("la cadena " + cad + " no esta dentro del array");
} else {
    console.log("La cadena " + cola[n] + " esta dentro del array en la posicion " + n);
}

console.log("");
console.log("28.- Ordena la lista de cadenas anterior de forma alfabética con sort.");
cola = cola.sort();
console.log(cola);

console.log("");
console.log("29.- Crea un array vacío de 50 posiciones.");
const arrayAleatorio = new Array(50);
arrayAleatorio.fill(undefined, 0, arrayAleatorio.length);
console.log(arrayAleatorio);

console.log("");
console.log("Con forEach asigna valores aleatorios entre 0 y 100.");
arrayAleatorio.forEach(function (num, i, lista) {
    let rand = Math.round(Math.random() * 100);
    lista[i] = rand;
});

console.log(arrayAleatorio);

console.log("Después ordena con sort.");
console.log(arrayAleatorio.sort());

console.log("");
console.log("¿Cómo se ha ordenado el array?");
console.log("Se ha ordenado por la longitud del string y luego por orden numerico");

console.log("");
console.log("Pasa a sort una función de ordenación de mayor a menor.");
arrayAleatorio.sort(function (a, b) {
    return a - b
});
console.log(arrayAleatorio);

console.log("");
console.log("30.- Usa reverse para invertir el array anterior.");
arrayAleatorio.reverse();
console.log(arrayAleatorio);

console.log("");
console.log("31.- Crea un objeto similar a un array. Añade propiedades del 0 al 10 con valores");
const noSoyArray = {
    0: 10,
    1: 11,
    2: 12,
    3: 13,
    4: 14,
    5: 15,
    6: 16,
    7: 27,
    8: 28,
    9: 29,
    10: 30
}
console.log(noSoyArray);

console.log("");
console.log("Calcula la suma del objeto similar a un array");
let sumaObjeto=0;
for(key in noSoyArray){
    sumaObjeto += noSoyArray[key];
}
console.log("La suma de todos los elementos vale " + sumaObjeto);
console.log("");

console.log("");
console.log("Prueba a usar el método forEach para recorrerlo.");
Object.entries(noSoyArray).forEach(element => console.log(element[1]));

console.log("");
console.log("Usa Array.prototype.forEach.call(array, lambda)");
Array.prototype.forEach.call(Object.keys(noSoyArray), (propiedad) => {
    console.log(noSoyArray[propiedad]);
  });
