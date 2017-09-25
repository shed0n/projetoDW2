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
 * Servlet implementation class AlterarSenha
 */
@WebServlet("/AlterarSenha")
public class AlterarSenha extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("user");
		String senha = request.getParameter("password");
		String confirmaSenha = request.getParameter("confirm-password");
		Usuario usuario = new Usuario(login, senha);
		String url = "/home.jsp";
		
		if(usuario.getSenha().equals(confirmaSenha)) {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.alterar(usuario);
			request.setAttribute("mensagem", "Alteração efetuada com sucesso!");
		} else {
			request.setAttribute("mensagem", "Senhas não conferem!");
			url="/alterar_senha.jsp";
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
