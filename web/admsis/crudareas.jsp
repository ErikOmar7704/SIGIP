<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="mx.com.dats.modelo.pojos.Area"%>
<%@include file="\plantilla\header.jsp" %>

<%
    System.out.println("Entre 1");
    boolean editar = false;
    Area areaSel = new Area();
    Cuenta cuentaAdmin = new Cuenta();
    String accion = "";
    int opcion = 0;
    List<Area> lstAllAreas = new ArrayList<Area>();
    System.out.println("Entre 2");
    if (session.getAttribute("cuentaActual") != null) {
        cuentaAdmin = (Cuenta) session.getAttribute("cuentaActual");
        if (cuentaAdmin.getTipo() != 1) {
            response.sendRedirect(request.getContextPath() + "/error.jsp?mensaje=Permisos denegados");
        }
    }
    System.out.println("Entre 3");
    if (request.getParameter("accion") != null) {
        accion = request.getParameter("accion");
    }
    System.out.println("Entre 4");
    if (request.getAttribute("lstAllAreas") != null) {
        lstAllAreas = (List<Area>) request.getAttribute("lstAllAreas");
    }
    System.out.println("Entre 5");
    if (request.getAttribute("areaSel") != null) {
        areaSel = (Area) request.getAttribute("areaSel");
    }
    System.out.println("Entre 6");
%>
<div class="col-sm-8">
    <div class="container panel-body mb-4">
        <h1><span class="fab fa-buromobelexperte" style="font-size:72px;"></span> Datos de áreas</h1>
        <form class="form-vertical" id="idFrmAreas" name="frmAreas" 
              action="<%=request.getContextPath() + "/security"%>" method="POST">
            <!--cuadro combinado-->
            <div class="form-group text-right">
                <label for="idSuperior" >Área Superior:</label>
                <select id="idSuperior" name="superior" class="form-control-md" style="width: 200px">
                    <option value="0" selected="true">Ninguna</option>
                    <%
                        int index = areaSel.getSuperior();
                        for (Area a : lstAllAreas) {
                            out.print("<option value='" + a.getId() + "'");
                            if (a.getId() == index) {
                                out.print("selected");
                            }
                            out.print(" >" + a.getNombreCorto() + "</option>");
                        }
                    %>        
                </select>
            </div>
            <!--caja de texto-->
            <div class="form-group">
                <label for="idNombre" >Nombre de Área:</label>
                <input id="idNombre" name="nombre" type="text" class="form-control" value="<%=areaSel.getNombre()%>"/>
            </div>

            <!--caja de texto-->
            <div class="form-group">
                <label for="idNombreCorto" >Nombre Corto de Area:</label>
                <input id="idNombreCorto" name="nombreCorto" type="text" class="form-control" value="<%=areaSel.getNombreCorto()%>"/>
            </div>
            <input id="idArea" name="idArea" type="hidden" value="<%=areaSel.getId()%>"/>
            <input id="idPj" name="pj" type="hidden" value="area"/>
            <hr/>
            <div class="container text-right">
                <%
                    if (accion.equals("nueva")) {
                        
                %>
                <input type="submit" id="idAgregar" name="accion" value="Agregar" class="btn btn-info"/>
                <%
                    }
                    if (accion.equals("seleccionar")) {
                        
                %>
                <input type="submit" id="idEditar" name="accion" value="Editar" class="btn btn-info"/>
                <input type="submit" id="idEliminar" name="accion" value="Borrar" class="btn btn-danger"/>
                <%
                    }
                %>
                <a id="idVolver" href="<%=request.getContextPath() + "/security?accion=inicio"%>" class="btn btn-light">Volver</a>
            </div>
        </form>
    </div>
</div>
<%@include file="\plantilla\footer.jsp" %>
