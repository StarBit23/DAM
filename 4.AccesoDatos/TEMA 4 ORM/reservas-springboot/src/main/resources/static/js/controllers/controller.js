
/**
 * Este Objeto es usado para controlar el panel activo en cada momento
 * y es llamado desde los otros objetos.
 */

// El controlador es un objeto
$.controller = {};

// propiedades del controlador (atributos)
// cuidado con el host, cámbialo a 127.0.0.1 ó localhost 
$.controller.host="localhost";
$.controller.port="8080";
$.controller.api="/admin";

$.controller.url= "http://"+$.controller.host+":"+$.controller.port+
    "/"+$.controller.api+"/";

$.controller.username="";
$.controller.password="";
$.controller.active_panel = "";
$.controller.init_panel = "";

/**
 * Esta función gestiona qué panel está activo en cada momento (sólo puede
 * haber uno)
 * @param {type} panel_name el nombre del panel a activar
 */
$.controller.activate = function (panel_name) {
    $($.controller.active_panel).hide("fast","swing");
    $(panel_name).show("fast","swing");
    $.controller.active_panel = panel_name;
};

/**
 * función para volver al panel inicial
 */
$.controller.activate_inicio = function() {
    $.controller.activate($.controller.init_panel);
}

/**
 * Función para recoger los datos del Login
 */
$.controller.login = function () {
    $.controller.username = $("#username").val();
    $.controller.password = $("#password").val();
    $.controller.activate("#panel_main");
};

/**
 * Función para gestionar el panel de mensajes de error.
 * @param {type} title título del error
 * @param {type} msg mensaje del error (descripción)
 */
$.controller.error = function (title, msg) {
    var caja_error = $("#panel_error");
    caja_error.empty();
    caja_error.append('<h3>' + title + '</h3>');
    caja_error.append('<p>' + msg + '</p>');
    // cargamos el panel error
    $.controller.activate("#panel_error");
};

/**
 * Función para gestionar los códigos de retorno (error) del servidor
 * tras hacer las peticiones REST
 * @param {type} codigo
 */
$.controller.errorManager = function (codigo) {
    switch (codigo) {
        case 500: // error interno
            $.controller.error("Error 500", "No se ha podido completar la operación en el servidor");
            break;
        case 401: // no autorizado
            $.controller.activate("#panel_login");
            break;
        case 404: // no autorizado
            $.controller.error("Error 404", "No se ha encontrado el objeto");
            break;
        case 204: // sin respuesta (ej. tras un delete o un put
            $.controller.activate("#panel_main");
            break;
        default:
            $.controller.error("Error de conexión", "En estos momentos no ha sido posible acceder al servidor");
    }
}; 

/**
 * Función para gestionar la autorización contra el servidor.
 * Puedes cambiarla para hacerlo con sesiones, sessionStorage, token, OAuth...
 * @param {type} xhr las cabeceras
 */
$.controller.authorize = function(xhr) {
    // Descomentar para mandar autorización básica en las peticiones
    //xhr.setRequestHeader ("Authorization", "Basic " +  
    //    btoa($.controller.username+":"+$.controller.password));
};

/**
 * Función para crear todos los "onClick" de los menús y
 * asociarlos con cada panel correspondiente.
 */
$.controller.init = function (panel_inicial) {

    // Conectamos cada "menu_XXX" con su panel "panel_XXX" correspondiente
    // i.e., le enlazamos el evento "on click"
    $('[id^="menu_"]').each(function () {
        let $this = $(this);
        let menu_id = $this.attr('id');
        let panel_id = menu_id.replace('menu_', 'panel_');

        $("#" + menu_id).click(function () {
            $.controller.activate("#" + panel_id);
        });
        console.log("id_menu::" + menu_id + "  id_panel" + panel_id);
    });

    // para cerrar el menú al hacer clic
    $('.dropdown-item').on('click',function() {
        $('.navbar-collapse').collapse('hide');
    });

    // ocultamos todos los paneles
    $(".panel").hide();
    $("#alerta").hide();
    // mostramos sólo el panel inicial
    $(panel_inicial).show();
    // en el atributo para el "panel activo" guardamos el inicial
    $.controller.active_panel = panel_inicial;
    $.controller.init_panel = panel_inicial;
};


/**
 * Función para hacer el GET al servicio REST
 * @param {type} target la URL donde está el servicio REST
 * @param {type} fn_exito función a llamar cuando tenga éxito 
 */
$.controller.doGet = function (target, fn_exito) {
    $.get({
        url: target,
        type: 'GET',
        dataType: 'json',
        contentType: 'application/json;charset=UTF-8',
        crossDomain: true,
        success: fn_exito,
        beforeSend: function (xhr) {
            $.controller.authorize(xhr);
        },
        error: function (xhr, status) {
            console.log("ERROOOOOR!!!!", xhr.status);
            $.controller.errorManager(xhr.status);                
        }});
};

/**
 * Función para hacer el POST al servicio REST
 * @param {type} target la URL donde está el servicio REST
 * @param {type} datos los datos a subir
 * @param {type} fn_exito función a llamar cuando tenga éxito 
 */
$.controller.doPost = function(target, datos, fn_exito) {
    $.ajax({
            url: target ,
            method: 'POST',
            dataType: 'json',
            contentType: "application/json;charset=UTF-8",
            data: JSON.stringify(datos),
            beforeSend: function (xhr) {
                $.controller.authorize(xhr);
            },
            error: function (xhr, status) {
                $.controller.errorManager(xhr.status);                
            }
        }).done(fn_exito);
};

/**
 * 
 * @param {type} target
 * @param {type} id
 * @param {type} datos
 * @param {type} fn_exito
 */
$.controller.doPut = function(target, id, datos, fn_exito) {
    $.ajax({
        url: target+'/'+id,
        method: 'PUT',
        dataType: 'json',
        contentType: "application/json;charset=UTF-8",
        data: JSON.stringify(datos),
        beforeSend: function (xhr) {
            $.controller.authorize(xhr);
        },
        success: fn_exito,
        error: function (xhr, status) {
            $.controller.errorManager(xhr.status);                
        }
    });
};

/**
 * 
 * @param {type} target
 * @param {type} id
 * @param {type} fn_exito
 */
$.controller.doDelete = function(target, id, fn_exito) {
    $.ajax({
        url: target + '/' + id,
        method: 'DELETE',
        dataType: 'json',
        contentType: "application/json;charset=UTF-8",
        beforeSend: function (xhr) {
            $.controller.authorize(xhr);
        },
        success: fn_exito,
        error: function (xhr, status) {
            $.controller.errorManager(xhr.status);                
        }
    });
};

$.controller.alert = function(titulo, mensaje){
    $("#titulo_alerta").contents().last().replaceWith(titulo);
    $("#mensaje_alerta").contents().last().replaceWith(mensaje);
    $("#alerta").show();
    setTimeout(() => {
        $("#alerta").hide();
    },2000);
};

$.controller.modal = function(titulo, texto, fn_confirmar) {
    $.controller.confirmar = fn_confirmar;
    $("#confirmarTitulo").contents().last().replaceWith(titulo);
    $("#confirmarText").contents().last().replaceWith(texto);
    // $("#confirmarBoton").attr("onclick",fn_confirmar);
    // $("#confirmarCancelarBoton").attr("onclick", $('#confirmar').modal('hide'));
    $("#confirmarBoton").click(() => { 
        $('#confirmar').modal('hide'); 
        $.controller.confirmar();
        console.log("Aceptado");
    });
    $("#confirmarCancelarBoton").click(() => { 
        $('#confirmar').modal('hide'); });
    // $("#confirmarCancelarBoton").click($('#confirmar').modal('hide'));
    $('#confirmar').modal('show');
};

