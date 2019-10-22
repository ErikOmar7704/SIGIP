<%@include file="\plantilla\header.jsp" %>
                <div class="col-sm-7">
                    <div class="container panel-body mb-4">
                        <h1><span class="fa fa-sticky-note" style="font-size:72px;"></span> Publicaion</h1>
                        <form class="form-vertical" id="idFrmPublicacion" name="frmPublicacion" action="" method="POST">
                            <div class="form-group text-right">
                                <label for="idFecha" >Fecha:</label>
                                <input type="datetime" id="idFecha" name="Fecha"/>
                            </div>
                            <div class="form-group text-right">
                                <label for="idEstado" >Estado:</label>
                                <select id="idEstado" name="estado" class="form-control-md" style="width: 200px">
                                    <option value="">Creado</option>
                                    <option value="">Devuelto</option>
                                    <option value="">En Revisión</option>
                                    <option value="">Pre Validado</option>
                                    <option value="">Validado</option>
                                    <option value="">Publicado</option>
                                    <option value="">Archivado</option>
                                    <option value="">No aprobado</option>
                                </select>
                            </div>
                            <div class="form-group text-right">
                                <label for="idPreVal" >Pre Validación:</label>
                                <select id="idPreVal" name="preVal" class="form-control-md" style="width: 200px">
                                    <option value="">En Revisión</option>
                                    <option value="">Validado</option>
                                    <option value="">Devuelto</option>
                                    <option value="">No aprobado</option>
                                </select>
                            </div>
                            <div class="form-group text-right">
                                <label for="idValidado" >Val. Vinculación:</label>
                                <select id="idValidado" name="validado" class="form-control-md" style="width: 200px">
                                    <option value="">En Revisión</option>
                                    <option value="">Validado</option>
                                    <option value="">Devuelto</option>
                                    <option value="">No aprobado</option>
                                </select>
                            </div>                           
                            <div class="form-group">
                                <label for="idTitulo" >Titulo:</label>
                                <input id="idTitulo" name="titulo" type="text" class="form-control"/>
                            </div>
                            <div class="form-group">
                                <label for="idResumen" >Resumen:</label>
                                <textarea id="idResumen" name="resumen" multiline class="form-control"></textarea>
                            </div>
                            <div class="form-group">
                                <label for="idTexto" >Redacción:</label>
                                <textarea id="idTexto" name="texto" class="form-control"></textarea>
                            </div>

                            <!--Botonera CRUD-->
                            <hr/>
                            <div class="container text-right">
                                <input type="submit" id="idAgregar" name="Agregar" value="Agregar" class="btn btn-success"/>
                                <input type="submit" id="idEditar" name="Editar" value="Editar" class="btn btn-info"/>
                                <input type="submit" id="idEliminar" name="Borrar" value="Borrar" class="btn btn-danger"/>
                                <input type="submit" id="idVolver" name="Volver" value="Volver" class="btn btn-light"/>
                            </div>
                            <hr/>
                        </form>
                        <h3><span class="fa fa-newspaper-o" style="font-size:72px;"></span> Archivos de publicacion:</h3>
                        <div class="bg-light text-right">
                            <a href="#" class="" data-toggle="collapse" data-target="#dvTabFiles">Ver/ocultar archivos</a>                        
                        </div>
                        <div id="dvTabFiles" class="collapse">
                            <table id="tbFiles" class="table">
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
                        <form class="container" id="idFrmArchivos" name="frmArchivos" action="" method="POST">
                            <input type="File" id="idFile" name="file"/>
                            <input type="submit" id="idAgregar" name="Agregar" value="Agregar" class="btn btn-success"/>
                        </form>
                    </div>
                </div>
                <div class="col-sm-3">
                    <form id="idFrmComentarios" name="frmComentarios" action="" method="">
                        <div class="form-group">
                            <label for="idMensaje" >Comentario:</label>
                            <input class="form-control" type="text" id="idMensaje" name="mensaje"/>    
                        </div>
                        <div class="form-group text-right">
                        <input type="submit" id="idAgregarMsj" name="AgregarMsj" value="Enviar mensaje" class="btn btn-light"/>
                        </div>
                        <textarea id="idComentarios" name="comentarios" class="form-control" style="height: 500px;width: 100%;">
                        
                        </textarea>

                    </form>

                </div>
            </div>
        </div>

        <div class="jumbotron text-center" style="margin-bottom:0">
            <p>Footer</p>
        </div>

    </body>
</html>
