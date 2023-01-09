package com.pmdm.virgen.pueblosconnavigationdraweb.listener;


import com.pmdm.virgen.pueblosconnavigationdraweb.modelos.Pueblo;

/**
 * Esta interfaz, se encargará de gestionar los
 * eventos click sobre un pueblo y el botón de editar y borrar.
 */
public interface OnPuebloInteractionListener {

    public void onPuebloClick(Pueblo pueblo);
    public void onPuebloEditarClick(Pueblo pueblo);
    public void onPuebloBorrarClick(Pueblo pueblo);
}
