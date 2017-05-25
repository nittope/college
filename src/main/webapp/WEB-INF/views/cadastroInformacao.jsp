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
    </head>
    <body>
        <div class="container">
		<div class="row">
			<div class="col-md-12">

				<center><h1 class="page-header">Gerenciamento de Informações </h1> </center>

				<div class="removeMessages"></div>

				<button class="btn btn-default pull pull-right" data-toggle="modal" data-target="#addMember" id="addMemberModalBtn">
					<span class="glyphicon glyphicon-plus-sign"></span>	Adicionar Informação
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
    </body>
</html>
