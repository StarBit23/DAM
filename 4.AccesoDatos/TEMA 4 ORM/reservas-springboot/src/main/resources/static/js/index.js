

function cargaInicial() {

        let deleteBtn = document.querySelector('#instalacion-delete-btn');
        console.log(deleteBtn);
        deleteBtn.addEventListener(
            "click", () => {
            let idInstalacion = 
                document.querySelector('#instalacion-delete-select');
            console.log(idInstalacion);
            deleteInstalacion(idInstalacion.value);
        });

        $.controller.init("#panel_home");

        $('#menu_instalacion_baja').click(()=>{
            renderSelectInstalacion('#instalacion-delete-select');
        });

        $('#menu_instalacion_listado').click(()=>{
            renderInstalacion('#listado_instalaciones');
        });

        $('#instalacion-delete-btn').click(() => {
            let instalacionId = $('#instalacion-delete-select').val();
            $.controller.doDelete('admin/instalacion', instalacionId,()=>{
                renderInstalacion('#listado_instalaciones');
                $.controller.activate('#panel_instalacion_listado');
            });
        });

        $('#menu_instalacion_actualiza').click(() => {
            renderInstalacion('#select_instalacion_actualiza')
        });

        $('#btn_instalacion_alta').click(() =>{
            let nombre = $('#input_instalacion_nombre').val();
            let instalacion = {
                nombre: nombre,
                id: -1
            }
            console.log(instalacion);
            $.controller.doPost('admin/instalacion',instalacion,() => {
                renderInstalacion('#listado_instalaciones');
                $.controller.activate('#panel_instalacion_listado')
            });
        });


    };
