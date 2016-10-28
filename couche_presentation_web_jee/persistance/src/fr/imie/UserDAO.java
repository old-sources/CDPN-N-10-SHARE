package fr.imie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;


@Dependent
@ConnetionManagement
public class UserDAO implements IUserDAO, ConnectionSupport {

	private @Inject ConnectionProvider connectionProvider;
	private Connection connection;

	@Override
	public List<UserEntity> getUsers() throws SQLException {

		Statement statement = null;
		ResultSet resultSet = null;
		List<UserEntity> retour = new ArrayList<UserEntity>();

		statement = connection.createStatement();
		resultSet = statement.executeQuery("SELECT id,login,mdp FROM personne");

		while (resultSet.next()) {
			UserEntity personneDTO = buildDTOFromResultset(resultSet);
			retour.add(personneDTO);
		}

		return retour;
	}

	@Override
	public UserEntity addUser(UserEntity userToInsert) throws SQLException {

		PreparedStatement statement = null;
		ResultSet resultSet = null;
		UserEntity retour = null;

		List<ParamJDBC> paramsList = new ArrayList<ParamJDBC>();
		if (userToInsert.getLogin() != null) {
			paramsList.add(new ParamJDBC("login", userToInsert.getLogin()));
		}
		if (userToInsert.getPassw() != null) {
			paramsList.add(new ParamJDBC("mdp", userToInsert.getPassw()));
		}
	

		String fields = "";
		String params = "";
		Boolean firstField = true;
		for (ParamJDBC paramJDBC : paramsList) {
			fields = fields.concat(firstField ? "" : ",").concat(paramJDBC.getNom());
			params = params.concat(firstField ? "" : ",").concat("?");
			firstField = false;
		}

		String query = "INSERT into personne (".concat(fields).concat(") values (").concat(params)
				.concat(") returning id, nom, prenom, datenaiss");

		statement = connection.prepareStatement(query);

		Integer paraNumber = 1;
		for (ParamJDBC paramJDBC : paramsList) {
			statement.setObject(paraNumber++, paramJDBC.getValue());
		}

		resultSet = statement.executeQuery();
		resultSet.next();
		retour = buildDTOFromResultset(resultSet);

		return retour;

	}

	private UserEntity buildDTOFromResultset(ResultSet resultSet) throws SQLException {
		UserEntity retour;
		retour = new UserEntity();

		retour.setId(resultSet.getInt("id"));
		retour.setLogin(resultSet.getString("login"));
		retour.setPassw(resultSet.getString("mdp"));

		return retour;
	}

	@Override
	public void setConnection(Connection conn) {
		this.connection = conn;

	}

	@Override
	public Connection getConnection() {
		return connection;
	}

}
