/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jortmorc.examen.daoimp;

import java.lang.System.Logger.Level;
import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.SQLException;
// import java.util.logging.Level;
// import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Conexion {

    Connection conn;
    Context ctx;
    DataSource ds;


    public Conexion(){
         
            // Vía DriverManager
            // if (conn==null)
            // try {
            //     Class.forName("com.mysql.jdbc.Driver");
            //     conn = DriverManager.getConnection(
            //         "jdbc:mysql://localhost:33306/barajas1?" + 
            //         "useUnicode=true&useJDBCCompliantTimezoneShift=true&"+
            //         "serverTimezone=UTC&user=root&password=ffgxIkVKzZOH7hUbR0cMv/uLdvWKEw7WB+f0q4AAiLbTa/6nrSUPx0craorCp9Rh");
            // } catch (SQLException | ClassNotFoundException ex) {
            //     System.out.println("Error al crear la conexion");
            //     // Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);     
            // } 
        

        // Vía DataSource con Contexto inyectado
        try {
            if (ctx==null) ctx = new InitialContext();
            if (ds==null) ds = (DataSource) ((Context)ctx.lookup("java:comp/env")).lookup("jdbc/barajas1");
            conn = ds.getConnection();
        } catch (Exception ex) {
        	System.out.println("## Conexion ERROR ## "+ex.getLocalizedMessage());
            ctx=null;
            ds=null;
            conn=null;
        }
    }
    public Connection getConnection() {
        return conn;
    }

    public void destroy() {
        if (this.conn != null) {
            try {
                this.conn.close();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
