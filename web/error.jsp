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
                    <h3 class="text-center"><a href="<%= request.getContextPath() %>"><span class="fas fa-sign-out-alt" style="font-size:75px;"></span></a> </h3>
                    <h6 class="text-center">Página de ERROR</h6>
                    <div class="panel">
                                       
                    </div>                  
                    <p class="alert-danger text-center"><%=request.getParameter("mensaje")%></p>
                </div>
                <div class="col-sm-4">
                </div>
            </div>
        </div>

        <div class="jumbotron text-center" style="margin-bottom:0">
            
        </div>

    </body>
</html>
