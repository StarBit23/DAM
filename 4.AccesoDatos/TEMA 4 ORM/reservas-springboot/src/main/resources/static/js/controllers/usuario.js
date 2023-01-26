let urlUsuario = "/admin/usuario";

async function getusuario () {
    try {
        let res = await fetch(urlUsuario);
        return await res.json();
    } catch {
        console.error("Imposible conectar al backend");
        return '{ "error" = "Usuario: imposible conectar al backend"  }'
    }
}

async function renderSelectUsuario(select) {
    let usuarios = await getusuario();
    let html = "";
    try {
        usuarios.forEach( usuario => {
            html += `<option value= ${usuario.id} > ${usuario.username} </option>`;
        });
        
    } catch {
        html = "<option>ERROR</option>";
    }   
    let container = document.querySelector(select);
    container.innerHTML = html;
}

async function createUsuario() {
    try{
        let username = document.querySelector('#usuario').nodeValue;
        let pass = document.querySelector('#pass').nodeValue;
        let email = document.querySelector('#email').nodeValue;
        let activo = document.querySelector('#activo').nodeValue;
        let usuario ={id: 1, username: username, pass: pass, email: email, activo: activo} 
        let respuesta = fetch(url, {method: "POST", body: JSON.stringify(usuario)}).then(
            () => renderUsuario()
        );
    } catch{

    } 
} 

async function deleteUsuario(id) {
    
    try {
        let respuesta = fetch(url+"/"+id, '{method: "DELETE"}').then(
            () => renderUsuario()
        );
    } catch {
        let container = document.querySelector('#panel_error');
        container.innerHTML = "<h2>Error al eliminar la instalación.</h2>";
    }
}

async function renderUsuario(listado) {
    let usuarios = await getusuario();

    let html = "";

    try {
        html += `
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>ID</th> 
                        <th>nombre</th>
                        <th>email</th>
                        <th>passwd</th>
                        <th>activo</th>
                    </tr>
                </thead>
                <tbody>`;

        usuarios.forEach(usuario => {
            html += `<tr>
                <td>${usuario.id}</td>
                <td>${usuario.username}</td>
                <td>${usuario.email}</td>
                <td>${usuario.password}</td>
                <td>${usuario.activo}</td>
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

