<%-- 
    Document   : index.jsp
    Created on : 02/04/2017, 11:35:19
    Author     : Marcus Vinícius <vinimarcus02@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Logo Nav - Start Bootstrap Template</title> 
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">  
    <link href="resources/css/logo-nav.css" rel="stylesheet">

   
</head>

<body>

  
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
           
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">
                    <img src="http://placehold.it/150x50&text=Logo" alt="">
                </a>
            </div>
            
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="funcao/cadastro">Função</a>
                    </li>
                    <li>
                        <a href="setor/view">Setor</a>
                    </li>
                    <li>
                        <a href="cabecalho/view">Cabeçalho</a>
                    </li> 
                    <li>
                        <a href="indicador/view">Indicador</a>
                    </li> 
                    <li>
                        <a href="usuario/view">Usuário</a>
                    </li>
                    <li>
                        <a href="usuario/usuarioSetor">Usuário Setor</a>
                    </li> 
                     <li>
                        <a href="competencia/view">Competencia</a>
                    </li> 
                    <li>
                        <a href="dadoIndicador/view">Add - Colegiado</a>
                    </li> 
                    
                </ul>
            </div>
            
        </div>
       
    </nav>

    
    <div class="container">
        <div class="row">
            <div class="col-lg-12"></div>
        </div>
    </div>
   
    <script src="resources/js/jquery.js"></script>

   
    <script src="resources/js/bootstrap.min.js"></script>

</body>
</html>
