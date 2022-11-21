/*
Los siguientes ejercicios tienes que ejecutarlos en el navegador:
Ejercicios iniciales asincronía:
======================================
Antes registrate en www.themoviedb.org y obten tu apikey.
1 - Crea una función mediante promesas que consulte la siguiente url https://api.themoviedb.org/3/search/movie?api_key=ecade04f0950fc78674036e1ed5c4931&language=es-ES&query=sonic+the+hedgehog+2&page=1&include_adult=false
A la función se le pasa un string con la película a buscar. Muestra el json en consola
2 - Después para cada película consulta esta url que da los detalles. (Cambia el MOVIE_ID): https://api.themoviedb.org/3/movie/MOVIE_ID?api_key=API_KEY&language=en-US
Muestra solo los campos original_title, popularity, homepage
3 - Refactoriza usando async/await
https://gitlab.iesvirgendelcarmen.com/luis/ejercicios_javascript.git
- Usa el repositorio anterior como referencia.
*/
const nombrePeli = "peter"
const apikey = "aMrr0RDuTmYWBJIcohqJrtlRpqndJ7b0";
const url_top_rated ="api.giphy.com/v1/gifs/trending?api_key="+apikey


function getPeliculas() {
    return fetch(url_top_rated)
    .then((response)=>response.json())
    .then((peliculas)=>{
        return peliculas.results;
    });
}

function getDatosPelicula(id) {
    const url_details = `https://api.giphy.com/v1/gifs/${id}?api_key=aMrr0RDuTmYWBJIcohqJrtlRpqndJ7b0`;
    return fetch(url_details)
    .then(response=>response.json())
    .then(pelicula=>pelicula);
}


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