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

    <title>Cadastro de Computador</title>

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
    '#tabelacomp': function (element, renderer) {
        return true;
        }
    };

    pdf.addHTML($('#tabelacomp').first(), function() {
        pdf.save("RelatórioComputadores.pdf");
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
	 <%		ComputadorDAO computadorDAO = new ComputadorDAO();
			List<Computador> computadores = computadorDAO.getComputadores(); %>	
    <div class="container"> 

      <!-- Static navbar -->
      <nav class="navbar navbar-default">
        <div class="container-fluid">
          <div class="navbar-header">
            <a class="navbar-brand" href="#">Patrimonios</a>
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
		<form class="form-inline" method="post" action="CadastroComputadorServlet" class="form-horizontal" >
			<fieldset>
			<!-- Form Name -->
			<legend>Formulário de Cadastro de Computadores</legend>
		   
		    
		  <div class="col-sm-3 col-md-6">
		    <div class="row">
		    <div class="form-group col-xs-5 col-md-2">
			  <label for="codigo">Codigo</label>
			  <input id="codigo" name="codigo" type="text"  class="form-control input-md" readonly="true" value=<%=  request.getAttribute("codigo") %> required >
			  </div>
			</div>
			<br>
			
			<div class="row">
		    <div class="form-group col-xs-5 col-md-1">
			  <label  for="nome">Nome</label>
			  <input id="nome" name="nome" type="text"  placeholder="Nome do Host"  class="form-control input-md" required >
			  </div>
			</div>
			<br>
			
			<div class="row">
		    <div class="form-group col-xs-5 col-md-1">
			  <label  for="placamae">Placa Mãe</label>
			  <input id="placamae" name="placamae" type="text" placeholder="Modelo da Placa Mãe" class="form-control input-md" required>
			  </div>
			</div>
			<br>
			
			<div class="row">
		    <div class="form-group col-xs-5 col-md-2">
			  <label for="processador">Processador</label>
			  <input id="processador" name="processador" type="text" placeholder="Modelo do Processador" class="form-control input-md" required>
			  </div>
			</div>
			<br>
			
		  </div>	
		
		  <div class="col-sm-9 col-md-6">	
		  			
			<div class="row">
		    <div class="form-group col-xs-5 col-md-2">
			  <label  for="memoria">Memória</label>
			  <input id="memoria" name="memoria" type="text" placeholder="Memória" class="form-control input-md" required>
			  </div>
			</div>
			<br>
		  
			<div class="row">
		    <div class="form-group col-xs-5 col-md-2">
			  <label for="hd">HD</label>
			  <input id="hd" name="hd" type="text" placeholder="HD" class="form-control input-md" required>
			  </div>
			</div>
			<br>
			
			<div class="row">
		    <div class="form-group col-xs-5 col-md-2">
			  <label  for="placadevideo">Placa de Vídeo</label>
			  <input id="placadevideo" name="placadevideo" type="text" placeholder="Modelo da Placa de Vídeo" class="form-control input-md" required>
			  </div>
			</div>
			<br>
			
			<div class="row">
		    <div class="form-group col-xs-5 col-md-2">
			  <label  for="outros">Outros</label>
			  <input id="outros" name="outros" type="text" placeholder="Outros" class="form-control input-md" required>
			  </div>
			</div>
			
			<div class="row">
		    <div class="form-group col-xs-5 col-md-2">
			  <label  for="salvar"></label>
			  <button id="salvar" name="salvar"  class="btn btn-primary">Salvar</button>
			  </div>
			</div>
			<br>
				
		 </div>
			</fieldset>
		</form>
	 </div>	
     </div>
     </div>
     
     <div class="row" style="margin-top:5px">
        <table id="tabelacomp"  class="table table-bordered table-hover">
				<tr>
					<td></td>
					<td>Codigo</td>
					<td>Nome(Host)</td>
					<td>Placa Mãe </td>
					<td>Processador</td>
					<td>Memória</td>
					<td>HD</td>
					<td>Placa de Vídeo </td>
					<td>Outros</td>
					<td></td>
				</tr>
				<% for(Computador comp:computadores) { %> 
				<tr>
					<td><a href=FiltraAcaoComp?acao=alterar&codigo=<%=comp.getCodigo_comp()%>>+</a></td>
					<td id="id"><%= comp.getCodigo_comp() %></td>
					<td><%= comp.getNome() %></td>
					<td><%= comp.getPlaca_mae() %></td>
					<td><%= comp.getProcessador() %></td>
					<td><%= comp.getMemoria() %></td>
					<td><%= comp.getHd() %></td>
					<td><%= comp.getVideo() %></td>
					<td><%= comp.getOutros() %></td>
					<td>
						<a href=FiltraAcaoComp?acao=del&codigo=<%=comp.getCodigo_comp()%>>Excluir</a></td>
				</tr>
				 <% } %>
        </table>
        <a href="#" id="btnPrint" onclick="printPDF();">
        Exportar para PDF</a>
        <br>
        <a download="Relatório.xls" href="#" onclick="return ExcellentExport.excel(this, 'tabelacomp', 'Sheet Name Here');">
        Exportar para o Excel</a>
      </div>
     
     
    </div> <!-- /container -->
    
  </body>
</html>