package control;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ComputadorDAO;
import model.Patrimonio;
import model.PatrimonioDAO;

/**
 * Servlet implementation class AlterarPatrimonio
 */
@WebServlet("/AlterarPatrimonio")
public class AlterarPatrimonio extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PatrimonioDAO patrimonioDAO;
	private ComputadorDAO computadorDAO;


	public void init(ServletConfig config) throws ServletException {
		patrimonioDAO = new PatrimonioDAO();
		computadorDAO = new ComputadorDAO();
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
		
		String codigo = request.getParameter("codigo");
		String situacao = request.getParameter("situacao");
		String responsavel = request.getParameter("responsavel");
		String setor = request.getParameter("setor");
		String local = request.getParameter("local");
		String material = request.getParameter("material");
		String marca = request.getParameter("marca");
		String modelo = request.getParameter("modelo");
		
		Patrimonio patrimonio = new Patrimonio();
		patrimonio.setCodigo(Integer.parseInt(codigo));
		patrimonio.setSituacao(situacao);
		patrimonio.setResponsavel(responsavel);
		patrimonio.setSetor(setor);
		patrimonio.setLocal(local);
		patrimonio.setMaterial(material);
		patrimonio.setMarca(marca);
		patrimonio.setModelo(modelo);
		
		try {
			patrimonioDAO.alterar(patrimonio);
			String url="./home.jsp";
			request.setAttribute("mensagem", "Alteração de patrimonio efetuada com sucesso!");
			
			if (material.equals("computador") || material.equals("Computador")){
				url="./computador.jsp";
				request.setAttribute("codigo", codigo);
			} else {
				computadorDAO.deletar(patrimonio.getCodigo());
			}
			
			request.getRequestDispatcher(url).forward(request, response);
	
		} catch (Exception e) {
			String url="./alterar_patrimonio.jsp";
			request.setAttribute("mensagem", "Erro ao realizar a alteração do patrimonio!");
			request.getRequestDispatcher(url).forward(request, response);
		}
		
	
	}

}
