package fr.imie;

import java.io.IOException;
import java.io.Writer;

import javax.inject.Inject;
import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IUserService service;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Writer writer = response.getWriter();
		writer.append("<html>");
		writer.append("<body>");
		writer.append("<form method=\"POST\">");
		writer.append(String.format("<div><label for=\"loginInput\">login</label><input id=\"loginInput\" name=\"loginInput\" type=\"text\" /></div>"));
		writer.append(String.format("<div><label for=\"passwInput\">mot de passe</label><input id=\"passwInput\" name=\"passwInput\" type=\"password\" /></div>"));
		writer.append("<button name=\"loginAction\">se connecter</button>");
		writer.append("</form>");
		writer.append("</body>");
		writer.append("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("loginAction")!=null){
			UserEntity unsecuredUser = new UserEntity();
			unsecuredUser.setLogin(request.getParameter("loginInput"));
			unsecuredUser.setPassw(request.getParameter("passwInput"));
			UserEntity securedUser = service.verifyUsers(unsecuredUser);
			if(securedUser!=null){
				request.getSession().setAttribute("connectedUser", securedUser);
			}
		}
		doGet(request, response);
	}

}
