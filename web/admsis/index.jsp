<%@page import="mx.com.dats.modelo.pojos.MedioPublicacion"%>
<%@page import="mx.com.dats.modelo.pojos.Area"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@include file="\plantilla\header.jsp" %>
<%
    String mensaje="";
    if(request.getAttribute("mensaje")!=null)
        mensaje=mensaje +request.getAttribute("mensaje");
    List<Cuenta> lstAllUsers= new ArrayList<Cuenta>();
    if(request.getAttribute("lstAllUsers")!=null){
        lstAllUsers=(List<Cuenta>)request.getAttribute("lstAllUsers");
    }
    List<Area> lstAllAreas= new ArrayList<Area>();
    if(request.getAttribute("lstAllAreas")!=null){
        lstAllAreas=(List<Area>)request.getAttribute("lstAllAreas");
    }
    List<MedioPublicacion> lstAllMedios= new ArrayList<MedioPublicacion>();
    if(request.getAttribute("lstAllMedios")!=null){
        lstAllMedios=(List<MedioPublicacion>)request.getAttribute("lstAllMedios");
    }
%>
<div class="col-sm-8">
    
    <h2><span class="fab fa-buromobelexperte" style="font-size:72px;"></span> Áreas</h2>
    <div class="bg-light text-right">
        <a href="#" class="" data-toggle="collapse" data-target="#dvTbAreas">Ver/ocultar áreas</a>                        
    </div>
    <div id="dvTbAreas" class="collapse">
        <table id="tbAreas" class="table">
            <thead>
                <tr><th>Num.</th><th>Area</th><th>Nomb. Corto</th><th>Acciones</th></tr>
            </thead>
            <tbody>
                <tr>
                     <%
                        if(lstAllAreas!=null)
                            for(Area a : lstAllAreas){
                                out.println("<tr>");
                                out.println("<td>"+a.getId()+"</td>");
                                out.println("<td>"+a.getNombre()+"</td>");
                                out.println("<td>"+a.getNombreCorto()+"</td>");
                                out.println("<td>"+"<a href='"+request.getContextPath()+"/security?accion=seleccionar&pj=area&id="+a.getId()+"'>Ver</a>"+"</td>");
                                out.println("</tr>");
                            }
                    %>
                </tr>
            </tbody>
            
        </table>
    </div>
    <p>Información de areas</p>
    <h5 class="text-right">
         <h5 class="text-right"><a href="<%=request.getContextPath()+"/security?accion=nueva&pj=area"%>" class="btn btn-light" >Agregar</a></h5>
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
                                out.println("<td>"+"<a href='"+request.getContextPath()+"/security?accion=seleccionar&pj=cuenta&id="+c.getIdcuenta()+"'>Ver</a>"+"</td>");
                                out.println("</tr>");
                            }
                    %>
            </tbody>
        </table>
    </div>
    <p>Información de usuarios</p>
    <h5 class="text-right"><a href="<%=request.getContextPath()+"/security?accion=nueva&pj=cuenta"%>" class="btn btn-light" >Agregar</a></h5>
    <hr/>
    <br>
    <h2><span class="fas fa-share-alt" style="font-size:72px;"></span> Medios de publicación</h2>
    <div class="bg-light text-right">
        <a href="#" class="" data-toggle="collapse" data-target="#dvTbMedios">Ver/ocultar medios</a>
    </div>
    <div id="dvTbMedios" class="collapse">
        <table id="tbMedios" class="table">
            <thead>
                <tr><th>Num.</th><th>Medio</th><th>Cuenta</th><th>Dirección</th><th>Acciones</th></tr>
            </thead>
            <tbody>
                <tr>
                    <%
                        if(lstAllMedios!=null)
                            for(MedioPublicacion m : lstAllMedios){
                                out.println("<tr>");
                                out.println("<td>"+m.getIdMedio()+"</td>");
                                out.println("<td>"+m.getNombre()+"</td>");
                                out.println("<td>"+m.getCuenta()+"</td>");
                                out.println("<td class='small' style='white-space:pre'>"+m.getDireccion()+"</td>");
                                out.println("<td>"+"<a href='"+request.getContextPath()+"/security?accion=seleccionar&pj=medio&id="+m.getIdMedio()+"'>Ver</a>"+"</td>");
                                out.println("</tr>");
                            }
                    %>
                </tr>
            </tbody>
        </table>
    </div>
    <p>Información de Medios</p>
    <h5 class="text-right"><a href="<%=request.getContextPath()+"/security?accion=nueva&pj=medio"%>" class="btn btn-light" >Agregar</a></h5>
    <hr/>
    <br>
</div>
    
    <div class="col-sm-2" id="dvPnlMensajes">
        <h5>Mensajes</h5>
       
            
        <%
            if(mensaje!=""){
                out.print(" <div id='dvMensaje' class='alert alert-warning small' style='font-size: 12px'>");
                out.print(mensaje);
            }
        %>
    </div>
    </div>
<%@include file="\plantilla\footer.jsp" %>
