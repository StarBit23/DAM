



/*

Los siguientes ejercicios tienes que ejecutarlos en el navegador:

Ejercicios iniciales asincronía:
======================================
Antes registrate en www.themoviedb.org y obten tu apikey.

1 - Crea una función mediante promesas que consulte la siguiente url https://api.themoviedb.org/3/search/movie?api_key=API_KEY&language=es-ES&query=PELI_A_BUSCAR&page=1&include_adult=false
A la función se le pasa un string con la película a buscar. Muestra el json en consola
2 - Después para cada película consulta esta url que da los detalles. (Cambia el MOVIE_ID): https://api.themoviedb.org/3/movie/MOVIE_ID?api_key=API_KEY&language=en-US
Muestra solo los campos original_title, popularity, homepage
3 - Refactoriza usando async/await

https://gitlab.iesvirgendelcarmen.com/luis/ejercicios_javascript.git


- Usa el repositorio anterior como referencia.


Ejercicios:
=============
1 - Refactoriza el código anterior usando async/await en lugar de promesas (rama y commits)
2 - Crea una nueva rama "buscador". En lugar de ver todas las películas, vamos a hacer un buscador:
Crea en el html una caja de texto (input type="text") y un botón "Buscar". Registra un manejador de eventos para detectar cuando se pulsa el botón. 
Entonces consulta el endpoint 
https://api.themoviedb.org/3/search/movie?api_key=API_KEY&language=es-ES&query=PELI_A_BUSCAR&page=1&include_adult=false
Genera el dom con los resultados de la búsqueda.

3 - Vuelve a la rama principal. Refactoriza a una versión usando programación orientado a objetos (rama y commits)
Tendrás que crear una o varias clases con métodos e ir instanciandolas y llamar a los métodos.

4 - Crea un proyecto similar al anterior con la api https://developers.giphy.com/
- El usuario buscará un texto y los resultados se añadirán al dom
- Se proporciona un ejemplo

*/