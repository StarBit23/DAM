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

var input = document.getElementById("barraBuscar");
input.addEventListener("keypress", function(event) {
    if (event.key === "Enter") {
        event.preventDefault();
        console.log("pulsado");
        document.getElementById("cajaGifs").innerHTML = "";
        leerDatos();
    }
});

document.getElementById("btnBuscar").addEventListener("click",()=>{
    document.getElementById("cajaGifs").innerHTML = "";
    leerDatos()
})

async function getGifs(buscar){
    const response = await fetch(`https://api.giphy.com/v1/stickers/search?api_key=aMrr0RDuTmYWBJIcohqJrtlRpqndJ7b0&q=${buscar}&limit=25&offset=0&rating=g&lang=es`);
    const lista = await response.json();
    return lista.data;
}

async function leerDatos (){
    const buscar = document.getElementById("barraBuscar").value;
    const lista = await getGifs(buscar);
    lista.forEach(gif => {
        console.log(gif)
        const linkImagen = gif.images.downsized_medium.url;
        const contenedor = document.createElement("div");
        const enlace = document.createElement("a");
        const imagen = document.createElement("img");
        contenedor.appendChild(enlace);
        contenedor.appendChild(imagen);
        enlace.setAttribute("href",gif.embed_url);
        imagen.setAttribute("src",linkImagen)
        document.getElementById("cajaGifs").appendChild(contenedor)
    })
}