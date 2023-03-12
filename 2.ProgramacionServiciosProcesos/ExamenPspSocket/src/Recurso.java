import modelo.Coche;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Recurso {
    private int id = 0;
    private int num = 0;
    private List<Coche> lista = new ArrayList<>();

    public void fillList(){
        lista.add(new Coche(1,"mercedes", 2000));
        lista.add(new Coche(2,"alfa",2200));
        lista.add(new Coche(3,"audi",2500));
        lista.add(new Coche(4,"bmw",3000));
        lista.add(new Coche(5,"cupra",1700));
    }

    public synchronized String getLista(){
        StringBuilder sb = new StringBuilder();
        lista.forEach(coche -> {
            sb.append("id: "+coche.getId()+" marca: "+coche.getModelo() + " cilindrada "+ coche.getCilindrada() + "\n");
        });
        return sb.toString();
    }

    public synchronized String getById(int id){
        StringBuilder sb = new StringBuilder();
        lista.forEach(coche -> {
            if (coche.getId() == id){
                sb.append("id: "+coche.getId()+" marca: "+coche.getModelo() + " cilindrada "+ coche.getCilindrada());
            }
        });
        return sb.toString();
    }

    public synchronized String getAllById(){
        StringBuilder sb = new StringBuilder();
        lista.forEach(coche -> {
                sb.append("id: "+coche.getId() + "\n");
        });
        return sb.toString();
    }

    public synchronized void addCoche(String modelo, int cilindrada){
        Coche newCoche = new Coche((lista.size()+1),modelo,cilindrada);
        lista.add(newCoche);
    }

    public synchronized void deleteCoche(int id){
        List<Coche> newLista = new ArrayList<>();
        int i = 0;
        for(Coche c : lista) {
            if (c.getId() == id){
                i = lista.indexOf(c);
            }
        }
        lista.remove(i);
    }

    public synchronized void putCoche(int id, String modelo, int cilindrada){
        Coche newCoche = new Coche(id,modelo,cilindrada);
        List<Coche> newLista = new ArrayList<>();
        for (Coche c : lista){
            if (id == c.getId()){
                newLista.add(newCoche);
            }else {
                newLista.add(c);
            }
        }
        lista = newLista;
    }






    public int getId(){
        id++;
        return id;
    }

    public void addNum(){
        num++;
    }

    public int getNum(){
        return num;
    }




}
