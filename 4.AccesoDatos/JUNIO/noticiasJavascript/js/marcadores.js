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
    // TO-DO FALTAN COMPROBACIONES
    marcadores.lista.push(marcador)
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
marcadores.retrieveAtom =(url, caja) => {
    fetch(url, { mode: 'cors' })
        .then(response => response.text())
        .then(data => {
            // parseamos la respuesta con DOM
            const parser = new DOMParser();
            const xml = parser.parseFromString(data, 'application/xml');
            const items = xml.querySelectorAll('item');
            const container = document.querySelector(caja); 
            // vaciamos el contenedor donde van las noticias
            while (container.firstChild) {
                container.removeChild(container.firstChild);
              }
            // creamos una "card" para cada noticia
            items.forEach(item => {
                const title = item.querySelector('title').textContent;
                const description = item.querySelector('description').textContent;
                const date = item.querySelector('pubDate').textContent;
                const link = item.querySelector('link').textContent;

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
        })
        .catch((error) => {
            const container = document.querySelector(caja);
            while(container.firstChild) {
                container.removeChild(container.firstChild)
            }
            const caja2 = document.createElement('div');
            caja2.classList.add(`alert`);
            caja2.classList.add(`alert-danger`);
            caja2.innerHTML = `
            <p>ERROR al conectar al canal</p>
            ${error}
            `;
            container.appendChild(caja);
        });
};

/**
 * Comprueba que es un canal RSS/FEED válido
 * Marcador:
 * {
 *  nombre: "Diario Jaén",
 *  url: "http://www.jaen.es",
 *  tipo: "atom"
 * }
 * @param {*} marcador 
 */
marcadores.retrieveFeed =(url, caja) => {
    fetch(url, { mode: 'cors' })
        .then(response => response.text())
        .then(data => {
            // parseamos la respuesta con DOM
            const parser = new DOMParser();
            const xml = parser.parseFromString(data, 'application/xml');
            const items = xml.querySelectorAll('item');
            const container = document.querySelector(caja); 
            // vaciamos el contenedor donde van las noticias
            while (container.firstChild) {
                container.removeChild(container.firstChild);
              }
            // creamos una "card" para cada noticia
            items.forEach(item => {
                const title = item.querySelector('title').textContent;
                const summary = item.querySelector('summary').textContent;
                const date = item.querySelector('updated').textContent;
                const link = item.querySelector('link').textContent;

                const card = document.createElement('div');
                card.classList.add('card');
                card.innerHTML = `
                    <h5 class="card-title">${title}</h2>
                    <p class="card-text">${summary}</p>
                    <p class="card-subtitle mb-2 text-muted">${date}</p>
                    <a class="card-link" href="${link}" target="_blank">Más información</a>
                `;
                container.appendChild(card);
            });
        })
        .catch((error) => {
            const container = document.querySelector(caja);
            while(container.firstChild) {
                container.removeChild(container.firstChild)
            }
            const caja2 = document.createElement('div');
            caja2.classList.add(`alert`);
            caja2.classList.add(`alert-danger`);
            caja2.innerHTML = `
            <p>ERROR al conectar al canal</p>
            ${error}
            `;
            container.appendChild(caja);
        });
};


