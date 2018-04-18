<%-- 
    Document   : bodega
    Created on : 04-12-2018, 05:30:24 PM
    Author     : Estudiante
--%>


<%@page import="com.sv.udb.controlador.controlBodega"%>
<%@page import="com.sv.udb.modelo.bodega"%>
<%@page import="com.sv.udb.controlador.controlProveedores"%>
<%@page import="com.sv.udb.modelo.proveedores"%>
<%@page import="com.sv.udb.modelo.piezas"%>
<%@page import="com.sv.udb.controlador.controlPiezas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenimiento de Bodega</title>
        <link rel='stylesheet' href='../webjars/bootstrap/4.0.0-2/css/bootstrap.min.css'>
        <script type="text/javascript" src="../webjars/jquery/2.1.1/jquery.min.js"></script>
        <script type="text/javascript" src="../webjars/bootstrap/4.0.0-2/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%
            boolean estaModi = Boolean.parseBoolean((String) request.getAttribute("estaModi"));
            String nombBton = estaModi ? "Nuevo" : "Guardar"; // Para el texto del botón
            String clssEditBton = estaModi ? "" : "display: none"; //Pra ocultar botones
        %>
        <div class="container">
            <div class="alert alert-success">
                <h1 class="text-center">Mantenimiento de Bodega</h1>
            </div>
            <div class="row">
                <div class="col-md-5">
                    <div class="panel panel-primary">
                        <div class="panel-heading">El Formulario</div>
                        <div class="panel-body">
                            <div class="alert alert-success">
                                ${mensAler}
                            </div>
                            <form method="POST" action="BodegaServ" name="Demo">
                                <input type="hidden" name="codi" id="codi" value="${codi}"/>
                                <div class="form-group">
                                    <label for="piez">Seleccione la pieza:</label>
                                    <select class="custom-select" name="codPiez" id="codPiez">
                                        <option selected disabled>Seleccione la pieza</option>
                                        <%
                                            for (piezas temp : new controlPiezas().selectPiezas()) {
                                        %>
                                        <option value="<%= temp.getCodipiez()%>"><%= temp.getNomb()%></option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="prov">Seleccione el proveedor:</label>
                                    <select class="custom-select" name="codProv" id="codProv">
                                        <option selected disabled>Seleccione el proveedor</option>
                                        <%
                                            for (proveedores temp : new controlProveedores().selectProveedores()) {
                                        %>
                                        <option value="<%= temp.getCodiprov()%>"><%= temp.getNomb()%></option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="cant">Cantidad:</label>
                                    <input type="number" class="form-control" name="cant" id="cant" value="${cant}">
                                </div>
                                <div class="form-group">
                                    <label for="fech">Fecha de compra:</label>
                                    <input type="text" class="form-control" name="fecha" id="fecha" value="${fecha}">
                                </div>
                                <input type="submit" class="btn btn-default" name="btnBode" value="<%=nombBton%>"/>
                                <input type="submit" class="btn btn-primary" style="<%=clssEditBton%>" name="btnBode" value="Modificar"/>
                                <input type="submit" class="btn btn-danger" style="<%=clssEditBton%>" name="btnBode" value="Eliminar"/>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-md-7">
                    <div class="panel panel-primary">
                        <div class="panel-heading">La Tabla</div>
                        <div class="panel-body">
                            <form method="POST" action="BodegaServ" name="Tabl">
                                <div class="table-responsive">
                                    <table class="table table-hover">
                                        <tr>
                                            <th scope="col">Cons</th>
                                            <th scope="col">Cantidad</th>
                                            <th scope="col">Pieza</th>
                                            <th scope="col">Proveedor</th>
                                            <th scope="col">Fecha de compra</th>
                                        </tr>
                                        <%
                                            for (bodega temp : new controlBodega().consTodo()) {
                                        %>
                                        <tr>
                                            <td><input type="radio" name="codiBodeRadi" value="<%= temp.getCodibode()%>"/></td>
                                            <td><%= temp.getCant()%></td>
                                            <td><%= temp.getPieza().getNomb()%></td>
                                            <td><%= temp.getProveedor().getNomb()%></td>
                                            <td><%= temp.getDate()%></td>
                                        </tr>
                                        <%
                                            }
                                        %>
                                    </table>
                                </div>
                                <input type="submit" class="btn btn-success" name="btnBode" value="Consultar"/>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>