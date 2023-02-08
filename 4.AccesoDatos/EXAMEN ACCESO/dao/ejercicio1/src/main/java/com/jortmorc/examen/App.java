package com.jortmorc.examen;

import com.jortmorc.examen.dao.EstanciaDao;
import com.jortmorc.examen.daoimp.Conexion;
import com.jortmorc.examen.daoimp.EstanciaDaoImp;
import com.jortmorc.examen.modelo.Estancia;

public class App 
{
    public static void main( String[] args )
    {
        Conexion con = new Conexion();
        con.destroy();

        System.out.println( "Comprobamos ESTANCIAS");
        Estancia e = new Estancia(0,"aula 1.1","Aula de alumnos enanos");
        EstanciaDao estanciaDao = new EstanciaDaoImp();
        estanciaDao.create(e);
        System.out.println("El número de estancias es: " + estanciaDao.count());
    }
}
