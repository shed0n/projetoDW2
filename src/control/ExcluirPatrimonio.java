package control;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PatrimonioDAO;

/**
 * Servlet implementation class AlterarPatrimonio
 */
@WebServlet("/ExcluirPatrimonio")
public class ExcluirPatrimonio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PatrimonioDAO patrimonioDAO;

	public void init(ServletConfig config) throws ServletException {
		patrimonioDAO = new PatrimonioDAO();
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
		
		try {
			if(request.getParameter("codigo") != null) {
				if(request.getParameter("acao").equals("del")) {
					patrimonioDAO.deletar(Integer.parseInt(request.getParameter("codigo")));
			}
						
		}
		
		String url="./home.jsp";
		request.setAttribute("mensagem", "O patrimonio foi excluido da base de dados.");
			
		request.getRequestDispatcher(url).forward(request, response);
	
		} catch (Exception e) {
			String url = "home.jsp";
			request.setAttribute("mensagem", "Erro ao excluir patrimonio!");
			request.getRequestDispatcher(url).forward(request, response);
		}
		
	}

}
