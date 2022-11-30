/*
Crea la clase User:
Propiedades:
- username
- firstname
- lastname
- password (Cadena vacía por defecto)
Métodos:
- En el constructor se pasa firstname, lastname, password
- username es la primera leta de firstname y las 3 primeras de lastname

Crea la clase Admins que hereda de User:
Propiedades:
- permissions 
Métodos:
- constructor. Se le pasa un objeto con los permisos por ejemplo {add_user:true, delete_user:true, edit_user: false}

Crea la clase Material:
Propiedades:
- ref
- description

Crea el objeto constante 
STATES = {
    open:'open',
    close:'close'
}

Crea la clase Ticket. (Incidencia)
Propiedades:
- user
- material
- date  (Por defecto fecha actual)
- state (Por defecto abierta)
- observations (Por defecto cadena vacía)
Métodos:
- constructor
- close(observation) Cierra la incidencia
- closeAll(tickets, observation). Método estático. Recorre el array de incidencias cerrándolas.
- getter y setter para date

Crea dos usuarios.
Crea un usuario administrador.
Crea un array con algunos materiales.
Crea un array con algunas incidencias. 
Cierra alguna incidencia con close.
Usa el getter y setter de fecha de alguna incidencia.
Cierra todas las incidencias con closeAll.
Añade un nuevo método (con el prototipo) open a ticket que reabre la incidencia.
*/
