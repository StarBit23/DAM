const countPromiseBooks = ()=> {
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

const countAsyncBooks = async ()=> {
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

countPromiseBooks().then((contador)=>{console.log(contador)});

const ejecutarContador = async () => {
    const contador = await countAsyncBooks();
    console.log(contador);
}

ejecutarContador();



const booksByYear = async (year=2022)=> {
    const url = "https://openlibrary.org/search.json?q=javascript";
    //const listado = [];
    const response = await fetch(url);
    const datos = await response.json();
    const libros = datos.docs.filter((libro)=>libro.first_publish_year === year);
    return libros.map((libro)=>({titulo: libro.title, isbn: libro.isbn[0]}));
    /*
    datos.docs.forEach(libro => {
        if (libro.first_publish_year === year) {
            if (libro.isbn !== undefined)
                listado.push({titulo: libro.title, isbn: libro.isbn[0]});
            else 
                listado.push({titulo: libro.title});
        }
    });
    return listado;*/
};

booksByYear(2020).then((listado)=>{console.log(listado);});


const makeSearch = async () =>{
    const inputBuscar = document.getElementById("inputBuscar").value;
    pagina = 1;
    await renderBooks(inputBuscar);
};

const changePage = async () =>{
    const inputBuscar = document.getElementById("inputBuscar").value;
    await renderBooks(inputBuscar);
};

const btnBuscar = document.getElementById("btnBuscar");
btnBuscar.addEventListener("click", makeSearch);

const renderBooks = async (busqueda)=> {
    const url = "https://openlibrary.org/search.json?q=" + busqueda;
    const response = await fetch(url);
    const datos = await response.json();
    controlPagina(datos);
    const divLibros = document.getElementById("libros");
    divLibros.innerHTML = "";
    const inicio = (pagina-1) * librosPagina;
    const fin = inicio + 10 - 1;
    console.log(inicio, fin);
    const libros = datos.docs.slice(inicio, fin);
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
        divLibros.appendChild(div);
    });
};

const controlPagina = (datos) => {
    totalPaginas = Math.ceil(datos.docs.length / librosPagina);
    console.log(datos.docs.length);
    console.log(totalPaginas);
}


let totalPaginas = 10;
const librosPagina = 10;
let pagina = 1;
const btnAnterior = document.getElementById("btnAnterior");
const btnSiguiente = document.getElementById("btnSiguiente");

btnAnterior.addEventListener("click", () =>{
    if (pagina > 1) {
        pagina-=1;
        changePage();
    }
    console.log(pagina);
});

btnSiguiente.addEventListener("click", () =>{
    if (pagina < totalPaginas) {
        pagina+=1;
        changePage();
    }
    console.log(pagina);
});


