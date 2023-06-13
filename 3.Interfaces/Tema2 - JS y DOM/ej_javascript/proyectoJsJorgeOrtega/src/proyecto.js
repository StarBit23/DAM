const buscar = document.getElementById("barraBuscar");
const atras = document.getElementById("btnAtras");
const siguiente = document.getElementById("btnSiguiente");

let gifsXpagina = 10;
let numPag = 0;
let pagina = 1;
atras.disabled=true;

//implementar ENTER
var input = document.getElementById("barraBuscar");
input.addEventListener("keypress", function (event) {
    if (event.key === "Enter") {
        event.preventDefault();
        //console.log("pulsado");
        document.getElementById("cajaGifs").innerHTML = "";
        const busqueda = buscar.value;
        const url = `https://api.giphy.com/v1/stickers/search?api_key=aMrr0RDuTmYWBJIcohqJrtlRpqndJ7b0&q=${busqueda}&page=${pagina}&limit=100&offset=1&lang=es`
        leerDatos(url);
    }
});

//boton buscar
document.getElementById("btnBuscar").addEventListener("click", () => {
    document.getElementById("cajaGifs").innerHTML = "";
    const busqueda = buscar.value;
    const url = `https://api.giphy.com/v1/stickers/search?api_key=aMrr0RDuTmYWBJIcohqJrtlRpqndJ7b0&q=${busqueda}&page=${pagina}&limit=100&offset=1&lang=es`
    leerDatos(url);
})

//logica de las paginas
//btn atras
atras.addEventListener("click", () => {
    document.getElementById("cajaGifs").innerHTML = "";
    siguiente.disabled = false;
    if (pagina > 1) {
        pagina = pagina - 1;
        console.log(pagina);
        const busqueda = buscar.value;
        const url = `https://api.giphy.com/v1/stickers/search?api_key=aMrr0RDuTmYWBJIcohqJrtlRpqndJ7b0&q=${busqueda}&limit=100&page=${pagina}&offset=1&lang=es`
        leerDatos(url);
    }
    if (pagina === 1) {
        atras.disabled = true;
    }

})
//btn siguiente
siguiente.addEventListener("click", () => {
    document.getElementById("cajaGifs").innerHTML = "";
    atras.disabled = false;
    if (pagina === (numPag - 1)) {
        siguiente.disabled = true;
    }
    if (pagina < numPag) {
        pagina = pagina + 1;
        console.log(pagina);
        const busqueda = buscar.value;
        const url = `https://api.giphy.com/v1/stickers/search?api_key=aMrr0RDuTmYWBJIcohqJrtlRpqndJ7b0&q=${busqueda}&limit=100&page=${pagina}&offset=1&lang=es`
        leerDatos(url);
    }
})

//getGifs
async function getGifs(url) {
    const response = await fetch(url);
    const peliculas = await response.json();
    return peliculas.data;
}
//mostrar gifs (leerDatos)
async function leerDatos(url) {
    const arrayGif = await getGifs(url);
    const pagis = Math.ceil(Object.keys(arrayGif).length / 10);
    numPag = pagis;
    //console.log(numPag);
    const mostrados = arrayGif.slice((pagina-1)*gifsXpagina, (pagina)*gifsXpagina)

    mostrados.forEach(gif => {
        //console.log(gif)
        const div = document.createElement("div");
        const portada = document.createElement("a")
        const url = gif.url;
        const imagen = `<img src="${gif.images.original.url} alt="${gif.title}"></img>`;

        portada.innerHTML = imagen;
        portada.setAttribute("href", url);
        portada.setAttribute("target", "_blank");
        //portada.setAttribute("src", gif.images.downsized_medium.url)

        div.appendChild(portada);

        document.getElementById("cajaGifs").appendChild(div)

        //arrayContador.push(contador);      
    })

}