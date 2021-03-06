package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class ControleAcesso
 */
@WebFilter("/*")
public class ControleAcesso implements Filter {


	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
	
		if(session.getAttribute("usuario") != null
				|| req.getRequestURI().endsWith("login.jsp")
				|| req.getRequestURI().endsWith("cadastro_usuario.jsp")
				|| req.getRequestURI().endsWith("cadastro_usuario.jsp")
				|| req.getRequestURI().endsWith("LoginServlet")
				|| req.getRequestURI().endsWith("CadastroUsuario")) {
			chain.doFilter(request, response);
		} else {
			session.invalidate();
			HttpServletResponse res =
					(HttpServletResponse) response;
			res.sendRedirect("login.jsp");
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
