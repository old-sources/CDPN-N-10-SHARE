package fr.imie;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProjectsServlet
 */
@WebServlet("/projects")
public class ProjectsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ICrowdFundingService service;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProjectsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<CrowdFundingEntity> table = service.getAllCrowdFunfingDTO();
		
		request.getSession().setAttribute("table", table);

		Writer writer = response.getWriter();
		writer.append("<html>");
		writer.append("<body>");
		writer.append("<table>");
		for (Integer i = 0;i<table.size(); i++) {
			CrowdFundingEntity projet = table.get(i);
			writer.append("<tr>");
			writer.append("<td>");
			writer.append(projet.getName());
			writer.append("</td>");
			writer.append("<td>");
			writer.append(projet.getGoal().toString());
			writer.append("</td>");
			writer.append("<td>");
			writer.append(String.format("<a href=\"./project?numLigne=%s\">editer</a>",i));
			writer.append("</td>");
			writer.append("</tr>");
		}
		writer.append("</table>");
		writer.append("</body>");
		writer.append("</html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		doGet(request, response);
	}

}
