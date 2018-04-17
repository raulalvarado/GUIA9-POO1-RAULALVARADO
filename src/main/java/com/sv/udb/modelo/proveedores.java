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
public class proveedores {
    
    private int codiprov;
    private String nomb;
    private String dire;
    private String tele;    

    public proveedores(int codiprov, String nomb, String dire, String tele) {
        this.codiprov = codiprov;
        this.nomb = nomb;
        this.dire = dire;
        this.tele = tele;
    }

    public int getCodiprov() {
        return codiprov;
    }

    public void setCodiprov(int codiprov) {
        this.codiprov = codiprov;
    }

    public String getNomb() {
        return nomb;
    }

    public void setNomb(String nomb) {
        this.nomb = nomb;
    }

    public String getDire() {
        return dire;
    }

    public void setDire(String dire) {
        this.dire = dire;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    @Override
    public String toString() {
        return this.nomb;
    }
    
    
    
    
}
