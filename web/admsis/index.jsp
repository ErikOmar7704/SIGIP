<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@include file="\plantilla\header.jsp" %>
<%
    String mensaje="";
    if(request.getAttribute("mensaje")!=null)
        mensaje=mensaje;
    List<Cuenta> lstAllUsers= new ArrayList<Cuenta>();
    if(request.getAttribute("lstAllUsers")!=null){
        lstAllUsers=(List<Cuenta>)request.getAttribute("lstAllUsers");
    }
%>
<div class="col-sm-8">
    <div id="dvMensaje">
        <%
            if(mensaje!=""){
                out.print("<h5 class='info'>"+mensaje+"</h3>");
            }
        %>
    </div>
    <h2><span class="fab fa-buromobelexperte" style="font-size:72px;"></span> Áreas</h2>
    <div class="bg-light text-right">
        <a href="#" class="" data-toggle="collapse" data-target="#dvTbAreas">Ver/ocultar áreas</a>                        
    </div>
    <div id="dvTbAreas" class="collapse">
        <table id="tbAreas" class="table">
            <thead>
                <tr><th>Col_1</th><th>Col_2</th><th>Col_3</th><th>Col_4</th><th>Col_5</th></tr>
            </thead>
            <tbody>
                <tr>
                    <td>dato_1</td>
                    <td>dato_2</td>
                    <td>dato_3</td>
                    <td>dato_4</td>
                    <td>dato_5</td>
                </tr>
            </tbody>
            
        </table>
    </div>
    <p>Información de areas</p>
    <h5 class="text-right"><a href="#" class="btn btn-light" >Agregar</a></h5>
    <hr/>
    <br>
    <h2><span class="fas fa-users" style="font-size:72px;"></span> Usuarios</h2>
    <div class="bg-light text-right">
        <a href="#" class="" data-toggle="collapse" data-target="#dvTbUsuarios">Ver/ocultar usuarios</a>
    </div>
    <div id="dvTbUsuarios" class="collapse">
        <table id="tbUsuarios" class="table">
            <thead>
                <tr><th>Num.</th><th>Nombre</th><th>Usuario</th><th>Contraseña</th><th>Acciones</th></tr>
            </thead>
            <tbody>
                    <%
                        if(lstAllUsers!=null)
                            for(Cuenta c : lstAllUsers){
                                out.println("<tr>");
                                out.println("<td>"+c.getIdcuenta()+"</td>");
                                out.println("<td>"+c.getNombre()+"</td>");
                                out.println("<td>"+c.getUsuario()+"</td>");
                                out.println("<td>"+c.getPass()+"</td>");
                                out.println("<td>"+"<a href='"+request.getContextPath()+"/security?accion=seleccionar&id="+c.getIdcuenta()+"'>Ver</a>"+"</td>");
                                out.println("</tr>");
                            }
                    %>
            </tbody>
        </table>
    </div>
    <p>Información de usuarios</p>
    <h5 class="text-right"><a href="<%=request.getContextPath()+"/security?accion=nueva"%>" class="btn btn-light" >Agregar</a></h5>
    <hr/>
    <br>
    <h2><span class="fas fa-share-alt" style="font-size:72px;"></span> Medios de publicación</h2>
    <div class="bg-light text-right">
        <a href="#" class="" data-toggle="collapse" data-target="#dvTbMedios">Ver/ocultar medios</a>
    </div>
    <div id="dvTbMedios" class="collapse">
        <table id="tbMedios" class="table">
            <thead>
                <tr><th>Col_1</th><th>Col_2</th><th>Col_3</th><th>Col_4</th><th>Col_5</th></tr>
            </thead>
            <tbody>
                <tr>
                    <td>dato_1</td>
                    <td>dato_2</td>
                    <td>dato_3</td>
                    <td>dato_4</td>
                    <td>dato_5</td>
                </tr>
            </tbody>
        </table>
    </div>
    <p>Información de Medios</p>
    <h5 class="text-right"><a href="#" class="btn btn-light" >Agregar</a></h5>
    <hr/>
    <br>
</div>
<%@include file="\plantilla\footer.jsp" %>
