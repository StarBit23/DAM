
let url = "/admin/instalacion";

async function getInstalacion() {
    try {
        let res = await fetch(url);
        return await res.json;
    } catch {
        console.error("Imposible conectar al backend");
        return ("error","Instalacion: imposible conectar al backend")
    }

}

async function renderInstalacion() {
    let instalaciones = await getInstalacion();
    let html="";
    try {
        html += `
    <table class="table table stripped">
        <thead>
            <tr>
                <th>id</th> <th>nombre</th>
            </tr>
        </thead>
        <tbody>`
    instalaciones.forEach(instalacion => {
        html +=`
        <tr>
            <td>${instalacion.id}</td>
            <td>${instalacion.nombre}</td>
        </tr>`
    });

    
    html += `</tbody>
    </table>`
    } catch {
        console.error("Imposible conectar al backend");
        return ("error","Instalacion: imposible conectar al backend")
    }
    

    let contador = document.querySelector('#instalacion');
    contador.innerHTML = html;

} 

//export default renderInstalacion();
