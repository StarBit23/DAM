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
const textLower = text.toLowerCase();
console.log(textLower+"\n")

//Convierte todo a mayúsculas.
const textUpper = text.toUpperCase();
console.log(textUpper+"\n")

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
const indexBuscar1 = text.indexOf("consola");
console.log("Palabra \"consola\" encontrada en caracter "+indexBuscar1)

const indexBuscar2 = text.indexOf("consola",indexBuscar1+1);
console.log("Palabra \"consola\" encontrada en caracter "+indexBuscar2)

const indexBuscar3 = text.indexOf("consola",indexBuscar2+1);
console.log("Palabra \"consola\" encontrada en caracter "+indexBuscar3+"\n")

//Extrae en una variable la subcadena desde la posición 3 hasta el final
console.log(text.substring(3)+"\n");

//Extrae en una variable la subcadena desde la posición 3 hasta la primera ocurrencia de la palabra texto.
const plabraTexto = text.indexOf("texto");
console.log(text.substring(3,plabraTexto)+"\n");

//Reemplaza las y los por les
const replaceResultado1 = text.replaceAll("los", "les");
const replaceResultado2 = replaceResultado1.replaceAll("las", "les");
console.log(replaceResultado2+"\n");

//Elimina los espacios antes y después del texto.
console.log(text.trim());

//Crea una cadena que no tenga ningún espacio.
const replaceEspacio = text.replaceAll(" ","");
console.log(replaceEspacio+"\n");

//Imprime la cadena texto invertida. "Hola mundo" -> "odnum..."
const saludo = "Hola mundo";
let indice=9;
let listadoInverso = [];
do{
    listadoInverso.push(saludo[indice]); 
    indice--;
}while(indice>=0);
console.log(listadoInverso.join().replaceAll(",","")+"\n");

//Cuenta cuantas veces aparece la palabra "el" en el texto.
let index=0;
let posicionEl;
let contador=0;
if(posicionEl=text.indexOf("el")>0){
    contador++;
}
console.log("He encontrado la palabra \"el\" un total de " + contador + " veces\n");

/////////////////////////////////////////////////////////////////////////////////////////////

const telefono = 'El siguiente teléfono hace spam +34654789543. Mi código es +3116.';

//Usa una expresión regular para comprobar que la cadena tiene números.
if (telefono.match(/[0-9]+/g)){
    console.log("La cadena telefono contiene números\n");
}else {
    console.log("La cadena telefono NO contiene números\n");
}

//Usa una expresión regular para comprobar que la cadena termina en punto.
if (telefono.match(/[.]$/g)) {
    console.log("La cadena telefono acaba en .\n");
} else {
    console.log("La cadena telefono NO acaba en .\n");
}

//Usa una expresión regular para comprobar que la cadena comienza por una mayúscula.
if (telefono.match(/^[A-Z]/g)){
    console.log("La cadena telefono empieza por mayuscula\n");
}else {
    console.log("La cadena telefono NO empieza por mayuscula\n");
}

//Usa una expresión regular para comprobar si la cadena contiene un teléfono con código internacional.
if (telefono.match(/\+\d{2}/g)){
    console.log("La cadena telefono contiene un código internacional\n");
}else {
    console.log("La cadena telefono NO contiene un código internacional\n");
}

//Reemplaza cualquier ocurrencia de un + seguido de números por la cadena SECRETO
const telefonoSecreto = "+34 SECRETO";
if (telefonoSecreto.match(/\+\d{2}\b.*SECRETO\b/g)){
    console.log("La cadena telefonoSecreto contiene un secreto\n");
}else {
    console.log("La cadena telefonoSecreto NO contiene un código secreto\n");
}