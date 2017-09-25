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
 * Servlet implementation class RelatoriosServlet
 */
@WebServlet("/RelatoriosServlet")
public class RelatoriosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PatrimonioDAO patrimonioDAO;
	
	public void init() throws ServletException {
		patrimonioDAO = new PatrimonioDAO();
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String codigo = request.getParameter("relatorio");
			
		try {
			List<Patrimonio> patrimonios = patrimonioDAO.getRelatorio(Integer.parseInt(codigo));
			request.setAttribute("relatorio", codigo);
			request.setAttribute("patrimonios", patrimonios);
			
			String url = "relatorios.jsp";
			
			if(Integer.parseInt(codigo) == 3){
				url = "computador.jsp";
			}
			
			request.getRequestDispatcher(url).forward(request, response);
	
		} catch (Exception e) {
			String url = "home.jsp";
			request.setAttribute("mensagem", "Erro ao realizar busca!");
			request.getRequestDispatcher(url).forward(request, response);
		}

	}
}
