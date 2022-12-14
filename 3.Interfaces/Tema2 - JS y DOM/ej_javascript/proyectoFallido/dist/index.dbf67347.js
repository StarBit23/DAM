//usar tecla ENTER para buscar
var input = document.getElementById("barraBuscar");
input.addEventListener("keypress", function(event) {
    if (event.key === "Enter") {
        event.preventDefault();
        console.log("pulsado");
        document.getElementById("peliculas").innerHTML = "";
        leerPeliculas();
    }
});
//ejecución
document.getElementById("btnBuscar").addEventListener("click", ()=>{
    document.getElementById("peliculas").innerHTML = "";
    leerPeliculas();
});
async function getPeliculas(busca) {
    const response = await fetch(`https://api.rawg.io/api/games?token&key=7cb26927e28d45789ff595a8174b42fb9&search=${busca}`);
    const lista = await response.json();
    return lista.results.map((gameData)=>console.log(gameData));
}
async function leerPeliculas() {
    const busca = document.getElementById("barraBuscar").value;
    const lista = await getPeliculas(busca);
    lista.forEach((pelicula)=>{
        console.log(pelicula);
        const peli = document.createElement("div");
        const portada = document.createElement("img");
        const titulo = document.createElement("p");
        const enlace = document.createElement("a");
        const separador = document.createElement("p");
        peli.appendChild(portada);
        peli.appendChild(titulo);
        peli.appendChild(enlace);
        peli.appendChild(separador);
        portada.setAttribute("src", `https://api.rawg.io/api/games/${pelicula.background_image}`);
        titulo.innerHTML = "Titulo: " + pelicula.name;
        enlace.innerHTML = "M\xe1s detalles";
        enlace.setAttribute("href", `https://api.rawg.io/api/games/${pelicula.id}`);
        enlace.setAttribute("target", "blank_");
        document.getElementById("peliculas").appendChild(peli);
    });
}

//# sourceMappingURL=index.dbf67347.js.map
