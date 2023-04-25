
const getBooks = async (query,page) => {
    const response = await fetch("http://openlibrary.org/search.json?q="+query+"&page="+page);
    const data = await response.json();
    return data.docs;
}

document.getElementById('formLibros').addEventListener('submit' , async (event) => {
    event.preventDefault();
    const search = document.getElementById('search').value;
    const page = 1;
    const books = await getBooks(search,page);

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
    }
    cargarLibros();

    //PAGINADO
    var btnAtras = document.getElementById("siguiente");
    btnAtras.addEventListener("click",async function(){
        page++;
        books = await getBooks(search,page);
    });
    var btnSiguiente = document.getElementById("siguiente");
    btnSiguiente.addEventListener("click",async function(){
        page++;
        books = await getBooks(search,page);
    });
});