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
    private String curp;
    private String nombre;
    private int valida;
    private int cargo;
    private String usuario;
    private String pass;
    private int tipo;

    public Cuenta(int idcuenta, String curp, String nombre, int valida, int cargo, String usuario, String pass, int tipo) {
        this.idcuenta = idcuenta;
        this.curp = curp;
        this.nombre = nombre;
        this.valida = valida;
        this.cargo = cargo;
        this.usuario = usuario;
        this.pass = pass;
        this.tipo = tipo;
    }

    public Cuenta(String curp, String nombre, int valida, int cargo, String usuario, String pass, int tipo) {
        this.curp = curp;
        this.nombre = nombre;
        this.valida = valida;
        this.cargo = cargo;
        this.usuario = usuario;
        this.pass = pass;
        this.tipo = tipo;
    }

    public Cuenta() {
        this.curp = "";
        this.nombre = "";
        this.valida = 0;
        this.cargo =0;
        this.usuario ="";
        this.pass = "";
        this.tipo = 0;
    }

    public int getIdcuenta() {
        return idcuenta;
    }

    public void setIdcuenta(int idcuenta) {
        this.idcuenta = idcuenta;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValida() {
        return valida;
    }

    public void setValida(int valida) {
        this.valida = valida;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
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

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    public String getNameTipo() {
        String tipUser;
        switch (this.tipo) {
            case 1:
                tipUser = "Administrador";
                break;
            case 2:
                tipUser = "Validador vinculación";
                break;
            case 3:
                tipUser = "Validador de área";
                break;
            case 4:
                tipUser = "Editor de medios";
                break;
            case 5:
                tipUser = "Autor";
                break;
            default:
                tipUser = "Invitado";
        }
        return tipUser;
    }
    public String getNameCargo() {
        String tipUser;
        switch (this.cargo) {
            case 1:
                tipUser = "Director";
                break;
            case 2:
                tipUser = "Jefe de Área";
                break;
            case 3:
                tipUser = "Docente";
                break;
            case 4:
                tipUser = "Administrativo";
                break;
            default:
                tipUser = "Sin Cargo";
        }
        return tipUser;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "idcuenta=" + idcuenta + ", usuario=" + usuario + ", pass=" + pass + ", tipo=" + tipo + '}';
    }
    

}
