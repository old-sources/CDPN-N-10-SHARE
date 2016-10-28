/**
 * 
 */
package fr.imie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.enterprise.context.Dependent;

/**
 * @author imie
 *
 */
@Dependent
public class ConnectionProvider {
	
	protected Connection openConnection() throws SQLException {
		Connection connection;
		connection = DriverManager
				.getConnection("jdbc:postgresql://localhost:5432/crowdfunding",
						"imiedev", "imiedev");
		return connection;
	}

	protected void closeJDBC(Connection connection, Statement statement,
			ResultSet resultSet) {
		try {
			if (resultSet != null && !resultSet.isClosed()) {
				resultSet.close();
			}
			if (statement != null && !statement.isClosed()) {
				statement.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
