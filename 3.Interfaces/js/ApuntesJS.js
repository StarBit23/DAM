/**
 * Iniciar un proyecto npm:
 * npm init -y
 * npm install -D parcel
 * añadimos al fichero package.json en el apartado de scripts:
 * "start": "parcel index.html" 
 */

/**
 * Utilizar el linter:
 * npm i -D eslint
 * npx eslint --init
 * Opciones:
 *  ○To check syntax, find problems, and enforce code style
 *  ○Javascript modules (import/export) Existen distintos tipos de módulos en Javascript. 
 *  ○Nosotros usaremos ES6 import/export.
 *  ○None of these. Por ahora no vamos a usar un framework
 * ○ No. Typescript es un lenguaje de programación desarrolado por Microsoft que es un superconjunto de Javascript. Es
 * decir, añade sintaxis a Javascript como el tipado de datos.
 * ○ Node. Donde se va a ejecutar el código en el navegador o en node.
 * ○ Use a popular style guide. Son un conjunto de reglas de estilo predefinidas. Usaremos Airbnb.
 * ○ JSON. Formato del fichero de configuración.
 * ○ Yes. Instalar las reglas de airbnb.
 * ○ npm. Usamos el gestor de dependencias npm
 * Para ejecutarlo usamos:
 *  ○   npx eslint *.js
 */

//Comentarios de una línea.

/*
Comentarios multiínea.
 */

/**
 * Las variables declaradas con var tienen un ámbito de función.
 * Si se declara fuera de una función, tiene un ámbito global.
 * 
 */

/**
 * El const en objetos, ayuda a que no se puede modificar la referencia,
 * pero sí el contenido del objeto.
 */


const templateString= `Hola a todos`;
console.log("Estamos mostrando el templateString: ",templateString);

const stringMultilinea =" linea1 \n linea2 \t tabulador";
console.log("Estamos mostrando el stringMultilinea: ", stringMultilinea);

const stringMultilineaConTemplateString= `Hola
a
todos`;
console.log("Estamos mostrando el stringMultilineaConTemplateString: ", stringMultilineaConTemplateString);

const pi = Math.PI;
console.log(`El valor de PI es: ${pi}`);

//Expresiones regulares:

let cadenaEjemplo="Usando expresiones regulares en Javascript";
//g global en toda la cadena, i case insensitive (no distingue entre minúscula y mayúscula)
let regExpEjemplo=/regular/gi;
const estaEjemplo=regExpEjemplo.test(cadenaEjemplo);

if(estaEjemplo){
    console.log("La palabra regular aparece en la cadena");
}else{
    console.log("La palabra regular no aparece en la cadena");
}

const posicionPatronBuscado = cadenaEjemplo.search(regExpEjemplo);
console.log("La posición donde aparece la expresión regular es: " + posicionPatronBuscado);

const patronesBuscados= cadenaEjemplo.match(regExpEjemplo);
console.log("Los patrones buscados son: " + patronesBuscados);

const cadenaEjemploNueva = cadenaEjemplo.replace(regExpEjemplo,"irregular");
console.log("Cadena original: \n" + cadenaEjemplo + "\n Cadena cambiando regular por irregular: \n" + cadenaEjemploNueva);

const separacionCadena = cadenaEjemplo.split(regExpEjemplo);
console.log("Creamos un array separando por la expresión regular: \n" + separacionCadena);

/**
 * == compara si los valores son iguales
 * === compara los valores, y además el tipo de dato
 */

/**
 * Operadores lógicos:
 * &&
 * ||
 * !
 */

//Crear objetos:
let objetoPrueba = {
    nombre:"Prueba",
    tipo:"Prueba",
    funcion: false
}

console.log(objetoPrueba);

//Desestructuración:

const array = [1,2,3,4,5,6];
console.log("Array entero: " + array);
let [x,y]= array;
console.log("Valor de x (Primer número): " + x);
console.log("Valor de y (Segundo número): " + y);
console.log("Hacemos swap");
[y,x]=[x,y];
console.log("Valor de x (Primer número): " + x);
console.log("Valor de y (Segundo número): " + y);

const {nombre,tipo}=objetoPrueba;
console.log("Nombre de la prueba: " + nombre);
console.log("Tipo de la prueba: " + tipo);

//Serializar objetos:
let data = JSON.stringify(objetoPrueba);
console.log(data);
//Deserializamos el JSON:
let copia = JSON.parse(data);
console.log(copia);

if(!(objetoPrueba===copia)){
    console.log("Son objetos distintos aunque sus valores sean iguales, porque tienen distinta referencia");
}

//Operador spread:
let objetoPrueba2 = {...objetoPrueba};
console.log(objetoPrueba2);