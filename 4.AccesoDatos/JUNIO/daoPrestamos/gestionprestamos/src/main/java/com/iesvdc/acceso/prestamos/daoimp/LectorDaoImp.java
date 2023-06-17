package com.iesvdc.acceso.prestamos.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iesvdc.acceso.prestamos.conexion.Conexion;
import com.iesvdc.acceso.prestamos.dao.LectorDao;
import com.iesvdc.acceso.prestamos.modelo.Direccion;
import com.iesvdc.acceso.prestamos.modelo.Lector;

public class LectorDaoImp implements LectorDao {

    @Override
     public boolean create(Lector lector) {
        Conexion conexion = new Conexion();
        boolean resultado = false;
        String sql = "INSERT INTO `lector` (`nombre`, `apellidos`, `calle`, `codigo_postal`)" +
        " VALUES (?, ?, ?, ?, ?);";
        Connection con = conexion.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, lector.getId());
            ps.setString(2, lector.getNombre());
            ps.setString(3, lector.getApellidos());
            ps.setString(4, lector.getDirecciones().getNombreVia());
            ps.setString(5, lector.getDirecciones().getCp());
            if (ps.executeUpdate() > 0) {
                resultado = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conexion.destroy();
        return resultado;
    }

    public Lector findById(int id) {
        Conexion conexion = new Conexion();
        Lector resultado = null;
        String sql = "SELECT * from `lector` WHERE `id`= ?;";
        Connection con = conexion.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                resultado = new Lector(
                        id,
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getInt("telefono"),
                        (Direccion) rs.getObject("direcciones"),
                        rs.getString("nombre"),
                        rs.getString("apellidos"));
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        conexion.destroy();
        return resultado;
    }

    @Override
    public List<Lector> findAll() {
        Conexion conexion = new Conexion();
        List<Lector> resultado = new ArrayList<Lector>();
        String sql = "SELECT * from `lector`";
        Connection con = conexion.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                resultado.add(new Lector(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getInt("telefono"),
                        (Direccion) rs.getObject("direcciones"),
                        rs.getString("nombre"),
                        rs.getString("apellidos")));
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        conexion.destroy();
        return resultado;
    }

    public Lector findByTitulo(String nombre) {
        Conexion conexion = new Conexion();
        Lector resultado = null;
        String sql = "SELECT * from `lector` WHERE `titulo`= ?;";
        Connection con = conexion.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                resultado = new Lector(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getInt("telefono"),
                        (Direccion) rs.getObject("direcciones"),
                        rs.getString("nombre"),
                        rs.getString("apellidos"));
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        conexion.destroy();
        return resultado;
    }

    @Override
    public boolean update(Lector o, Lector n) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean update(int id, Lector n) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(Lector u) {
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

    @Override
    public int count() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    public Lector findByNombre(String nombre) {
        Conexion conexion = new Conexion();
        Lector resultado = null;
        String sql = "SELECT * from `lector` WHERE `titulo`= ?;";
        Connection con = conexion.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                resultado = new Lector(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getInt("telefono"),
                        (Direccion) rs.getObject("direcciones"),
                        rs.getString("nombre"),
                        rs.getString("apellidos"));
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        conexion.destroy();
        return resultado;
    }

    
}
