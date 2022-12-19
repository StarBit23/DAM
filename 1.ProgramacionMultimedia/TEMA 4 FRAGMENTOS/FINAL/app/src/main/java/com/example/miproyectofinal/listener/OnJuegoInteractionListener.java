package com.example.miproyectofinal.listener;

import com.example.miproyectofinal.model.Juego;

/*
 * Esta interfaz, se encargará de gestionar los
 * eventos click sobre un pueblo y el botón de editar y borrar.
 */
public interface OnJuegoInteractionListener {

    public void onPuebloClick(Juego juego);
    public void onJuegoEditarClick(Juego juego);
    public void onJuegoBorrarClick(Juego mItem);
}
