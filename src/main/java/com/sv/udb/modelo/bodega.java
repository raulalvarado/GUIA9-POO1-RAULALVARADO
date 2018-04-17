/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

/**
 *
 * @author Estudiante
 */
public class bodega {
    
    private int codibode;
    private piezas pieza;
    private proveedores proveedor;
    private int cant;
    private String date;

    public bodega(int codibode, piezas pieza, proveedores proveedor, int cant, String date) {
        this.codibode = codibode;
        this.pieza = pieza;
        this.proveedor = proveedor;
        this.cant = cant;
        this.date = date;
    }

    public int getCodibode() {
        return codibode;
    }

    public void setCodibode(int codibode) {
        this.codibode = codibode;
    }

    public piezas getPieza() {
        return pieza;
    }

    public void setPieza(piezas pieza) {
        this.pieza = pieza;
    }

    public proveedores getProveedor() {
        return proveedor;
    }

    public void setProveedor(proveedores proveedor) {
        this.proveedor = proveedor;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return String.valueOf(codibode);
    }

    
   

    
    
    
    
}
