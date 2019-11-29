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
import mx.com.dats.modelo.pojos.Area;
import mx.com.dats.utils.conexion;
import mx.com.dats.utils.conexion;

/**
 *
 * @author GUFE
 */
public class AreaDao extends conexion {

    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement preStmt = null;

    /**
     *
     * @return
     */
    public List<Area> getTodaArea() {
        List<Area> resp = new ArrayList<Area>();
        String sql = "SELECT * FROM tbareas;";
        if (isCorrecto()) {
            
            try {
                stmt = this.getCon().createStatement();

                rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    System.out.println("Entre While: "+sql);
                    Area aAux = new Area();
                    aAux.setId(rs.getInt("idarea"));
                    aAux.setNombre(rs.getString("nombre"));
                    aAux.setNombreCorto(rs.getString("nombre_corto"));
                    aAux.setSuperior(rs.getInt("superior"));
                    resp.add(aAux);
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
        System.out.println("daoAreas: " + resp.size());
        return resp;
    }
    
        /**
     *
     * @param idArea
     * @return
     */
    public Area getArea(int idArea) {
        Area areaAux = new Area();
        String sql = "SELECT * FROM tbareas WHERE idarea="+idArea+";";
        System.out.println(sql);
        if (isCorrecto()) {
            try {
                preStmt = this.getCon().prepareStatement(sql);

                System.out.println(sql);
                rs = preStmt.executeQuery();
                System.out.println("regs: correcto");
                while (rs.next()) {
                    System.out.println("Entro a while");
                    areaAux.setId(rs.getInt("idarea"));
                    areaAux.setNombre(rs.getString("nombre"));
                    areaAux.setNombreCorto(rs.getString("nombre_corto"));
                    areaAux.setSuperior(rs.getInt("superior"));
                
                }
                rs.close();
                preStmt.close();
                rs= null;
                preStmt=null;
                correcto = true;
                return areaAux;
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
     * @param area
     * @return
     */
    public boolean addArea(Area area){
        boolean resp=false;
        String sql = "INSERT INTO tbareas(nombre,nombre_corto,superior) VALUES("
                +"'"+area.getNombre()+"',"
                +"'"+area.getNombreCorto()+"',"
                +""+area.getSuperior()+");";
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
    public boolean updArea(Area area){
        boolean resp=false;
        String sql = "UPDATE tbareas SET "
                +"nombre='"+area.getNombre()+"',"
                +"nombre_corto='"+area.getNombreCorto()+"',"
                +"superior="+area.getSuperior()+""
                +" WHERE idarea="+area.getId()+";";
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
     * @param idarea
     * @return
     */
    public boolean delArea(int idarea){
        boolean resp=false;
        String sql = "DELETE FROM tbareas  WHERE idarea="+idarea+";";
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
