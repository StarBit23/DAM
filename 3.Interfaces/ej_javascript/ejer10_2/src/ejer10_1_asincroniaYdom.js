
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
var input = document.getElementById("barraBuscar");
input.addEventListener("keypress", function(event) {
    if (event.key === "Enter") {
        event.preventDefault();
        console.log("pulsado");
        document.getElementById("peliculas").innerHTML = ""
        leerPeliculas();
    }
});

document.getElementById("btnBuscar").addEventListener("click",()=>{
    document.getElementById("peliculas").innerHTML = ""
    leerPeliculas();
})

async function getPeliculas(busca){
    const response = await fetch(`https://api.themoviedb.org/3/search/movie?api_key=b8165038935bb7549d8531dbec4d6749&query=${busca}&language=es-ES&page=1`);
    const lista = await response.json();
    return lista.results
}

async function leerPeliculas(){
    const busca = document.getElementById("barraBuscar").value
    const lista = await getPeliculas(busca)
    lista.forEach((pelicula) => {
        console.log(pelicula);

        const peli = document.createElement("div");
        const portada = document.createElement("img");
        const titulo = document.createElement("p");
        const enlace = document.createElement("a")
        const separador = document.createElement("p");

        peli.appendChild(portada)
        peli.appendChild(titulo)
        peli.appendChild(enlace)
        peli.appendChild(separador);

        portada.setAttribute("src",`https://image.tmdb.org/t/p/w200/${pelicula.poster_path}`)
        titulo.innerHTML = "Titulo: "+pelicula.original_title
        enlace.innerHTML = "Más detalles"
        enlace.setAttribute("href",`https://www.themoviedb.org/movie/${pelicula.id}`)
        enlace.setAttribute("target","blank_")

        document.getElementById("peliculas").appendChild(peli)
    })
}
