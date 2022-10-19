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

const author = 'Jorgito'

//Crea una cadena multilínea con comillas dobles.
const varMult = "Hola me llamo\nJorge\nprogramo en \"Java\"";
console.log(varMult);
console.log("-------------------------------------------------");
//Añade a la cadena algún retorno de carro y tabuladores con el símbolo de escape
const varMult2 = "Hola me llamo\nJorge\tprogramo en \"Java\"";
console.log(varMult2);
console.log("-------------------------------------------------");
//Añade a la cadena el caracter \
const varMult3 ="Hola me llamo\nJorge\nprogramo en \\Java\\";
console.log(varMult3);
console.log("-------------------------------------------------");
//Concatena text y from usando el operador +
console.log(text+from);
console.log("-------------------------------------------------");
//Concatena text y from usando una template string
console.log(`${from} ${text}`);
console.log("-------------------------------------------------");
//Concatena las tres variables usando + y template string
console.log(`${from} ${text}`+`${author}`);
console.log("-------------------------------------------------");
//Separa el texto en frases en un array.
const separar=text.split(".")
for (let i = 0; i < separar.length; i++){
    console.log(separar[i])
}
console.log("-------------------------------------------------");
//Convierte todo a minúsculas.
let mayúscula = "HOLA ME LLAMO JORGE"
console.log(mayúscula.toLowerCase());
console.log("-------------------------------------------------");

//Convierte todo a mayúsculas.
let minúsculas = "hola me llamo jorge"
console.log(mayúscula.toUpperCase());
console.log("-------------------------------------------------");

//Recorre con un bucle el texto caracter a caracter.
for(let i = 0;i<text.length;i++){
    console.log(text[i])
}
console.log("-------------------------------------------------");

//Busca la subcadena consola en el texto.
let textoBuscar = "consola";
let indexBuscar = text.search(textoBuscar);
for(indexBuscar;indexBuscar<201;indexBuscar++){
    console.log(text.charAt(indexBuscar))
}
console.log("-------------------------------------------------");

//Extrae en una variable la subcadena desde la posición 3 hasta el final
console.log(text.substring(3));
console.log("-------------------------------------------------");

//Extrae en una variable la subcadena desde la posición 3 hasta la primera ocurrencia de la palabra texto.
let indexBuscar2 = text.search("texto");
console.log(text.substring(3,indexBuscar2));
console.log("-------------------------------------------------");

//Reemplaza las y los por les
let replaceResultado = text.replaceAll("los", "les");
let replaceResultado2 = replaceResultado.replaceAll("las", "les");
console.log(replaceResultado2);
console.log("-------------------------------------------------");

//Elimina los espacios antes y después del texto.
let textoEspacios = "   Hola Pepe   ";
console.log(textoEspacios.trim())
console.log("-------------------------------------------------");

//Crea una cadena que no tenga ningún espacio.
let replaceResultado4 = text.replaceAll(" ", "");
console.log(replaceResultado4);
console.log("-------------------------------------------------");
//Imprime la cadena texto invertida. "Hola mundo" -> "odnum..."
const saludo = "Hola mundo";
let indice=9;
do{
console.log(saludo[indice]);
indice--;
}while(indice>=0);
console.log("-------------------------------------------------");


//Cuenta cuantas veces aparece la palabra "el" en el texto.
let indexx=0;
let posicionEl;
let contadorr=0;
if(posicionEl=text.indexOf("el")>0)
contadorr++;


console.log("En el texto he encontrado \"el\" "+contadorr+" veces");
console.log("-------------------------------------------------");



const telefono = 'El siguiente teléfono hace spam +34654789543. Mi código es +3116';
//Usa una expresión regular para comprobar que la cadena tiene números.
//Usa una expresión regular para comprobar que la cadena termina en punto.
//Usa una expresión regular para comprobar que la cadena comienza por una mayúscula.
const tfno2 = "e" + telefono;
if(tfno2.match("^[A-Z]"){
    console.log("El  texto empieza por mayuscula")
}else (console.log("El texto no empieza por mayuscula"));

//Usa una expresión regular para comprobar si la cadena contiene un teléfono con código internacional.
const tfno3 = telefono.match("[+][1-9][1,3][1-9]{9}")
console.log(tfno3[0]);

//Reemplaza cualquier ocurrencia de un + seguido de números por la cadena SECRETO


