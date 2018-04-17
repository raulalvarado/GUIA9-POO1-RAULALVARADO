/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Estudiante
 */
public class piezas {
    
    private int codipiez;
    private String nomb;
    private String tipo;
    private String marc;

    public piezas(int codipiez, String nomb, String tipo, String marc) {
        this.codipiez = codipiez;
        this.nomb = nomb;
        this.tipo = tipo;
        this.marc = marc;
    }

    public int getCodipiez() {
        return codipiez;
    }

    public void setCodipiez(int codipiez) {
        this.codipiez = codipiez;
    }

    public String getNomb() {
        return nomb;
    }

    public void setNomb(String nomb) {
        this.nomb = nomb;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarc() {
        return marc;
    }

    public void setMarc(String marc) {
        this.marc = marc;
    }

    @Override
    public String toString() {
        return  this.nomb;
    }
    
    

    
}
