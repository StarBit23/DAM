package com.example.miproyectofinal.model;

public class Contador {
    private static long id=0;

    public static void incrementarId(){
        id++;
    }

    public static long dameId(){
        return id;
    }
}
