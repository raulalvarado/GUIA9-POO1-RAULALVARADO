/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.sv.udb.modelo.piezas;
import com.sv.udb.recursos.conexion;
import java.sql.Connection;
/**
 *
 * @author Estudiante
 */
public class controlPiezas {
    private final Connection conect;

    public controlPiezas() {
        this.conect = new conexion().getConn();
    }
    
    
    public ArrayList<piezas> selectPiezas() {
        ArrayList<piezas> resp = new ArrayList<>();
        try {
            PreparedStatement cmd = conect.prepareStatement("SELECT * FROM piezas");
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                resp.add(new piezas(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
        } catch (Exception e) {
            System.err.println("Error al consultar piezas: " + e.getMessage());
        } finally {
            try {
                if (conect != null) {
                    if (!conect.isClosed()) {
                        conect.close();
                    }
                }
            } catch (Exception e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return resp;
    }
    
}
