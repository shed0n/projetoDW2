package control;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Patrimonio;
import model.PatrimonioDAO;

/**
 * Servlet implementation class CadastroPatrimonioServlet
 */
@WebServlet("/CadastroPatrimonioServlet")
public class CadastroPatrimonioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private PatrimonioDAO patrimonioDAO;

	public void init(ServletConfig config) throws ServletException {
		patrimonioDAO = new PatrimonioDAO();
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
			patrimonioDAO.salvar(patrimonio);
			
			String url="./home.jsp";
			request.setAttribute("mensagem", "Cadastro realizado com sucesso.");
			if (patrimonio.getMaterial().equals("computador") || patrimonio.getMaterial().equals("Computador")){
				url="./computador.jsp";
				request.setAttribute("codigo", codigo);
			}
			
			request.getRequestDispatcher(url).forward(request, response);
	
		} catch (Exception e) {;
			String url="./cadastro.jsp";
			request.setAttribute("mensagem", "Erro ao cadastrar o Patrimonio!");
			
			request.getRequestDispatcher(url).forward(request, response);
		}

	}

}
