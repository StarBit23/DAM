package com.example.miproyectofinal.listener;

public interface OnJuegoDialogInteractionListener
{
    public void insertarJuego(String nombre, String descripcion, String ventas);

    public void editarJuego(long id, String nombre, String descripcion, String ventas);

    public void borrarJuego(long id);
}
