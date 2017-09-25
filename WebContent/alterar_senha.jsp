<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Alterar Senha</title>

    <!-- Bootstrap core CSS -->
    <link href="./resourses/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap core JavaScript-->
    <script src="./resourses/js/jquery.min.js"></script>
    <script src="./resourses/js/bootstrap.min.js"></script>

    <!-- Custom styles for this template -->
    <link href="./resourses/css/home.css" rel="stylesheet">

  </head>

  <body>
   	<%
  		String mensagem = (String) request.getAttribute("mensagem");
		if (mensagem != null){
	  	out.print("<script>");
	    out.print("alert('"+ mensagem + "');");
	    out.print("</script>");
		}
    %>
		
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
		<form  method="post" action="./AlterarSenha" class="form-horizontal" >
			<fieldset>
			<!-- Form Name -->
			<legend>Alterar Senha</legend>

			<!-- Text input-->
			  <div class="form-group" >
			  <label class="col-md-4 control-label" for="Usuario">Usuario</label>
			  <div class="col-md-4">
     		  <input type="text" name="user" id="user" class="form-control"  required autofocus readonly="true" value="${usuario.nome}">
			  </div>
			  </div>
			
			<!-- Text input-->
			  <div class="form-group" >
			  <label class="col-md-4 control-label" for="nomeResponsavel">Digite a nova Senha</label>
			  <div class="col-md-4">
     		  <input type="password" name="password" id="password" class="form-control" placeholder="Senha" required autofocus>
			  </div>
			  </div>
			  
			  <!-- Text input-->
			  <div class="form-group" >
			  <label class="col-md-4 control-label" for="nomeResponsavel">Digite novamente a Senha</label>
			  <div class="col-md-4">
       		  <input type="password" name="confirm-password" id="confirm-password" class="form-control" placeholder="Confirmar Senha" required>
			  </div>
			  </div>
			
			<!-- Button -->
			<div class="form-group">
			<div class="col-md-7">
			  <label class="col-md-4 control-label" for="salvar"></label>
			    <button id="salvar" name="salvar" class="btn btn-primary">Alterar</button>
			  </div>
			</div>
		
			</fieldset>
		</form>
						
						

     </div>
    </div>
    </div> <!-- /container -->
    
  </body>
</html>