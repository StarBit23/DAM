let totalPaginas = 10;
const librosPagina = 10;
let page = 1;
let favourites = ['/works/OL29935054W','/works/OL28139232W'];
const FAVOURITES_KEY = 'FAVOURITES';

const saveFavourites = () => {
    localStorage.setItem(FAVOURITES_KEY, JSON.stringify(favourites))
};

const readFavourites = () => {
    const fav = localStorage.getItem(FAVOURITES_KEY);
    favourites = JSON.parse(fav);
}

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
            div.id = book.key;
            const img = document.createElement('img');
            const h1 = document.createElement('h1');
            const isbn = document.createElement('p');
            const year = document.createElement('p');
            const btnFav = document.createElement('button')
    
            img.width = '200';
            img.src=`https://covers.openlibrary.org/b/isbn/${book.isbn[0]}.jpg`;
            if (favourites.includes(book.key)) {
                h1.className = "resaltado"
            }
            h1.textContent = book.title;
            isbn.textContent = book.isbn[0];
            year.textContent = book.first_publish_year;
            btnFav.textContent = "Añadir a favoritos"
            btnFav.addEventListener("click", (event) => {
                const div = document.getElementById(book.key);
                const h1 = div.getElementsByTagName('h1');
                if (favourites.includes(book.key)) {
                    const index = favourites.indexOf(book.key);
                    favourites.splice(index, 1);
                    h1[0].className = "negrita";
                } else {
                    favourites.push(book.key);
                    saveFavourites();
                    h1[0].className = "resaltado";
                }
                
            })
    
            div.appendChild(img);
            div.appendChild(h1);
            div.appendChild(isbn);
            div.appendChild(year);
            div.appendChild(btnFav);
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
});

readFavourites;