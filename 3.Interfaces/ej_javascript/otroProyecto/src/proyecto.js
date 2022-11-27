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
    const response = await fetch(`https://api.giphy.com/v1/stickers/search?api_key=aMrr0RDuTmYWBJIcohqJrtlRpqndJ7b0&q=${buscar}&limit=20&offset=1&lang=es`);
    const lista = await response.json();
    return lista.data;
}

async function leerDatos (){
    let contador=0;
    let arrayContador = [];
    let lista=null;

    const buscar = document.getElementById("barraBuscar").value;
    do {
        lista = await getGifs(buscar);
        
        
    
    
    lista.forEach(gif => {
        console.log(gif)
        const div = document.createElement("div");
        const enlace = document.createElement("a");
        const imagen = document.createElement("img");

        div.appendChild(enlace);
        div.appendChild(imagen);

        enlace.setAttribute("href",gif.embed_url);
        imagen.setAttribute("src",gif.images.downsized_medium.url)
        
        document.getElementById("cajaGifs").appendChild(div)

        //arrayContador.push(contador);      
        contador = contador+1;
        console.log(contador);
    })
    } while (contador<10);
    
    
}