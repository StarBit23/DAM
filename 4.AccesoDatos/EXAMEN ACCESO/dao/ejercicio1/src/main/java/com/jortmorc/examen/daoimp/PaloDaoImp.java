package com.jortmorc.examen.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jortmorc.examen.dao.PaloDao;
import com.jortmorc.examen.modelo.Palo;

public class PaloDaoImp implements PaloDao{

    @Override
    public boolean create(Palo p){
        Conexion conexion = new Conexion();
        boolean resultado = false;
        String sql = "INSERT INTO `palo` (`nombre`, `email`)"+
            " VALUES (?,?);";
        Connection con = conexion.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getEmail());
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
    public Palo findById(int id) {
        Conexion conexion = new Conexion();
        Palo resultado = null;
        String sql = "SELECT * from `palo` WHERE `id` = ?";
        Connection con = conexion.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                resultado = new Palo(
                    id, 
                    rs.getString("nombre"), 
                    rs.getString("email"));
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        conexion.destroy();
        return resultado;
    }

    @Override
    public Palo findByNombre(String nombre) {
        Conexion conexion = new Conexion();
        Palo resultado = null;
        String sql = "SELECT * from `palo` WHERE `nombre` = ?";
        Connection con = conexion.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                resultado = new Palo(
                    rs.getInt("id"), 
                    rs.getString("nombre"), 
                    rs.getString("email"));
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        conexion.destroy();
        return resultado;
    }

    @Override
    public boolean update(Palo o, Palo n) {
        return update(o.getId(), n);
    }

    @Override
    public boolean update(int id, Palo p) {
        Conexion conexion = new Conexion();
        boolean resultado = false;
        String sql = "UPDATE palo SET `nombre` = ?, `email` = ?"+
            "WHERE `id` = ?";
        Connection con = conexion.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getEmail());
            ps.setInt(3, id);
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
    public boolean delete(Palo u) {
        return delete(u.getId());
    }

    @Override
    public boolean delete(int id) {
        Conexion conexion = new Conexion();
        boolean resultado = false;
        String sql = "DELETE palo WHERE `id` = ?";
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
    public List<Palo> findAll() {
        Conexion conexion = new Conexion();
        List<Palo> resultado = new ArrayList<Palo>();
        String sql = "SELECT * from `palo`";
        Connection con = conexion.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                resultado.add(new Palo(
                    rs.getInt("id"), 
                    rs.getString("nombre"), 
                    rs.getString("email")));
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
        String sql = "SELECT count(*) from `palo`";
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