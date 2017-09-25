package control;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Computador;
import model.ComputadorDAO;

/**
 * Servlet implementation class CadastroComputadorServlet
 */
@WebServlet("/CadastroComputadorServlet")
public class CadastroComputadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ComputadorDAO computadorDAO;
	
	public void init(ServletConfig config) throws ServletException {
		computadorDAO = new ComputadorDAO();
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String codigo = request.getParameter("codigo");
		
		if(codigo.equals("null"))
		{
			String url="./computador.jsp";	
			request.setAttribute("mensagem", "Erro ao cadastrar Computador! Realize o cadastro do patrimonio primeiro.");
			request.getRequestDispatcher(url).forward(request, response);
		} 
		
		String nome = request.getParameter("nome");
		String placamae = request.getParameter("placamae");
		String processador = request.getParameter("processador");
		String memoria = request.getParameter("memoria");
		String hd = request.getParameter("hd");
		String placadevideo = request.getParameter("placadevideo");
		String outros = request.getParameter("outros");
		
		Computador computador = new Computador();
		computador.setCodigo_comp(Integer.parseInt(codigo));
		computador.setNome(nome);
		computador.setPlaca_mae(placamae);
		computador.setProcessador(processador);
		computador.setMemoria(memoria);
		computador.setHd(hd);
		computador.setVideo(placadevideo);
		computador.setOutros(outros);
		
		try {
			computadorDAO.salvar(computador);
			String url="./computador.jsp";	
			request.setAttribute("mensagem", "Computador cadastrado com sucesso.");
			request.getRequestDispatcher(url).forward(request, response);
		} catch (Exception e) {
			String url="./computador.jsp";	
			request.setAttribute("mensagem", "Erro ao cadastrar o Computador!");
			request.getRequestDispatcher(url).forward(request, response);
		}
		
		
	}

}
