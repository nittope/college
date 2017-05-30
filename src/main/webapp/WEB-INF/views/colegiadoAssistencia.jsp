<%-- 
    Document   : colegiadoAssistencia
    Created on : 30/05/2017, 11:24:00
    Author     : Marcus Vinícius <vinimarcus02@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
		
        <meta name="description" content="HTML, CSS and jQuery plugin to create an off canvas layout for web apps or websites" />
        <meta name="keywords" content="off canvas, offcanvas, app, webapp, web app" />

        <link rel="stylesheet" href="../resources/css/offcanvas.css" />
        <link rel="icon" type="image/x-icon" href="favicon.ico" />

        <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
         <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300|Material+Icons' rel='stylesheet' type='text/css'>




        <script src="../resources/js/modernizr.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script src="../resources/js/jquery.offcanvas.min.js"></script>
        <script>
                jQuery(document).ready(function($) {
                        $('html').offcanvas({
                                hasSidebarRight: true
                        });
                });
        </script>
    </head>
    <body>
        <aside id="sidebarLeft" class="sidebarLeft">
			<div class="scrollableArea">
				<!-- Place whatever HTML you want in here -->
				
				<a class="shutLeft" href="">&#10006;</a>
				
				<div class="you padded">
					<a href="#" ><img class="avatar" src="pictures/perf.jpg" alt="Aidan Zealley" width="50"/></a>
					<h2><a href="#" >Hospital Mestre Vitalino</a></h2>
				</div>
				<ul class="paddedLight">
					<li><a href="#"><span class="glyphicon glyphicon-dashboard"></span>	Dashboard</a></li>
				</ul>
			</div>
		</aside>
		
		<section id="page" class="page">
			<header class="topBar">
				<a id="leftBurger" class="slideRight" href="">&#9776;</a>
				<a id="rightBurger" class="slideLeft" href="">&#9776;</a>
				<h1>Colegiado Assistência</h1>
			</header>
			<div class="scrollableArea">
				<!-- Place whatever HTML you want in here -->
			<div class="floated padded">
						
				<div class="main-panel">       


        <div class="content">
            <div class="container-fluid">
                <div class="row">
                		
						
                    <div class="col-md-4">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Atendimentos por Motivo</h4>
                                <p class="category">Pesquisa feita com Keywords</p>
                            </div>
                            <div class="content">
                                <div id="chart-container">
                                    <canvas id="mycanvasmotivo"></canvas>           
                                </div>
                                
                            </div>
                        </div>
                    </div>

                    <div class="col-md-8">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Atendimentos Diários</h4>
                                <p class="category">Quantidade de atendimentos durante a semana por atendente</p>
                            </div>
                            <div class="content">
                                <div id="chart-container">
                                    <canvas id="mycanvasdiario"></canvas>           
                                </div>                                
                            </div>
                        </div>
                    </div>
                </div>



                <div class="row">
                    <div class="col-md-4">
                        <div class="card ">
                            <div class="header">
                                <h4 class="title">Ranking Semanal</h4>
                                <p class="category">Quantidade de chamados abertos durante a semana passada</p>
                            </div>
                            <div class="content">
                                <div id="chart-container">
                                     <canvas id="mycanvassemanal"></canvas>           
                                </div>
                                
                            </div>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="card ">
                            <div class="header">
                                <h4 class="title">Ranking Mensal</h4>
                                <p class="category">Quantidade de chamados abertos durante o mês vigente</p>
                            </div>
                            <div class="content">
                            <div id="chart-container"> 
                                <div id="chart-container">
                                    <canvas id="mycanvasmensal"></canvas>           
                                </div>
                            </div>                        
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="card ">
                            <div class="header">
                                <h4 class="title">Ranking Geral</h4>
                                <p class="category">Quantidade de chamados abertos de sempre por atendente</p>
                            </div>
                            <div class="content">
                            <div id="chart-container"> 
                                <div id="chart-container">
                                    <canvas id="mycanvasgeral"></canvas>           
                                </div>
                            </div>                        
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <footer class="footer">
            <div class="container-fluid">
                
                <p class="copyright pull-right">
                    &copy; <script>document.write(new Date().getFullYear())</script> 
                    Departamento de TI HMV|HTRI
                </p>
            </div>
        </footer>

    </div>
				
				
			</div>
			</div>
		
		</section>
		
		<aside id="sidebarRight" class="sidebarRight">
			<div class="scrollableArea">
				<!-- Place whatever HTML you want in here -->
				
				<a class="shutRight" href="">&#10006;</a>
				
				<div class="you padded">
					<a href="#" ><img class="avatar" src="pictures/perf.jpg" alt="Aidan Zealley" width="50"/></a>
					<h2><a href="#" >Equipe HMVTI</a></h2>
				</div>
				<ul class="paddedLight">
					<li><a href="#"><span class="glyphicon glyphicon-dashboard"></span>	Dashboard</a></li>
				</ul>
			</div>
		</aside>

		<script src="../resources/js/overthrow.js"></script>
		<script src="../resources/js/hammer.js"></script>
		<script src="../resources/js/jquery.hammer.js"></script>
		<script type="text/javascript">
			var _gaq = _gaq || [];
			_gaq.push(["_setAccount", "UA-32925625-1"]);
			_gaq.push(["_trackPageview"]);
			(function() {
				var ga = document.createElement("script"); ga.type = "text/javascript"; ga.async = true;
				ga.src = ("https:" == document.location.protocol ? "https://ssl" : "http://www") + ".google-analytics.com/ga.js";
				var s = document.getElementsByTagName("script")[0]; s.parentNode.insertBefore(ga, s);
			})();
		</script>
		<script type="text/javascript" src="assets/js/Chart.min.js"></script>
	    <script type="text/javascript" src="assets/js/geral.js"></script>
	    <script type="text/javascript" src="assets/js/semanal.js"></script>
	    <script type="text/javascript" src="assets/js/mensal.js"></script>
	    <script type="text/javascript" src="assets/js/diario.js"></script>
	    <script type="text/javascript" src="assets/js/motivo.js"></script>
	    <script type="text/javascript" src="assets/js/quantitativos.js"></script>
	   	<script type="text/javascript" src="assets/js/quantitativos2dias.js"></script>
	   	<script type="text/javascript" src="assets/js/quantitativos3.js"></script>
	   	<script type="text/javascript" src="assets/js/quantitativospda.js"></script>
    </body>
</html>
