# FeedYa

Un lector de noticias ligero en HTML+JS

Tecnologías usadas:

* CSS: Bootstrap 5.2
* JS: Javascript Vanilla
* HTML: HTML5

## Calentando el plato

Creamos una web en HTML5 sencilla cin el asistente

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/style.css">
    <title>FeedYa</title>
</head>
<body>
    
</body>
</html>
```

Añadimos CDN con bootstrap desde un buscador buscando "bootstrap cdn":
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="./css/style.css">
    <title>FeedYa</title>
</head>
<body>
    
</body>
</html>
```

Siguiendo la documentación oficial de bootstrap (nav), hacemos el menú:
```html
<nav class="navbar bg-primary">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">FeedNews</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
            </button>
         <div class="collapse navbar-collapse" id="navbarNavDropdown">
           <ul class="navbar-nav">
            <li class="nav-item">Listado canales</li>
            <li class="nav-item">Listado noticias</li>
            <li class="nav-item">Añadir canal</li>
            <li class="nav-item">Acerca de</li>
           </ul>
         </div>
        </div>
    </nav>
```

Añadimos los divs para mostrar/ocultar cada menú:
```html
<div id="listadoRss" class="panel">
            <p>Lista de canales RSS</p>
        </div>

        <div id="listadoNoticias" class="panel">
            <p>Lista de noticias</p>
        </div>

        <div id="addRss" class="panel1">
            <p>Añadir canal</p>
            <form>
                <div class="mb-3">
                  <label for="formNombreCanal" class="form-label">Nombre del canal</label>
                  <input type="text" class="form-control" id="formNombreCanal" 
                  aria-describedby="ayudaNombre">
                  <div id="ayudaNombre" class="form-text">
                    Añade un nombre representativo para el canala de noticias
                </div>
                </div>
                <div class="mb-3">
                  <label for="formUrlCanal" class="form-label">Url del canal</label>
                  <input type="text" class="form-control" id="formUrlCanal" 
                  aria-describedby="ayudaUrl">
                  <div id="ayudaNUrl" class="form-text">
                    Ejemplo: https://www.diariojaen.es/rss/jaen.xml
                </div>

                <div class="mb-3">
                    <select id="formTipoCanal" class="formSelect">
                        <option value="rss">RSS</option>
                        <option value="rss">ATOM</option>
                        <option value="rss">AUTO</option>
                    </select>
                </div>

                <div id="formButtonCanal" type="submit" class="btn btn-primary">Añadir</div>
                
              </form>
        </div>

        <div id="acercaDe" class="panel">
            <p>Acerca de</p>
        </div>
```

Añadimos nuestro javascript al final de nuestro html para ocultar los divs y darle click a cada elemento del menú.
Para conectar los menús con los paneles hemos llamado igual a los atributos **id** de los menús
y de los paneles, pero a los menús de pusimos delante **menu_**. Buscamos los que empiezan por
```[id=^"menu"_]```

```html
<script src="./js/index.js"></script>
```

```js
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
    let panelName = ident.replace("menu_","");
    console.log(elemento);
    elemento.addEventListener("click", (event) => {
        hideAll();
        document.getElementById(panelName).style.visibility = 'block';
    });
    });
}
```


