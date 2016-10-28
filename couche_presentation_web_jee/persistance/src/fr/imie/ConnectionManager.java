package fr.imie;

import java.sql.SQLException;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@ConnetionManagement
@Priority(Interceptor.Priority.APPLICATION)
public class ConnectionManager {

	private @Inject ConnectionProvider connectionProvider;

	public ConnectionManager() {
		// TODO Auto-generated constructor stub
	}

	@AroundInvoke
	public Object aroundInvoke(InvocationContext ic) throws Exception {

		Object returnObject = null;
		try {
			// avant
			((ConnectionSupport) ic.getTarget()).setConnection(connectionProvider.openConnection());
			returnObject = ic.proceed();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			// apres
			connectionProvider.closeJDBC(((ConnectionSupport) ic.getTarget()).getConnection(), null, null);
		}

		return returnObject;
	}

}
