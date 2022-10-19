

/*Crea el objeto persona con las propiedades nombre, apellido, teléfono y edad
usando un literal.

Crea el objeto alumno que hereda las propiedades del objeto persona.
Además añade las propiedades: curso, módulos (un array de string)
*/

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


/*
Copia el objeto alumno a otro objeto alumno2 que inicialmente está vacío.
- Primero crea un bucle para copiar las propiedades.
- Usa Object.assign en una única sentencia para hacer la copia.
- Usa el operador spread para hacer la copia. Comprueba si se copian las propiedades propias y heredadas.

Crea dos objetos p1,p2. Uno con la propiedad x,y,z y otro con a,b,c,x
Crea un tercer objeto p3 que tenga todas las propiedades de p1 y p2. ¿Qué valor tiene la propiedad x?
Nota: Usa operador spread
*/


/*
Serializa el objeto persona a Json e imprime la cadena resultante.
Realizar la operación inversa, parse, convirtiendo la cadena a objeto.
¿Se obtiene el mismo objeto que el original?
*/

/*
Crea la constante nombre y apellidos y asigna valores.
Crea un objeto con la propiedad nombre y apellidos usando las constantes anteriores.
Usa propiedades abreviadas.
*/

/*
Añade al objeto persona un método imprimir que imprima todos los datos de la persona. Usa function.
Añade otro método imprime2 pero con método abreviado.
Añade el método toString a persona y llama a alguno de los métodos anteriores. 
¿Qué versión de toString se ejecuta la del objeto o la de Object.prototype?

Añade un getter y un setter a la propiedad teléfono.
En el setter comprueba que el teléfono tiene 9 dígitos.
En el getter retorna el teléfono con el prefijo "+34" delante.
*/


