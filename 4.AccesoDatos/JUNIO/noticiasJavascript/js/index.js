// Funcion para ocultar todos los paneles
hideAll = () => {
    document.querySelectorAll(".panel").forEach((elemento) => {
        // elemento.style.visibility = 'hidden';
        elemento.style.display = 'none'
    });
}


// Cuando la página está totalmente cargada, procesamos arranque

onload = () => {

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
    Lógica para añadir un canal
    */
    marcadores.load();

    document.getElementById("formButtonCanal").addEventListener("click", (event) => {

        let canal = {
            nombre: document.getElementById("formNombreCanal").value,
            url: document.getElementById("formUrlCanal").value,
            tipo: document.getElementById("formTipoCanal").value
        };

        marcadores.save(canal);

    });

    /*
    Lógica para listar canales
    */
    document.getElementById("menu_listadoRss").addEventListener("click", (event) => {

        // En ES6 podemos asignar directamente código HTML 
        // en una variable para hacerlo más fácil de mantener
        // fíjate en el carácter acento agudo.
        let contenido = `
            <table class="table table-striped"> 
                <thead class="table-dark">  
                    <tr> 
                        <th>Nombre</th><th>URL</th><th>tipo</th><th>acción</th> 
                    </tr> 
                </thead> 
                <tbody>
            `;

        marcadores.lista.forEach((marcador) => {
            contenido +=
                `<tr>
                        <td> ${marcador.nombre} </td>
                        <td> ${marcador.url} </td>
                        <td> ${marcador.tipo}</td>
                        <td> 
                            <i class="fa-solid fa-trash"></i> 
                            <i class="fa-solid fa-pen-to-square"></i> 
                        </td>
                    </tr>`
        })

        contenido += `
                </tbody> 
            </table> `

        console.log(contenido)

        document.getElementById("listadoRss").innerHTML = contenido;
    })

    /*
     Lógica para listar noticias
     */
    document.getElementById("menu_listadoNoticias").addEventListener("click", (event) => {
        //marcadores.retrieveAtom('https://www.diariojaen.es/rss/jaen.xml','#listadoNoticias');
        marcadores.retrieveFeed('https://www.ideal.es/rss/atom/portada/','#listadoNoticias');

    });

};
