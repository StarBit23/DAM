let url2 = "/admin/ususario";

async function getUsuario() {
    try {
        let res = await fetch(url2);
        return await res.json;
    } catch {
        console.error("Imposible conectar al backend");
        return ("error","Usuario: imposible conectar al backend")
    }

}

async function renderUsuario() {
    let usuarios = await getUsuario();
    let html="";
    try {
        html += `
    <table class="table table stripped">
        <thead>
            <tr>
                <th>id</th> <th>username</th> <th>password</th> <th>email</th> <th>activo</th>
            </tr>
        </thead>
        <tbody>`
    usuarios.forEach(usuario => {
        html +=`
        <tr>
            <td>${usuario.id}</td>
            <td>${usuario.username}</td>
            <td>${usuario.password}</td>
            <td>${usuario.email}</td>
            <td>${usuario.activo}</td>
        </tr>`
    });

    
    html += `</tbody>
    </table>`
    } catch {
        console.error("Imposible conectar al backend");
        return ("error","Usuario: imposible conectar al backend")
    }
    

    let contador = document.querySelector('#usuario');
    contador.innerHTML = html;

} 

//export default renderUsuario();