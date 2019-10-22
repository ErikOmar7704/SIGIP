<%@include file="\plantilla\header.jsp" %>
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
<%@include file="\plantilla\footer.jsp" %>
