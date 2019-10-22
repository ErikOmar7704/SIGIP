<%@include file="\plantilla\header.jsp" %>
                <div class="col-sm-8">
                    <div class="container panel-body mb-4">
                        <h1><span class="fab fa-buromobelexperte" style="font-size:72px;"></span> Datos de áreas</h1>
                        <form class="form-vertical" id="idFrmAreas" name="frmAreas" action="" method="POST">
                            <!--cuadro combinado-->
                            <div class="form-group text-right">
                                <label for="idSuperior" >Área Superior:</label>
                                <select id="idSuperior" name="superior" class="form-control-md" style="width: 200px">
                                    <option value="0" selected="true">Ninguna</option>
                                </select>
                            </div>
                            <!--caja de texto-->
                            <div class="form-group">
                                <label for="idNameArea" >Nombre de Área:</label>
                                <input id="idNameArea" name="nombreArea" type="text" class="form-control"/>
                            </div>
                            <!--caja de texto-->
                            <div class="form-group">
                                <label for="idCorto" >Nombre Corto de Area:</label>
                                <input id="idCorto" name="nombreCorto" type="text" class="form-control"/>
                            </div>

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
