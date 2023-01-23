//1 CONTAR LIBROS POR FECHA DE LANZAMIENTO=2022
//CONTAR LIBROS PROMISES
const contarLibrosPromesas = ()=>{
    const url = "https://openlibrary.org/search.json?q=javascript";
    let contador = 0;
    return fetch(url).then(
        (response) => {return response.json()}
    ).then(
        (datos)=>{
            datos.docs.forEach(libro => {
                if (libro.first_publish_year === 2022) {
                    contador++;
                }
            });
            return contador;
        }
    )
};
//CONTAR LIBROS ASYNC/AWAIT
const contarLibrosAsync = async() => {
    const url = "https://openlibrary.org/search.json?q=javascript";
    let contador = 0;
    const response = await fetch(url);
    const datos = await response.json();
    datos.docs.forEach(libro => {
        if (libro.first_publish_year === 2022) {
            contador++;
        }
    });
    return contador;
};
const ejecutarContador = async () => {
    const contador = await contarLibrosAsync();
    console.log(contador);
}

contarLibrosPromesas().then((contador)=>{console.log(contador)});
ejecutarContador();


//2 MOSTRAR TITULO E ISBN DEL LIBRO, BUSCADO POR SU AÑO
const librosPorAño = async (year = 2022) => {
    const url = "https://openlibrary.org/search.json?q=javascript";
    const response = await fetch(url);
    const datos = await response.json();
    const libros = datos.docs.filter((libro) => libro.first_publish_year == year);
    return libros.map((libro) => ({titulo:libro.title, isbn:libro.isbn[0]}))
}

librosPorAño(2020).then((listado) => {console.log(listado)})


//3
const hacerBusqueda = async () => {
    const barraBuscar = document.getElementById("barraBuscar").value;
    pagina = 1;
    await mostrarLibros(barraBuscar);
};

//recargar web al cambiar de pagina
const cambiarPagina= async () => {
    const barraBuscar = document.getElementById("barraBuscar").value;
    await mostrarLibros(barraBuscar);
};

const btnBuscar = document.getElementById("btnBuscar");
btnBuscar.addEventListener("click", hacerBusqueda);

const mostrarLibros = async (busqueda) => {
    const url = "https://openlibrary.org/search.json?q="+busqueda;
    const response = await fetch(url);
    const datos = await response.json();
    controlPagina(datos); //?
    const divLibros = document.getElementById("divLibros");
    divLibros.innerHTML = "";
    //crear varias paginas
    const inicio = (pagina-1) * librosPagina;
    const fin = inicio + 10 - 1;
    const libros = datos.docs.slice(inicio, fin);
    //mostrar libros
    libros.forEach(libro => {
        const div = document.createElement("div");
        const img = document.createElement("img");
        const p = document.createElement("p");
        p.innerHTML = `Año: ${libro.first_publish_year} ISBN: ${libro.isbn[0]}`;
        img.width = "100";
        img.height = "150";
        img.src = `https://covers.openlibrary.org/b/isbn/${libro.isbn[0]}.jpg`;
        const title = document.createElement("h1");
        title.textContent = libro.title;
        div.appendChild(title);
        div.appendChild(img);
        div.appendChild(p);
        divLibros.appendChild(div)
    });
};

const controlPagina = (datos) => {
    totalPaginas = Math.ceil(datos.docs.length / librosPagina);
    console.log(datos.docs.length);
    console.log(totalPaginas);
};

let totalPaginas = 10;
const librosPagina = 10;
let pagina = 1;
const btnAnterior = document.getElementById("btnAnterior");
const btnSiguiente = document.getElementById("btnSiguiente");

btnAnterior.addEventListener("click", () =>{
    if (pagina > 1) {
        pagina-=1;
        cambiarPagina();
    }
    console.log(pagina);
});

btnSiguiente.addEventListener("click", () =>{
    if (pagina < totalPaginas) {
        pagina+=1;
        cambiarPagina();
    }
    console.log(pagina);
});