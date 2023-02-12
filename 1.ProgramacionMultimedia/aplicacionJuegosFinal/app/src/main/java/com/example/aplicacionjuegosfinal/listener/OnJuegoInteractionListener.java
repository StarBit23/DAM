package com.example.aplicacionjuegosfinal.listener;


import com.example.aplicacionjuegosfinal.modelos.Juego;

/**
 * Esta interfaz, se encargará de gestionar los
 * eventos click sobre un pueblo y el botón de editar y borrar.
 */
public interface OnJuegoInteractionListener {

    public void onJuegoClick(Juego juego);
    public void onJuegoEditarClick(Juego juego);
    public void onJuegoBorrarClick(Juego juego);

    void editarJuego(long id, String nombre, String descripcion, String nVentas);
}
