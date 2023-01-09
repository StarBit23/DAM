package com.pmdm.virgen.pueblosconnavigationdraweb.modelos;



public class Pueblo {
    /**
         * Declaramos constantes con los argumentos que se le pasaránpublic static final String ARGUMENTO_ID = "id";
         * del Main al Dialogo Edición del Pueblo.public static final String ARGUMENTO_NOMBRE = "nombre";
   */
    public static final String ARGUMENTO_ID = "id";
    public static final String ARGUMENTO_NOMBRE = "nombre";
    public static final String ARGUMENTO_DESCRIPCION = "descripcion";
    public static final String ARGUMENTO_NUM_HABITANTES = "numHabitantes";
    public static final String ARGUMENTO_URL_FOTO = "urlFoto";

    private long id;
    private String urlFoto;
    private String nombre;
    private String descripcion;
    private int numHabitantes;




    public Pueblo() {

    }

    public Pueblo(long id, String urlFoto, String nombre, String descripcion, int numHabitantes) {
        this.id = id;
        this.urlFoto = urlFoto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.numHabitantes = numHabitantes;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getNumHabitantes() {
        return numHabitantes;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setNumHabitantes(int numHabitantes) {
        this.numHabitantes = numHabitantes;
    }

    @Override
    public String toString() {
        return "Pueblo{" +
                "id=" + id +
                ", urlFoto='" + urlFoto + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", numHabitantes=" + numHabitantes +
                '}';
    }
}
