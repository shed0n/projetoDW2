package control;

import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Patrimonio;
import model.PatrimonioDAO;

/**
 * Servlet implementation class AlterarServlet
 */
@WebServlet("/FiltraAcao")
public class FiltraAcao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PatrimonioDAO patrimonioDAO;

	public void init(ServletConfig config) throws ServletException {
		patrimonioDAO = new PatrimonioDAO();
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {

		String id = request.getParameter("codigo");
		String url="./alterar_patrimonio.jsp";

		if(request.getParameter("codigo") != null) {
			if(request.getParameter("acao").equals("alterar")) {
				
				List<Patrimonio> patrimonios = (List<Patrimonio>) patrimonioDAO.getPatrimonio(Integer.parseInt(id));
				
				for(Patrimonio patrimonio:patrimonios){	
				request.setAttribute("codigo", patrimonio.getCodigo());
				request.setAttribute("situacao", patrimonio.getSituacao());
				request.setAttribute("responsavel", patrimonio.getResponsavel());
				request.setAttribute("setor", patrimonio.getSetor());
				request.setAttribute("local", patrimonio.getLocal());
				request.setAttribute("material", patrimonio.getMaterial());
				request.setAttribute("marca", patrimonio.getMarca());
				request.setAttribute("modelo",  patrimonio.getModelo());
				}
		} else if(request.getParameter("acao").equals("del")) {
			patrimonioDAO.deletar(Integer.parseInt(request.getParameter("codigo")));
			url="./home.jsp";
			request.setAttribute("mensagem", "O patrimonio foi excluido da base de dados.");
		}
	}

			
		request.getRequestDispatcher(url).forward(request, response);
	}


}
