
let urlResverva = "/admin/reserva";



async function getReserva () {
    try {
        let res = await fetch(urlResverva);
        return await res.json();
    } catch {
        console.error("Inposible conectar al backend");
        return '{ "error" = "Instalación: imposible conectar al backend"  }'
    }
}



async function renderReserva(listado) {
    let reservas = await getReserva();

    let html = "";

    try {
        
        html += `
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>ID</th> <th>fecha</th><th>hora</th><th>usuario</th><th>instalación</th>
                    </tr>
                </thead>
                <tbody>`;

        reservas.forEach(reserva => {
            
            html += `<tr>
                <td>${reserva.id}</td>
                <td>${reserva.fecha}</td>
                <td>${reserva.horario.inicio}</td>
                <td>${reserva.usuario.username}</td>
                <td>${reserva.horario.instalacion.nombre}</td>                
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
