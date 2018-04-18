/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.piezas;
import com.sv.udb.modelo.proveedores;
import com.sv.udb.modelo.bodega;
import com.sv.udb.recursos.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Estudiante
 */
public class controlBodega {
    
    private final Connection conect;

    public controlBodega() {
        this.conect = new conexion().getConn();
    }
    
     public boolean guardar(int codigoPiez, int codigoProv, int cant, String fechaComp)
    {
        boolean resp= false;
        try
        {
            PreparedStatement cmd = this.conect.prepareStatement("INSERT INTO bodega VALUES(NULL,?,?,?,?)");
            cmd.setInt(1, codigoPiez);
            cmd.setInt(2, codigoProv);
            cmd.setInt(3, cant);
            cmd.setString(4,fechaComp);
            
            cmd.executeUpdate();
            resp=true;
        
        }
        catch(SQLException ex)
         {
             System.err.println("Ocurrio un error al guardar bodega: "+ ex.getMessage());
         }
        finally
        {
             try
            {
                if(this.conect != null)
                {
                    if(!this.conect.isClosed())
                    {
                        this.conect.close();
                    }
                }
            }
            catch(SQLException ex)
            {
                System.err.println("Error al cerrar la conexión");
            }
        }
        return resp;
        }
    
     public List<bodega> consTodo () {
        List<bodega> resp = new ArrayList<>();
        try {
            PreparedStatement cmd = this.conect.prepareStatement("SELECT b.codi_bode, pie.*, pro.*, "
                    + "b.cant, DATE_FORMAT(b.fecha_comp,'%d/%m/%Y')  FROM Bodega b INNER JOIN Piezas pie ON b.codi_piez = pie.codi_piez "
                    + "INNER JOIN Proveedores pro ON b.codi_prov = pro.codi_prov");
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                resp.add(
                        new bodega(
                                rs.getInt(1), 
                                new piezas(rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5)),
                                new proveedores(rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9)),
                                rs.getInt(10),
                                rs.getString(11)
                        ));
            }
        } catch (SQLException ex) {
            System.err.println("Error al consultar bodega: " + ex.getMessage());
        } finally {
            try {
                if (this.conect != null) {
                    if (!this.conect.isClosed()) {
                        this.conect.close();
                    }
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión al consultar bodega: " + ex.getMessage());
            }
        }
        return resp;
    }
     
      public bodega cons(int codiBode)
    {
        bodega resp = null;
        try
        {
            PreparedStatement cmd = this.conect.prepareStatement("SELECT b.codi_bode, pie.*, pro.*, b.cant, b.fecha_comp FROM bodega b INNER JOIN piezas pie ON b.codi_piez=pie.codi_piez INNER JOIN proveedores pro ON b.codi_prov=pro.codi_prov WHERE codi_bode = ?");
            cmd.setInt(1, codiBode);
            ResultSet rs = cmd.executeQuery();
            if(rs.next())
            {
                resp = new bodega(rs.getInt(1), new piezas(rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5)), new proveedores(rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9)), rs.getInt(10), rs.getString(11));
            }
        }
        catch(SQLException ex)
        {
            System.err.println("Error al consultar en Bodega: " + ex.getMessage());
        }
        finally
        {
            try
            {
                if(this.conect != null)
                {
                    if(!this.conect.isClosed())
                    {
                        this.conect.close();
                    }
                }
            }
            catch(SQLException ex)
            {
                System.err.println("Error al cerrar la conexión");
            }
        }
        return resp;
    }
     
     public boolean actualizar(int codigoBode,int codigoPiez, int codigoProv, int cant)
    {
        boolean resp= false;
        try
        {
            PreparedStatement cmd = this.conect.prepareStatement("UPDATE bodega SET codi_piez = ?, codi_prov = ?, cant=? WHERE codi_bode = ?");
            cmd.setInt(1, codigoPiez);
            cmd.setInt(2, codigoProv);
            cmd.setInt(3, cant);
            cmd.setInt(4, codigoBode);
            cmd.executeUpdate();
            resp=true;
        
        }
        catch(SQLException ex)
         {
             System.err.println("Ocurrio un error al actualizar bodega: "+ ex.getMessage());
         }
        finally
        {
             try
            {
                if(this.conect != null)
                {
                    if(!this.conect.isClosed())
                    {
                        this.conect.close();
                    }
                }
            }
            catch(SQLException ex)
            {
                System.err.println("Error al cerrar la conexión");
            }
        }
        return resp;
        }
     
      public boolean eliminar (int codiJuga) {
        boolean resp = false;
        try {
            PreparedStatement cmd = conect.prepareStatement("DELETE FROM bodega WHERE codi_bode = ?");
            cmd.setInt(1, codiJuga);
            cmd.executeUpdate();
            resp = true;
        }
        catch (Exception e) {
            System.err.println("Error al eliminar bodega: " + e.getMessage());
        }
        finally {
            try {
                if (conect != null)
                    if (!conect.isClosed())
                        conect.close();
            } catch (Exception e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return resp;       
    }
    }
    
    
    
    
   
