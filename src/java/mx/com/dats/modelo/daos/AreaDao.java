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
                    Area aAux = new Area();
                    aAux.setId(rs.getInt("id"));
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
        return resp;
    }

}
