/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.dats.modelo.pojos;

/**
 *
 * @author 
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

    /**
     *
     * @param idcuenta
     * @param curp
     * @param nombre
     * @param valida
     * @param cargo
     * @param usuario
     * @param pass
     * @param tipo
     */
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

    /**
     *
     * @param curp
     * @param nombre
     * @param valida
     * @param cargo
     * @param usuario
     * @param pass
     * @param tipo
     */
    public Cuenta(String curp, String nombre, int valida, int cargo, String usuario, String pass, int tipo) {
        this.curp = curp;
        this.nombre = nombre;
        this.valida = valida;
        this.cargo = cargo;
        this.usuario = usuario;
        this.pass = pass;
        this.tipo = tipo;
    }

    /**
     *
     */
    public Cuenta() {
        this.curp = "";
        this.nombre = "";
        this.valida = 0;
        this.cargo =0;
        this.usuario ="";
        this.pass = "";
        this.tipo = 0;
    }

    /**
     *
     * @return
     */
    public int getIdcuenta() {
        return idcuenta;
    }

    /**
     *
     * @param idcuenta
     */
    public void setIdcuenta(int idcuenta) {
        this.idcuenta = idcuenta;
    }

    /**
     *
     * @return
     */
    public String getCurp() {
        return curp;
    }

    /**
     *
     * @param curp
     */
    public void setCurp(String curp) {
        this.curp = curp;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public int getValida() {
        return valida;
    }

    /**
     *
     * @param valida
     */
    public void setValida(int valida) {
        this.valida = valida;
    }

    /**
     *
     * @return
     */
    public int getCargo() {
        return cargo;
    }

    /**
     *
     * @param cargo
     */
    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    /**
     *
     * @return
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     *
     * @param usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     *
     * @return
     */
    public String getPass() {
        return pass;
    }

    /**
     *
     * @param pass
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     *
     * @return
     */
    public int getTipo() {
        return tipo;
    }

    /**
     *
     * @param tipo
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    /**
     *
     * @return
     */
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

    /**
     *
     * @return
     */
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
