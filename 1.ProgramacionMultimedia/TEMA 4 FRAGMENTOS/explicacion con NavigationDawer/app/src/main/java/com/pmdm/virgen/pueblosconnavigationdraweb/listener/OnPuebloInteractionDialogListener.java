package com.pmdm.virgen.pueblosconnavigationdraweb.listener;

public interface OnPuebloInteractionDialogListener {
    //Inserta un nuevo pueblo


    public void insertarPueblo(String nombre, String descripcion, int nHabitantes );
    //Edita un pueblo ya existente.

    public void editarPueblo(long id, String nombre, String descripcion, int nHabitantes);

    public void eliminarPueblo(long id);

}
