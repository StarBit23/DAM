package com.pmdm.virgen.pueblosconnavigationdraweb.varios;


public class Contador {
    private static int id=0;

    public static void increId(){
        id++;
    }
    public static int dameId(){
        return id;
    }
}
