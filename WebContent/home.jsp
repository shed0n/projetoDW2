<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    import="model.Patrimonio, model.PatrimonioDAO, java.util.List, java.util.ArrayList"
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

    <title>Home</title>

    <!-- Bootstrap core CSS -->

    <link href="./resourses/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap core JavaScript-->

    <script src="./resourses/js/jquery.min.js"></script>
    <script src="./resourses/js/bootstrap.min.js"></script>

    <!-- Custom styles for this template -->

    <link href="./resourses/css/home.css" rel="stylesheet">
    
    <script>
    </script>

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
     <%		PatrimonioDAO patrimonioDAO = new PatrimonioDAO();
			List<Patrimonio> patrimonios = patrimonioDAO.getPatrimoniosAtivos(); %>	
    <div class="container"> 

      <!-- Static navbar -->
      <nav class="navbar navbar-default">
        <div class="container-fluid">
          <div class="navbar-header">
            <a class="navbar-brand" href="home.jsp">Patrimonios</a>
          </div>
       
            <ul class="nav navbar-nav">
              <li class="active"><a href="home.jsp">Lista de Patrimonios</a></li>
              <li><a href="relatorios.jsp">Relat�rios</a></li>
            </ul>
      
            <form  method="post" action="./BuscaServlet" class="navbar-form navbar-left">
        	<div class="form-group">
          	<input id="busca" name="busca" type="text" class="form-control" placeholder="Buscar" required>
        	</div>
			<!-- Select Basic -->
			  	  <select id="situacao" name="situacao" class="form-control">
			      <option value="Ativo">Ativo</option>
			      <option value="Manuten��o">Manuten��o</option>
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
      	<div class="row" style="margin-top:5px">
        <table class="table table-bordered table-striped table-hover">
				<tr>
					<td></td>
					<td>Codigo</td>
					<td>Situa��o</td>
					<td>Responsavel</td>
					<td>Setor</td>
					<td>Local</td>
					<td>Material</td>
					<td>Marca</td>
					<td>Modelo</td>
					<td>Data de Inser��o</td>
					<td></td>
				</tr>
				<% for(Patrimonio patrimonio:patrimonios) { %> 
				<tr>
					<td><a href=FiltraAcao?acao=alterar&codigo=<%=patrimonio.getCodigo()%>>+</a></td>
					<td><%= patrimonio.getCodigo() %></td>
					<td><%= patrimonio.getSituacao() %></td>
					<td><%= patrimonio.getResponsavel() %></td>
					<td><%= patrimonio.getSetor() %></td>
					<td><%= patrimonio.getLocal() %></td>
					<td><%= patrimonio.getMaterial() %></td>
					<td><%= patrimonio.getMarca() %></td>
					<td><%= patrimonio.getModelo() %></td>
					<td><%= patrimonio.getData() %></td>
					<td>
						<a href=FiltraAcao?acao=del&codigo=<%=patrimonio.getCodigo()%>>Excluir</a></td>
				</tr>
				 <% } %>
			</table>
      </div>
    </div> <!-- /container -->
    
  </body>