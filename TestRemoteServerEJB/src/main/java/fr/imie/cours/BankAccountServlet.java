package fr.imie.cours;

import java.io.IOException;
import java.math.BigDecimal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BankAccountServlet")
public class BankAccountServlet extends HttpServlet {

	private static final long serialVersionUID = -8772725883947500861L;

	@EJB
	private BankAccountLocal ejbBankAccount;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ejbBankAccount.transfer(BigDecimal.valueOf(100), 1, 2);
	}

}
