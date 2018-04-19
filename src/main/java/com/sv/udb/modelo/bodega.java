/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;



/**
 *
 * @author Estudiante
 */
@AllArgsConstructor
@NoArgsConstructor
@Data public class bodega {
    
    private int codibode;
    private piezas pieza;
    private proveedores proveedor;
    private int cant;
    private String date;


    @Override
    public String toString() {
        return String.valueOf(codibode);
    }

    
   

    
    
    
    
}
