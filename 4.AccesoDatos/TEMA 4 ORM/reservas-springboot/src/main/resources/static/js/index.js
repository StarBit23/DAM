

function cargaInicial() {

        $.controller.init("#panel_home");

        $('#ayuda_home').click(()=>{
            $.controller.modal(
                'Gestión integral de reservas', 
                'Panel del administrador, pulse en el menú para ver todas las opciones posibles',
                ()=>{ console.log("modal cerrando...")});
        });
        /* Lógica instalaciones */

        $('#menu_instalacion_baja').click(()=>{
            renderSelectInstalacion('#select_instalacion_baja');
        });

        $('#menu_instalacion_listado').click(()=>{
            renderInstalacion('#listado_instalaciones');
        });

        $('#btn_instalacion_alta').click(()=>{
            let nombre = $('#input_instalacion_nombre').val();
            let instalacion = {
                nombre: nombre,
                id: -1
            };
            console.log(instalacion);
            $.controller.doPost('admin/instalacion', instalacion, ()=>{
                renderInstalacion('#listado_instalaciones');
                $.controller.activate('#panel_instalacion_listado');
            });
        });

        $('#btn_instalacion_baja').click(()=>{
            let instalacionId = $('#select_instalacion_baja').val();
            $.controller.doDelete('admin/instalacion', instalacionId, ()=>{
                renderInstalacion('#listado_instalaciones');
                $.controller.activate('#panel_instalacion_listado');
            });
        });

        $('#menu_instalacion_actualiza').click(()=>{
            renderSelectInstalacion('#select_instalacion_actualiza');
        });

        $('#select_instalacion_actualiza').on('change', ()=>{
            $('#id_instalacion_actualiza').val(
                $('#select_instalacion_actualiza').val() );
                
            $('#input_instalacion_actualiza').val(
                $('#select_instalacion_actualiza option:selected').text() );                
            });

        $('#btn_instalacion_actualiza').click(()=>{
            let instalacion = {
                id:     $('#id_instalacion_actualiza').val(),
                nombre: $('#input_instalacion_actualiza').val()
            }
            $.controller.doPost('/admin/instalacion', instalacion, ()=>{
                renderInstalacion('#listado_instalaciones');
                $.controller.activate('#panel_instalacion_listado');
            });
        });

        /* Lógica reservas */

        $('#menu_reserva_listado').click(()=>{
            renderReserva('#listado_reserva');
        });

        $('#btn_reserva_alta').click(()=>{
            
            let reserva =  {
                "id": -1,
                "usuario": {
                    "id": 2
                },
                "horario": {
                    "id": 130
                },
                "fecha": "2023-01-04"
             };
            //  let reserva =  {
            //     "id": 1,
            //     "usuario": {
            //         "id": 2,
            //         "username": "pepillo",
            //         "password": "secreto",
            //         "email": "pepe@gmail.com",
            //         "activo": true
            //     },
            //     "horario": {
            //         "id": 130,
            //         "instalacion": {
            //             "id": 14,
            //             "nombre": "pista de pádel"
            //         },
            //         "inicio": "08:00:00",
            //         "fin": "09:30:00"
            //     },
            //     "fecha": "2023-01-26"
            // }
            console.log(reserva);
            $.controller.doPost('admin/reserva', reserva, ()=>{
                renderReserva('#listado_reserva');
                $.controller.activate('#panel_reserva_listado');
            });
        });

        /* Logica usuarios */ 
        $('#menu_usuario_baja').click(()=>{
            renderSelectUsuario('#select_usuario_baja');
        });

        $('#menu_usuario_listado').click(()=>{
            renderUsuario('#listado_usuarios');
            //$.controller.activate('#panel_usuario_listado')
        });

        $('#btn_usuario_baja').click(()=>{
            let usuarioId = $('#select_usuario_baja').val();
            $.controller.doDelete('admin/usuario', usuarioId, ()=>{
                renderUsuario('#listado_usuarios');
                $.controller.activate('#panel_usuario_listado');
            });
        });

        $('#btn_usuario_alta').click(()=>{
            let username = $('#input_usuario_nombre').val();
            let password = $('#input_usuario_pass').val();
            let email = $('#input_usuario_email').val();
            let activo = $('#input_usuario_activo').val();
            let usuario = {
                id: -1,
                username: username,
                password: password,
                email: email,
                activo: activo
            };
            console.log(usuario);
            $.controller.doPost('admin/usuario', usuario, ()=>{
                renderUsuario('#listado_usuarios');
                $.controller.activate('#panel_usuario_listado');
            });
        });

        $('#menu_usuario_actualiza').click(()=>{
            renderSelectUsuario('#select_usuario_actualiza');
        });

        $('#select_usuario_actualiza').on('change', ()=>{
            $('#id_usuario_actualiza').val(
                $('#select_usuario_actualiza').val() );
                
            $('#input_usuario_actualiza').val(
                $('#select_usuario_actualiza option:selected').text() );
                
            $('#pass_usuario_actualiza').val(
                $('#select_usuario_actualiza option:selected').text() );

            $('#email_usuario_actualiza').val(
                $('#select_usuario_actualiza option:selected').text() );  

            $('#activo_usuario_actualiza').val(
                $('#select_usuario_actualiza option:selected').text() );  
            });

        $('#btn_usuario_actualiza').click(()=>{
            let usuario = {
                id:     $('#id_usuario_actualiza').val(),
                username: $('#input_usuario_actualiza').val(),
                email: $('#email_usuario_actualiza').val(),
                password: $('#pass_usuario_actualiza').val(),
                activo: $('#activo_usuario_actualiza option:selected').val()
            }
            $.controller.doPost('/admin/usuario', usuario, ()=>{
                renderUsuario('#listado_usuarios');
                $.controller.activate('#panel_usuario_listado');
            });
        });
    };
