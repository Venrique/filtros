/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.sun.istack.internal.logging.Logger;
import conexion.Conexion;
import interfaces.metodos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import modelo.Filtro;
import sun.util.logging.PlatformLogger;

/**
 *
 * @author LN710Q
 */
public class FiltroDao implements metodos<Filtro> {
    
    private static final String SQL_INSERT = "INSERT INTO filtros_aceite (codFiltro,stock,existencia,marca) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE filtros_aceite SET stock=?,existencia=?,marca=? WHERE codFiltro=?";
    private static final String SQL_DELETE = "DELETE FROM filtros_aceite WHERE codFiltro=?";
    private static final String SQL_READ = "SELECT * FROM filtros_aceite WHERE codFiltro=?";
    private static final String SQL_READALL = "SELECT * FROM filtros_aceite";
    private static final Conexion con = Conexion.conectar();
    
    
    @Override
    public boolean create(Filtro g) {
        PreparedStatement ps;
        
        try{
            ps = con.getCnx().prepareStatement(SQL_INSERT);
            ps.setString(1, g.getCodigo());
            ps.setInt(2, g.getStock());
            ps.setBoolean(3, true);
            ps.setInt(4, g.getMarca());
            if(ps.executeUpdate() > 0){
                return true;
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            //Logger.getLogger(FiltroDao.class.getName()).log(Level.SEVERE,null,ex);
        }finally{
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean delete(Object key) {
        PreparedStatement ps;
        try {
            ps = con.getCnx().prepareStatement(SQL_DELETE);
            ps.setString(1, key.toString());
            
            if(ps.executeUpdate()>0){
                return true;
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(Filtro c) {
        PreparedStatement ps;
        try{
            System.out.println(c.getCodigo());
            ps = con.getCnx().prepareStatement(SQL_UPDATE);
            ps.setInt(1, c.getStock());
            ps.setBoolean(2, true);
            ps.setInt(3, c.getMarca());
            ps.setString(4, c.getCodigo());
            if(ps.executeUpdate() > 0){
                return true;
            }
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public Filtro read(Object key) {
        Filtro f = null;
        PreparedStatement ps;
        ResultSet rs;
        
        try{
            ps = con.getCnx().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                f = new Filtro(rs.getString(1),rs.getInt(2),rs.getBoolean(3),rs.getInt(4));
            }
            rs.close();
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            con.cerrarConexion();
        }
        return f;
    }

    @Override
    public ArrayList<Filtro> readAll() {
        ArrayList<Filtro> all = new ArrayList();
        Statement s;
        ResultSet rs;
        try{
            s = con.getCnx().prepareStatement(SQL_READALL);
            rs = s.executeQuery(SQL_READALL);
            while(rs.next()){
                all.add(new Filtro(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getBoolean(4),rs.getInt(5)));
            }
            rs.close();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(FiltroDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return all;
    }
    
}
