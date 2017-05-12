<%-- 
    Document   : cadastroUsuarioSetor
    Created on : 04/05/2017, 10:13:46
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
<script src="../resources/js/usuario-setor.js"></script> 
 
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-12">

				<center><h1 class="page-header">Vinculo de Usuários por Setor </h1> </center>

				<div class="removeMessages"></div>
				

				<br /> <br /> <br />

				<table class="table" id="manageMemberTable">					
					<thead>
						<tr>
							<th>Usuário</th>
                                                        <th>Setores Vinculados</th>
                                                        <th>Ação</th>
							
						</tr>
					</thead>
				</table>
			</div>
		</div>
	</div>

	<!-- add modal -->
	
	<!-- /add modal -->

	

	<!-- edit modal -->
	<div class="modal fade" tabindex="-1" role="dialog" id="editMemberModal">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">	        
	        <h4 class="modal-title"><span class="glyphicon glyphicon-edit"></span> Editar Usuário</h4>                
	      </div>

		<form class="form-horizontal" action="atualizar" method="POST" id="updateMemberForm" >	      

                    <div class="modal-body">
                        
                        <div class="edit-messages"></div>
                          <div class="form-group"> <!--/here teh addclass has-error will appear -->
                          <label for="editNome" class="col-sm-2 control-label">Usuário</label>
                          <div class="col-sm-10"> 
                            <input type="text" class="form-control" id="editNome" name="nome" placeholder="Usuário" readonly>
                              <!-- here the text will apper  -->
                          </div>                      
                          
                          
                          </div>
                        
                        <h4 class="modal-title" >Setores Vinculados <button id="add" class="btn btn-info" type="button">Add Setor</button></h4> 
                        
                        <div class="form-group">
                            
                            <label for="editNome" class="col-sm-2 control-label"></label>
                            <div class="col-sm-8" id="container">
                                
                            </div>
                            <div id="container2" class="col-sm-2"/>
                            <br>  
                            <div id="fieldw"></div>
                        </div>   <!--/here teh addclass has-error will appear -->         
                    
                    <div class="modal-footer editMemberModal">
                        <br><br><br><br><br><br>
                        <button type="button" class="btn btn-default" id="modal"  data-modal="modal" data-dismiss="modal">Fechar</button>
                        <button type="submit" class="btn btn-primary" > Salvar alterações</button>
                    </div>
                    </form>

                   
                        
	      
	      
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div>
        </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	<!-- /edit modal -->
        
        <!-- /VINCULAR SETOR -->
        
        <div class="modal fade" tabindex="-1" role="dialog" id="editMemberModal">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">	        
	        <h4 class="modal-title"><span class="glyphicon glyphicon-edit"></span> Vincular Setor</h4>                
	      </div>

		<form class="form-horizontal" action="atualizar" method="POST" id="updateMemberForm" >	      

                    <div class="modal-body">
                        
                        <div class="edit-messages"></div>
                          <div class="form-group"> <!--/here teh addclass has-error will appear -->
                          <label for="editNome" class="col-sm-2 control-label">Usuário</label>
                          <div class="col-sm-10"> 
                            <input type="text" class="form-control" id="editNome" name="nome" placeholder="Usuário" readonly>
                              <!-- here the text will apper  -->
                          </div>                      
                          
                          
                          </div>
                        
                        <h4 class="modal-title" >Setores Vinculados <button id="add" class="btn btn-info" type="button">Add Setor</button></h4> 
                        
                        <div class="form-group">
                            
                            <label for="editNome" class="col-sm-2 control-label"></label>
                            <div class="col-sm-8" id="container">
                                
                            </div>
                            <div id="container2" class="col-sm-2"/>
                            <br>  
                            <div id="fieldw"></div>
                        </div>   <!--/here teh addclass has-error will appear -->         
                    
                    <div class="modal-footer editMemberModal">
                        <br><br><br><br><br><br>
                        <button type="button" class="btn btn-default" id="modal"  data-modal="modal" data-dismiss="modal">Fechar</button>
                        <button type="submit" class="btn btn-primary" > Salvar alterações</button>
                    </div>
                    </form>

                   
                        
	      
	      
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div>
        </div><!-- /.modal-dialog -->
	</div>

	
</body>

</html>

