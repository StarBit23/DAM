
marcadores = {}
    
marcadores.lista = [];
    
marcadores.load = () => {
    let lista = JSON.parse(localStorage.getItem("marcadores"))
    if (lista != null) {
        marcadores.lista = lista
    } else {
        marcadores.lista = []
    }
}

/**
 * Añade un canal RSS/ATOM
 * Marcador:
 * {
 *  nombre: "Diario Jaén",
 *  url: "http://www.jaen.es",
 *  tipo: "atom"
 * }
 * @param {*} marcador 
 */
marcadores.save = (marcador) => {

    if (marcador.id == "") {
        marcadores.lista.push(marcador)
    } else {
        let index = marcador.id;
        marcadores.lista[index].nombre  = marcador.nombre;
        marcadores.lista[index].url     = marcador.url;
        marcadores.lista[index].tipo    = marcador.tipo;
    }
    localStorage.setItem("marcadores", JSON.stringify(marcadores.lista))
}


/**
 * Comprueba que es un canal RSS/ATOM válido
 * Marcador:
 * {
 *  nombre: "Diario Jaén",
 *  url: "http://www.jaen.es",
 *  tipo: "atom"
 * }
 * @param {*} marcador 
 */
marcadores.check = (marcador) => {
    fetch(marcador.url, { mode: 'cors' })
        .then(response => response.json())
        .then(data => {
            let respuesta = "none";
            // parseamos la respuesta con DOM
            const items = data.rss.channel.item;
            if (items.length > 0 ){ 
                respuesta = "rss";
            } else {
                const entries = data.feed.channel.entry;
                if (entries.length > 0 ){ 
                    respuesta = "atom";
                }
            }
            return respuesta;
        }).catch( (error) => {
            console.log(error);
            return "error: " + error;
        });
}

marcadores.retrieveRss = (url) => {
    
    fetch('http://127.0.0.1:3000/proxy?url='+url, 
        { 
            method: 'POST', 
            mode: 'cors',  
        })
        .then(response => response.json())
        .then(data => {
            // parseamos la respuesta con DOM
            const items = data.rss.channel.item;
            const container = document.querySelector('#listadoNoticias'); 
            // vaciamos el contenedor donde van las noticias
            while (container.firstChild) {
                container.removeChild(container.firstChild);
                }
            // creamos una "card" para cada noticia
            items.forEach(item => {
                const title = item.title;
                const description = item.description;
                const date = item.pubDate;
                const link = item.link;

                const card = document.createElement('div');
                card.classList.add('card');
                card.innerHTML = `
                    <h5 class="card-title">${title}</h2>
                    <p class="card-text">${description}</p>
                    <p class="card-subtitle mb-2 text-muted">${date}</p>
                    <a class="card-link" href="${link}" target="_blank">Más información</a>
                `;
                container.appendChild(card);
            });
            updateNews();
        })
    .catch((error) => {
            // vaciamos el contenedor donde van las noticias
            // container.innerHTML = '';
            const container = document.querySelector('#listadoNoticias'); 
            while (container.firstChild) {
                container.removeChild(container.firstChild);
              }
            const caja = document.createElement('div');
            caja.classList.add('alert');
            caja.classList.add('alert-danger');
            caja.innerHTML = `
              <p>ERROR al conectar al canal:</p>
              <p>${error}</p>
            `;
            container.appendChild(caja);
        });
}


marcadores.retrieveAtom = (url) => {
    
    fetch('http://127.0.0.1:3000/proxy?url='+url, 
        { 
            method: 'POST', 
            mode: 'cors',  
        })
        .then(response => response.json())
        .then(data => {
            // parseamos la respuesta con DOM
            const items = data.feed.channel.entry;
            const container = document.querySelector('#listadoNoticias'); 
            // vaciamos el contenedor donde van las noticias
            while (container.firstChild) {
                container.removeChild(container.firstChild);
                }
            // creamos una "card" para cada noticia
            items.forEach(item => {
                const title = item.querySelector('title').textContent;
                const description = item.querySelector('summary').textContent;
                const date = item.querySelector('updated').textContent;
                const link = item.querySelector('link').getAttribute('href');

                const card = document.createElement('div');
                card.classList.add('card');
                card.innerHTML = `
                    <h5 class="card-title">${title}</h2>
                    <p class="card-text">${description}</p>
                    <p class="card-subtitle mb-2 text-muted">${date}</p>
                    <a class="card-link" href="${link}" target="_blank">Más información</a>
                `;
                container.appendChild(card);
            });
            updateNews();
        })
    .catch((error) => {
            // vaciamos el contenedor donde van las noticias
            // container.innerHTML = '';
            const container = document.querySelector('#listadoNoticias'); 
            while (container.firstChild) {
                container.removeChild(container.firstChild);
              }
            const caja = document.createElement('div');
            caja.classList.add('alert');
            caja.classList.add('alert-danger');
            caja.innerHTML = `
              <p>ERROR al conectar al canal:</p>
              <p>${error}</p>
            `;
            container.appendChild(caja);
        });
}


marcadores.news = (index) => {
    console.log(marcadores.lista[index].tipo);
    if (marcadores.lista[index].tipo == "rss") {
        marcadores.retrieveRss(marcadores.lista[index].url);
    } else {
        if (marcadores.lista[index].tipo == "atom") {
            marcadores.retrieveAtom(marcadores.lista[index].url);
        }
    }
}

marcadores.listar = (caja, fnclbk) => {
        // En ES6 podemos asignar directamente código HTML 
        // en una variable para hacerlo más fácil de mantener
        // fíjate en el carácter acento agudo.
        let contenido = `
            <table class="table table-striped"> 
                <thead class="table-dark">  
                    <tr> 
                        <th>#</th>
                        <th>Nombre</th>
                        <th>URL</th>
                        <th>tipo</th>
                        <th>borrar</th> 
                        <th>editar</th> 
                    </tr> 
                </thead> 
                <tbody>
            `;

        marcadores.lista.forEach((marcador, index) => {
            contenido +=
                `<tr>
                        <td> ${index}</td>
                        <td onclick="marcadores.news(${index})"> ${marcador.nombre} </td>
                        <td> ${marcador.url} </td>
                        <td> ${marcador.tipo}</td>
                        <td> 
                            <i onclick="marcadores.delete(${index})" class="fa-solid fa-trash"></i>
                        </td>
                        <td>
                            <i onclick="marcadores.update(${index}, updateMarcador)" class="fa-regular fa-pen-to-square"></i> 
                        </td>
                    </tr>`
        })

        contenido += `
                </tbody> 
            </table> `

        document.getElementById(caja).innerHTML = contenido;
}

marcadores.delete = (index) => {
    marcadores.lista.splice(index,1);
    localStorage.setItem("marcadores", JSON.stringify(marcadores.lista));
    marcadores.listar("listadoRss");
}


marcadores.update = (index, clbkfn) => {
    document.getElementById("formIdCanal").value = index;
    document.getElementById("formNombreCanal").value = marcadores.lista[index].nombre;
    document.getElementById("formUrlCanal").value = marcadores.lista[index].url;
    document.getElementById("formTipoCanal").value = marcadores.lista[index].tipo;    
    clbkfn();
}