package com.appJuegosFinal.listener;


import com.appJuegosFinal.modelos.Juego;

/**
 * Esta interfaz, se encargará de gestionar los
 * eventos click sobre un pueblo y el botón de editar y borrar.
 */
public interface OnJuegoInteractionListener {

    public void onJuegoClick(Juego juego);
    public void onJuegoEditarClick(Juego juego);
    public void onJuegoBorrarClick(Juego juego);
}
