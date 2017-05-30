<%-- 
    Document   : cadastroInformacao
    Created on : 25/05/2017, 10:30:02
    Author     : Marcus Vinícius <vinimarcus02@gmail.com>
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <script src="../resources/js/jquery.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.12/datatables.min.js"></script>
        <link href="../resources/css/bootstrap.min.css" rel="stylesheet"> 
        <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.min.css">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.12/datatables.min.css"/>  
        <script src="../resources/js/bootstrap.min.js"></script>
        <script src="../resources/js/dado-indicador.js"></script>
    </head>
    <body>
        <div class="container">
		<div class="row">
			<div class="col-md-12">

				<center><h1 class="page-header">Gerenciamento de Usuários </h1> </center>

				<div class="removeMessages"></div>

				<button class="btn btn-default pull pull-right" data-toggle="modal" data-target="#addMember" id="addMemberModalBtn">
					<span class="glyphicon glyphicon-plus-sign"></span>	Adicionar Informação
				</button>

				<br /> <br /> <br />

				<table class="table" id="manageMemberTable">					
					<thead>
						<tr>
							<th>Cabeçalho</th>
                                                        <th>Setor</th>
                                                        <th>Competência</th>                                                        
							<th>Indicador</th>	
                                                        <th>Informação</th>
                                                        <th>Feito Por</th>
                                                        <th>Status</th>
                                                        <th>Ação</th>
							
						</tr>
					</thead>
				</table>
			</div>
		</div>
	</div>

	<!-- add modal -->
	<div class="modal fade" tabindex="-1" role="dialog" id="addMember">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title"><span class="glyphicon glyphicon-plus-sign"></span>	Adicionar Usuário</h4>
	      </div>
	      
                <form class="form-horizontal" action="cadastrar" method="POST" id="createMemberForm" onsubmit="recarregar()">

	      <div class="modal-body">
	      	<div class="messages"></div>

                        <div class="form-group"> <!--/here teh addclass has-error will appear -->
                         <label for="idUsuario" class="col-sm-2 control-label">Usuário</label>
                         <div class="col-sm-10">                              
                           <select id="idUsuario" class="form-control" name="idUsuario"></select>
                           <script>
                               $.getJSON("listarUsuariosAtivos", function(result) { 
                                    var options = $("#idUsuario"); 
                                    $.each(result, function(ind, item) { 
                                        $('#idUsuario').append($('<option>', { 
                                            value: item.id,
                                            text : item.nome 
                                        }));                                        
                                    }); 
                                }); 
                           </script>
                         </div>
                        </div>
                        <div class="form-group"> <!--/here teh addclass has-error will appear -->
                         <label for="idSetor" class="col-sm-2 control-label">Setor</label>
                         <div class="col-sm-10">                              
                           <select id="idSetor" class="form-control" name="idSetor"></select>
                           <script>
                               $.getJSON("listarSetoresAtivos", function(result) { 
                                    var options = $("#idSetor"); 
                                    $.each(result, function(ind, item) { 
                                        $('#idSetor').append($('<option>', { 
                                            value: item.id,
                                            text : item.nome 
                                        }));                                        
                                    }); 
                                }); 
                           </script>
                         </div>
                        </div>
                        <div class="form-group"> <!--/here teh addclass has-error will appear -->
                         <label for="idCompetencia" class="col-sm-2 control-label">Competência</label>
                         <div class="col-sm-10">                              
                           <select id="idCompetencia" class="form-control" name="idCompetencia"></select>
                           <script>
                               $.getJSON("listarCompetenciasAtivas", function(result) { 
                                    var options = $("#idCompetencia"); 
                                    $.each(result, function(ind, item) { 
                                        $('#idCompetencia').append($('<option>', { 
                                            value: item.id,
                                            text : item.nome 
                                        }));                                        
                                    }); 
                                }); 
                           </script>
                         </div>
                        </div>
                       <div class="form-group"> <!--/here teh addclass has-error will appear -->
                         <label for="idCabecalho" class="col-sm-2 control-label">Cabeçalho</label>
                         <div class="col-sm-10">                              
                           <select id="idCabecalho" class="form-control" name="idCabecalho"></select>
                           <script>
                               $.getJSON("listarCabecalhosAtivos", function(result) { 
                                    var options = $("#idCabecalho"); 
                                    $.each(result, function(ind, item) { 
                                        $('#idCabecalho').append($('<option>', { 
                                            value: item.id,
                                            text : item.nome 
                                        }));                                        
                                    }); 
                                }); 
                           </script>
                         </div>
                        </div>
                        
                         <div class="form-group"> <!--/here teh addclass has-error will appear -->
                         <label for="nome" class="col-sm-2 control-label">Indicador</label>
                         <div class="col-sm-10">                              
                           <select id="nome" class="form-control" name="idIndicador"></select>
                           <script>
                               $.getJSON("listarIndicadoresAtivos", function(result) { 
                                    var options = $("#nome"); 
                                    $.each(result, function(ind, item) { 
                                        $('#nome').append($('<option>', { 
                                            value: item.id,
                                            text : item.nome 
                                        }));                                        
                                    }); 
                                }); 
                           </script>
                         </div>
                        </div>
                        <div class="form-group"> <!--/here teh addclass has-error will appear -->
			    <label for="ativo" class="col-sm-2 control-label">Status</label>
			    <div class="col-sm-10"> 
                                <select class="form-control" id="ativo" name="ativo"id="ativo">
                                <option value="true" selected="selected">Ativo</option>
                                <option value="false">Inativo</option>                                
                              </select>
			    </div>
			  </div>
                         <div class="form-group"> <!--/here teh addclass has-error will appear -->
                          <label for="informacao" class="col-sm-2 control-label">Informação</label>
                          <div class="col-sm-10"> 
                            <input type="text" class="form-control" id="informacao" name="informacao" placeholder="Informação">
                              <!-- here the text will apper  -->
                          </div>
                        </div>
			  		

	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" id="modal" data-modal="modal" data-dismiss="modal">Fechar</button>
	        <button type="submit" class="btn btn-primary">Salvar Alterações</button>
	      </div>
	      </form> 
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	<!-- /add modal -->

	

	<!-- edit modal -->
	<div class="modal fade" tabindex="-1" role="dialog" id="editMemberModal">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title"><span class="glyphicon glyphicon-edit"></span> Editar Informação</h4>
	      </div>

		<form class="form-horizontal" action="atualizar" method="POST" id="updateMemberForm" >	      

                    <div class="modal-body">

                        <div class="edit-messages"></div>
                          <div class="form-group"> <!--/here teh addclass has-error will appear -->
                         <label for="editIdUsuario" class="col-sm-2 control-label">Usuário</label>
                         <div class="col-sm-10">                              
                           <select id="editIdUsuario" class="form-control" name="idUsuario"></select>
                           <script>
                               $.getJSON("../usuario/listar", function(result) { 
                                    var options = $("#editIdUsuario"); 
                                    $.each(result, function(ind, item) { 
                                        $('#editIdUsuario').append($('<option>', { 
                                            value: item.id,
                                            text : item.nome 
                                        }));                                        
                                    }); 
                                }); 
                           </script>
                         </div>
                        </div>
                        <div class="form-group"> <!--/here teh addclass has-error will appear -->
                         <label for="editIdSetor" class="col-sm-2 control-label">Setor</label>
                         <div class="col-sm-10">                              
                           <select id="editIdSetor" class="form-control" name="idSetor"></select>
                           <script>
                               $.getJSON("../setor/listar", function(result) { 
                                    var options = $("#editIdSetor"); 
                                    $.each(result, function(ind, item) { 
                                        $('#editIdSetor').append($('<option>', { 
                                            value: item.id,
                                            text : item.nome 
                                        }));                                        
                                    }); 
                                }); 
                           </script>
                         </div>
                        </div>
                        <div class="form-group"> <!--/here teh addclass has-error will appear -->
                         <label for="editIdCompetencia" class="col-sm-2 control-label">Competência</label>
                         <div class="col-sm-10">                              
                           <select id="editIdCompetencia" class="form-control" name="idCompetencia"></select>
                           <script>
                               $.getJSON("../competencia/listar", function(result) { 
                                    var options = $("#editIdCompetencia"); 
                                    $.each(result, function(ind, item) { 
                                        $('#editIdCompetencia').append($('<option>', { 
                                            value: item.id,
                                            text : item.nome 
                                        }));                                        
                                    }); 
                                }); 
                           </script>
                         </div>
                        </div>
                       <div class="form-group"> <!--/here teh addclass has-error will appear -->
                         <label for="editIdCabecalho" class="col-sm-2 control-label">Cabeçalho</label>
                         <div class="col-sm-10">                              
                           <select id="editIdCabecalho" class="form-control" name="idCabecalho"></select>
                           <script>
                               $.getJSON("../cabecalho/listar", function(result) { 
                                    var options = $("#editIdCabecalho"); 
                                    $.each(result, function(ind, item) { 
                                        $('#editIdCabecalho').append($('<option>', { 
                                            value: item.id,
                                            text : item.nome 
                                        }));                                        
                                    }); 
                                }); 
                           </script>
                         </div>
                        </div>
                        
                         <div class="form-group"> <!--/here teh addclass has-error will appear -->
                         <label for="editIdIndicador" class="col-sm-2 control-label">Indicador</label>
                         <div class="col-sm-10">                              
                           <select id="editIdIndicador" class="form-control" name="idIndicador"></select>
                           <script>
                               $.getJSON("../indicador/listar", function(result) { 
                                    var options = $("#editIdIndicador"); 
                                    $.each(result, function(ind, item) { 
                                        $('#editIdIndicador').append($('<option>', { 
                                            value: item.id,
                                            text : item.nome 
                                        }));                                        
                                    }); 
                                }); 
                           </script>
                         </div>
                        </div>
                        <div class="form-group"> <!--/here teh addclass has-error will appear -->
			    <label for="editAtivo" class="col-sm-2 control-label">Status</label>
			    <div class="col-sm-10"> 
                                <select class="form-control" id="editAtivo" name="ativo" >
                                <option value="true" selected="selected">Ativo</option>
                                <option value="false">Inativo</option>                                
                              </select>
			    </div>
			  </div>
                         <div class="form-group"> <!--/here teh addclass has-error will appear -->
                          <label for="editInformacao" class="col-sm-2 control-label">Informação</label>
                          <div class="col-sm-10"> 
                            <input type="text" class="form-control" id="editInformacao" name="informacao" placeholder="Informação">
                              <!-- here the text will apper  -->
                          </div>
                        </div>
                        
                    </div>
                    <div class="modal-footer editMemberModal">
                        <button type="button" class="btn btn-default" id="modal"  data-modal="modal" data-dismiss="modal">Fechar</button>
                        <button type="submit" class="btn btn-primary" > Salvar alterações</button>
                    </div>
                    </form>

                   
                        
	      
	      
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	<!-- /edit modal -->

    </body>
</html>
