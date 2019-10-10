<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Usuarios</title>
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
                    <div class="container panel-body mb-4">
                        <h1><span class="fas fa-users" style="font-size:72px;"></span> Datos de usuarios</h1>
                        <form class="form-vertical" id="idFrmAreas" name="frmUsuarios" action="" method="POST">
                            <div class="form-group text-right">
                                <label for="idRol" >Rol:</label>
                                <select id="idRol" name="rol" class="form-control-md" style="width: 200px">
                                    <option value="">Val. Vinculación</option>
                                    <option value="">Val. Jefe de Área</option>
                                    <option value="">Autor</option>
                                    <option value="">Editor</option>
                                    <option value="">Administrador</option>
                                </select>
                            </div>
                            <div class="form-group text-right">
                                <label for="idValider" >Validado por:</label>
                                <select id="idValider" name="valider" class="form-control-md" style="width: 200px">
                                    <option value="">    Ninguno    </option>
                                </select>
                            </div>
                            <div class="form-group text-right">
                                <label for="idCargo" >Cargo:</label>
                                <select id="idCargo" name="cargo" class="form-control-md" style="width: 200px">
                                    <option value="">Director</option>
                                    <option value="">Jefe de Área</option>
                                    <option value="">Docente</option>
                                    <option value="">Administrativo</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="idNombre" >Nombre:</label>
                                <input id="idNombre" name="nombre" type="text" class="form-control"/>
                            </div>
                            <div class="form-group">
                                <label for="idCurp" >CURP:</label>
                                <input id="idCurp" name="curp" type="text" class="form-control"/>
                            </div>
                            <div class="form-group">
                                <label for="idUsuario" >Usuario:</label>
                                <input id="idUsuario" name="usuario" type="text" class="form-control"/>
                            </div>
                            <div class="form-group">
                                <label for="idPass" >Contraseña:</label>
                                <input id="idPass" name="pass" type="password" class="form-control"/>
                            </div>
                            <!--Botonera CRUD-->
                            <hr/>
                            <div class="container text-right">
                                <input type="submit" id="idAgregar" name="Agregar" value="Agregar" class="btn btn-success"/>
                                <input type="submit" id="idEditar" name="Editar" value="Editar" class="btn btn-info"/>
                                <input type="submit" id="idEliminar" name="Borrar" value="Borrar" class="btn btn-danger"/>
                                <input type="submit" id="idVolver" name="Volver" value="Volver" class="btn btn-light"/>
                            </div>
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
