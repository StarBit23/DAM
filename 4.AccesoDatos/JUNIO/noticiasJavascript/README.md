# FeedY'a

Un lector de noticias, un alimentador RSS/ATOM, ligero en HTML+JS.

Tecnologías usadas:

* CSS: BootStrap 5.2
* JS: JavaScript Vanilla.
* HTML: HTML 5.

## Calentando el plato

Creamos una Web en HTML5 sencilla con el asistente:

```html
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Feed Y'a</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        <!-- Aquí va el cuerpo de la página -->
    </body>
</html>
```

Añadimos de CDN (Content Delivery Network) Bootstrap, buscando "CDN BootStrap" en un buscador. Lo encontramos en <https://www.bootstrapcdn.com/>. Recordamos que el CSS hay que añadirlo en el HEAD de la página. El JavaScript puede ir también en el HEAD o en el BODY.

```html
    <head>
        <title>Feed Y'a</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>

        <link href="css/style.css" rel="stylesheet">
    </head>
```

Siguiendo la [documentación oficial](https://getbootstrap.com/docs/5.2/components/navbar/) hacemos el menú:

```html
<nav class="navbar navbar-dark bg-dark navbar-expand-lg">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">FeedY'a</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
                aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav">
                    <li class="nav-item" id="menu_listadoRss">
                        <a class="nav-link" href="#">Listado Canales </a>
                    </li>
                    <li class="nav-item" id="menu_listadoNoticias">
                        <a class="nav-link" href="#">Listado Noticias</a>
                    </li>
                    <li class="nav-item" id="menu_addRss">
                        <a class="nav-link" href="#">Añadir Canal </a>
                    </li>
                    <li class="nav-item" id="menu_acercaDe">
                        <a class="nav-link" href="#">Acerca de... </a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
```

Como queremos hacer una [SPA (Single Page Aplication)](https://en.wikipedia.org/wiki/Single-page_application), vamos a crear varios DIV (cajas) etiquetados con el atributo "**panel**" que serán las distintas vistas o ventanas de la aplicación:

```html
    <div class="container">
        <div id="listadoRss" class="panel">
            <p>Lista de canales RSS/ATOM</p>
        </div>

        <div id="listadoNoticias" class="panel">
            <p>Lista de Noticias</p>
        </div>

        <div id="addRss" class="panel">
            <h3>Añadir canal</h3>
            <form>
                <div class="mb-3">
                  <label for="formNombreCanal" class="form-label">
                    Nombre del Canal
                  </label>
                  <input type="text" class="form-control" id="formNombreCanal" aria-describedby="ayudaNombre">
                  <div id="ayudaNombre" class="form-text">
                    Introduce un nombre representativo para el canal de noticias.
                  </div>
                </div>
                <div class="mb-3">
                  <label for="formUrlCanal" class="form-label">URL del Canal</label>
                  <input type="url" class="form-control" id="formUrlCanal" aria-describedby="ayudaUrl">
                  <div id="ayudaUrl" class="form-text">
                    Ejemplo: https://www.diariojaen.es/rss/jaen.xml
                  </div>
                </div>
                <div class="mb-3">
                    <select id="formTipoCanal" class="form-select">
                        <option value="rss">RSS</option>
                        <option value="atom">ATOM</option>
                        <option value="auto">AUTO</option>
                    </select>
                </div>
                <div id="formButtonCanal" class="btn btn-primary">Añadir</div>
              </form>
        </div>

        <div id="acercaDe" class="panel">
            <p>Sobre nosotros</p>
        </div>

    </div>
```

Ahora creamos unas funciones JavaScript para controlar desde el menú que se vean unos paneles u otros. Empezamos ocultando todos los paneles (DIVs con la clase panel):

```javascript
// Funcion para ocultar todos los paneles
hideAll = () => {
    document.querySelectorAll(".panel").forEach((elemento) => {
        // elemento.style.visibility = 'hidden';
        elemento.style.display = 'none'
    }); 
}
```

Para conectar los menús con los paneles, hemos llamado igual los atributos **id**s de los menús y de los paneles, pero a los menús le pusimos delante **menu_**. Buscamos los que empiezan por menú:

```javascript
[id^="menu_"]
```

A cada entrada **li** del menú le añado un evento **onClick**:

```javascript
// Cuando la página está totalmente cargada, procesamos arranque

onload = () => {

    hideAll();
    // Esto hace que cada clic en el menú muestre sólo su panel correspondiente
    document.querySelectorAll('[id^="menu_"]').forEach((elemento) =>{        
        let ident = elemento.getAttribute('id');
        let panelName = ident.replace("menu_", "");
        console.log(elemento)
        elemento.addEventListener("click", (event)=>{
            hideAll()
            // Usamos none/block y no visible/hidden porque este último 
            // deja espacios siempre aunque esté oculto.
            // document.getElementById(panelName).style.visibility = 'visible'
            document.getElementById(panelName).style.display = 'block'
        });
    });
};
```

