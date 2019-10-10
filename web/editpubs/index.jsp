<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Mis Publicaciones</title>
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
        <nav class="bg-light text-right small text-muted">
            <span class="fas fa-user-check"></span> nombre de usuario 
            <a class="text-muted"  href="#"><i class="fas fa-sign-out-alt"></i></a>
        </nav>
        <!--div class="text-center bg-banner" -->
        <nav class="navbar navbar-expand-sm bg-light navbar-dark">
            <div class="collapse navbar-collapse">
                <h2>Instituto Tecnol�gico Superior de Venustiano Carranza</h2>
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
                        <a class="nav-link" href="#">Link</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Link</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Link</a>
                    </li>    
                </ul>
            </div>  
        </nav>

        <div class="container" style="margin-top:30px">
            <div class="row">
                <div class="col-sm-2">
                    <h4 id="lbTipoUser">Administrador</h4>
                    <h6 id="lbNombreUser" class="small">Nombre de usuario</h6>
                    <div class="fakeimg">Logo/imagen</div>
                    <p></p>
                    <h3>Datos del usuario</h3>
                    <p></p>
                    <ul class="nav nav-pills flex-column">
                        <li class="nav-item">
                            <a class="nav-link active" href="#">Texto</a>
                        </li>
                    </ul>
                    <hr class="d-sm-none">
                </div>
                <div class="col-sm-8">
                    <h2><span class="fa fa-sticky-note" style="font-size:72px;"></span> Mis Publicaciones</h2>
                    <div class="bg-light text-right">
                        <a href="#" class="" data-toggle="collapse" data-target="#dvTbAreas">Ver/ocultar publicaciones</a>                        
                    </div>
                    <div id="dvTbAreas" class="collapse show">
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
                    <p>Informaci�n de publicaciones</p>
                    <h5 class="text-right"><a href="#" class="btn btn-light" >Agregar</a></h5>
                    <hr/>
                </div>
                <div class="col-sm-2">
                </div>
            </div>
        </div>

        <div class="jumbotron text-center" style="margin-bottom:0">
            <p>Footer</p>
        </div>

    </body>
</html>
