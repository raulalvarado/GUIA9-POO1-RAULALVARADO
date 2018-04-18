/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.vistas;

import com.sv.udb.controlador.controlBodega;
import com.sv.udb.controlador.controlPiezas;
import com.sv.udb.controlador.controlProveedores;
import com.sv.udb.modelo.bodega;
import com.sv.udb.modelo.piezas;
import com.sv.udb.modelo.proveedores;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Estudiante
 */
@WebServlet(name = "BodegaServ", urlPatterns = {"/BodegaServ"})
public class vistaBodega extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        boolean esValido = request.getMethod().equals("POST");
        String mens = "";
        if (!esValido) {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } else {
            String CRUD = request.getParameter("btnBode");
            if (CRUD.equals("Guardar")) {
                if (new controlBodega().guardar(Integer.parseInt(request.getParameter("codPiez")), Integer.parseInt(request.getParameter("codProv")), Integer.parseInt(request.getParameter("cant")), request.getParameter("fecha"))) {
                    mens = "Datos guardados";
                } else {
                    mens = "Error al guardar";
                }
            }
            else if(CRUD.equals("Consultar")) {
                int codi = Integer.parseInt(request.getParameter("codiBodeRadi") == null ? "-1" :
                        request.getParameter("codiBodeRadi"));
                bodega bode = new controlBodega().cons(codi);
                if (bode != null) {
                    request.setAttribute("codi", bode.getCodibode());
                    request.setAttribute("codPiez", bode.getPieza().getCodipiez());
                    request.setAttribute("codProv", bode.getProveedor().getCodiprov());
                    request.setAttribute("cant", bode.getCant());
                    request.setAttribute("fecha", bode.getDate());
                    mens = "Información consultada";
                    request.setAttribute("estaModi", "true");
                }
                else
                {
                    mens = "Error al consultar";
                }
            }
            else if(CRUD.equals("Modificar"))
            {
                if (new controlBodega().actualizar(Integer.parseInt(request.getParameter("codPiez")), Integer.parseInt(request.getParameter("codProv")), Integer.parseInt(request.getParameter("cant")), Integer.parseInt(request.getParameter("codi") == null ? "-1" :
                        request.getParameter("codi")))) {
                    mens = "Datos modificados";
                }
                else
                {
                    mens = "Error al modificar";
                }
            }
            else if(CRUD.equals("Eliminar"))
            {
                if (new controlBodega().eliminar(Integer.parseInt(request.getParameter("codi")))) {
                    mens = "Datos eliminados";
                }
                else
                {
                    mens = "Error al eliminar";
                }
            }
            else if(CRUD.equals("Nuevo"))
            {
                request.getRequestDispatcher("/bodega.jsp").forward(request, response);
            }
            request.setAttribute("mensAler", mens);
            request.getRequestDispatcher("/bodega.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
