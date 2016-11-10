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
		request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean connected = false;
		if(request.getParameter("loginAction")!=null){
			UserEntity unsecuredUser = new UserEntity();
			unsecuredUser.setLogin(request.getParameter("loginInput"));
			unsecuredUser.setPassw(request.getParameter("passwInput"));
			UserEntity securedUser = service.verifyUsers(unsecuredUser);
			if(securedUser!=null){
				request.getSession().setAttribute("connectedUser", securedUser);
				connected=true;
			}
		}
		
		if(request.getParameter("logoutAction")!=null){
			request.getSession().removeAttribute("connectedUser");
			doGet(request, response);
		}
		
		if(connected==false){
			doGet(request, response);
		}
		
	}

}
