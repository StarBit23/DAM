let urlUsuario = "/admin/usuario";

async function getusuario () {
    try {
        let res = await fetch(urlUsuario);
        return await res.json();
    } catch {
        console.error("Inposible conectar al backend");
        return '{ "error" = "Instalación: imposible conectar al backend"  }'
    }
}

async function renderUsuario() {
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

    let container = document.querySelector('#usuario');
    container.innerHTML = html;
}

