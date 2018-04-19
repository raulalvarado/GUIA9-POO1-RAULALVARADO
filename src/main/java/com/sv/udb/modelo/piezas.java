/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author Estudiante
 */
@AllArgsConstructor
@NoArgsConstructor
@Data public class piezas {
    
    private int codipiez;
    private String nomb;
    private String tipo;
    private String marc;


    @Override
    public String toString() {
        return  this.nomb;
    }
    
    

    
}
