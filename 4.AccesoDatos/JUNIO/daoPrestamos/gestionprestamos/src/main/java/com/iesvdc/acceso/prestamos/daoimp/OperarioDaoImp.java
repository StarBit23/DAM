package com.iesvdc.acceso.prestamos.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iesvdc.acceso.prestamos.conexion.Conexion;
import com.iesvdc.acceso.prestamos.dao.OperarioDao;
import com.iesvdc.acceso.prestamos.modelo.Operario;

public class OperarioDaoImp implements OperarioDao {

    @Override
    public boolean create(Operario operario) {
        Conexion conexion = new Conexion();
        boolean resultado = false;
        String sql = "INSERT INTO `operario` (`id`, `username`, `password`, `email`)" +
        " VALUES (?, ?, ?, ?, ?);";
        Connection con = conexion.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, operario.getId());
            ps.setString(2, operario.getUsername());
            ps.setString(3, operario.getPassword());
            ps.setString(4, operario.getEmail());
            if (ps.executeUpdate() > 0) {
                resultado = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conexion.destroy();
        return resultado;
    }

    @Override
    public Operario findById(int id) {
        Conexion conexion = new Conexion();
        Operario resultado = null;
        String sql = "SELECT * from `operario` WHERE `id`= ?;";
        Connection con = conexion.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                resultado = new Operario(
                        id,
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"));
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        conexion.destroy();
        return resultado;
    }

    @Override
    public Operario findByUsername(String nombre) {
        Conexion conexion = new Conexion();
        Operario resultado = null;
        String sql = "SELECT * from `operario` WHERE `username`= ?;";
        Connection con = conexion.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                resultado = new Operario(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"));
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        conexion.destroy();
        return resultado;
    }

    @Override
    public Operario findByUsernameAndPassword(String username, String password) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByUsernameAndPassword'");
    }

    @Override
    public boolean update(Operario o, Operario n) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean update(int id, Operario n) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(Operario u) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public boolean delete(int id) {
        Conexion conexion = new Conexion();
        boolean resultado = false;
        String sql = "DELETE FROM `operario` WHERE `id`= ?;";
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
    public List<Operario> findAll() {
        Conexion conexion = new Conexion();
        List<Operario> resultado = new ArrayList<Operario>();
        String sql = "SELECT * from `lector`";
        Connection con = conexion.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                resultado.add(new Operario(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email")));
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

    
}
