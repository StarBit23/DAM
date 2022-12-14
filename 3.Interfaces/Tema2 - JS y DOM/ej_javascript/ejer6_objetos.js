

/*Crea el objeto persona con las propiedades nombre, apellido, teléfono y edad
usando un literal.

Crea el objeto alumno que hereda las propiedades del objeto persona.
Además añade las propiedades: curso, módulos (un array de string)
*/
const persona = {nombre: "luis", apellido: "molina", tfno:"689235645", edad:17};
const alumno = Object.create(persona);
alumno.curso = "2º";
alumno.modulos = "Lengua, Matemáticas, Historia, TIC";
console.log(alumno);
console.log("-------------------------------");

/*
Usando solo el objeto alumno:
- Añade una nueva propiedad grupo.
- Modifica la edad. ¿Qué ha ocurrido?
- Elimina la propiedad grupo.
- Comprueba con un condicional si la propiedad grupo existe en el objeto persona. Si es así muestra un mensaje.
- Imprime todas las propiedades propias.
- Imprime todas las propiedades propias y heredadas con un bucle.
Usando solo el objeto persona:
- Modifica la edad. Consulta la edad usando alumno. ¿Qué ocurre?
- Añade la propiedad curso. Consulta la propiedad en los dos objetos. ¿Qué ocurre?
Consulta con Object.getPrototypeOf() el prototipo de cada objeto hasta que no existan más.
¿Qué objeto tiene como prototipo Object.prototype?
¿Qué objeto tiene como prototipo null?
Crea un objeto que no tenga prototipo. Añade la propiedad x. ¿Tiene el objeto la propiedad toString? ¿Por qué?
*/
alumno.grupo = "A";
alumno.edad = 22;
delete alumno.grupo;
if (alumno.hasOwnProperty("grupo") == true) {
    console.log("¡Soy la propiedad grupo, y estoy viva!")
}
console.log("Propiedades propias de alumno");
console.log(Object.getOwnPropertyNames(alumno));
console.log("");
console.log("Propiedades propias y heredadas de alumno");
for (const key in alumno){
    console.log(key)
}
console.log("-------------------------------");
persona.edad = 50;
console.log(alumno);
console.log("al cambiar la propiedad en persona, se ha cambiado en el objeto heredado alumno")
console.log("");

console.log(Object.getPrototypeOf(persona));
console.log(Object.getPrototypeOf(alumno));
console.log("-------------------------------");
console.log("");

/*
Copia el objeto alumno a otro objeto alumno2 que inicialmente está vacío.
- Primero crea un bucle para copiar las propiedades.
- Usa Object.assign en una única sentencia para hacer la copia.
- Usa el operador spread para hacer la copia. Comprueba si se copian las propiedades propias y heredadas.

Crea dos objetos p1,p2. Uno con la propiedad x,y,z y otro con a,b,c,x
Crea un tercer objeto p3 que tenga todas las propiedades de p1 y p2. ¿Qué valor tiene la propiedad x?
Nota: Usa operador spread
*/
const alumno2 = {};
for (let key in alumno) {
    alumno2[key] = alumno[key];
}
console.log("");

Object.assign(alumno, alumno2);
console.log(alumno2);
console.log("");

let alumno3 = {...alumno2};
console.log(alumno3);
console.log("");

const p1={x:1,y:2,z:3};
const p2={a:1,b:2,c:3,x:4};
const p3={...p1,p2};
console.log(p3);
console.log("-------------------------------");
console.log("");

/*
Serializa el objeto persona a Json e imprime la cadena resultante.
Realizar la operación inversa, parse, convirtiendo la cadena a objeto.
¿Se obtiene el mismo objeto que el original?
*/
let personaJSON = JSON.stringify(persona);
console.log(personaJSON);
console.log("");

const personaDeserializar = JSON.parse(personaJSON);
console.log(personaDeserializar);
console.log("las comillas ahora son simples en vex de dobles")
console.log("-------------------------------");
console.log("");

/*
Crea la constante nombre y apellidos y asigna valores.
Crea un objeto con la propiedad nombre y apellidos usando las constantes anteriores.
Usa propiedades abreviadas.
*/
const nombre = 'jorge';
const apellidos = 'ortega';
const persona2 = {nombre, apellidos};
console.log(persona2);
console.log("-------------------------------");
console.log("");

/*
Añade al objeto persona un método imprimir que imprima todos los datos de la persona. Usa function.
Añade otro método imprime2 pero con método abreviado.
Añade el método toString a persona y llama a alguno de los métodos anteriores. 
¿Qué versión de toString se ejecuta la del objeto o la de Object.prototype?

Añade un getter y un setter a la propiedad teléfono.
En el setter comprueba que el teléfono tiene 9 dígitos.
En el getter retorna el teléfono con el prefijo "+34" delante.
*/

console.log();
persona.imprimir = function () {
    console.log(`${this.nombre} ${this.apellido} ${this.edad} ${this.telefono}`);
};
persona.imprimir();

console.log();
 persona.imprime2 = () => {
     for(key in persona){
         console.log(persona[key]);
     }
 };
 
 persona.imprime2();

 console.log();
 persona.toString = function (datos) {
     return datos;
 };
 persona.toString(persona.imprime2());

 console.log();

 

persona.getTelefono = function () {
    return telefono;
}

persona.setTelefono = function (telefono){
    this.telefono = telefono;
}

console.log();

console.log();
persona.getTelefono = function () {
    return "+34" + this.tfno;
}
console.log(persona.getTelefono());

    
    
    




