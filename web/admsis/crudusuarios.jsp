<%@page import="mx.com.dats.modelo.pojos.Area"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@include file="\plantilla\header.jsp" %>
<%
    boolean editar = false;
    Cuenta cuentaSel = new Cuenta();
    Cuenta cuentaAdmin = new Cuenta();
    String accion = "";
    List<Cuenta> lstAllUsers = new ArrayList<Cuenta>();
    List<Area> lstAllAreas = new ArrayList<Area>();
    if (session.getAttribute("cuentaActual") != null) {
        cuentaAdmin = (Cuenta) session.getAttribute("cuentaActual");
        if (cuentaAdmin.getTipo() != 1) {
            response.sendRedirect(request.getContextPath() + "/error.jsp?mensaje=Permisos denegados");
        }
    }
    if (request.getParameter("accion") != null) {
        accion = request.getParameter("accion");
    }
    if (request.getAttribute("lstAllUsers") != null) {
        lstAllUsers = (List<Cuenta>) request.getAttribute("lstAllUsers");
    }
    if (request.getAttribute("lstAllAreas") != null) {
        lstAllAreas = (List<Area>) request.getAttribute("lstAllAreas");
    }
    if (request.getAttribute("cuentaSel") != null) {
        cuentaSel = (Cuenta) request.getAttribute("cuentaSel");
    }
    System.out.println("areas: "+ lstAllAreas.size());
%>
<div class="col-sm-8">
    <div class="container panel-body mb-4">
        <h1><span class="fas fa-users" style="font-size:72px;"></span> Datos de usuarios</h1>
        <form class="form-vertical" id="idFrmAreas" name="frmUsuarios" action="<%=request.getContextPath() + "/security"%>" method="POST">
            <div class="form-group text-right">
                <label for="idRol" >Rol:</label>
                <select id="idRol" name="tipo" class="form-control-md" style="width: 200px">
                    <option value="1" <% if (cuentaSel.getTipo() == 1) {
                                            out.print("Selected");
                                        } %>>Administrador</option>
                    <option value="2" <% if (cuentaSel.getTipo() == 2) {
                                            out.print("Selected");
                                        } %>>Val. Vinculación</option>
                    <option value="3" <% if (cuentaSel.getTipo() == 3) {
                                            out.print("Selected");
                                        } %>>Val. Jefe de Área</option>
                    <option value="4" <% if (cuentaSel.getTipo() == 4) {
                                            out.print("Selected");
                                        } %>>Editor</option>
                    <option value="5" <% if (cuentaSel.getTipo() == 5) {
                                            out.print("Selected");
                                        } %>>Autor</option>
                </select>
            </div>
            <div class="form-group text-right">
                <label for="idValider" >Validado por:</label>
                <select id="idValider" name="valida" class="form-control-md" style="width: 200px">
                    <option value="0">    Ninguno    </option>
                    <%
                        int index = cuentaSel.getValida();
                        for (Cuenta c : lstAllUsers) {
                            out.print("<option value='" + c.getIdcuenta() + "'");
                            if (c.getIdcuenta() == index) {
                                out.print("selected");
                            }
                            out.print(" >" + c.getNombre() + "</option>");
                        }
                    %>
                </select>
            </div>
            <div class="form-group text-right">
                <label for="idArea" >Area:</label>
                <select id="idArea" name="idarea" class="form-control-md" style="width: 200px">
                    <option value="0">    Ninguna    </option>
                    <%
                        index = cuentaSel.getIdArea();
                        for (Area c : lstAllAreas) {
                            out.print("<option value='" + c.getId()+ "'");
                            if (c.getId()== index) {
                                out.print("selected");
                            }
                            out.print(" >" + c.getNombreCorto()+ "</option>");
                        }
                    %>
                </select>
            </div>
            <div class="form-group text-right">
                <label for="idCargo" >Cargo:</label>
                <select id="idCargo" name="cargo" class="form-control-md" style="width: 200px">
                    <option value="1" <% if (cuentaSel.getCargo() == 1) {
                                            out.print("Selected");
                                        } %>>Director</option>
                    <option value="2" <% if (cuentaSel.getCargo() == 2) {
                                            out.print("Selected");
                                        } %>>Jefe de Área</option>
                    <option value="3" <% if (cuentaSel.getCargo() == 3) {
                                            out.print("Selected");
                                        } %>>Docente</option>
                    <option value="4" <% if (cuentaSel.getCargo() == 4) {
                                            out.print("Selected");
                                        }%>>Administrativo</option>
                </select>
            </div>
            <div class="form-group">
                <label for="idNombre" >Nombre:</label>
                <input id="idNombre" name="nombre" type="text" class="form-control" value="<%=cuentaSel.getNombre()%>"/>
            </div>
            <div class="form-group">
                <label for="idCurp" >CURP:</label>
                <input id="idCurp" name="curp" type="text" class="form-control" value="<%=cuentaSel.getCurp()%>"/>
            </div>
            <div class="form-group">
                <label for="idUsuario" >Usuario:</label>
                <input id="idUsuario" name="usuario" type="text" class="form-control" value="<%=cuentaSel.getUsuario()%>"/>
            </div>
            <div class="form-group">
                <label for="idPass" >Contraseña:</label>
                <input id="idPass" name="pass" type="password" class="form-control"/>
            </div>
            <input id="idCuenta" name="idCuenta" type="hidden" value="<%=cuentaSel.getIdcuenta()%>"/>
            <input id="idPj" name="pj" type="hidden" value="cuenta"/>
            <!--Botonera CRUD-->
            <hr/>
            <div class="container text-right">
                <%
                    if(accion.equals("nueva")){
                    %>
                <input type="submit" id="idAgregar" name="accion" value="Agregar" class="btn btn-info"/>
                <%
                    }
                    if(accion.equals("seleccionar")){
                    %>
                <input type="submit" id="idEditar" name="accion" value="Editar" class="btn btn-info"/>
                <input type="submit" id="idEliminar" name="accion" value="Borrar" class="btn btn-danger"/>
                <%
                    }
                    %>
                <a id="idVolver" href="<%=request.getContextPath()+"/security?accion=inicio"%>" class="btn btn-light">Volver</a>
            </div>
        </form>
    </div>
</div>
<%@include file="\plantilla\footer.jsp" %>
