
// Funcion para ocultar todos los paneles
hideAll = () => {
    document.querySelectorAll(".panel").forEach((elemento) => {
        // elemento.style.visibility = 'hidden';
        elemento.style.display = 'none'
    });
}

// función para mostrar el panel del formulario de RSS/ATOM
updateMarcador = () => {
    hideAll();
    document.getElementById("addRss").style.display = 'block';    
}

// función para mostrar el panel de noticias
updateNews = () => {
    hideAll();
    document.getElementById("listadoNoticias").style.display = 'block';
}


// función para añadir un canal
async function addChannel() {

    const canal = {
        id: document.getElementById("formIdCanal").value,
        nombre: document.getElementById("formNombreCanal").value,
        url: document.getElementById("formUrlCanal").value,
        tipo: document.getElementById("formTipoCanal").value
    };
    
    const resultado = await fetch('http://127.0.0.1:3000/proxy?url='+canal.url, 
        { 
            method: 'POST', 
            mode: 'cors',  
        })
        .then(response => response.json())
        .then(data => {
            let respuesta = "none";            
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

    console.log(resultado);
    if (resultado == "rss" || resultado == "atom") {
        canal.tipo = resultado;
        marcadores.save(canal);
        marcadores.listar("listadoRss");
        hideAll();
        document.getElementById("listadoRss").style.display = 'block';
    } else {
        // alert("URL no válida\n "+ resultado);
        document.getElementById("tituloAviso").innerText = "Error en la URL";
        document.getElementById("mensajeAviso").innerText = resultado;
        var modal1 = new bootstrap.Modal(document.getElementById("aviso"));
        modal1.toggle();
    }
}

// Cuando la página está totalmente cargada, procesamos arranque

onload = () => {

    /*
    Lógica para conectar los menús con su panel correspondiente (mostrar/ocultar)
    */
    hideAll();
    // Esto hace que cada clic en el menú muestre sólo su panel correspondiente
    document.querySelectorAll('[id^="menu_"]').forEach((elemento) => {
        let ident = elemento.getAttribute('id');
        let panelName = ident.replace("menu_", "");
        console.log(elemento)
        elemento.addEventListener("click", (event) => {
            hideAll()
            // Usamos none/block y no visible/hidden porque este último 
            // deja espacios siempre aunque esté oculto.
            // document.getElementById(panelName).style.visibility = 'visible'
            document.getElementById(panelName).style.display = 'block'
        });
    });

    /*
    Cargamos todos los canales de localStorage.
    */
    marcadores.load();

    /*
    Lógica para que al hacer clic en una entrada de menú, se cierre.
    También se puede hacer con clases, añadiendo a cada nav-item los tres atributos:
        data-bs-toggle="collapse" 
        data-bs-target="#navbarNavDropdown" 
        aria-controls="navbarNavDropdown" 
    */
    const navLinks = document.querySelectorAll('.nav-item')
    const menuToggle = document.getElementById('navbarNavDropdown')
    const bsCollapse = new bootstrap.Collapse(menuToggle)
    navLinks.forEach((l) => {
        l.addEventListener('click', () => { bsCollapse.toggle() })
    });
    

    /*
    Lógica para añadir un canal
    */

    document.getElementById("menu_addRss").addEventListener("click" , (event) => {
        document.getElementById("formCanal").reset();
        document.getElementById("formIdCanal").value = "";
    });

    document.getElementById("formButtonCanal").addEventListener("click", (event) => {
        addChannel();
    });

    document.getElementById("formCancelCanal").addEventListener("click", (event) => {
        hideAll();
        marcadores.listar("listadoRss");
        document.getElementById("listadoRss").style.display = 'block'
    });

    /*
    Lógica para listar canales
    */
    document.getElementById("menu_listadoRss").addEventListener("click", (event) => {

        marcadores.listar("listadoRss");
    })

    /*
     Lógica para listar noticias
     */
    document.getElementById("menu_listadoNoticias").addEventListener("click", (event) => {
        
        // FUNCIONAN:
        // marcadores.retrieveAtom('https://www.diariojaen.es/rss/jaen.xml');        
        // marcadores.retrieveFeed('https://www.ideal.es/rss/atom/?section=jaen');
        // marcadores.retrieveAtom('https://feeds.elpais.com/mrss-s/pages/ep/site/elpais.com/portada');

        // NO FUNCIONAN
        // marcadores.retrieveAtom('https://www.schneier.com/feed/atom/');
        // marcadores.retrieveAtom('https://grahamcluley.com/feed/');
        // marcadores.retrieveAtom('https://feeds.feedburner.com/TheHackersNews');
        // marcadores.retrieveFeed('https://www.ideal.es/rss/atom/?section=jaen');
        // marcadores.retrieveAtom('https://e00-elmundo.uecdn.es/elmundo/rss/portada.xml');
        // marcadores.retrieveAtom('https://www.elperiodico.com/es/rss/rss_portada.xml');
        // marcadores.retrieveAtom('http://rss.slashdot.org/Slashdot/slashdotMainatom');
    });       
    
    
};
