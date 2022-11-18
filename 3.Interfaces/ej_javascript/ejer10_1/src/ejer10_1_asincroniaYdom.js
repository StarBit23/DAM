
//))
/*
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

const nombrePeli = "sonic+the+hedgehog"
const apikey = "ecade04f0950fc78674036e1ed5c4931";
let url_top_rated ="";
const botonBuscar = document.getElementById("btnBuscar");

botonBuscar.onclick = () => {
    document.getElementById("peliculas").innerHTML = "";
    const busqueda = document.getElementById("barraBuscar").value;
    url_top_rated="https://api.themoviedb.org/3/search/movie?api_key="+apikey+"&language=es-ES&query="+busqueda+"&page=1&include_adult=false"
    getPeliculas()
    .then((arrayPeliculas)=>{
    arrayPeliculas.forEach(pelicula => {
        getDatosPelicula(pelicula.id)
        .then((pelicula)=>{
            console.log(pelicula);
            const peli = document.createElement('div');
            const portada = document.createElement('img');
            const titulo = document.createElement('p');
            titulo.innerHTML = pelicula.original_title;
            peli.appendChild(titulo);
            peli.appendChild(portada);
            portada.setAttribute('src', `https://image.tmdb.org/t/p/w200/${pelicula.poster_path}`);
            document.getElementById("peliculas").appendChild(peli);            
        }).catch(err=>{});
        ;
    });
})
}

function getPeliculas() {
    return fetch(url_top_rated)
    .then((response)=>response.json())
    .then((peliculas)=>{
        return peliculas.results;
    });
}

function getDatosPelicula(id) {
    const url_details = `https://api.themoviedb.org/3/movie/${id}?api_key=ecade04f0950fc78674036e1ed5c4931&language=en-US`;
    return fetch(url_details)
    .then(response=>response.json())
    .then(pelicula=>pelicula);
}