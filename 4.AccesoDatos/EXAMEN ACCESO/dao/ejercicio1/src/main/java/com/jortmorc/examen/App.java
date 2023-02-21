package com.jortmorc.examen;

import com.jortmorc.examen.dao.PaloDao;
import com.jortmorc.examen.daoimp.Conexion;
import com.jortmorc.examen.daoimp.PaloDaoImp;
import com.jortmorc.examen.modelo.Palo;

public class App 
{
    public static void main( String[] args )
    {
        Conexion con = new Conexion();
        con.destroy();

        System.out.println( "Comprobamos BARAJAS");
        Palo p = new Palo(0, "jorgito", "jorgito@gmail.com");
        PaloDao paloDao = new PaloDaoImp();
        paloDao.create(p);
        System.out.println("El número de palos es " + paloDao.count());
    }
}
