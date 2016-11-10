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
public class ContributionDAO implements IContributionDAO, ConnectionSupport {

	private Connection connection;

	@Override
	public List<DonEntity> getContributionsByCrowdFunding(CrowdFundingEntity crowdFundingEntity) throws SQLException {

		Statement statement = null;
		ResultSet resultSet = null;
		List<DonEntity> retour = new ArrayList<DonEntity>();

		statement = connection.createStatement();
		resultSet = statement.executeQuery(String.format("SELECT don.id,don.valeur,personne.id AS personne_id,personne.login AS personne_login FROM don INNER JOIN personne ON don.personne_id = personne.id  WHERE don.projet_id=%S",crowdFundingEntity.getId()));

		while (resultSet.next()) {
			DonEntity donDTO = buildDTOFromResultset(resultSet);
			donDTO.setCrowdFunding(crowdFundingEntity);
			retour.add(donDTO);
		}

		return retour;
	}

	

	private DonEntity buildDTOFromResultset(ResultSet resultSet) throws SQLException {
		DonEntity retour;
		retour = new DonEntity();

		retour.setId(resultSet.getInt("id"));
		retour.setValue(resultSet.getInt("valeur"));
		
		UserEntity user = new UserEntity();
		user.setLogin(resultSet.getString("personne_login"));
		user.setId(resultSet.getInt("personne_id"));
		
		retour.setUser(user);


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
