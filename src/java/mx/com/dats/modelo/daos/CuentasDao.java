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
import mx.com.dats.modelo.pojos.Cuenta;
import mx.com.dats.utils.conexion;
import static mx.com.dats.utils.conexion.isCorrecto;

/**
 *
 * @author Erick Omar G Flores
 */
public class CuentasDao extends conexion {

    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement preStmt=null;
    public List<Cuenta> getTodasCuentas() {
        List<Cuenta> resp = new ArrayList<Cuenta>();
        String sql = "SELECT * FROM tbcuentas;";
        if (isCorrecto()) {
            try {
                stmt = conexion.getCon().createStatement();

                rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    
                    Cuenta cntaAux = new Cuenta();
                    cntaAux.setIdcuenta(rs.getInt("idcuenta"));
                    cntaAux.setUsuario(rs.getString("usuario"));
                    cntaAux.setPass(rs.getString("pass"));
                    cntaAux.setTipo(rs.getInt("tipo"));
                    resp.add(cntaAux);
                }
                rs.close();
                stmt.close();
                correcto = true;
                rs= null;
                stmt=null;
            } catch (SQLException e) {
                correcto = false;
                mensaje = "SQLException: " + e.getMessage();
            }
        }
        return resp;
    }
    public Cuenta getCuenta(String user, String pass) {
        Cuenta cntaAux = new Cuenta();
        String sql = "SELECT * FROM tbcuentas WHERE usuario='"+user+"' AND pass= '"+pass+"';";
        if (isCorrecto()) {
            try {
                preStmt = conexion.getCon().prepareStatement(sql);

                System.out.println(sql);
                rs = preStmt.executeQuery();
                while (rs.next()) {

                    cntaAux.setIdcuenta(rs.getInt("idcuenta"));
                    cntaAux.setUsuario(rs.getString("usuario"));
                    cntaAux.setPass(rs.getString("pass"));
                    cntaAux.setTipo(rs.getInt("tipo"));
                }
                rs.close();
                preStmt.close();
                rs= null;
                preStmt=null;
                correcto = true;
                return cntaAux;
            } catch (SQLException e) {
                correcto = false;
                mensaje = "SQLException: " + e.getMessage();
            }
        }
        return null;
    }

}
