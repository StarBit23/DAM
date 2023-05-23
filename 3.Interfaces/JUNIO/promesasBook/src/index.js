
const countPromiseBook = () => {
    return fetch("http://openlibrary.org/search.json?q=javascript")
    .then(response => response.json())
    .then((datos) => {
        let nbooks = 0;
        datos.docs.forEach(book => {
            // if (book.first_publish_year === 2022) {
            //     nbooks++;
            // }
            return book;
            
        });
        //return nbooks;
    })
};

countPromiseBook().then((contador)=>{console.log(contador)});

const countAsyncBooks = async () => {
    const response = await fetch("http://openlibrary.org/search.json?q=javascript");
    const data = await response.json();
    let nbooks = 0;
    data.docs.forEach(book => {
        if (book.first_publish_year === 2022) {
            nbooks++;
        }
    });
    return nbooks;
}

const booksByYear = async (query, year=2022) => {
    const response = await fetch("http://openlibrary.org/search.json?q="+query);
    const data = await response.json();
    let nbooks = 0;
    const books = [];
    data.docs.forEach(book => {
        if (book.first_publish_year === year) {
            books.push({title: book.title, isbn: book.isbn})
        }
    });
    return books;
}


const renderNBooks = (nbooks) => {
    document.getElementById("nbooks").innerHTML = `El nº de <b class="resaltado">libros</b> son ${nbooks}`
}

const renderCountBooks = async () => {
    const nbooks = await countAsyncBooks();
    console.log(nbooks);
    renderNBooks(nbooks);
}

const renderByYear = async () => {
    const bookByYear = await booksByYear('javascript');
    console.log(bookByYear);
}

//renderCountBooks();
renderByYear();