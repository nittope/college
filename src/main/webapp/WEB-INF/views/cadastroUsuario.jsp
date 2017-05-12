<%-- 
    Document   : cadastroUsuario
    Created on : 27/04/2017, 08:50:44
    Author     : Marcus Vinícius <vinimarcus02@gmail.com>
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
<link href="../resources/css/bootstrap.min.css" rel="stylesheet"> 
<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.min.css">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.12/datatables.min.css"/>  
<script src="../resources/js/bootstrap.min.js"></script>
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
                                        
                                        if (obj.authority == 'ROLE_USER'){
                                            obj.authority = "Usuário Comum";
                                        }
                                        if (obj.authority == 'ROLE_ADMIN'){
                                            obj.authority = "Usuário Administrador";
                                        }
                                        
                                       
                                            
                                        
                                        
					manageMemberTable.row.add([
											
						obj.nome,
                                                obj.cpf,                                                
                                                obj.ativo,
                                                obj.authority, 
                                                obj.funcaoNome,
                                                "<button type='button' value='"+obj.id+"'id='"+obj.id+"' data-target='#editMemberModal' onclick='editMember(id);'><span class='glyphicon glyphicon-edit'></span></button>"
					]).draw();
                                        
				});
			}
	}
    });    
    
     function montarCombobox(){
        
         $.ajax({
                url: 'listarFuncoesAtivas',
                type: 'get',                
                dataType: 'json',
                "success" :  function(response){
                    
                    var combobox = $("#funcoes");

                    for (var i = 0; i < response.length; i++) {
                        combobox.append(
                                $('<option>', {value: response.id, text: response.nome})
                        );
                    }
                                            
                                    }
                                });
        
    }
    
   
    


	$("#addMemberModalBtn").on('click', function() {
		// reset the form 
		$("#createMemberForm")[0].reset();
		// remove the error 
		$(".form-group").removeClass('has-error').removeClass('has-success');
		$(".text-danger").remove();
		// empty the message div
		$(".messages").html("");

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
                                        var descricao = obj.descricao;
                                        
                                        
                                        if (obj.ativo == true){
                                            document.getElementById("editAtivo").selectedIndex = "0";
                                        }
                                        if (obj.ativo == false){
                                            document.getElementById("editAtivo").selectedIndex = "1";
                                        }
                                        
                                        if (obj.authority == 'ROLE_USER'){
                                            document.getElementById("editAuthority").selectedIndex = "0";
                                        }
                                        if (obj.authority == 'ROLE_ADMIN'){
                                            document.getElementById("editAuthority").selectedIndex = "1";
                                        }  
					
				
		
                                $("#editNome").val(obj.nome);
                                $("#editFuncao").val(obj.funcao);
                                $("#editCpf").val(obj.cpf);
                                $("#editSenha").val(obj.senha);
                                
                                
                                
                                
                                
								

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

				<center><h1 class="page-header">Gerenciamento de Usuários </h1> </center>

				<div class="removeMessages"></div>

				<button class="btn btn-default pull pull-right" data-toggle="modal" data-target="#addMember" id="addMemberModalBtn">
					<span class="glyphicon glyphicon-plus-sign"></span>	Adicionar Usuário
				</button>

				<br /> <br /> <br />

				<table class="table" id="manageMemberTable">					
					<thead>
						<tr>
							<th>Usuário</th>
                                                        <th>CPF</th>                                                        
							<th>Status</th>	
                                                        <th>Privilégio</th>
                                                        <th>Função</th>
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
                          <label for="nome" class="col-sm-2 control-label">Usuário</label>
                          <div class="col-sm-10"> 
                            <input type="text" class="form-control" id="nome" name="nome" placeholder="Usuário">
                              <!-- here the text will apper  -->
                          </div>
                        </div>
                        <div class="form-group"> <!--/here teh addclass has-error will appear -->
                         <label for="cpf" class="col-sm-2 control-label">CPF</label>
                         <div class="col-sm-10"> 
                           <input type="text" class="form-control" id="cpf" name="cpf" placeholder="CPF">
                             <!-- here the text will apper  -->
                         </div>
                       </div>
                        <div class="form-group"> <!--/here teh addclass has-error will appear -->
                         <label for="senha" class="col-sm-2 control-label">Senha</label>
                         <div class="col-sm-10"> 
                           <input type="password" class="form-control" id="senha" name="senha" placeholder="Senha">
                             <!-- here the text will apper  -->
                         </div>
                       </div>
                       <div class="form-group"> <!--/here teh addclass has-error will appear -->
			    <label for="authority" class="col-sm-2 control-label">Privilégio</label>
			    <div class="col-sm-10"> 
			      <select class="form-control" id="authority" name="authority">
                                <option value="ROLE_USER" selected="selected">Usuário Comum</option>
                                <option value="ROLE_ADMIN">Usuário Administrador</option>                                
                              </select>
			    </div>
			  </div>
                        <div class="form-group"> <!--/here teh addclass has-error will appear -->
                         <label for="idFuncao" class="col-sm-2 control-label">Função</label>
                         <div class="col-sm-10">                              
                           <select id="idFuncao" class="form-control" name="idFuncao"></select>
                           <script>
                               $.getJSON("listarFuncoesAtivas", function(result) { 
                                    var options = $("#idFuncao"); 
                                    $.each(result, function(ind, item) { 
                                        $('#idFuncao').append($('<option>', { 
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
	        <h4 class="modal-title"><span class="glyphicon glyphicon-edit"></span> Editar Usuário</h4>
	      </div>

		<form class="form-horizontal" action="atualizar" method="POST" id="updateMemberForm" >	      

                    <div class="modal-body">

                        <div class="edit-messages"></div>
                          <div class="form-group"> <!--/here teh addclass has-error will appear -->
                          <label for="editNome" class="col-sm-2 control-label">Usuário</label>
                          <div class="col-sm-10"> 
                            <input type="text" class="form-control" id="editNome" name="nome" placeholder="Usuário">
                              <!-- here the text will apper  -->
                          </div>
                        </div>
                        <div class="form-group"> <!--/here teh addclass has-error will appear -->
                         <label for="editCpf" class="col-sm-2 control-label">CPF</label>
                         <div class="col-sm-10"> 
                           <input type="text" class="form-control" id="editCpf" name="cpf" placeholder="CPF">
                             <!-- here the text will apper  -->
                         </div>
                       </div>
                         <div class="form-group"> <!--/here teh addclass has-error will appear -->
                         <label for="editSenha" class="col-sm-2 control-label">Senha</label>
                         <div class="col-sm-10"> 
                           <input type="password" class="form-control" id="editSenha" name="senha" placeholder="Senha">
                             <!-- here the text will apper  -->
                         </div>
                       </div>
                       <div class="form-group"> <!--/here teh addclass has-error will appear -->
			    <label for="editAuthority" class="col-sm-2 control-label">Privilégio</label>
			    <div class="col-sm-10"> 
			      <select class="form-control" id="editAuthority" name="authority">
                                <option value="ROLE_USER">Usuário Comum</option>
                                <option value="ROLE_ADMIN">Usuário Administrador</option>                                
                              </select>
			    </div>
			  </div>
                        <div class="form-group"> <!--/here teh addclass has-error will appear -->
                         <label for="editFuncao" class="col-sm-2 control-label">Função</label>
                         <div class="col-sm-10"> 
                          <select id="editFuncao" class="form-control" name="idFuncao"></select>
                           <script>
                               $.getJSON("listarFuncoesAtivas", function(resultedit) { 
                                    var options = $("#editFuncao"); 
                                    $.each(resultedit, function(i, item2) { 
                                        $('#editFuncao').append($('<option>', { 
                                            value: item2.id,
                                            text : item2.nome 
                                        }));                                        
                                    }); 
                                }); 
                           </script>
                         </div>
                        </div>
                            <div class="form-group"> <!--/here teh addclass has-error will appear -->
			    <label for="editAtivo" class="col-sm-2 control-label">Status</label>
			    <div class="col-sm-10"> 
			      <select class="form-control" id="editAtivo" name="ativo">
                                <option value="true" selected="selected">Ativo</option>
                                <option value="false">Inativo</option>                                
                              </select>
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

