package com.iesvdc.acceso.prestamos.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iesvdc.acceso.prestamos.conexion.Conexion;
import com.iesvdc.acceso.prestamos.dao.LibroDao;
import com.iesvdc.acceso.prestamos.dao.PrestamoDao;
import com.iesvdc.acceso.prestamos.modelo.Lector;
import com.iesvdc.acceso.prestamos.modelo.Libro;
import com.iesvdc.acceso.prestamos.modelo.Operario;
import com.iesvdc.acceso.prestamos.modelo.Prestamo;

public class PrestamoDaoImp implements PrestamoDao {

    @Override
     public boolean create(Prestamo prestamo) {
        Conexion conexion = new Conexion();
        boolean resultado = false;
        String sql = "INSERT INTO prestamo (lector_id, libro_id, operario_id) VALUES (?, ?, ?)";
        Connection con = conexion.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, prestamo.getLector().getId());
            ps.setInt(2, prestamo.getLibro().getId());
            ps.setInt(3, prestamo.getOperario().getId());
            if (ps.executeUpdate() > 0) {
                resultado = true;
            }
        } catch (SQLException e) {
            conexion.destroy();
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public Prestamo findById(int id) {
        Conexion conexion = new Conexion();
        Prestamo resultado = null;
        String sql = "SELECT * from `prestamo` WHERE `id`= ?;";
        Connection con = conexion.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Lector lector = new LectorDaoImp().findById(rs.getInt("lector_id"));
                Libro libro = new LibroDaoImp().findById(rs.getInt("libro_id"));
                Operario operario = new OperarioDaoImp().findById(rs.getInt("operario_id"));
                resultado = new Prestamo(id, lector, libro, operario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conexion.destroy();
        return resultado;
    }

    @Override
    public Prestamo findByNombre(String nombre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByNombre'");
    }

    @Override
    public Prestamo findByLibro(Libro l) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByEstancia'");
    }

    @Override
    public Prestamo findByOperario(Operario o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByOperario'");
    }

    @Override
    public Prestamo findByLector(Lector u) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByLector'");
    }

    @Override
    public boolean update(Prestamo o, Prestamo n) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean update(int id, Prestamo n) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(Prestamo i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<Prestamo> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public int count() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    
}
