package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import model.UsuarioDAO;

/**
 * Servlet implementation class CadastroUsuario
 */
@WebServlet("/CadastroUsuario")
public class CadastroUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("User");
		String senha = request.getParameter("Password");
		String confirmaSenha = request.getParameter("confirm-password");
		Usuario usuario = new Usuario(login, senha);
		String url = "/login.jsp";
		
		if(usuario.getSenha().equals(confirmaSenha)) {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.salvar(usuario);
			request.setAttribute("mensagem", "Cadastro efetuado com sucesso!");
		} else {
			request.setAttribute("mensagem", "Senhas não conferem!");
			url="/cadastro_usuario.jsp";
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
