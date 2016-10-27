package fr.imie;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

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
		ArrayList<Projet> table = new ArrayList<>();
		Projet newProjet1 = new Projet();
		newProjet1.setNom("projet 1");
		newProjet1.setObjectif(10000);
		table.add(newProjet1);
		Projet newProjet2 = new Projet();
		newProjet2.setNom("projet 2");
		newProjet2.setObjectif(50000);
		table.add(newProjet2);
		Projet newProjet3 = new Projet();
		newProjet3.setNom("projet 3");
		newProjet3.setObjectif(100000);
		table.add(newProjet3);
		
		request.getSession().setAttribute("table", table);

		Writer writer = response.getWriter();
		writer.append("<html>");
		writer.append("<body>");
		writer.append("<table>");
		for (Integer i = 0;i<table.size(); i++) {
			Projet projet = table.get(i);
			writer.append("<tr>");
			writer.append("<td>");
			writer.append(projet.getNom());
			writer.append("</td>");
			writer.append("<td>");
			writer.append(projet.getObjectif().toString());
			writer.append("</td>");
			writer.append("<td>");
			writer.append("<form method=\"POST\">");
			writer.append(String.format("<input type=\"hidden\" name=\"numLigne\" value=\"%s\"/>",i));
			writer.append("<button>editer</button>");
			writer.append("</form>");
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
		ArrayList<Projet> projets = (ArrayList<Projet>) request.getSession().getAttribute("table");
		System.out.println(request.getParameter("numLigne"));
		System.out.println(projets.get(Integer.parseInt(request.getParameter("numLigne"))).getNom());
		System.out.println("FIN DE JOURNEE");
		doGet(request, response);
	}

}
