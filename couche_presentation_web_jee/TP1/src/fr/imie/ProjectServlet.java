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
 * Servlet implementation class ProjectServlet
 */
@WebServlet("/project")
public class ProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private ICrowdFundingService service;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProjectServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<CrowdFundingEntity> projets = (List<CrowdFundingEntity>) request.getSession().getAttribute("table");
		System.out.println(request.getParameter("id"));
		Integer id = Integer.parseInt(request.getParameter("id"));

		
		CrowdFundingEntity project = service.getByIdCrowdfundingDTO(id);
		request.setAttribute("project", project);
		// CrowdFundingEntity projet =
		// projets.get(Integer.parseInt(request.getParameter("numLigne")));

		//Writer writer = response.getWriter();
		Boolean modeEdition = (Boolean) request.getAttribute("modeEdition");
		modeEdition=modeEdition==null?false:modeEdition;
		request.setAttribute("modeEdition",modeEdition);

		request.getRequestDispatcher("/WEB-INF/project.jsp").forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("editionAction") != null) {
			request.setAttribute("modeEdition", true);
			doGet(request, response);
		}
		if (request.getParameter("saveAction") != null) {
			CrowdFundingEntity projet= new CrowdFundingEntity();
			projet.setId(Integer.parseInt(request.getParameter("idInput")));
			projet.setName(request.getParameter("nameInput"));
			projet.setGoal(Integer.parseInt(request.getParameter("goalInput")));
			projet.setDescription(request.getParameter("descriptionInput"));	
			service.saveCrowdfundingDTO(projet);
			response.sendRedirect("projects");
		}

		
	}

}
