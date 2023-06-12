package com.iesvdc.acceso.prestamos.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iesvdc.acceso.prestamos.conexion.Conexion;
import com.iesvdc.acceso.prestamos.dao.LibroDao;
import com.iesvdc.acceso.prestamos.modelo.Libro;

public class LibroDaoImp implements LibroDao {

    public boolean create(Libro e) {
        Conexion conexion = new Conexion();
        boolean resultado = false;
        String sql = "INSERT INTO `libro` (`titulo`, `autor`)" +
                " VALUES (?, ?);";
        Connection con = conexion.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, e.getTitulo());
            ps.setString(2, e.getAutor());
            // ps.executeUpdate() devuelve un número entero que representa
            // el número de filas afectadas (con cambios).
            if (ps.executeUpdate() > 0) {
                resultado = true;
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        conexion.destroy();
        return resultado;
    }

    public Libro findById(int id) {
        Conexion conexion = new Conexion();
        Libro resultado = null;
        String sql = "SELECT * from `libro` WHERE `id`= ?;";
        Connection con = conexion.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                resultado = new Libro(
                        id,
                        rs.getString("isbn"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getInt("edicion"),
                        rs.getString("editorial"),
                        rs.getInt("año"));
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        conexion.destroy();
        return resultado;
    }

    public Libro findByTitulo(String nombre) {
        Conexion conexion = new Conexion();
        Libro resultado = null;
        String sql = "SELECT * from `libro` WHERE `titulo`= ?;";
        Connection con = conexion.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                resultado = new Libro(
                        rs.getInt("id"),
                        rs.getString("isbn"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getInt("edicion"),
                        rs.getString("editorial"),
                        rs.getInt("año"));
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        conexion.destroy();
        return resultado;
    }

    public boolean update(Libro o, Libro n) {
        return update(o.getId(), n);
    }

    public boolean update(int id, Libro e) {
        Conexion conexion = new Conexion();
        boolean resultado = false;
        String sql = "UPDATE `libro` SET `nombre`= ? , `descripcion`= ?" +
                " WHERE `id`= ?;";
        Connection con = conexion.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, e.getTitulo());
            ps.setString(2, e.getAutor());
            ps.setInt(3, id);
            if (ps.executeUpdate() > 0) {
                resultado = true;
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        conexion.destroy();
        return resultado;
    }

    public boolean delete(Libro u) {
        return delete(u.getId());
    }

    public boolean delete(int id) {
        Conexion conexion = new Conexion();
        boolean resultado = false;
        String sql = "DELETE FROM `libro` WHERE `id`= ?;";
        Connection con = conexion.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                resultado = true;
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        conexion.destroy();
        return resultado;
    }

    public List<Libro> findAll() {
        Conexion conexion = new Conexion();
        List<Libro> resultado = new ArrayList<Libro>();
        String sql = "SELECT * from `libro`";
        Connection con = conexion.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                resultado.add(new Libro(
                        rs.getInt("id"),
                        rs.getString("isbn"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getInt("edicion"),
                        rs.getString("editorial"),
                        rs.getInt("año")));
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        conexion.destroy();
        return resultado;
    }

    public int count() {
        Conexion conexion = new Conexion();
        int resultado = -1;
        String sql = "SELECT count(*) from `libro`";
        Connection con = conexion.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                resultado = rs.getInt(1);
                // resultado = rs.getInt("count(*)")
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        conexion.destroy();
        return resultado;
    }
}
