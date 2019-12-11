<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="mx.com.dats.modelo.pojos.MedioPublicacion"%>
<%@include file="\plantilla\header.jsp" %>
<%
    
    boolean editar = false;
    MedioPublicacion medioSel = new MedioPublicacion();
    Cuenta cuentaAdmin = new Cuenta();
    String accion = "";
    int opcion = 0;
    List<Cuenta> lstAllUsuarios = new ArrayList<Cuenta>();
    if (session.getAttribute("cuentaActual") != null) {
        cuentaAdmin = (Cuenta) session.getAttribute("cuentaActual");
        if (cuentaAdmin.getTipo() != 1) {
            response.sendRedirect(request.getContextPath() + "/error.jsp?mensaje=Permisos denegados");
        }
    }
    if (request.getParameter("accion") != null) {
        accion = request.getParameter("accion");
    }
    if (request.getAttribute("lstAllUsuarios") != null) {
        lstAllUsuarios = (List<Cuenta>) request.getAttribute("lstAllUsuarios");
    }
    if (request.getAttribute("medioSel") != null) {
        medioSel = (MedioPublicacion) request.getAttribute("medioSel");
    }
%>
<div class="col-sm-8">
    <div class="container panel-body mb-4">
        <h1><span class="fas fa-share-alt" style="font-size:72px;"></span> Datos de medios de publicación</h1>
        <form class="form-vertical" id="idFrmAreas" name="frmMedios"  action="<%=request.getContextPath() + "/security"%>" method="POST">
            <div class="form-group text-right">
                <label for="idEditor" >Responsable de medio:</label>
                <select id="idEditor" name="editor" class="form-control-md" style="width: 200px">
                    <option value="0" selected="true">Ninguna</option>
                    <%
                        int index = medioSel.getIdcuenta();
                        for (Cuenta c : lstAllUsuarios) {
                            out.print("<option value='" + c.getIdcuenta()+ "'");
                            if (c.getIdcuenta()== index) {
                                out.print("selected");
                            }
                            out.print(" >" + c.getNombre()+ "</option>");
                        }
                    %> 
                </select>
            </div>
            <div class="form-group">
                <label for="idNombre" >Nombre del medio de publicación:</label>
                <input id="idNombre" name="nombre" type="text" class="form-control" value="<%=medioSel.getNombre()%>"/>
            </div>
            <div class="form-group">
                <label for="idDireccion" >Dirección (URL):</label>
                <input id="idDireccion" name="direccion" type="text" class="form-control"  value="<%=medioSel.getDireccion()%>"/>
            </div>
            <div class="form-group">
                <label for="idCuenta" >Cuenta de usuario:</label>
                <input id="idCuenta" name="cuenta" type="text" class="form-control"  value="<%=medioSel.getCuenta()%>" />
            </div>
            <div class="form-group">
                <label for="idPass" >Contraseña:</label>
                <input id="idPass" name="pass" type="text" class="form-control"  value="<%=medioSel.getPassword()%>"/>
                <input id="idMedio" name="idMedio" type="hidden" value="<%=medioSel.getIdMedio()%>"/>
                <input id="idPj" name="pj" type="hidden" value="medio"/>
            </div>
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
