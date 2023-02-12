package com.example.miproyecto.listener;

import com.example.miproyecto.modelo.Juego;

/*
 * Esta interfaz, se encargará de gestionar los
 * eventos click sobre un pueblo y el botón de editar y borrar.
 */
public interface OnPuebloInteractionListener {

    public void onJuegoClick(Juego juego);
    public void onJuegoEditarClick(Juego juego);
    public void onJuegoBorrarClick(Juego mItem);
}
