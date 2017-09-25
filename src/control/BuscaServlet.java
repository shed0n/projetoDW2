package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Patrimonio;
import model.PatrimonioDAO;

/**
 * Servlet implementation class BuscaServlet
 */
@WebServlet("/BuscaServlet")
public class BuscaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PatrimonioDAO patrimonioDAO;
	
	
	public void init() throws ServletException {
		patrimonioDAO = new PatrimonioDAO();
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String codigo = request.getParameter("busca");
		String situacao = request.getParameter("situacao");
		
		try {
			List<Patrimonio> patrimonios = patrimonioDAO.getBusca(Integer.parseInt(codigo), situacao);
			request.setAttribute("relatorio", codigo);
			request.setAttribute("patrimonios", patrimonios);
			String url = "busca.jsp";
			
			request.getRequestDispatcher(url).forward(request, response);
	
		} catch (Exception e) {
			String url = "home.jsp";
			request.setAttribute("mensagem", "Erro ao realizar busca!");
			request.getRequestDispatcher(url).forward(request, response);
		}
	}

}
