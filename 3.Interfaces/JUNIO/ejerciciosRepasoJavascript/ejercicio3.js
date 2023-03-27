//Cadenas de caracteres
/*En los siguientes ejercicios intenta usar todo tipo de cadenas.
Cadenas con comillas simples, dobles, templates string, cadenas multilínea.
 Práctica también la conversion de number a string.
*/

const text = `
A primera vista, las cadenas se tratan de forma similar a los números, pero cuando profundizas empiezas a ver diferencias notables. 
Comencemos ingresando algunas líneas de texto básicas en la consola para familiarizarnos. 
Te proveeremos de una aquí abajo 
(también puedes abrir la consola en una pestaña o ventana separada, o usar la consola de desarrollo del navegador si así lo prefieres).
`;
const from = "https://developer.mozilla.org";

const author = 'Perico'

//Crea una cadena multilínea con comillas dobles.
const varMult = "Hola, te gusta el\nchocolate blanco?\na mi me gusta más el chocolate negro\n";
console.log(varMult);

//Añade a la cadena algún retorno de carro y tabuladores con el símbolo de escape
const varMult2 = "Hola, te gusta el\nchocolate blanco?\na mi me gusta más el \tchocolate negro\n";
console.log(varMult2);

//Añade a la cadena el caracter \
const varMult3 = "Hola, te gusta el\nchocolate blanco?\na mi me gusta más el \t\\chocolate negro\\\n";
console.log(varMult3);

//Concatena text y from usando el operador +
console.log(text+from+"\n");

//Concatena text y from usando una template string
console.log(`${text} ${from}\n`);

//Concatena las tres variables usando + y template string
console.log(`${text} ${from} ` + `${author}`);

//Separa el texto el frases en un array.
const splitText=text.split(".")
for (let i = 0; i < splitText.length; i++){
    console.log(splitText[i])
}

//Convierte todo a minúsculas.
console.log(text.toLowerCase+"\n")

//Convierte todo a mayúsculas.
console.log(text.toUpperCase+"\n")

//Recorre con un bucle el texto caracter a caracter.
for(let i = 0;i<text.length;i++){
    console.log(text[i])
}

//Busca la subcadena consola en el texto.
// const splitTextEspacio=text.split(" ")
// let contadorConsola=0;
// for (let i = 0; i < splitTextEspacio.length; i++){
//     contadorConsola++;
//     if (splitTextEspacio[i]=="consola") {
//         console.log("Encontrado \"consola\" en la palabra número "+contadorConsola)
//     }
// }
//console.log(text.search("consola"));
//Busca la subcadena consola en el texto.
let textoBuscar = "consola";
let indexBuscar = text.search(textoBuscar);
for(indexBuscar;indexBuscar<201;indexBuscar++){
    console.log(text.charAt(indexBuscar))
}

console.log("\n");

//Extrae en una variable la subcadena desde la posición 3 hasta el final


//Extrae en una variable la subcadena desde la posición 3 hasta la primera ocurrencia de la palabra texto.


//Reemplaza las y los por les


//Elimina los espacios antes y después del texto.


//Crea una cadena que no tenga ningún espacio.


//Imprime la cadena texto invertida. "Hola mundo" -> "odnum..."


//Cuenta cuantas veces aparece la palabra "el" en el texto.


const telefono = 'El siguiente teléfono hace spam +34654789543. Mi código es +3116';
//Usa una expresión regular para comprobar que la cadena tiene números.
//Usa una expresión regular para comprobar que la cadena termina en punto.
//Usa una expresión regular para comprobar que la cadena comienza por una mayúscula.
//Usa una expresión regular para comprobar si la cadena contiene un teléfono con código internacional.
//Reemplaza cualquier ocurrencia de un + seguido de números por la cadena SECRETO
