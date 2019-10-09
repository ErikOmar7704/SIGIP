<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Bootstrap 4 Website Example</title>
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
        </style>
    </head>
    <body>
        <nav class="bg-light text-right small text-muted">
            <span class="fas fa-user-check"></span> nombre de usuario 
            <a class="text-muted"  href="#"><i class="fas fa-sign-out-alt"></i></a>
        </nav>
        <div class="jumbotron text-center" style="margin-bottom:0">
            <h1>Sistema de Gestion de Información Pública</h1>
            <p>Instituto Tecnológico de Venustiano Carranza</p> 
        </div>

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
                    <div class="container">
                        <form class="form-vertical" id="idFrmAreas" name="frmAreas" action="" method="POST">
                            
                        </form>
                    </div>
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
