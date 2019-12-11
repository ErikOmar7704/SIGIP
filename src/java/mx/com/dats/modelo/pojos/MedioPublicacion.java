/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.dats.modelo.pojos;

import java.io.Serializable;

/**
 *
 * @author lenovo
 */
public class MedioPublicacion implements Serializable{
    private int idMedio;
    private String nombre;
    private String cuenta;
    private String password;
    private String direccion;
    private int idcuenta;

    public MedioPublicacion() {
        this.idMedio = 0;
        this.nombre = "";
        this.cuenta = "";
        this.password = "";
        this.direccion = "";
        this.idcuenta = 0;
    }

    public MedioPublicacion(String nombre, String cuenta, String password, String direccion, int idcuenta) {
        this.nombre = nombre;
        this.cuenta = cuenta;
        this.password = password;
        this.direccion = direccion;
        this.idcuenta = idcuenta;
    }

    
    public MedioPublicacion(int idMedio, String nombre, String cuenta, String password, String direccion, int idcuenta) {
        this.idMedio = idMedio;
        this.nombre = nombre;
        this.cuenta = cuenta;
        this.password = password;
        this.direccion = direccion;
        this.idcuenta = idcuenta;
    }

    public int getIdMedio() {
        return idMedio;
    }

    public void setIdMedio(int idMedio) {
        this.idMedio = idMedio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getIdcuenta() {
        return idcuenta;
    }

    public void setIdcuenta(int idcuenta) {
        this.idcuenta = idcuenta;
    }
    
    
    
}
