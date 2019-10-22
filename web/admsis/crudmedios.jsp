<%@include file="\plantilla\header.jsp" %>
                <div class="col-sm-8">
                    <div class="container panel-body mb-4">
                        <h1><span class="fas fa-share-alt" style="font-size:72px;"></span> Datos de medios de publicación</h1>
                        <form class="form-vertical" id="idFrmAreas" name="frmMedios" action="" method="POST">
                            <div class="form-group text-right">
                                <label for="idEditor" >Responsable de medio:</label>
                                <select id="idEditor" name="editor" class="form-control-md" style="width: 200px">
                                    <option value="">Ninguno</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="idNombreM" >Nombre del medio de publicación:</label>
                                <input id="idNombrem" name="nombreM" type="text" class="form-control"/>
                            </div>
                            <div class="form-group">
                                <label for="idUbicaciob" >Dirección (URL):</label>
                                <input id="idUbicacion" name="ubicacion" type="url" class="form-control"/>
                            </div>
                            <div class="form-group">
                                <label for="idCuenta" >Cuenta de usuario:</label>
                                <input id="idCuenta" name="cuenta" type="text" class="form-control"/>
                            </div>
                            <div class="form-group">
                                <label for="idPass" >Contraseña:</label>
                                <input id="idPass" name="pass" type="text" class="form-control"/>
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
<%@include file="\plantilla\footer.jsp" %>
