/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.dats.modelo.pojos;

/**
 *
 * @author Erick Omar G Flores
 */
public class Cuenta {

    private int idcuenta;
    private String usuario;
    private String pass;
    private int tipo;

    public Cuenta(String usuario, String pass, int tipo) {
        this.usuario = usuario;
        this.pass = pass;
        this.tipo = tipo;
    }

    public Cuenta(int idcuenta, String usuario, String pass, int tipo) {
        this.idcuenta = idcuenta;
        this.usuario = usuario;
        this.pass = pass;
        this.tipo = tipo;
    }

    public Cuenta() {
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getIdcuenta() {
        return idcuenta;
    }

    public void setIdcuenta(int idcuenta) {
        this.idcuenta = idcuenta;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "idcuenta=" + idcuenta + ", usuario=" + usuario + ", pass=" + pass + ", tipo=" + tipo + '}';
    }
    

}
