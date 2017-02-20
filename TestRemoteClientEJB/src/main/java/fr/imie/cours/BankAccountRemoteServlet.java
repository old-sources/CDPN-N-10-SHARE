package fr.imie.cours;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/remote")
public class BankAccountRemoteServlet extends HttpServlet {

	private static final long serialVersionUID = -8772725883947500861L;

	private BankAccountRemote ejbBankAccount;

	// // @PostConstruct
	// public void initEJB() {
	// }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Properties p = new Properties();
			p.put("java.naming.factory.initial", "org.apache.openejb.client.RemoteInitialContextFactory");
			p.put("java.naming.provider.url", "http://localhost:8080/tomee/ejb");
			// user and pass optional
			// p.put("java.naming.security.principal", "myuser");
			// p.put("java.naming.security.credentials", "mypass");

			InitialContext ctx = new InitialContext(p);

			for (NameClassPair pair : Collections.list(ctx.list(""))) {
				System.out.println(pair.getName());
				System.out.println(pair.getClassName());
			}

			// ejbBankAccount = (BankAccountRemote) ctx.lookup("BankAccountEJB");
			ejbBankAccount = (BankAccountRemote) ctx.lookup("BankAccountEJBRemote");

			ejbBankAccount.transfer(BigDecimal.valueOf(100), 1, 2);
			System.out.println("EJB OK");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
