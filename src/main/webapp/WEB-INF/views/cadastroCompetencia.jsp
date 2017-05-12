<%-- 
    Document   : cadastroCompetencia
    Created on : 03/05/2017, 20:07:06
    Author     : vinim
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> <!-- ENCODING HTML 5, necessary for bootstrap -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Example Application Spring and Bootstrap</title>
 
 
<script src="../resources/js/jquery.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.12/datatables.min.js"></script>
<link href="../resources/css/bootstrap-datepicker.min.css" rel="stylesheet"> 
<link href="../resources/css/bootstrap.min.css" rel="stylesheet"> 
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.12/datatables.min.css"/>  
<script src="../resources/js/bootstrap.min.js"></script>
<script src="../resources/js/bootstrap-datepicker.min.js"></script>
<script src="../resources/js/bootstrap-datepicker.pt-BR.min.js"></script>

<script>
    var manageMemberTable;

$(document).ready(function() {
	manageMemberTable = $("#manageMemberTable").DataTable({
                "oLanguage": {
                    "sProcessing":   "Processando...",
                    "sLengthMenu":   "Mostrar _MENU_ registros",
                    "sZeroRecords":  "Não foram encontrados resultados",
                    "sInfo":         "Mostrando de _START_ até _END_ de _TOTAL_ registros",
                    "sInfoEmpty":    "Mostrando de 0 até 0 de 0 registros",
                    "sInfoFiltered": "",
                    "sInfoPostFix":  "",
                    "sSearch":       "Buscar:",
                    "sUrl":          "",
                    "oPaginate": {
                        "sFirst":    "Primeiro",
                        "sPrevious": "Anterior",
                        "sNext":     "Seguinte",
                        "sLast":     "Último"
                    }
                },
		"autoWidth": false,	
		"ajax": {
			"url": "listar",
			"type": "GET",
			"success" :  function(data){
				$.each(data, function(ind, obj){
					
                                        if (obj.ativo == true){
                                            obj.ativo = "Ativo";
                                        }
                                        if (obj.ativo == false){
                                            obj.ativo = "Inativo";
                                        }
					manageMemberTable.row.add([
											
						obj.nome,
                                                obj.ativo,
                                                obj.descricao,
                                                obj.dataIni,
                                                obj.dataFim,
                                                "<button type='button' value='"+obj.id+"'id='"+obj.id+"' data-target='#editMemberModal' onclick='editMember(id);'><span class='glyphicon glyphicon-edit'></span></button>"
					]).draw();
				});
			}
	}
    });

	$("#addMemberModalBtn").on('click', function() {
		// reset the form 
		$("#createMemberForm")[0].reset();
		// remove the error 
		$(".form-group").removeClass('has-error').removeClass('has-success');
		$(".text-danger").remove();
		// empty the message div
		$(".messages").html("");
                
                $('#dataIni').datepicker({
                    format: "dd/mm/yyyy",
                    locale: 'pt-BR'
                }); 
                
               
		// submit form
		$("#createMemberForm").unbind('submit').bind('submit', '.table', function(e) {

			$(".text-danger").remove();

			var form = $(this);

			// validation
			var nome = $("#nome").val();			

			if(nome == "") {
				$("#nome").closest('.form-group').addClass('has-error');
				$("#nome").after('<p class="text-danger">The Name field is required</p>');
			} else {
				$("#nome").closest('.form-group').removeClass('has-error');
				$("#nome").closest('.form-group').addClass('has-success');				
			}
			

			if(nome) {
				//submi the form to server
				$.ajax({
					url : form.attr('action'),
					type : form.attr('method'),
					data : form.serialize(),
					dataType : 'json',
					success:function(response) {

						// remove the error 
						$(".form-group").removeClass('has-error').removeClass('has-success');

						if(response.success == true) {
							$(".messages").html('<div class="alert alert-success alert-dismissible" role="alert">'+
							  '<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>'+
							  '<strong> <span class="glyphicon glyphicon-ok-sign"></span> </strong>'+response.messages+
							'</div>');

							// reset the form
							$("#createMemberForm")[0].reset();		

							// reload the datatables
							
							// this function is built in function of datatables;

						} else {
							$(".messages").html('<div class="alert alert-warning alert-dismissible" role="alert">'+
							  '<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>'+
							  '<strong> <span class="glyphicon glyphicon-exclamation-sign"></span> </strong>'+response.messages+
							'</div>');
						}  // /else
                               
					} // success  
				}); // ajax subit
                                
			} /// if

                        manageMemberTable.clear().draw();                                
                        manageMemberTable.ajax.reload();
                        e.preventDefault();
                        jQuery(function(){   
                        jQuery('#modal').click();
                        location.reload();
                        });
			
		}); // /submit form for create member
	}); // /add modal

});



function editMember(id) {
	             
                
		// remove the error 
		$(".form-group").removeClass('has-error').removeClass('has-success');
		$(".text-danger").remove();
		// empty the message div
		$(".edit-messages").html("");

		// remove the id
		$("#id").remove();

		// fetch the member data
		$.ajax({
			url: 'consultarPorId',
			type: 'get',
			data: {id : id},
			dataType: 'json',
			"success" :  function(response){
				$.each(response, function(ind, obj){
					
					
											
					var nome = obj.nome;
                                        
                                        if (obj.ativo == true){
                                            document.getElementById("editAtivo").selectedIndex = "0";
                                        }
                                        if (obj.ativo == false){
                                            document.getElementById("editAtivo").selectedIndex = "1";
                                        }  
					
				
		
                                $("#editNome").val(obj.nome);
                                
                                
								

				// mmeber id 
				$(".editMemberModal").append('<input type="hidden" name="id" id="id" value="'+id+'"/>');
                                $("#editMemberModal").modal('show');
				// here update the member data
				$("#updateMemberForm").unbind('submit').bind('submit', '.table', function(e) {
					// remove error messages
					$(".text-danger").remove();

					var form = $(this);

					// validation
					var editNome = $("#editNome").val();
					

					if(editNome == "") {
						$("#editNome").closest('.form-group').addClass('has-error');
						$("#editNome").after('<p class="text-danger">The Name field is required</p>');
					} else {
						$("#editNome").closest('.form-group').removeClass('has-error');
						$("#editNome").closest('.form-group').addClass('has-success');				
					}

					

					if(editNome) {
						$.ajax({
							url: form.attr('action'),
							type: form.attr('method'),
							data: form.serialize(),
							dataType: 'json',
							success:function(response) {
								if(response.success == true) {
									$(".edit-messages").html('<div class="alert alert-success alert-dismissible" role="alert">'+
									  '<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>'+
									  '<strong> <span class="glyphicon glyphicon-ok-sign"></span> </strong>'+response.messages+
									'</div>');

									// reload the datatables
									
									// this function is built in function of datatables;

									// remove the error 
									$(".form-group").removeClass('has-success').removeClass('has-error');
									$(".text-danger").remove();
                                                                        
                                                                        
                                                                        
								} else {
									$(".edit-messages").html('<div class="alert alert-warning alert-dismissible" role="alert">'+
									  '<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>'+
									  '<strong> <span class="glyphicon glyphicon-exclamation-sign"></span> </strong>'+response.messages+
									'</div>')
								}
                                                                
							}
                                                       // /success
						}); // /ajax
                                                 
					} // /if
                                manageMemberTable.clear().draw();                                
                                manageMemberTable.ajax.reload();
				e.preventDefault();
                                jQuery(function(){   
                                jQuery('#modal').click();
                                location.reload();
                                }); 
                                
				});
                        }); 
                        
			} // /success
		
                });// /fetch selected member info
              
}


   
</script>

 
 
 
 
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-12">

				<center><h1 class="page-header">Gerenciamento de Competencias </h1> </center>

				<div class="removeMessages"></div>

				<button class="btn btn-default pull pull-right" data-toggle="modal" data-target="#addMember" id="addMemberModalBtn">
					<span class="glyphicon glyphicon-plus-sign"></span>	Adicionar Competencia
				</button>

				<br /> <br /> <br />

				<table class="table" id="manageMemberTable">					
					<thead>
						<tr>
							<th>Competencia</th>	
							<th>Status</th>	
                                                        <th>Descrição</th>	
                                                        <th>Início</th>
                                                        <th>Fim</th>
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
	        <h4 class="modal-title"><span class="glyphicon glyphicon-plus-sign"></span>	Adicionar Competencia</h4>
	      </div>
	      
	      <form class="form-horizontal" action="cadastrar" method="POST" id="createMemberForm" >

	      <div class="modal-body">
	      	<div class="messages"></div>

			  <div class="form-group"> <!--/here teh addclass has-error will appear -->
			    <label for="name" class="col-sm-2 control-label">Competencia</label>
			    <div class="col-sm-10"> 
			      <input type="text" class="form-control" id="nome" name="nome" placeholder="Competencia">
				<!-- here the text will apper  -->
			    </div>
			  </div>
                            <div class="form-group"> <!--/here teh addclass has-error will appear -->
			    <label for="name" class="col-sm-2 control-label">Status</label>
			    <div class="col-sm-10"> 
			      <select class="form-control" id="ativo" name="ativo"id="ativo">
                                <option value="true" selected="selected">Ativo</option>
                                <option value="false">Inativo</option>                                
                              </select>
			    </div>
			  </div>
                            <div class="form-group"> <!--/here teh addclass has-error will appear -->
                                <label for="descricao" class="col-sm-2 control-label">Descrição</label>
                                <div class="col-sm-10"> 
                                    <input type="text" class="form-control" id="descricao" name="descricao" placeholder="Descrição">
                                    <!-- here the text will apper  -->
                                </div>
			  </div>
                            <div class="form-group"> <!--/here teh addclass has-error will appear -->
                                <label for="dataIni" class="col-sm-2 control-label">Início</label>
                                <div class="col-sm-10"> 
                                  <input type="text" class="form-control" id="dataIni" name="dataIni" placeholder="Início" >
                                    <!-- here the text will apper  -->
                                </div>
                            </div>
                            <div class="form-group"> <!--/here teh addclass has-error will appear -->
                                <label for="dataFim" class="col-sm-2 control-label">Fim</label>
                                <div class="col-sm-10"> 
                                  <input type="text" class="form-control" id="dataFim" name="dataFim" placeholder="Fim" pattern="[0-3][0-9]/[0-1][0-9]/[0-9][0-9][0-9][0-9]">
                                    <!-- here the text will apper  -->
                                </div>
                            </div>
			  		

	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-modal="modal" data-dismiss="modal">Fechar</button>
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
	        <h4 class="modal-title"><span class="glyphicon glyphicon-edit"></span> Editar Competencia</h4>
	      </div>

		<form class="form-horizontal" action="atualizar" method="POST" id="updateMemberForm" >	      

                    <div class="modal-body">

                        <div class="edit-messages"></div>

                        <div class="form-group"> <!--/here teh addclass has-error will appear -->
                          <label for="editNome" class="col-sm-2 control-label">Competencia</label>
                          <div class="col-sm-10"> 
                            <input type="text" class="form-control" id="editNome" name="nome" placeholder="Competencia">
                              <!-- here the text will apper  -->
                          </div>
                        </div>
                        <div class="form-group"> <!--/here teh addclass has-error will appear -->
                            <label for="name" class="col-sm-2 control-label">Status</label>
                            <div class="col-sm-10"> 
                              <select class="form-control" id="editAtivo" name="ativo">
                                <option value="true" >Ativo</option>
                                <option value="false">Inativo</option>                                
                              </select>
                            </div>
                        </div>
                         <div class="form-group"> <!--/here teh addclass has-error will appear -->
                                <label for="editDescricao" class="col-sm-2 control-label">Descrição</label>
                                <div class="col-sm-10"> 
                                    <input type="text" class="form-control" id="editDescricao" name="descricao" placeholder="Descrição">
                                    <!-- here the text will apper  -->
                                </div>
			  </div>
                            <div class="form-group"> <!--/here teh addclass has-error will appear -->
                                <label for="editDataIni" class="col-sm-2 control-label">Início</label>
                                <div class="col-sm-10"> 
                                  <input type="date" class="form-control" id="editDataIni" name="dataIni" placeholder="Início">
                                    <!-- here the text will apper  -->
                                </div>
                            </div>
                            <div class="form-group"> <!--/here teh addclass has-error will appear -->
                                <label for="editDataFim" class="col-sm-2 control-label">Fim</label>
                                <div class="col-sm-10"> 
                                  <input type="data" class="form-control" id="editDataFim" name="dataFim" placeholder="Fim">
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
