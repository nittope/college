<%-- 
    Document   : funcao
    Created on : 03/04/2017, 18:27:21
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
					
					manageMemberTable.row.add([
											
						obj.nome,                                                
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

				<center><h1 class="page-header">Gerenciamento de Funções </h1> </center>

				<div class="removeMessages"></div>

				<button class="btn btn-default pull pull-right" data-toggle="modal" data-target="#addMember" id="addMemberModalBtn">
					<span class="glyphicon glyphicon-plus-sign"></span>	Adicionar Função
				</button>

				<br /> <br /> <br />

				<table class="table" id="manageMemberTable">					
					<thead>
						<tr>
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
	        <h4 class="modal-title"><span class="glyphicon glyphicon-plus-sign"></span>	Adicionar Função</h4>
	      </div>
	      
	      <form class="form-horizontal" action="cadastrar" method="POST" id="createMemberForm" >

	      <div class="modal-body">
	      	<div class="messages"></div>

			  <div class="form-group"> <!--/here teh addclass has-error will appear -->
			    <label for="name" class="col-sm-2 control-label">Função</label>
			    <div class="col-sm-10"> 
			      <input type="text" class="form-control" id="nome" name="nome" placeholder="Função">
				<!-- here the text will apper  -->
			    </div>
			  </div>
			  		

	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
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
	        <h4 class="modal-title"><span class="glyphicon glyphicon-edit"></span> Editar Função</h4>
	      </div>

		<form class="form-horizontal" action="atualizar" method="POST" id="updateMemberForm" >	      

                    <div class="modal-body">

                        <div class="edit-messages"></div>

                        <div class="form-group"> <!--/here teh addclass has-error will appear -->
                          <label for="editNome" class="col-sm-2 control-label">Função</label>
                          <div class="col-sm-10"> 
                            <input type="text" class="form-control" id="editNome" name="nome" placeholder="Função">
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


