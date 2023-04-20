//FUNCION PARA OCULTAR TODOS LOS ELEMENTOS DE UNA CLASE
function hideAll() {
    document.querySelectorAll(".panel").forEach((elemento) => {
        //elemento.style.visibility = "hidden";
        elemento.style.display = "none";
    });
};

onload = () => {

    hideAll();

    document.querySelectorAll('[id^="menu_"]').forEach((elemento) => {
        let ident = elemento.getAttribute('id');
        let panelName = ident.replace("menu_", "");
        console.log(elemento);
        elemento.addEventListener("click", (event) => {
            hideAll();
            document.getElementById(panelName).style.visibility = 'block';
        });
    });

    /*
    Lógica para guardar canales en localStorage
    */ 
    marcadores.load();

    document.getElementById("formButtonCanal").addEventListener("click", (event) => {
        let canal = {
            nombre: document.getElementById("formNombreCanal").value,
            url: document.getElementById("formUrlCanal").value,
            tipo: document.getElementById("formTipoCanal").value
        };
            console.log(canal);

        marcadores.save(canal);

        /*
        Lógica para listar canales
        */
       document.getElementById("menu_ListadoRss").addEventListener("click" , (event) => {
        let contenido = "<table class=table table>  \
            <thead> \
                <tr>    \
                    <th>Nombre</th><th>URL</th><th>Tipo</th><th>Accion</th>    \
                </tr>   \
            </thead>    \
            <tbody> \
                <tr>"

            marcadoress.lista.forEach((marcador) => {
                contenido += '<tr>';
                contenido += '<td>'+marcador.nombre+'</td>';
                contenido += '<td>'+marcador.url+'</td>';
                contenido += '<td>'+marcador.tipo+'</td>';
                contenido += '<td>borrar</td>';
                contenido += '</tr>';
            });

            contenido+= "</tr> \
            </tbody> \
        </table>"

        document.getElementById("listadoRss")
       });
       /*
       Lógica para listar noticias
       */
      document.getElementById("menu_listadoNoticias").addEventListener("click", (event) => {
        fetch('https://www.diariojaen.es/rss/jaen.xml')
        .then( (response) => response.text)
        .then( (texto) => new window.DOMParser().parseFromString(texto, "text/html"))
        .then( (documento) => 
            documento.getElementsByName("item").forEach(item) => {
                noticias.push(
                    {
                        titular: item.getElementByTagName('title')[0].textContent(),
                        fecha: pubDate.getElementByTagName('pubDate')[0].textContent(),
                        url: item.getElementByTagName('source')[0].getAttribute('url')
                    }
                )
            }
        )
        .catch(error) => {
            console.log(error)
        }
      })
      
    })
};