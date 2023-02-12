const nombreLibro = "javascript";
const url = 'https://openlibrary.org/search.json?q=' + nombreLibro;
let contador = 0;

countPromiseBooks();

booksByYear();

mostrarPaginaLibros();

//PARTE A
async function countPromiseBooks() {
    let response = await fetch(url);
    let libro = await response.json();
    
    for (const elementoLibro of libro.docs) {
        if (elementoLibro.first_publish_year == 2021) {
            contador++;
            console.log(elementoLibro);
            
        }
        
    }
    console.log("Total de libros del año 2021: " + contador);
    console.log("\n");
    console.log("//////////////////////////////////////////////////");
    console.log("\n");
}

//PARTE B
async function booksByYear() {
    let response = await fetch(url);
    let libro = await response.json();

    for (const elementoLibro of libro.docs) {
        if (elementoLibro.publish_year == 2021) {
            contador++;
            console.log("Título: "+elementoLibro.title);
            console.log("ISBN: "+elementoLibro.isbn);
            console.log("--------------------------------------");
            
        }
        
    }
    console.log("\n");
    console.log("//////////////////////////////////////////////////");
    console.log("\n");
}

async function mostrarPaginaLibros() {
document.getElementById("buttonBuscar").addEventListener("click", () => {
    document.getElementById("divLibros").innerHTML = "";
    booksByYear();
})
}

