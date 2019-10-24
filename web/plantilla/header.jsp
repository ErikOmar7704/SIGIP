<%@page import="mx.com.dats.modelo.pojos.Cuenta"%>
<%
    String urlStr = request.getContextPath();
    System.out.println("Entre1");
    boolean isSession = false;
    Cuenta cuentaUser = new Cuenta();
    if (session.getAttribute("cuentaActual") != null) {
        isSession = true;
        cuentaUser = (Cuenta) session.getAttribute("cuentaActual");
    }
    System.out.println("Entre2");
    if (!isSession) {
        response.sendRedirect(request.getContextPath());
    }
    System.out.println("Entre3");
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>SIGIP</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="/SIGIP/libs/dist/css/bootstrap.min.css">
        <script src="/SIGIP/libs/js/jquery.min.js"></script>
        <script src="/SIGIP/libs/js/popper.min.js"></script>
        <script src="/SIGIP/libs/dist/js/bootstrap.min.js"></script>
        <script src="/SIGIP/libs/boots/iconos.js"></script>
        <style>
            .fakeimg {
                height: 200px;
                background: #aaa;
            }
            .bg-banner{background:#EEE;height:120px;vertical-align:botton;}
        </style>
    </head>
    <body>
        <nav class="bg-light text-right text-muted">
            <span class="fas fa-user-check"></span> <%= cuentaUser.getUsuario()%> 
            <a class="text-muted"  href="<%=request.getContextPath()%>/security?accion=cerrar"><span class="fas fa-sign-out-alt"></span> Salir</a>
        </nav>
        <!--div class="text-center bg-banner" -->
        <nav class="navbar navbar-expand-sm bg-light navbar-dark">
            <div class="collapse navbar-collapse">
                <h2>Instituto Tecnológico Superior de Venustiano Carranza</h2>
            </div>
        </nav>

        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
            <a class="navbar-brand" href="#">S I G I P</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="collapsibleNavbar">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="<%=urlStr+"/security?accion=inicio"%>"><span class="fa fa-home"></span> Inicio</a>
                    </li>

                </ul>
            </div>  
        </nav>
        <div class="container" style="margin-top:30px">
            <div class="row">
                <div class="col-sm-2">
                    <h4 id="lbTipoUser"><%=cuentaUser.getNameTipo()%></h4>
                    <h6 id="lbNombreUser" class="small"><%=cuentaUser.getNombre()%></h6>
                    <div class="fakeimg">Logo/imagen</div>
                    <p></p>
                    <h3><%=cuentaUser.getNameCargo()%></h3>
                    <p></p>
                    <ul class="nav nav-pills flex-column">
                        <li class="nav-item">
                            <a class="nav-link active" href="#">Texto</a>
                        </li>
                    </ul>
                    <hr class="d-sm-none">
                </div>