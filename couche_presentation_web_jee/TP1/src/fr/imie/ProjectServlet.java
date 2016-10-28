package fr.imie;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProjectServlet
 */
@WebServlet("/project")
public class ProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CrowdFundingEntity> projets = (List<CrowdFundingEntity>) request.getSession().getAttribute("table");
		System.out.println(request.getParameter("numLigne"));
		CrowdFundingEntity projet = projets.get(Integer.parseInt(request.getParameter("numLigne")));
		
		Writer writer = response.getWriter();
		
		writer.append("<html>");
		writer.append("<body>");
		writer.append(String.format("<h1>%S</h1>", projet.getName()));
		writer.append(String.format("<h2>%S</h2>", projet.getGoal()));
		writer.append(String.format("<div>%S</div>", projet.getDescription()));
		writer.append("</body>");
		writer.append("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
