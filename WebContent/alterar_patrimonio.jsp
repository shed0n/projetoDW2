<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
    <link href="./resourses/css/home.css" rel="stylesheet">

  </head>

  <body>
  	<jsp:useBean id="dao" class="model.ResponsavelDAO" />
	<jsp:useBean id="dao2" class="model.SetorDAO" />

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
		<form  method="post" action="./AlterarPatrimonio" class="form-horizontal" >
			<fieldset>
			<!-- Form Name -->
			<legend>Alteração de Dados</legend>

			
			<!-- Text input-->

			  <div class="form-group" >
			  <label class="col-md-4 control-label" for="codigo">Código</label>
			  <div class="col-md-2">
			  <input id="codigo" name="codigo" type="text" placeholder="Código" class="form-control input-md" readonly="true" value='<%=  request.getAttribute("codigo") %>'>	
			  </div>
			  </div>

			
			<!-- Select Basic -->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="situacao">Situação</label>
			  <div class="col-md-2">
			    <select id="situacao" name="situacao" class="form-control">
			      <option value="Ativo">Ativo</option>
			      <option value="Manutenção">Manutenção</option>
			      <option value="Inativo">Inativo</option>
			    </select>
			  </div>
			</div>
			
				<!-- Text input-->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="responsavel">Responsavel</label>  
			  <div class="col-md-4">
				<select id="responsavel"name="responsavel" class="form-control">
                   <c:forEach var="responsavel" items="${dao.responsavel}">
                   	 <option value="${responsavel.nome}">${responsavel.nome}</option>
                    </c:forEach>
                 </select>
			  </div>
			</div>
			
			<!-- Text input-->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="setor">Setor</label>
			  <div class="col-md-4">
				<select id="setor"name="setor" class="form-control">
                   <c:forEach var="setor" items="${dao2.setor}">
                   	 <option value="${setor.nome}">${setor.nome}</option>
                    </c:forEach>
                </select>
			  </div>
			</div>
			
			<!-- Text input-->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="local">Local</label>  
			  <div class="col-md-4">
			  <input id="local" name="local" type="text" placeholder="Local" class="form-control input-md" value='<%=  request.getAttribute("local") %>'>
			    
			  </div>
			</div>
			
			<!-- Text input-->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="material">Material</label>  
			  <div class="col-md-4">
			  <input id="material" name="material" type="text" placeholder="Material" class="form-control input-md" value='<%=  request.getAttribute("material") %>'>
			    
			  </div>
			</div>
			
			<!-- Text input-->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="marca">Marca</label>  
			  <div class="col-md-4">
			  <input id="marca" name="marca" type="text" placeholder="Marca" class="form-control input-md" value='<%=  request.getAttribute("marca") %>'>
			    
			  </div>
			</div>
			
			<!-- Text input-->
			<div class="text form-group">
			  <label class="col-md-4 control-label" for="modelo">Modelo</label>  
			  <div class="col-md-4">
			  <input id="modelo" name="modelo" type="text" placeholder="Modelo" class="form-control input-md" value='<%=  request.getAttribute("modelo") %>'>
			    
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