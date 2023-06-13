function aleatorio() {
    return Math.random()
}

function cuadrado(x, y) {
    return x * x;
}

function factoria(nombre, apellidos) {
return {nombre, apellidos};
}

console.log("Crea versiones arrow de las funciones anteriores.");

console.log("");
const aleatorio1 = () => {
    return Math.random();
};
console.log("Probando la funcion aleatorio", aleatorio1());

const cuadrado1 = x => {
    return x * x;
};
console.log("Probando la funcion cuadrado " + cuadrado1(2));

const factoria1 = (nombre, apellidos) => {
    return nombre, apellidos;
};
console.log("Probando la funcion factoria " + factoria1("jorge", "ortega"));
console.log("- Con paréntesis y sin paréntesis si es posible.");
console.log("- Con llaves en el cuerpo y sin llaves si es posible.");

console.log("- Invoca (llama) las funciones.");
console.log(aleatorio1.call(this));
console.log(cuadrado1.call(this,3));
console.log(factoria1.call(this,"jorge","ortega"));


console.log("");
console.log("Crea una función \"creaPersona\" con parámetros opcionales y valores por defecto");
console.log("parámetros:");
console.log("- nombre y apellidos (obligatorio) Lanzar excepción si no se pasan: throw new TypeError('nombre y apellidos obligatorios');");
console.log("- fecha de nacimiento opcional. Si el parámetro no se pasa no se añade la propiedad al objeto persona. ");
console.log("- ciudad. Valor por defecto Jaén.");
console.log("- La función debe retornar un objeto con las propiedades.");
console.log("");

const creaPersona = (nombre, apellidos, fecha) =>{
    
    if(nombre == undefined || apellidos == undefined){
        throw new TypeError("nombre y apellidos obligatorios")
    }
    let persona = {};
    if(nombre != undefined){persona.nombre = nombre;};
    if(apellidos != undefined){persona.apellidos = apellidos;};
    if(fecha != undefined){persona.fecha = fecha;};
    persona.ciudad = "Jaen";
    return persona;
}
const persona1 = creaPersona("jorge","ortega","05-03-03");
console.log(persona1);

console.log("");
console.log("Crea una función que calcule la media de los parámetros pasados.");
console.log("");
const calcularMedia = function(a,b,c){
    return (a+b+c)/3;
};

console.log("la media pasando argumentos es: "+calcularMedia(6,7,8));
console.log("Pasa un array a la función con el operador spread");
const arrayNum = [3,4,5,9];
console.log("la media pasando un array es: " + calcularMedia(...arrayNum));

console.log("");
console.log("Crea la función imprime a la que se le pasa un objeto");
console.log("como el siguiente:");
console.log("imprime({nombre:\"Susana\", apellidos:\"Pérez\", edad:12});");
console.log("En los parámetros de la función desestructura nombre y apellidos e imprímelos con console.log");
const imprime = function ({
    nombre: nombre,
    apellidos: apellidos,
    edad: edad = persona
}) {
    console.log(`Nombre: ${nombre} Apellidos: ${apellidos} Edad: ${edad}`);
};
imprime({
    nombre: "Susana",
    apellidos: "Perez",
    edad: 12
});

console.log("");
console.log("Crea la siguiente función que suma los dos primeros elementos de un array:");
console.log("sumaPrimeroSegundo([10,20,30,40,50,60]);");
const sumaPrimeroSegundo1 = function (array = new Array) {
    return array[0] + array[1];
};
console.log("la suma de los dos primeros elementos del array es: " + sumaPrimeroSegundo1([10, 20, 30, 40, 50, 60]));

console.log("");
console.log("Desestructura los dos primeros elementos en la variable x e y.");
const sumaPrimeroSegundo2 = function ([x, y] = array) {

    return x + y;
};
console.log("la suma de los dos primeros elementos del array desestructurado es: " + sumaPrimeroSegundo2([10, 20, 30, 40, 50, 60]));

console.log("");
console.log("Crea un objeto con la propiedad ancho y alto y el método toString.");
const formaCuadrado = {
    ancho : 10,
    alto : 10,
    toString : function(){console.log(`Ancho: ${this.ancho} Alto: ${this.alto}`)}
}
console.log(formaCuadrado);
formaCuadrado.toString(); 

console.log("");
console.log("Crea un segundo objeto con valores distintos de ancho y alto. No se implementa toString.");
const rectangulo = {
    ancho : 10,
    alto : 20,
}
console.log(rectangulo);

console.log("");
console.log("Haz un call para usar el método toString del primer objeto en el segundo.");
formaCuadrado.toString.call(rectangulo);
