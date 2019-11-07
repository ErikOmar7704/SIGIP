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
import mx.com.dats.utils.conexion;

/**
 *
 * @author 
 */
public class CuentasDao extends conexion {

    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement preStmt=null;

    /**
     *
     * @return
     */
    public List<Cuenta> getTodasCuentas() {
        List<Cuenta> resp = new ArrayList<Cuenta>();
        String sql = "SELECT * FROM tbcuentas;";
        if (isCorrecto()) {
            try {
                stmt = this.getCon().createStatement();

                rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    Cuenta cntaAux = new Cuenta();
                    cntaAux.setIdcuenta(rs.getInt("idcuenta"));
                    cntaAux.setCurp(rs.getString("curp"));
                    cntaAux.setNombre(rs.getString("nombre"));
                    cntaAux.setValida(rs.getInt("valida"));
                    cntaAux.setCargo(rs.getInt("cargo"));                    
                    cntaAux.setUsuario(rs.getString("usuario"));
                    cntaAux.setPass(rs.getString("pass"));
                    cntaAux.setTipo(rs.getInt("tipo"));
                    cntaAux.setIdArea(rs.getInt("idarea"));
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

    /**
     *
     * @param user
     * @param pass
     * @return
     */
    public Cuenta getCuenta(String user, String pass) {
        Cuenta cntaAux = new Cuenta();
        String sql = "SELECT * FROM tbcuentas WHERE usuario='"+user+"' AND pass= '"+pass+"';";
        if (isCorrecto()) {
            try {
                preStmt = this.getCon().prepareStatement(sql);

                System.out.println(sql);
                rs = preStmt.executeQuery();
                while (rs.next()) {
                    cntaAux.setIdcuenta(rs.getInt("idcuenta"));
                    cntaAux.setCurp(rs.getString("curp"));
                    cntaAux.setNombre(rs.getString("nombre"));
                    cntaAux.setValida(rs.getInt("valida"));
                    cntaAux.setCargo(rs.getInt("cargo"));                    
                    cntaAux.setUsuario(rs.getString("usuario"));
                    cntaAux.setPass(rs.getString("pass"));
                    cntaAux.setTipo(rs.getInt("tipo"));
                    cntaAux.setIdArea(rs.getInt("idarea"));
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

    /**
     *
     * @param idCuenta
     * @return
     */
    public Cuenta getCuenta(int idCuenta) {
        Cuenta cntaAux = new Cuenta();
        String sql = "SELECT * FROM tbcuentas WHERE idcuenta="+idCuenta+";";
        System.out.println(sql);
        if (isCorrecto()) {
            try {
                preStmt = this.getCon().prepareStatement(sql);

                System.out.println(sql);
                rs = preStmt.executeQuery();
                System.out.println("regs: correcto");
                while (rs.next()) {
                    System.out.println("Entro a while");
                    cntaAux.setIdcuenta(rs.getInt("idcuenta"));
                    cntaAux.setCurp(rs.getString("curp"));
                    cntaAux.setNombre(rs.getString("nombre"));
                    cntaAux.setValida(rs.getInt("valida"));
                    cntaAux.setCargo(rs.getInt("cargo"));                    
                    cntaAux.setUsuario(rs.getString("usuario"));
                    cntaAux.setPass(rs.getString("pass"));
                    cntaAux.setTipo(rs.getInt("tipo"));
                    cntaAux.setIdArea(rs.getInt("idarea"));
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
                System.err.println(mensaje);
            }
        }
        return null;
    }

    /**
     *
     * @param cuenta
     * @return
     */
    public boolean addCuenta(Cuenta cuenta){
        boolean resp=false;
        String sql = "INSERT INTO tbcuentas(curp,nombre,valida,cargo,usuario,pass,tipo,idarea) VALUES("
                +"'"+cuenta.getCurp()+"',"
                +"'"+cuenta.getNombre()+"',"
                +""+cuenta.getValida()+","
                +""+cuenta.getCargo()+","
                +"'"+cuenta.getUsuario()+"',"
                +"'"+cuenta.getPass()+"',"
                +""+cuenta.getTipo()+","
                +""+cuenta.getIdArea()+");";
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
    public boolean updCuenta(Cuenta cuenta){
        boolean resp=false;
        String sql = "UPDATE tbcuentas SET "
                +"curp='"+cuenta.getCurp()+"',"
                +"nombre='"+cuenta.getNombre()+"',"
                +"valida="+cuenta.getValida()+","
                +"cargo="+cuenta.getCargo()+","
                +"usuario='"+cuenta.getUsuario()+"',"
                +"pass='"+cuenta.getPass()+"',"
                +"tipo="+cuenta.getTipo()+","
                +"idarea="+cuenta.getIdArea()+
                " WHERE idcuenta="+cuenta.getIdcuenta()+";";
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
     * @param idcuenta
     * @return
     */
    public boolean delCuenta(int idcuenta){
        boolean resp=false;
        String sql = "DELETE FROM tbcuentas  WHERE idcuenta="+idcuenta+";";
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
