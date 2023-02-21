package com.jortmorc.examen.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jortmorc.examen.dao.CartaDao;
import com.jortmorc.examen.modelo.Carta;

public class CartaDaoImp implements CartaDao{

    @Override
    public boolean create(Carta c) {
        Conexion conexion = new Conexion();
        boolean resultado = false;
        String sql = "INSERT INTO `carta` (`nombre`, `descripcion`,`palo`)"+
            " VALUES (?,?);";
        Connection con = conexion.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getDescripcion());
            ps.setString(3, c.getPalo());
            if (ps.executeUpdate() > 0){
                resultado = true;
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        conexion.destroy();
        return resultado;
    }

    @Override
    public Carta findById(int id) {
        Conexion conexion = new Conexion();
        Carta resultado = null;
        String sql = "SELECT * from `carta` WHERE `id` = ?";
        Connection con = conexion.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                resultado = new Carta(
                    id, 
                    rs.getString("nombre"), 
                    rs.getString("descripcion"),
                    rs.getString("palo"));
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        conexion.destroy();
        return resultado;
    }

    @Override
    public Carta findByNombre(String nombre) {
        Conexion conexion = new Conexion();
        Carta resultado = null;
        String sql = "SELECT * from `carta` WHERE `nombre` = ?";
        Connection con = conexion.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                resultado = new Carta(
                    rs.getInt("id"), 
                    rs.getString("nombre"), 
                    rs.getString("descripcion"),
                    rs.getString("palo"));
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        conexion.destroy();
        return resultado;
    }

    @Override
    public boolean update(Carta o, Carta n) {
        return update(o.getId(), n);
    }

    @Override
    public boolean update(int id, Carta c) {
        Conexion conexion = new Conexion();
        boolean resultado = false;
        String sql = "UPDATE carta SET `nombre` = ?, `descripcion` = ?, `palo` = ? "+
            "WHERE `id` = ?";
        Connection con = conexion.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getDescripcion());
            ps.setString(3, c.getPalo());
            ps.setInt(4, id);
            if (ps.executeUpdate() > 0){
                resultado = true;
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        conexion.destroy();
        return resultado;
    }

    @Override
    public boolean delete(Carta u) {
        return delete(u.getId());
    }

    @Override
    public boolean delete(int id) {
        Conexion conexion = new Conexion();
        boolean resultado = false;
        String sql = "DELETE carta WHERE `id` = ?";
        Connection con = conexion.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0){
                resultado = true;
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        conexion.destroy();
        return resultado;
    }

    @Override
    public List<Carta> findAll() {
        Conexion conexion = new Conexion();
        List<Carta> resultado = new ArrayList<Carta>();
        String sql = "SELECT * from `carta`";
        Connection con = conexion.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                resultado.add(new Carta(
                    rs.getInt("id"), 
                    rs.getString("nombre"), 
                    rs.getString("descripcion"),
                    rs.getString("palo")));
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        conexion.destroy();
        return resultado;
    }

    @Override
    public int count() {
        Conexion conexion = new Conexion();
        int resultado = -1;
        String sql = "SELECT count(*) from `carta`";
        Connection con = conexion.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                resultado = rs.getInt(1);
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        conexion.destroy();
        return resultado;
    }
    
}
