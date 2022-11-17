package com.jorge.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jorge.conexion.Conexion;
import com.jorge.dao.UsuarioDAO;
import com.jorge.modelo.TipoUsuario;
import com.jorge.modelo.Usuario;

public class UsuarioDAOimp implements UsuarioDAO{

    @Override
    /**
     * @param Usuario u: el usuario a dar de alta en la base de datos
     * @return verdadero si éxito
     */
    public boolean create(Usuario u) {
        boolean resultado = true;
        try {
            Conexion con = new Conexion();
            Connection conn = con.getConnection();
            String sql = 
                "INSERT INTO usuario(id, username, password, tipo, email)"+ 
                "VALUES (NULL, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(0, u.getUsername());
            ps.setString(1, u.getPassword());
            ps.setString(3, u.getTipoUsuario().toString());
            ps.setString(0, u.getEmail());
            conn.close();
        } catch (Exception e) {
            
        }
        return resultado;
    }

    @Override
    /**
     * @param int id: el id del usuario a buscar
     * @return usuario si encontrado
     */
    public Usuario findById(int id) {
        Usuario u = null;
        try {
            Conexion con = new Conexion();
            Connection conn = con.getConnection();
            String sql = 
                "SELECT * FROM usuario WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                u = new Usuario(
                    rs.getString("username"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getInt("id"),
                    TipoUsuario.valueOf(rs.getString("tipo")));
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("::UsuarioDaoImp::CREATE::Error=" + e.getLocalizedMessage());
        }
        return u;
    }

    @Override
    public Usuario findByUsername(String username) {
        Usuario u=null;
        try {
            Conexion con = new Conexion();
            Connection conn = con.getConnection();
            String sql = "SELECT * FROM usuario WHERE username=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                u = new Usuario(
                    rs.getString("username"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getInt("id"),
                    TipoUsuario.valueOf(rs.getString("tipo")));
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("::UsuarioDaoImp::CREATE::Error=" + e.getLocalizedMessage());
        }
        return u;
    }

    @Override
    public Usuario findByUsernameAndPassword(String username, String password) {
        Usuario u=null;
        try {
            Conexion con = new Conexion();
            Connection conn = con.getConnection();
            String sql = "SELECT * FROM usuario WHERE username=? AND password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                u = new Usuario(
                    rs.getString("username"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getInt("id"),
                    TipoUsuario.valueOf(rs.getString("tipo")));
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("::UsuarioDaoImp::CREATE::Error=" + e.getLocalizedMessage());
        }
        return u;
    }

    @Override
    public boolean update(int id, Usuario n) {
        boolean resultado = true;
        try {
            Conexion con = new Conexion();
            Connection conn = con.getConnection();
            String sql = 
                "UPDATE usuario SET id=?, username=?, password=?, tipo=?, email=?"+ 
                "WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(0, n.getUsername());
            ps.setString(1, n.getPassword());
            ps.setString(3, n.getTipoUsuario().toString());
            ps.setString(0, n.getEmail());
            
            if (ps.executeUpdate() == 0) {
                return false;
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("::UsuarioDaoImp::CREATE::Error=" + e.getLocalizedMessage());
            return false;
        }
        return resultado;
    }

    @Override
    public boolean update(Usuario o, Usuario n) {
        return update(o, n);
    }


    @Override
    public boolean delete(Usuario u) {
        return delete(u);
    }

    @Override
    public boolean delete(int id) {
        boolean resultado = true;
        try {
            Conexion con = new Conexion();
            Connection conn = con.getConnection();
            String sql = "DELETE FROM usuario WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            if(ps.executeUpdate()==0){
                resultado=false;
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("::UsuarioDaoImp::CREATE::Error=" + e.getLocalizedMessage());
            resultado=false;
        }
        return resultado;
    }
    
}
