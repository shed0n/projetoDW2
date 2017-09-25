<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="model.Computador, model.ComputadorDAO, java.util.List, java.util.ArrayList"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
</html>

  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Alteração de Patrimonio</title>

    <!-- Bootstrap core CSS -->
    <link href="./resourses/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap core JavaScript-->
    <script src="./resourses/js/jquery.min.js"></script>
    <script src="./resourses/js/bootstrap.min.js"></script>

    <!-- Custom styles for this template -->
    <link href="/resourses/css/home.css" rel="stylesheet">

  </head>
  
  
  <body>
    <div class="container"> 

      <!-- Static navbar -->
      <nav class="navbar navbar-default">
        <div class="container-fluid">
          <div class="navbar-header">
            <a class="navbar-brand" href="home.jsp">Patrimonios</a>
          </div>
       
            <ul class="nav navbar-nav">
              <li><a href="home.jsp">Lista de Patrimonios</a></li>
              <li><a href="relatorios.jsp">Relatórios</a></li>
            </ul>
      
            <form  method="post" action="./BuscaServlet" class="navbar-form navbar-left">
        	<div class="form-group">
          	<input id="busca" name="busca" type="text" class="form-control" placeholder="Buscar" required>
        	</div>
			<!-- Select Basic -->
			  	  <select id="situacao" name="situacao" class="form-control">
			      <option value="Ativo">Ativo</option>
			      <option value="Manutenção">Manutenção</option>
			      <option value="Inativo">Inativo</option>
			    </select>
        	<button type="submit" class="btn btn-default">Enviar</button>
      		</form>
      		
            <ul class="nav navbar-nav navbar-right">
              <li class="dropdown">
             	 <a class="dropdown-toggle" data-toggle="dropdown" href="#">Cadastrar
             	 <span class="caret"></span></a>
             	 <ul class="dropdown-menu">
             	 	<li><a href="cadastro.jsp">Patrimonio</a></li>
             	 	<li><a href="cadastro_responsavel.jsp">Responsavel</a></li>
             	 	<li><a href="cadastro_local.jsp">Setor</a></li>
              	</ul>
               </li>
               
              <li class="dropdown">
			  	<a class="dropdown-toggle" data-toggle="dropdown" href="#">${usuario.nome}
			    <span class="caret"></span></a>
			    <ul class="dropdown-menu">
			      <li><a href="alterar_senha.jsp">Alterar Senha</a></li>
			      <li><a href="Deslogar">Sair</a></li>
			    </ul>
      		  </li>
            </ul>
        </div><!--/.container-fluid -->
      </nav>

      <!-- Main component for a primary marketing message or call to action -->
      <div class="span12" style="text-align:center; margin: 0 auto;">
      <div class="jumbotron">

      <div class="row">
		<form class="form-inline" method="post" action="./AlterarComputador" class="form-horizontal" >
			<fieldset>
			<!-- Form Name -->
			<legend>Alteração de Dados</legend>
		   
		    
		  <div class="col-sm-3 col-md-6">
		    <div class="row">
		    <div class="form-group col-xs-5 col-md-2">
			  <label for="codigo">Codigo</label>
			  <input id="codigo" name="codigo" type="text"  class="form-control input-md" required readonly="true" value='<%=  request.getAttribute("codigo") %>' >
			  </div>
			</div>
			<br>
			
			<div class="row">
		    <div class="form-group col-xs-5 col-md-1">
			  <label  for="nome">Nome</label>
			  <input id="nome" name="nome" type="text"  class="form-control input-md" required value='<%= request.getAttribute("nome") %>' >
			  </div>
			</div>
			<br>
			
			<div class="row">
		    <div class="form-group col-xs-5 col-md-1">
			  <label  for="placamae">Placa Mãe</label>
			  <input id="placamae" name="placamae" type="text" placeholder="" class="form-control input-md" required value='<%= request.getAttribute("placamae")%>' >
			  </div>
			</div>
			<br>
			
			<div class="row">
		    <div class="form-group col-xs-5 col-md-2">
			  <label for="processador">Processador</label>
			  <input id="processador" name="processador" type="text" placeholder="" class="form-control input-md" required value='<%= request.getAttribute("processador")%>' >
			  </div>
			</div>
			<br>
			
		  </div>	
		
		  <div class="col-sm-9 col-md-6">	
		  			
			<div class="row">
		    <div class="form-group col-xs-5 col-md-2">
			  <label  for="memoria">Memória</label>
			  <input id="memoria" name="memoria" type="text" placeholder="" class="form-control input-md" required  value='<%= request.getAttribute("memoria")%>' >
			  </div>
			</div>
			<br>
		  
			<div class="row">
		    <div class="form-group col-xs-5 col-md-2">
			  <label for="hd">HD</label>
			  <input id="hd" name="hd" type="text" placeholder="" class="form-control input-md" required value='<%= request.getAttribute("hd")%>' >
			  </div>
			</div>
			<br>
			
			<div class="row">
		    <div class="form-group col-xs-5 col-md-2">
			  <label  for="placadevideo">Placa de Vídeo</label>
			  <input id="placadevideo" name="placadevideo" type="text" placeholder="" class="form-control input-md" required value='<%= request.getAttribute("placadevideo")%>' >
			  </div>
			</div>
			<br>
			
			<div class="row">
		    <div class="form-group col-xs-5 col-md-2">
			  <label  for="outros">Outros</label>
			  <input id="outros" name="outros" type="text" placeholder="" class="form-control input-md" required value='<%= request.getAttribute("outros")%>' >
			  </div>
			</div>
			
			<div class="row">
		    <div class="form-group col-xs-5 col-md-2">
			  <label  for="salvar"></label>
			  <button id="salvar" name="salvar"  class="btn btn-primary">Alterar</button>
			  </div>
			</div>
			<br>
				
		 </div>
			</fieldset>
		</form>
	 </div>	
     </div>
     </div>
   
    </div> <!-- /container -->
    
  </body>
</html>