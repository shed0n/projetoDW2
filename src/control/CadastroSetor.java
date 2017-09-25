package control;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Setor;
import model.SetorDAO;

/**
 * Servlet implementation class CadastroSetor
 */
@WebServlet("/CadastroSetor")
public class CadastroSetor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SetorDAO setorDAO;

	public void init(ServletConfig config) throws ServletException {
		setorDAO = new SetorDAO();
	}
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nomeSetor");
		
		Setor setor = new Setor();
		setor.setNome(nome);
		
		try {
			setorDAO.salvar(setor);
			String url="./home.jsp";
			request.setAttribute("mensagem", "Setor cadastrado com sucesso.");
			
			request.getRequestDispatcher(url).forward(request, response);
	
		} catch (Exception e) {
			String url="./cadastro_local.jsp";
			request.setAttribute("mensagem", "Erro ao cadastrar o Setor!");
			
			request.getRequestDispatcher(url).forward(request, response);
		}
		
	}
}