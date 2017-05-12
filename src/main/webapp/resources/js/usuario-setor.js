var manageMemberTable;
var x = 1;    $(document).ready(function() {




    
    
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
                                                obj.setores,
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
                                        
                                        
                                        
					
				
		
                                $("#editNome").val(obj.nome);
                                
                                
                                var number = obj.setores.length;
                                var container = document.getElementById("container");
                                var container2 = document.getElementById("container2");  
                                while (container.hasChildNodes()) {
                                    container.removeChild(container.lastChild);
                                }
                                while (container2.hasChildNodes()) {
                                    container2.removeChild(container2.lastChild);
                                }
                                for (i=0;i<number;i++){                                    
                                    var input = document.createElement("input");
                                    var button = document.createElement("input");
                                    container2.appendChild(document.createElement("br"));
                                    container.appendChild(document.createElement("br"));
                                    input.type = "text";
                                    input.value = obj.setores[i];
                                    input.name = "obj.setores[]";
                                    input.className = "form-control";
                                    input.setAttribute('readonly',true);
                                    container.appendChild(input);                                    
                                                                     
                                    
                                    button.type = "button";
                                    button.value = "Remover";
                                    button.name = obj.setores[i];
                                    button.className = "btn btn-danger";
                                    container2.appendChild(button);
                                    
                                    container2.appendChild(document.createElement("br"));
                                    container2.appendChild(document.createElement("br"));
                                    container.appendChild(document.createElement("br"));
                                }                              
                                
                                
                                
								

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

//Adicionar Setor!

function addMember(id) {
	             
                
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
                                        
                                        
                                        
					
				
		
                                $("#editNome").val(obj.nome);
                                
                                
                                var number = obj.setores.length;
                                var container = document.getElementById("container");
                                var container2 = document.getElementById("container2");  
                                while (container.hasChildNodes()) {
                                    container.removeChild(container.lastChild);
                                }
                                while (container2.hasChildNodes()) {
                                    container2.removeChild(container2.lastChild);
                                }
                                for (i=0;i<number;i++){                                    
                                    var input = document.createElement("input");
                                    var button = document.createElement("input");
                                    container2.appendChild(document.createElement("br"));
                                    container.appendChild(document.createElement("br"));
                                    input.type = "text";
                                    input.value = obj.setores[i];
                                    input.name = "obj.setores[]";
                                    input.className = "form-control";
                                    input.setAttribute('readonly',true);
                                    container.appendChild(input);                                    
                                                                     
                                    
                                    button.type = "button";
                                    button.value = "Remover";
                                    button.name = obj.setores[i];
                                    button.className = "btn btn-danger";
                                    container2.appendChild(button);
                                    
                                    container2.appendChild(document.createElement("br"));
                                    container2.appendChild(document.createElement("br"));
                                    container.appendChild(document.createElement("br"));
                                }                              
                                
                                
                                
								

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
                                
                                
				});
                        }); 
                        
			} // /success
		
                });// /fetch selected member info
              
}





    