package control;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Responsavel;
import model.ResponsavelDAO;


/**
 * Servlet implementation class CadastroResponsavel
 */
@WebServlet("/CadastroResponsavel")
public class CadastroResponsavel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ResponsavelDAO responsavelDAO;

	public void init(ServletConfig config) throws ServletException {
		responsavelDAO = new ResponsavelDAO();
	}
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nomeResponsavel");
		
		Responsavel responsavel = new Responsavel();
		responsavel.setNome(nome);
		
		try {
			responsavelDAO.salvar(responsavel);
			String url="./home.jsp";
			request.setAttribute("mensagem", "Responsavel cadastrado com sucesso.");
			
			request.getRequestDispatcher(url).forward(request, response);
	
		} catch (Exception e) {
			String url="./cadastro_responsavel.jsp";
			request.setAttribute("mensagem", "Erro ao cadastrar o Responsavel!");
			
			request.getRequestDispatcher(url).forward(request, response);
		}
		

	}

}
