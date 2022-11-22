/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorge.conexion;

import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
// import java.sql.DriverManager;
// import java.sql.SQLException;
// import java.util.logging.Level;
// import java.util.logging.Logger;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author juangu
 */
public class Conexion {

    Connection conn;
    Context ctx;
    DataSource ds;

    public Conexion() {
        // Via JDBC
        if(conn==null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                this.conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:33306/incidencias?"+
                    "useUnicode=yes&useJDBCCompliantTimezoneShift=true&"+
                    "user=root&password=example"
                    );
            } catch (SQLException | ClassNotFoundException e) {
                Logger.getLogger(e.getLocalizedMessage());
            }
        }

        // Vía DataSource con Contexto inyectado
        // try {
        //     if (ctx == null)
        //         ctx = new InitialContext();
        //     if (ds == null)
        //         ds = (DataSource) ((Context) ctx.lookup("java:comp/env")).lookup("jdbc/incidencia");
        //     conn = ds.getConnection();
        // } catch (Exception ex) {
        //     System.out.println("## Conexion ERROR ## " + ex.getLocalizedMessage());
        //     ctx = null;
        //     ds = null;
        //     conn = null;
        // }
    }

    public Connection getConnection() {
        return conn;
    }

    public void destroy() {
        if (this.conn != null) {
            try {
                this.conn.close();
            } catch (SQLException e) {
                
            }
        }
    }
}
