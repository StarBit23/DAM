let urlInstalacion = "/admin/instalacion";

// Documentación FECTH https://developer.mozilla.org/es/docs/Web/API/Fetch_API/Using_Fetch

async function getInstalacion () {
    try {
        let res = await fetch(urlInstalacion);
        return await res.json();
    } catch {
        console.error("Inposible conectar al backend");
        return '{ "error" = "Instalación: imposible conectar al backend"  }'
    }
}

async function renderSelectInstalacion(select) {
    let instalaciones = await getInstalacion();
    let html = "";
    try {
        instalaciones.forEach( instalacion => {
            html += `<option value= ${instalacion.id} > ${instalacion.nombre} </option>`;
        });
        
    } catch {
        html = "<option>ERROR</option>";
    }   
    let container = document.querySelector(select);
    container.innerHTML = html;
}

async function deleteInstalacion(id) {
    
    try {
        let respuesta = fetch(url+"/"+id, '{method: "DELETE"}').then(
            () => renderInstalacion()
        );
    } catch {
        let container = document.querySelector('#panel_error');
        container.innerHTML = "<h2>Error al eliminar la instalación.</h2>";
    }
}

async function createInstalacion() {
    try{
        let nombre = document.querySelector('#instalacion').nodeValue;
        let instalacion ={id: 1, nombre: nombre} 
        let respuesta = fetch(url, {method: "POST", body: JSON.stringify(instalacion)}).then(
            () => renderInstalacion()
        );
    } catch{

    } 
} 

async function renderInstalacion(listado) {
    let instalaciones = await getInstalacion();

    let html = "";

    try {
        html += `
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>ID</th> <th>nombre</th>
                    </tr>
                </thead>
                <tbody>`;

        instalaciones.forEach(instalacion => {
            html += `<tr>
                <td>${instalacion.id}</td>
                <td>${instalacion.nombre}</td>
            </tr>`;
        });
        html += `</tbody>
            </table>`;
    } catch {
        html = " <b>Error conectando al backend</b>";
    }

    let container = document.querySelector(listado);
    container.innerHTML = html;
}

