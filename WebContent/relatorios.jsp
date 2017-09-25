<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
     import="model.Patrimonio, model.PatrimonioDAO, java.util.List, java.util.ArrayList"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Relatórios</title>

    <!-- Bootstrap core CSS -->
    <link href="./resourses/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap core JavaScript-->
    <script src="./resourses/js/jquery.min.js"></script>
    <script src="./resourses/js/bootstrap.min.js"></script>
    
    <!--JavaScript para exportar a tabela para o Excel-->
    <script src="./resourses/js/table-xms/excellentexport.js"></script>
    
    <!--JavaScript para exportar a tabela para o PDF-->
    <script src="./resourses/js/jsPDF-master/jspdf.js"></script>
    <script src="./resourses/js/jsPDF-master/from_html.js"></script>
    <script src="./resourses/js/jsPDF-master/addhtml.js"></script>
	<script src="./resourses/js/jsPDF-master/jspdf.debug.js"></script>
	<script src="http://html2canvas.hertzen.com/build/html2canvas.js"></script>
	<script src="./resourses/js/jsPDF-master/defalte.js"></script>
	<script src="./resourses/js/jsPDF-master/addimage.js"></script>
	<script src="./resourses/js/jsPDF-master/svg.js"></script>
	
    <script src="./resourses/js/jsPDF-master/split_text_to_size.js"></script>
    <script src="./resourses/js/jsPDF-master/standard_fonts_metrics.js"></script>

    <!-- Custom styles for this template -->
    <link href="./resourses/css/home.css" rel="stylesheet">
    
    <script type="text/javascript">
    $(document).ready(function() {

        $("#btnPrint").click(function() {

    var pdf = new jsPDF('p','pt','letter');
    var specialElementHandlers = {
    '#tabela': function (element, renderer) {
        return true;
        }
    };

    pdf.addHTML($('#tabela').first(), function() {
        pdf.save("Relatório.pdf");
    });
    });
});
    </script>
    
    <style>
    table {
    background-color: #ffffff
	}
    </style>

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
              <li class="active"><a href="relatorios.jsp">Relatórios</a></li>
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

		
	 <form  method="post"  action="RelatoriosServlet">
	 <label for="relatorio">Escolha um relatório</label>
	  <div class="form-group">
	  	<div class="col-md-2">
		  	<select id="relatorio" name="relatorio" class="form-control">
			<option value="1">Mesas</option>
			<option value="2">Cadeiras</option>
			<option value="3">Computadores</option>
			<option value="4">Monitores</option>
			<option value="5">Patrimônios Ativos</option>
			<option value="6">Patrimônios em Manutenção</option>
			<option value="7">Patrimônios Inativos</option>
			<option value="8">Todos os Patrimônios</option>
			</select>
	  	</div>
	 	 <button id="enviar" name="enviar" type="submit" class="btn btn-default">Enviar</button>
	  </div>
	  <%		
	  			List<Patrimonio> patrimonios = null;
	 	        if(request.getAttribute("relatorio") != null){
		 	     	String relatorio = (String) request.getAttribute("relatorio");
		 	        PatrimonioDAO patrimonioDAO = new PatrimonioDAO();
					patrimonios = patrimonioDAO.getRelatorio(Integer.parseInt(relatorio));
				}
	  %>
	</form>	
      <!-- Main component for a primary marketing message or call to action -->
      <div class="jumbotron">
      	<div id="row" class="row" style="margin-top:5px">
        <table id="tabela" class="table table-bordered table-hover">
        
				<tr>
					<td>Codigo</td>
					<td>Situação</td>
					<td>Responsavel</td>
					<td>Setor</td>
					<td>Local</td>
					<td>Material</td>
					<td>Marca</td>
					<td>Modelo</td>
					<td>Data de Inserção</td>
				</tr>
				<% if(request.getAttribute("relatorio") != null) 
						for(Patrimonio patrimonio:patrimonios) { %> 
				<tr>
					<td><%= patrimonio.getCodigo() %></td>
					<td><%= patrimonio.getSituacao() %></td>
					<td><%= patrimonio.getResponsavel() %></td>
					<td><%= patrimonio.getSetor() %></td>
					<td><%= patrimonio.getLocal() %></td>
					<td><%= patrimonio.getMaterial() %></td>
					<td><%= patrimonio.getMarca() %></td>
					<td><%= patrimonio.getModelo() %></td>
					<td><%= patrimonio.getData() %></td>
				</tr>
				 <% } %>
        </table>
        <a href="#" id="btnPrint" onclick="printPDF();">
        Exportar para PDF</a>
        <br>
       <a download="Relatório.xls" href="#" onclick="return ExcellentExport.excel(this, 'tabela', 'Sheet Name Here');">
        Exportar para o Excel</a>
      </div>
     </div>
    </div> <!-- /container -->
  </body>
</html>
