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
     
        <div class="jumbotron text-center" style="margin-bottom:0">
            <h3>Sistema de Gestion de Información Pública</h3>
            <p>Instituto Tecnológico de Venustiano Carranza</p> 
        </div>

        <div class="container" style="margin-top:30px">
            <div class="row">
                <div class="col-sm-4 ">
                </div>
                <div class="col-sm-4">
                    <h3 class="text-center"><span class="fas fa-sign-in-alt" style="font-size:75px;"></span> </h3>
                    <h6 class="text-center">Acceso al sistema</h6>
                    <div class="panel">
                        <form id="frmAcceso" class="form-vertical" action="<%= request.getContextPath() %>/security" method="POST">
                            <div class="form-group">
                                <label for="idUser" >usuario:</label>
                                <input id="idUser" name="usuario" type="text" class="form-control"/>
                            </div>
                            <div class="form-group">
                                <label for="idPass" >contraseña:</label>
                                <input id="idPass" name="pass" type="password" class="form-control"/>
                            </div>
                            <div class="container text-right">
                               <input type="submit" id="idEntrar" name="accion" value="Entrar" class="btn btn-light"/>
                            </div>      
                        </form>                   
                    </div>                  
                    <p>Información de areas</p>
                </div>
                <div class="col-sm-4">
                </div>
            </div>
        </div>

        <div class="jumbotron text-center" style="margin-bottom:0">
            
        </div>

    </body>
</html>
