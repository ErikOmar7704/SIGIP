/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.dats.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 
 */
public class conexion {

    private  Connection con = null;

    /**
     *
     */
    protected  boolean correcto = true;

    /**
     *
     */
    protected  String mensaje = "";

    /**
     *
     */
    public conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bditsvc?serverTimezone=UTC&useSSL=false","root","root");
            correcto = true;
        } catch (SQLException ex) {
            // handle any errors
            correcto = false;
            mensaje = "SQLException: " + ex.getMessage() + "; SQLState: " + ex.getSQLState()
                    + "; VendorError: " + ex.getErrorCode();
        }catch(ClassNotFoundException ce){
            correcto = false;
            mensaje = "ClassNotFoundException: " + ce.getMessage();
        }
    }

    /**
     *
     * @return
     */
    public  Connection getCon() {
        return con;
    }

    /**
     *
     * @return
     */
    public  boolean isCorrecto() {
        return correcto;
    }

    /**
     *
     * @return
     */
    public  String getMensaje() {
        return mensaje;
    }

    /**
     *
     * @param mensaje
     */
    public void setMensaje(String mensaje) {
        mensaje = mensaje;
    }

//    public static ResultSet sqlConsulta(String sql) {
//        Statement stmt = null;
//        ResultSet rs = null;
//        if (isCorrecto()) {
//           
//            try {
//                stmt = conexion.getCon().createStatement();
//                
//                    rs = stmt.executeQuery(sql);
//                    correcto=true;
//                
//            } catch (SQLException e) {
//                correcto = false;
//                mensaje = "SQLException: " + e.getMessage() +
//                        "SQLState: " + e.getSQLState() +
//                        "VendorError: " + e.getErrorCode();
//            } finally {
//                if (rs != null) {
//                    try {
//                        rs.close();
//                    } catch (SQLException sqlEx) {
//                        correcto=false;
//                        mensaje="SQLException: " + sqlEx.getMessage();
//                    } // ignore
//                    rs = null;
//                }
//                if (stmt != null) {
//                    try {
//                        stmt.close();
//                    } catch (SQLException sqlEx) {
//                        correcto=false;
//                        mensaje="SQLException: " + sqlEx.getMessage();
//                    } // ignore
//                    stmt = null;
//                }
//            }
//        }
//        System.out.println("Mensaje: "+getMensaje());
//        return rs;
//    }

}
