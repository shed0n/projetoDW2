package control;

import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Computador;
import model.ComputadorDAO;
import model.PatrimonioDAO;


/**
 * Servlet implementation class FiltraAcaoComp
 */
@WebServlet("/FiltraAcaoComp")
public class FiltraAcaoComp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ComputadorDAO computadorDAO;
	private PatrimonioDAO patirmonioDAO;

	public void init(ServletConfig config) throws ServletException {
		computadorDAO = new ComputadorDAO();
		patirmonioDAO = new PatrimonioDAO();
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {

		String id = request.getParameter("codigo");
		String url="./alterar_computador.jsp";

		if(request.getParameter("codigo") != null) {
			if(request.getParameter("acao").equals("alterar")) {
				
				List<Computador> computadores = (List<Computador>) computadorDAO.getComputador(Integer.parseInt(id));
				
				for(Computador computador:computadores){	
				request.setAttribute("codigo", computador.getCodigo_comp());
				request.setAttribute("nome", computador.getNome());
				request.setAttribute("placamae", computador.getPlaca_mae());
				request.setAttribute("processador", computador.getProcessador());
				request.setAttribute("memoria", computador.getMemoria());
				request.setAttribute("hd", computador.getHd());
				request.setAttribute("placadevideo", computador.getVideo());
				request.setAttribute("outros",  computador.getOutros());
				}
		} else if(request.getParameter("acao").equals("del")) {
			computadorDAO.deletar(Integer.parseInt(request.getParameter("codigo")));
			patirmonioDAO.deletar(Integer.parseInt(request.getParameter("codigo")));
			url="./home.jsp";
			request.setAttribute("mensagem", "O patrimonio foi excluido da base de dados.");
		}
	}

			
		request.getRequestDispatcher(url).forward(request, response);
	}


}
