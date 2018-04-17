<%-- 
    Document   : piezas
    Created on : 04-12-2018, 05:19:38 PM
    Author     : Estudiante
--%>

<%@page import="com.sv.udb.controlador.controlPiezas"%>
<%@page import="com.sv.udb.modelo.piezas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenimiento de Piezas</title>
        <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
        <script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
        <script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%
            boolean update = Boolean.parseBoolean((String)request.getAttribute("update"));
            String btnName = update ? "Nuevo" : "Guardar"; // Para el texto del botón
            String btnEditClass = update ? "" : "display: none"; //Para ocultar botones
        %>
        <div class="container">
            <div class="alert alert-success">
                <strong>Indicaciones:</strong> Usando Bootstrap con la Guía 09.
            </div>
            <div class="row">
                <h1>Piezas</h1>
                <div class="col-md-5">
                    <div class="panel panel-primary">
                        <div class="panel-heading">El Formulario</div>
                        <div class="panel-body">
                            <div class="alert alert-success">
                                ${message}
                            </div>
                            <form method="POST" action="TeamServ" name="Demo">
                                <input type="hidden" name="code" id="code" value="${codipiez}"/>
                                <div class="form-group">
                                    <label for="nomb">Nombre:</label>
                                    <input type="text" class="form-control" name="name" id="name" value="${nomb}"/>
                                </div>
                                <div class="form-group">
                                    <label for="desc">Tipo:</label>
                                    <input type="text" class="form-control" name="desc" id="desc" value="${tipo}"/>
                                </div>
                                <div class="form-group">
                                    <label for="desc">Marca:</label>
                                    <input type="text" class="form-control" name="desc" id="desc" value="${marc}"/>
                                </div>
                                <input type="submit" class="btn btn-default" name="teamBtn" value="<%=btnName%>"/>
                                <input type="submit" class="btn btn-primary" style="<%=btnEditClass%>" name="teamBtn" value="Modificar"/>
                                <input type="submit" class="btn btn-danger" style="<%=btnEditClass%>" name="teamBtn" value="Eliminar" onclick="return confirm('¿Desea eliminar este registro?')"/>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-md-7">
                    <div class="panel panel-primary">
                        <div class="panel-heading">La Tabla</div>
                        <div class="panel-body">
                            <form method="POST" action="TeamServ" name="Tabl">
                                <table class="table table-bordered">
                                    <tr>
                                        <th>Cons</th>
                                        <th>Nombre</th>
                                        <th>Tipo</th>
                                        <th>Marca</th>
                                    </tr>
                                    <%
                                        for(piezas temp : new controlPiezas().selectPiezas())
                                        {
                                    %>
                                        <tr>
                                            <td><input type="radio" name="teamCodeRadio" value="<%= temp.getCodipiez() %>"/></td>
                                            <td><%= temp.getNomb() %></td>
                                            <td><%= temp.getTipo() %></td>
                                            <td><%= temp.getMarc() %></td>
                                        </tr>
                                    <%
                                        }
                                    %>
                                </table>
                                <input type="submit" class="btn btn-success" name="piezBtn" value="Consultar"/>
                            </form>
                        </div>
                    </div>
                </div>
                <a href='proveedores.jsp'><h2>Ir a proveedores</h2></a>
                <a href='bodega.jsp'><h2>Ir a bodega</h2></a>
            </div>
                                
            
        </div>
    </body>
</html>