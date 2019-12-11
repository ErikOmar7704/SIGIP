/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.dats.modelo.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mx.com.dats.utils.conexion;
import mx.com.dats.modelo.pojos.MedioPublicacion;

/**
 *
 * @author lenovo
 */
public class MedioPublicacionDao extends conexion {
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement preStmt = null;

    /**
     *
     * @return
     */
    public List<MedioPublicacion> getTodoMedio() {
        List<MedioPublicacion> resp = new ArrayList<MedioPublicacion>();
        String sql = "SELECT * FROM tbmedios;";
        if (isCorrecto()) {
            
            try {
                stmt = this.getCon().createStatement();

                rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    MedioPublicacion mAux = new MedioPublicacion();
                    mAux.setIdMedio(rs.getInt("idmedio"));
                    mAux.setNombre(rs.getString("nombre"));
                    mAux.setCuenta(rs.getString("cuenta"));
                    mAux.setPassword(rs.getString("password"));
                    mAux.setDireccion(rs.getString("direccion"));
                    mAux.setIdcuenta(rs.getInt("idcuenta"));
                    resp.add(mAux);
                }
                rs.close();
                stmt.close();
                correcto = true;
                rs = null;
                stmt = null;
            } catch (SQLException e) {
                correcto = false;
                mensaje = "SQLException: " + e.getMessage();
            }
        }
        System.out.println("daoMedios: " + resp.size());
        return resp;
    }
    
        /**
     *
     * @param idMedio
     * @return
     */
    public MedioPublicacion getMedio(int idMedio) {
        MedioPublicacion mAux = new MedioPublicacion();
        String sql = "SELECT * FROM tbmedios WHERE idMedio="+idMedio+";";
        System.out.println(sql);
        if (isCorrecto()) {
            try {
                preStmt = this.getCon().prepareStatement(sql);

                System.out.println(sql);
                rs = preStmt.executeQuery();
                System.out.println("regs: correcto");
                while (rs.next()) {
                    
                    mAux.setIdMedio(rs.getInt("idmedio"));
                    mAux.setNombre(rs.getString("nombre"));
                    mAux.setCuenta(rs.getString("cuenta"));
                    mAux.setPassword(rs.getString("password"));
                    mAux.setDireccion(rs.getString("direccion"));
                    mAux.setIdcuenta(rs.getInt("idcuenta"));
                
                }
                rs.close();
                preStmt.close();
                rs= null;
                preStmt=null;
                correcto = true;
                return mAux;
            } catch (SQLException e) {
                correcto = false;
                mensaje = "SQLException: " + e.getMessage();
                System.err.println(mensaje);
            }
        }
        return null;
    }

    /**
     *
     * @param Medio
     * @return
     */
    public boolean addMedio(MedioPublicacion medio){
        boolean resp=false;
        String sql = "INSERT INTO tbmedios(nombre,cuenta,password,direccion,idcuenta) VALUES("
                +"'"+medio.getNombre()+"',"
                +"'"+medio.getCuenta()+"',"
                +"'"+medio.getPassword()+"',"
                +"'"+medio.getDireccion()+"',"
                +""+medio.getIdcuenta()+");";
        if (isCorrecto()) {
            try {
                stmt = this.getCon().createStatement();
                resp=stmt.execute(sql);
                stmt.close();
                stmt=null;
                correcto = true;
            } catch (SQLException e) {
                correcto = false;
                mensaje = "SQLException: " + e.getMessage();
            }
        }
        return resp;
    }

    /**
     *
     * @param cuenta
     * @return
     */
    public boolean updMedio(MedioPublicacion medio){
        boolean resp=false;
        String sql = "UPDATE tbmedios SET "
                +"nombre='"+medio.getNombre()+"',"
                +"cuenta='"+medio.getCuenta()+"',"
                +"password='"+medio.getPassword()+"',"
                +"direccion='"+medio.getDireccion()+"',"
                +"idcuenta="+medio.getIdcuenta()+" "
                +" WHERE idmedio="+medio.getIdMedio()+";";
        if (isCorrecto()) {
            try {
                stmt = this.getCon().createStatement();
                resp=stmt.execute(sql);
                stmt.close();
                stmt=null;
                correcto = true;
            } catch (SQLException e) {
                correcto = false;
                mensaje = "SQLException: " + e.getMessage();
            }
        }
        return resp;
    }

    /**
     *
     * @param idMedio
     * @return
     */
    public boolean delMedio(int idMedio){
        boolean resp=false;
        String sql = "DELETE FROM tbmedios  WHERE idmedio="+idMedio+";";
        if (isCorrecto()) {
            try {
                stmt = this.getCon().createStatement();
                resp=stmt.execute(sql);
                stmt.close();
                stmt=null;
                correcto = true;
            } catch (SQLException e) {
                correcto = false;
                mensaje = "SQLException: " + e.getMessage();
            }
        }
        return resp;
    }
    
}
