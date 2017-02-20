package fr.imie.cours;

import java.io.IOException;
import java.math.BigDecimal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bank")
public class BankAccountServlet extends HttpServlet {

	private static final long serialVersionUID = 4508899405337851695L;

	@EJB
	private BankAccountLocal ejb;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ejb.transfer(BigDecimal.valueOf(100), 1, 2);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
