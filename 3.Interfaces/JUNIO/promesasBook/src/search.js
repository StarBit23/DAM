let totalPaginas = 10;
const librosPagina = 10;
let page = 1;

const getBooks = async (query) => {
    const response = await fetch("http://openlibrary.org/search.json?q="+query);
    const data = await response.json();
    controlPaginas(data)
    const inicio = (page-1) * librosPagina;
    const fin = inicio + 10 - 1;
    return data.docs.slice(inicio, fin);
}

const mostrarLibros = document.getElementById('formLibros').addEventListener('submit' , async (event) => {
    event.preventDefault();
    var search = document.getElementById('search').value;
    var books = await getBooks(search);

    const cargarLibros = () => {
        const bookListElement = document.getElementById('bookList');
        bookListElement.innerHTML = '';
        books.forEach(book => {
            const div = document.createElement('div');
            const img = document.createElement('img');
            const h1 = document.createElement('h1');
            const isbn = document.createElement('p');
            const year = document.createElement('p');
    
            img.width = '200';
            img.src=`https://covers.openlibrary.org/b/isbn/${book.isbn[0]}.jpg`;
            h1.textContent = book.title;
            isbn.textContent = book.isbn[0];
            year.textContent = book.first_publish_year;
    
            div.appendChild(img);
            div.appendChild(h1);
            div.appendChild(isbn);
            div.appendChild(year);
            document.getElementById('bookList').appendChild(div);
        });
    };
    cargarLibros();

});

//PAGINADO
const controlPaginas = (data) => {
    totalPaginas = Math.ceil(data.docs.length / librosPagina);
    console.log(data.docs.length);
    console.log(totalPaginas);
}


var btnAtras = document.getElementById("atras");
btnAtras.addEventListener("click", () =>{
    if (page > 1) {
        page-=1;
        mostrarLibros();
    }
    console.log(page)
});
var btnSiguiente = document.getElementById("siguiente");
btnSiguiente.addEventListener("click", () =>{
    if (page < totalPaginas) {
        page+=1;
        mostrarLibros();
    }
    console.log(page)
})