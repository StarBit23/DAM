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
const nombrePeli = "ice+age"
const apikey = "ecade04f0950fc78674036e1ed5c4931";
const url_top_rated = "https://api.themoviedb.org/3/search/movie?api_key=" + apikey + "&language=es-ES&query=" + nombrePeli;
    
mostarPeli();


async function getPeliculas() {
    const response = await fetch(url_top_rated);
    const peliculas = await response.json();
    return peliculas.results;
}

async function mostarPeli () {
    const listaPelis = await getPeliculas()
    listaPelis.forEach(element => {
        console.log(element)
        const pelicula = document.createElement("div");
        const portada = document.createElement("img");
        const homepage = document.createElement("a");
        const titulo = document.createElement("p");
        const popularidad = document.createElement("p");
        const separador = document.createElement("p");

        pelicula.appendChild(portada);
        pelicula.appendChild(titulo);
        pelicula.appendChild(popularidad);
        pelicula.appendChild(homepage);
        pelicula.appendChild(separador);

        homepage.setAttribute("target", "blank_");
        homepage.setAttribute("href", `https://www.themoviedb.org/movie/${element.id}`);
        homepage.innerHTML = "Ver";
        titulo.innerHTML = "Titulo: " + element.original_title;
        popularidad.innerHTML = "Popularidad: " + element.popularity;
        separador.innerHTML = "-------------------------------------------"
        portada.setAttribute("src", `https://image.tmdb.org/t/p/w200/${element.poster_path}`);
        document.getElementById("peliculas").appendChild(pelicula);
    });
}