/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.dats.modelo.pojos;

import java.io.Serializable;

/**
 *
 * @author GUFE
 */
public class Area implements Serializable {
    private int id=-1;
    private String nombre="";
    private String nombreCorto="";
    private int superior=-1;

    public Area(int id, String nombre, String nombreCorto, int superior) {
        this.id = id;
        this.nombre = nombre;
        this.nombreCorto = nombreCorto;
        this.superior = superior;
    }

    public Area(String nombre, String nombreCorto, int superior) {
        this.nombre = nombre;
        this.nombreCorto = nombreCorto;
        this.superior = superior;
    }

    public Area() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreCorto() {
        return nombreCorto;
    }

    public void setNombreCorto(String nombreCorto) {
        this.nombreCorto = nombreCorto;
    }

    public int getSuperior() {
        return superior;
    }

    public void setSuperior(int superior) {
        this.superior = superior;
    }
    
    
}
