/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiendanike;

/**
 *
 * @author neon
 */
public class nodo {
    public String tipo, talla, id;
    public int unidades;
    public double precio;
    
    nodo sig, ant;

    public nodo(String tipo, String talla, String id, int unidades, double precio) {
        this.tipo = tipo;
        this.talla = talla;
        this.id = id;
        this.unidades = unidades;
        this.precio = precio;
        sig = null;
        ant = null;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public nodo getSig() {
        return sig;
    }

    public void setSig(nodo sig) {
        this.sig = sig;
    }

    public nodo getAnt() {
        return ant;
    }

    public void setAnt(nodo ant) {
        this.ant = ant;
    }
    
    
    
}
