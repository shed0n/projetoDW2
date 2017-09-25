package control;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import model.Usuario;
import model.UsuarioDAO;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

		public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {		    
				String name = request.getParameter("User");
				String password = request.getParameter("Password");
				
				Usuario user = new Usuario(name, password);
				String url="/loginInvalido.jsp";
				
				UsuarioDAO usuarioDAO = new UsuarioDAO();
				if(usuarioDAO.verificaUsuario(user)){
					HttpSession sessao = request.getSession(true);
					sessao.setAttribute("usuario", user);
					url = "/home.jsp";
				}
				else {
					request.setAttribute("mensagem", "Usuario ou senha inválido!");
				}
				
				/*PatrimonioDAO patrimonioDAO = new PatrimonioDAO();
				List<Patrimonio> patrimonios = patrimonioDAO.getPatrimonios();
				request.setAttribute("patrimonios", patrimonios); */
				
				getServletContext().getRequestDispatcher(url).forward(request, response);


		}
}
